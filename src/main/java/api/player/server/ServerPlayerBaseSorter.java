package api.player.server;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ServerPlayerBaseSorter {
    private Map<String, Set<String>> explicitInferiors;
    private Map<String, Set<String>> explicitSuperiors;
    private Map<String, Set<String>> directInferiorsMap;
    private Map<String, Set<String>> allInferiors;
    private List<String> withoutSuperiors;
    private final List<String> list;
    private final Map<String, String[]> allBaseSuperiors;
    private final Map<String, String[]> allBaseInferiors;
    private final String methodName;
    private static final Set<String> Empty = new HashSet<>();

    public ServerPlayerBaseSorter(List<String> list, Map<String, String[]> allBaseSuperiors, Map<String, String[]> allBaseInferiors, String methodName) {
        this.list = list;
        this.allBaseSuperiors = allBaseSuperiors;
        this.allBaseInferiors = allBaseInferiors;
        this.methodName = methodName;
    }

    public void Sort() {
        if (this.list.size() > 1) {
            if (this.explicitInferiors != null) {
                this.explicitInferiors.clear();
            }

            if (this.explicitSuperiors != null) {
                this.explicitSuperiors.clear();
            }

            if (this.directInferiorsMap != null) {
                this.directInferiorsMap.clear();
            }

            if (this.allInferiors != null) {
                this.allInferiors.clear();
            }

            for(int i = 0; i < this.list.size(); ++i) {
                String baseId = this.list.get(i);
                String[] inferiorNames = this.allBaseInferiors.get(baseId);
                boolean hasInferiors = inferiorNames != null && inferiorNames.length > 0;
                String[] superiorNames = this.allBaseSuperiors.get(baseId);
                boolean hasSuperiors = superiorNames != null && superiorNames.length > 0;
                if ((hasInferiors || hasSuperiors) && this.directInferiorsMap == null) {
                    this.directInferiorsMap = new Hashtable<>();
                }

                if (hasInferiors) {
                    this.explicitInferiors = build(baseId, this.explicitInferiors, this.directInferiorsMap, (Map<String, Set<String>>)null, inferiorNames);
                }

                if (hasSuperiors) {
                    this.explicitSuperiors = build(baseId, this.explicitSuperiors, (Map<String, Set<String>>)null, this.directInferiorsMap, superiorNames);
                }
            }

            Set<String> rightInferiors;
            if (this.directInferiorsMap != null) {
                for(int i = 0; i < this.list.size() - 1; ++i) {
                    for(int n = i + 1; n < this.list.size(); ++n) {
                        String left = this.list.get(i);
                        String right = this.list.get(n);
                        Set<String> leftInferiors = null;
                        rightInferiors = null;
                        if (this.explicitInferiors != null) {
                            leftInferiors = this.explicitInferiors.get(left);
                            rightInferiors = this.explicitInferiors.get(right);
                        }

                        Set<String> leftSuperiors = null;
                        Set<String> rightSuperiors = null;
                        if (this.explicitSuperiors != null) {
                            leftSuperiors = this.explicitSuperiors.get(left);
                            rightSuperiors = this.explicitSuperiors.get(right);
                        }

                        boolean leftWantsToBeInferiorToRight = leftSuperiors != null && leftSuperiors.contains(right);
                        boolean leftWantsToBeSuperiorToRight = leftInferiors != null && leftInferiors.contains(right);
                        boolean rightWantsToBeInferiorToLeft = rightSuperiors != null && rightSuperiors.contains(left);
                        boolean rightWantsToBeSuperiorToLeft = rightInferiors != null && rightInferiors.contains(left);
                        if (leftWantsToBeInferiorToRight && rightWantsToBeInferiorToLeft) {
                            throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. '" + left + "' wants to be inferior to '" + right + "' and '" + right + "' wants to be inferior to '" + left + "'");
                        }

                        if (leftWantsToBeSuperiorToRight && rightWantsToBeSuperiorToLeft) {
                            throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. '" + left + "' wants to be superior to '" + right + "' and '" + right + "' wants to be superior to '" + left + "'");
                        }

                        if (leftWantsToBeInferiorToRight && leftWantsToBeSuperiorToRight) {
                            throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. '" + left + "' wants to be superior and inferior to '" + right + "'");
                        }

                        if (rightWantsToBeInferiorToLeft && rightWantsToBeSuperiorToLeft) {
                            throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. '" + right + "' wants to be superior and inferior to '" + left + "'");
                        }
                    }
                }

                if (this.allInferiors == null) {
                    this.allInferiors = new Hashtable<>();
                }

                for(int i = 0; i < this.list.size(); ++i) {
                    this.build(this.list.get(i), (String)null);
                }
            }

            if (this.withoutSuperiors == null) {
                this.withoutSuperiors = new LinkedList<>();
            }

            int offset = 0;
            int size = this.list.size();

            while(size > 1) {
                this.withoutSuperiors.clear();

                for(int i = offset; i < offset + size; ++i) {
                    this.withoutSuperiors.add(this.list.get(i));
                }

                if (this.allInferiors != null) {
                    for(int i = offset; i < offset + size; ++i) {
                        Set<String> inferiors = this.allInferiors.get(this.list.get(i));
                        if (inferiors != null) {
                            this.withoutSuperiors.removeAll(inferiors);
                        }
                    }
                }

                boolean initial = true;

                for(int i = offset; i < offset + size; ++i) {
                    String key = this.list.get(i);
                    if (this.withoutSuperiors.contains(key)) {
                        if (initial) {
                            rightInferiors = null;
                            if (this.allInferiors != null) {
                                rightInferiors = this.allInferiors.get(key);
                            }

                            if (rightInferiors == null || rightInferiors.isEmpty()) {
                                this.withoutSuperiors.remove(key);
                                --size;
                                ++offset;
                                continue;
                            }
                        }

                        this.list.remove(i--);
                        --size;
                    }

                    initial = false;
                }

                this.list.addAll(offset + size, this.withoutSuperiors);
            }

        }
    }

    private Set<String> build(String type, String startType) {
        Set<String> inferiors = this.allInferiors.get(type);
        if (inferiors == null) {
            inferiors = this.build(type, (Set<String>)null, startType != null ? startType : type);
            if (inferiors == null) {
                inferiors = Empty;
            }

            this.allInferiors.put(type, inferiors);
        }

        return inferiors;
    }

    private Set<String> build(String type, Set<String> inferiors, String startType) {
        Set<String> directInferiors = this.directInferiorsMap.get(type);
        if (directInferiors == null) {
            return inferiors;
        } else {
            if (inferiors == null) {
                inferiors = new HashSet<>();
            }

            Iterator<String> iter = directInferiors.iterator();

            while(iter.hasNext()) {
                String inferiorType = (String)iter.next();
                if (inferiorType == startType) {
                    throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + startType + "'");
                }

                if (this.list.contains(inferiorType)) {
                    ((Set<String>)inferiors).add(inferiorType);
                }

                Set<String> inferiorSet;
                try {
                    inferiorSet = this.build(inferiorType, startType);
                } catch (UnsupportedOperationException var9) {
                    throw new UnsupportedOperationException("Can not sort ServerPlayerBase classes for method '" + this.methodName + "'. Circular superiosity found including '" + inferiorType + "'", var9);
                }

                if (inferiorSet != Empty) {
                    ((Set<String>)inferiors).addAll(inferiorSet);
                }
            }

            return inferiors;
        }
    }

    private static Map<String, Set<String>> build(String baseId, Map<String, Set<String>> map, Map<String, Set<String>> directMap, Map<String, Set<String>> otherDirectMap, String[] names) {
        if (map == null) {
            map = new Hashtable<>();
        }

        HashSet<String> types = new HashSet<>();

        for (String element : names) {
            if (element != null) {
                types.add(element);
            }
        }

        if (directMap != null) {
            getOrCreateSet(directMap, baseId).addAll(types);
        }

        if (otherDirectMap != null) {
            Iterator<String> iter = types.iterator();

            while(iter.hasNext()) {
                getOrCreateSet(otherDirectMap, (String)iter.next()).add(baseId);
            }
        }

        ((Map<String, Set<String>>)map).put(baseId, types);
        return map;
    }

    private static Set<String> getOrCreateSet(Map<String, Set<String>> map, String key) {
        Set<String> value = map.get(key);
        if (value != null) {
            return value;
        } else {
            HashSet<String> var3 = new HashSet<>();
            map.put(key, var3);
            return var3;
        }
    }
}
