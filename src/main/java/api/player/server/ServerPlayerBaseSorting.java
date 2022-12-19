package api.player.server;

import java.util.HashMap;
import java.util.Map;

public final class ServerPlayerBaseSorting {
    private String[] beforeLocalConstructingSuperiors = null;
    private String[] beforeLocalConstructingInferiors = null;
    private String[] afterLocalConstructingSuperiors = null;
    private String[] afterLocalConstructingInferiors = null;
    private Map<String, String[]> dynamicBeforeSuperiors = null;
    private Map<String, String[]> dynamicBeforeInferiors = null;
    private Map<String, String[]> dynamicOverrideSuperiors = null;
    private Map<String, String[]> dynamicOverrideInferiors = null;
    private Map<String, String[]> dynamicAfterSuperiors = null;
    private Map<String, String[]> dynamicAfterInferiors = null;
    private String[] beforeAddExhaustionSuperiors = null;
    private String[] beforeAddExhaustionInferiors = null;
    private String[] overrideAddExhaustionSuperiors = null;
    private String[] overrideAddExhaustionInferiors = null;
    private String[] afterAddExhaustionSuperiors = null;
    private String[] afterAddExhaustionInferiors = null;
    private String[] beforeAddExperienceSuperiors = null;
    private String[] beforeAddExperienceInferiors = null;
    private String[] overrideAddExperienceSuperiors = null;
    private String[] overrideAddExperienceInferiors = null;
    private String[] afterAddExperienceSuperiors = null;
    private String[] afterAddExperienceInferiors = null;
    private String[] beforeAddExperienceLevelSuperiors = null;
    private String[] beforeAddExperienceLevelInferiors = null;
    private String[] overrideAddExperienceLevelSuperiors = null;
    private String[] overrideAddExperienceLevelInferiors = null;
    private String[] afterAddExperienceLevelSuperiors = null;
    private String[] afterAddExperienceLevelInferiors = null;
    private String[] beforeAddMovementStatSuperiors = null;
    private String[] beforeAddMovementStatInferiors = null;
    private String[] overrideAddMovementStatSuperiors = null;
    private String[] overrideAddMovementStatInferiors = null;
    private String[] afterAddMovementStatSuperiors = null;
    private String[] afterAddMovementStatInferiors = null;
    private String[] beforeAttackEntityFromSuperiors = null;
    private String[] beforeAttackEntityFromInferiors = null;
    private String[] overrideAttackEntityFromSuperiors = null;
    private String[] overrideAttackEntityFromInferiors = null;
    private String[] afterAttackEntityFromSuperiors = null;
    private String[] afterAttackEntityFromInferiors = null;
    private String[] beforeAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] beforeAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] overrideAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] overrideAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] afterAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] afterAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] beforeCanBreatheUnderwaterSuperiors = null;
    private String[] beforeCanBreatheUnderwaterInferiors = null;
    private String[] overrideCanBreatheUnderwaterSuperiors = null;
    private String[] overrideCanBreatheUnderwaterInferiors = null;
    private String[] afterCanBreatheUnderwaterSuperiors = null;
    private String[] afterCanBreatheUnderwaterInferiors = null;
    private String[] beforeCanHarvestBlockSuperiors = null;
    private String[] beforeCanHarvestBlockInferiors = null;
    private String[] overrideCanHarvestBlockSuperiors = null;
    private String[] overrideCanHarvestBlockInferiors = null;
    private String[] afterCanHarvestBlockSuperiors = null;
    private String[] afterCanHarvestBlockInferiors = null;
    private String[] beforeCanPlayerEditSuperiors = null;
    private String[] beforeCanPlayerEditInferiors = null;
    private String[] overrideCanPlayerEditSuperiors = null;
    private String[] overrideCanPlayerEditInferiors = null;
    private String[] afterCanPlayerEditSuperiors = null;
    private String[] afterCanPlayerEditInferiors = null;
    private String[] beforeCanTriggerWalkingSuperiors = null;
    private String[] beforeCanTriggerWalkingInferiors = null;
    private String[] overrideCanTriggerWalkingSuperiors = null;
    private String[] overrideCanTriggerWalkingInferiors = null;
    private String[] afterCanTriggerWalkingSuperiors = null;
    private String[] afterCanTriggerWalkingInferiors = null;
    private String[] beforeClonePlayerSuperiors = null;
    private String[] beforeClonePlayerInferiors = null;
    private String[] overrideClonePlayerSuperiors = null;
    private String[] overrideClonePlayerInferiors = null;
    private String[] afterClonePlayerSuperiors = null;
    private String[] afterClonePlayerInferiors = null;
    private String[] beforeDamageEntitySuperiors = null;
    private String[] beforeDamageEntityInferiors = null;
    private String[] overrideDamageEntitySuperiors = null;
    private String[] overrideDamageEntityInferiors = null;
    private String[] afterDamageEntitySuperiors = null;
    private String[] afterDamageEntityInferiors = null;
    private String[] beforeDisplayGUIChestSuperiors = null;
    private String[] beforeDisplayGUIChestInferiors = null;
    private String[] overrideDisplayGUIChestSuperiors = null;
    private String[] overrideDisplayGUIChestInferiors = null;
    private String[] afterDisplayGUIChestSuperiors = null;
    private String[] afterDisplayGUIChestInferiors = null;
    private String[] beforeDisplayGUIDispenserSuperiors = null;
    private String[] beforeDisplayGUIDispenserInferiors = null;
    private String[] overrideDisplayGUIDispenserSuperiors = null;
    private String[] overrideDisplayGUIDispenserInferiors = null;
    private String[] afterDisplayGUIDispenserSuperiors = null;
    private String[] afterDisplayGUIDispenserInferiors = null;
    private String[] beforeDisplayGUIFurnaceSuperiors = null;
    private String[] beforeDisplayGUIFurnaceInferiors = null;
    private String[] overrideDisplayGUIFurnaceSuperiors = null;
    private String[] overrideDisplayGUIFurnaceInferiors = null;
    private String[] afterDisplayGUIFurnaceSuperiors = null;
    private String[] afterDisplayGUIFurnaceInferiors = null;
    private String[] beforeDisplayGUIWorkbenchSuperiors = null;
    private String[] beforeDisplayGUIWorkbenchInferiors = null;
    private String[] overrideDisplayGUIWorkbenchSuperiors = null;
    private String[] overrideDisplayGUIWorkbenchInferiors = null;
    private String[] afterDisplayGUIWorkbenchSuperiors = null;
    private String[] afterDisplayGUIWorkbenchInferiors = null;
    private String[] beforeDropOneItemSuperiors = null;
    private String[] beforeDropOneItemInferiors = null;
    private String[] overrideDropOneItemSuperiors = null;
    private String[] overrideDropOneItemInferiors = null;
    private String[] afterDropOneItemSuperiors = null;
    private String[] afterDropOneItemInferiors = null;
    private String[] beforeDropPlayerItemSuperiors = null;
    private String[] beforeDropPlayerItemInferiors = null;
    private String[] overrideDropPlayerItemSuperiors = null;
    private String[] overrideDropPlayerItemInferiors = null;
    private String[] afterDropPlayerItemSuperiors = null;
    private String[] afterDropPlayerItemInferiors = null;
    private String[] beforeFallSuperiors = null;
    private String[] beforeFallInferiors = null;
    private String[] overrideFallSuperiors = null;
    private String[] overrideFallInferiors = null;
    private String[] afterFallSuperiors = null;
    private String[] afterFallInferiors = null;
    private String[] beforeGetAIMoveSpeedSuperiors = null;
    private String[] beforeGetAIMoveSpeedInferiors = null;
    private String[] overrideGetAIMoveSpeedSuperiors = null;
    private String[] overrideGetAIMoveSpeedInferiors = null;
    private String[] afterGetAIMoveSpeedSuperiors = null;
    private String[] afterGetAIMoveSpeedInferiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] beforeGetDistanceSqSuperiors = null;
    private String[] beforeGetDistanceSqInferiors = null;
    private String[] overrideGetDistanceSqSuperiors = null;
    private String[] overrideGetDistanceSqInferiors = null;
    private String[] afterGetDistanceSqSuperiors = null;
    private String[] afterGetDistanceSqInferiors = null;
    private String[] beforeGetBrightnessSuperiors = null;
    private String[] beforeGetBrightnessInferiors = null;
    private String[] overrideGetBrightnessSuperiors = null;
    private String[] overrideGetBrightnessInferiors = null;
    private String[] afterGetBrightnessSuperiors = null;
    private String[] afterGetBrightnessInferiors = null;
    private String[] beforeGetEyeHeightSuperiors = null;
    private String[] beforeGetEyeHeightInferiors = null;
    private String[] overrideGetEyeHeightSuperiors = null;
    private String[] overrideGetEyeHeightInferiors = null;
    private String[] afterGetEyeHeightSuperiors = null;
    private String[] afterGetEyeHeightInferiors = null;
    private String[] beforeHealSuperiors = null;
    private String[] beforeHealInferiors = null;
    private String[] overrideHealSuperiors = null;
    private String[] overrideHealInferiors = null;
    private String[] afterHealSuperiors = null;
    private String[] afterHealInferiors = null;
    private String[] beforeIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] beforeIsEntityInsideOpaqueBlockInferiors = null;
    private String[] overrideIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] overrideIsEntityInsideOpaqueBlockInferiors = null;
    private String[] afterIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] afterIsEntityInsideOpaqueBlockInferiors = null;
    private String[] beforeIsInWaterSuperiors = null;
    private String[] beforeIsInWaterInferiors = null;
    private String[] overrideIsInWaterSuperiors = null;
    private String[] overrideIsInWaterInferiors = null;
    private String[] afterIsInWaterSuperiors = null;
    private String[] afterIsInWaterInferiors = null;
    private String[] beforeIsInsideOfMaterialSuperiors = null;
    private String[] beforeIsInsideOfMaterialInferiors = null;
    private String[] overrideIsInsideOfMaterialSuperiors = null;
    private String[] overrideIsInsideOfMaterialInferiors = null;
    private String[] afterIsInsideOfMaterialSuperiors = null;
    private String[] afterIsInsideOfMaterialInferiors = null;
    private String[] beforeIsOnLadderSuperiors = null;
    private String[] beforeIsOnLadderInferiors = null;
    private String[] overrideIsOnLadderSuperiors = null;
    private String[] overrideIsOnLadderInferiors = null;
    private String[] afterIsOnLadderSuperiors = null;
    private String[] afterIsOnLadderInferiors = null;
    private String[] beforeIsPlayerSleepingSuperiors = null;
    private String[] beforeIsPlayerSleepingInferiors = null;
    private String[] overrideIsPlayerSleepingSuperiors = null;
    private String[] overrideIsPlayerSleepingInferiors = null;
    private String[] afterIsPlayerSleepingSuperiors = null;
    private String[] afterIsPlayerSleepingInferiors = null;
    private String[] beforeIsSneakingSuperiors = null;
    private String[] beforeIsSneakingInferiors = null;
    private String[] overrideIsSneakingSuperiors = null;
    private String[] overrideIsSneakingInferiors = null;
    private String[] afterIsSneakingSuperiors = null;
    private String[] afterIsSneakingInferiors = null;
    private String[] beforeJumpSuperiors = null;
    private String[] beforeJumpInferiors = null;
    private String[] overrideJumpSuperiors = null;
    private String[] overrideJumpInferiors = null;
    private String[] afterJumpSuperiors = null;
    private String[] afterJumpInferiors = null;
    private String[] beforeKnockBackSuperiors = null;
    private String[] beforeKnockBackInferiors = null;
    private String[] overrideKnockBackSuperiors = null;
    private String[] overrideKnockBackInferiors = null;
    private String[] afterKnockBackSuperiors = null;
    private String[] afterKnockBackInferiors = null;
    private String[] beforeMountEntitySuperiors = null;
    private String[] beforeMountEntityInferiors = null;
    private String[] overrideMountEntitySuperiors = null;
    private String[] overrideMountEntityInferiors = null;
    private String[] afterMountEntitySuperiors = null;
    private String[] afterMountEntityInferiors = null;
    private String[] beforeMoveEntitySuperiors = null;
    private String[] beforeMoveEntityInferiors = null;
    private String[] overrideMoveEntitySuperiors = null;
    private String[] overrideMoveEntityInferiors = null;
    private String[] afterMoveEntitySuperiors = null;
    private String[] afterMoveEntityInferiors = null;
    private String[] beforeMoveEntityWithHeadingSuperiors = null;
    private String[] beforeMoveEntityWithHeadingInferiors = null;
    private String[] overrideMoveEntityWithHeadingSuperiors = null;
    private String[] overrideMoveEntityWithHeadingInferiors = null;
    private String[] afterMoveEntityWithHeadingSuperiors = null;
    private String[] afterMoveEntityWithHeadingInferiors = null;
    private String[] beforeMoveFlyingSuperiors = null;
    private String[] beforeMoveFlyingInferiors = null;
    private String[] overrideMoveFlyingSuperiors = null;
    private String[] overrideMoveFlyingInferiors = null;
    private String[] afterMoveFlyingSuperiors = null;
    private String[] afterMoveFlyingInferiors = null;
    private String[] beforeOnDeathSuperiors = null;
    private String[] beforeOnDeathInferiors = null;
    private String[] overrideOnDeathSuperiors = null;
    private String[] overrideOnDeathInferiors = null;
    private String[] afterOnDeathSuperiors = null;
    private String[] afterOnDeathInferiors = null;
    private String[] beforeOnLivingUpdateSuperiors = null;
    private String[] beforeOnLivingUpdateInferiors = null;
    private String[] overrideOnLivingUpdateSuperiors = null;
    private String[] overrideOnLivingUpdateInferiors = null;
    private String[] afterOnLivingUpdateSuperiors = null;
    private String[] afterOnLivingUpdateInferiors = null;
    private String[] beforeOnKillEntitySuperiors = null;
    private String[] beforeOnKillEntityInferiors = null;
    private String[] overrideOnKillEntitySuperiors = null;
    private String[] overrideOnKillEntityInferiors = null;
    private String[] afterOnKillEntitySuperiors = null;
    private String[] afterOnKillEntityInferiors = null;
    private String[] beforeOnStruckByLightningSuperiors = null;
    private String[] beforeOnStruckByLightningInferiors = null;
    private String[] overrideOnStruckByLightningSuperiors = null;
    private String[] overrideOnStruckByLightningInferiors = null;
    private String[] afterOnStruckByLightningSuperiors = null;
    private String[] afterOnStruckByLightningInferiors = null;
    private String[] beforeOnUpdateSuperiors = null;
    private String[] beforeOnUpdateInferiors = null;
    private String[] overrideOnUpdateSuperiors = null;
    private String[] overrideOnUpdateInferiors = null;
    private String[] afterOnUpdateSuperiors = null;
    private String[] afterOnUpdateInferiors = null;
    private String[] beforeOnUpdateEntitySuperiors = null;
    private String[] beforeOnUpdateEntityInferiors = null;
    private String[] overrideOnUpdateEntitySuperiors = null;
    private String[] overrideOnUpdateEntityInferiors = null;
    private String[] afterOnUpdateEntitySuperiors = null;
    private String[] afterOnUpdateEntityInferiors = null;
    private String[] beforeReadEntityFromNBTSuperiors = null;
    private String[] beforeReadEntityFromNBTInferiors = null;
    private String[] overrideReadEntityFromNBTSuperiors = null;
    private String[] overrideReadEntityFromNBTInferiors = null;
    private String[] afterReadEntityFromNBTSuperiors = null;
    private String[] afterReadEntityFromNBTInferiors = null;
    private String[] beforeSetDeadSuperiors = null;
    private String[] beforeSetDeadInferiors = null;
    private String[] overrideSetDeadSuperiors = null;
    private String[] overrideSetDeadInferiors = null;
    private String[] afterSetDeadSuperiors = null;
    private String[] afterSetDeadInferiors = null;
    private String[] beforeSetEntityActionStateSuperiors = null;
    private String[] beforeSetEntityActionStateInferiors = null;
    private String[] overrideSetEntityActionStateSuperiors = null;
    private String[] overrideSetEntityActionStateInferiors = null;
    private String[] afterSetEntityActionStateSuperiors = null;
    private String[] afterSetEntityActionStateInferiors = null;
    private String[] beforeSetPositionSuperiors = null;
    private String[] beforeSetPositionInferiors = null;
    private String[] overrideSetPositionSuperiors = null;
    private String[] overrideSetPositionInferiors = null;
    private String[] afterSetPositionSuperiors = null;
    private String[] afterSetPositionInferiors = null;
    private String[] beforeSetSneakingSuperiors = null;
    private String[] beforeSetSneakingInferiors = null;
    private String[] overrideSetSneakingSuperiors = null;
    private String[] overrideSetSneakingInferiors = null;
    private String[] afterSetSneakingSuperiors = null;
    private String[] afterSetSneakingInferiors = null;
    private String[] beforeSetSprintingSuperiors = null;
    private String[] beforeSetSprintingInferiors = null;
    private String[] overrideSetSprintingSuperiors = null;
    private String[] overrideSetSprintingInferiors = null;
    private String[] afterSetSprintingSuperiors = null;
    private String[] afterSetSprintingInferiors = null;
    private String[] beforeSwingItemSuperiors = null;
    private String[] beforeSwingItemInferiors = null;
    private String[] overrideSwingItemSuperiors = null;
    private String[] overrideSwingItemInferiors = null;
    private String[] afterSwingItemSuperiors = null;
    private String[] afterSwingItemInferiors = null;
    private String[] beforeUpdateEntityActionStateSuperiors = null;
    private String[] beforeUpdateEntityActionStateInferiors = null;
    private String[] overrideUpdateEntityActionStateSuperiors = null;
    private String[] overrideUpdateEntityActionStateInferiors = null;
    private String[] afterUpdateEntityActionStateSuperiors = null;
    private String[] afterUpdateEntityActionStateInferiors = null;
    private String[] beforeUpdatePotionEffectsSuperiors = null;
    private String[] beforeUpdatePotionEffectsInferiors = null;
    private String[] overrideUpdatePotionEffectsSuperiors = null;
    private String[] overrideUpdatePotionEffectsInferiors = null;
    private String[] afterUpdatePotionEffectsSuperiors = null;
    private String[] afterUpdatePotionEffectsInferiors = null;
    private String[] beforeUpdateRiddenSuperiors = null;
    private String[] beforeUpdateRiddenInferiors = null;
    private String[] overrideUpdateRiddenSuperiors = null;
    private String[] overrideUpdateRiddenInferiors = null;
    private String[] afterUpdateRiddenSuperiors = null;
    private String[] afterUpdateRiddenInferiors = null;
    private String[] beforeWakeUpPlayerSuperiors = null;
    private String[] beforeWakeUpPlayerInferiors = null;
    private String[] overrideWakeUpPlayerSuperiors = null;
    private String[] overrideWakeUpPlayerInferiors = null;
    private String[] afterWakeUpPlayerSuperiors = null;
    private String[] afterWakeUpPlayerInferiors = null;
    private String[] beforeWriteEntityToNBTSuperiors = null;
    private String[] beforeWriteEntityToNBTInferiors = null;
    private String[] overrideWriteEntityToNBTSuperiors = null;
    private String[] overrideWriteEntityToNBTInferiors = null;
    private String[] afterWriteEntityToNBTSuperiors = null;
    private String[] afterWriteEntityToNBTInferiors = null;

    public String[] getBeforeLocalConstructingSuperiors() {
        return this.beforeLocalConstructingSuperiors;
    }

    public String[] getBeforeLocalConstructingInferiors() {
        return this.beforeLocalConstructingInferiors;
    }

    public String[] getAfterLocalConstructingSuperiors() {
        return this.afterLocalConstructingSuperiors;
    }

    public String[] getAfterLocalConstructingInferiors() {
        return this.afterLocalConstructingInferiors;
    }

    public void setBeforeLocalConstructingSuperiors(String[] value) {
        this.beforeLocalConstructingSuperiors = value;
    }

    public void setBeforeLocalConstructingInferiors(String[] value) {
        this.beforeLocalConstructingInferiors = value;
    }

    public void setAfterLocalConstructingSuperiors(String[] value) {
        this.afterLocalConstructingSuperiors = value;
    }

    public void setAfterLocalConstructingInferiors(String[] value) {
        this.afterLocalConstructingInferiors = value;
    }

    public Map<String, String[]> getDynamicBeforeSuperiors() {
        return this.dynamicBeforeSuperiors;
    }

    public Map<String, String[]> getDynamicBeforeInferiors() {
        return this.dynamicBeforeInferiors;
    }

    public Map<String, String[]> getDynamicOverrideSuperiors() {
        return this.dynamicOverrideSuperiors;
    }

    public Map<String, String[]> getDynamicOverrideInferiors() {
        return this.dynamicOverrideInferiors;
    }

    public Map<String, String[]> getDynamicAfterSuperiors() {
        return this.dynamicAfterSuperiors;
    }

    public Map<String, String[]> getDynamicAfterInferiors() {
        return this.dynamicAfterInferiors;
    }

    public void setDynamicBeforeSuperiors(String name, String[] superiors) {
        this.dynamicBeforeSuperiors = this.setDynamic(name, superiors, this.dynamicBeforeSuperiors);
    }

    public void setDynamicBeforeInferiors(String name, String[] inferiors) {
        this.dynamicBeforeInferiors = this.setDynamic(name, inferiors, this.dynamicBeforeInferiors);
    }

    public void setDynamicOverrideSuperiors(String name, String[] superiors) {
        this.dynamicOverrideSuperiors = this.setDynamic(name, superiors, this.dynamicOverrideSuperiors);
    }

    public void setDynamicOverrideInferiors(String name, String[] inferiors) {
        this.dynamicOverrideInferiors = this.setDynamic(name, inferiors, this.dynamicOverrideInferiors);
    }

    public void setDynamicAfterSuperiors(String name, String[] superiors) {
        this.dynamicAfterSuperiors = this.setDynamic(name, superiors, this.dynamicAfterSuperiors);
    }

    public void setDynamicAfterInferiors(String name, String[] inferiors) {
        this.dynamicAfterInferiors = this.setDynamic(name, inferiors, this.dynamicAfterInferiors);
    }

    private Map<String, String[]> setDynamic(String name, String[] names, Map<String, String[]> map) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter 'name' may not be null");
        } else if (names == null) {
            if (map != null) {
                map.remove(name);
            }

            return map;
        } else {
            if (map == null) {
                map = new HashMap<>();
            }

            map.put(name, names);
            return map;
        }
    }

    public String[] getBeforeAddExhaustionSuperiors() {
        return this.beforeAddExhaustionSuperiors;
    }

    public String[] getBeforeAddExhaustionInferiors() {
        return this.beforeAddExhaustionInferiors;
    }

    public String[] getOverrideAddExhaustionSuperiors() {
        return this.overrideAddExhaustionSuperiors;
    }

    public String[] getOverrideAddExhaustionInferiors() {
        return this.overrideAddExhaustionInferiors;
    }

    public String[] getAfterAddExhaustionSuperiors() {
        return this.afterAddExhaustionSuperiors;
    }

    public String[] getAfterAddExhaustionInferiors() {
        return this.afterAddExhaustionInferiors;
    }

    public void setBeforeAddExhaustionSuperiors(String[] value) {
        this.beforeAddExhaustionSuperiors = value;
    }

    public void setBeforeAddExhaustionInferiors(String[] value) {
        this.beforeAddExhaustionInferiors = value;
    }

    public void setOverrideAddExhaustionSuperiors(String[] value) {
        this.overrideAddExhaustionSuperiors = value;
    }

    public void setOverrideAddExhaustionInferiors(String[] value) {
        this.overrideAddExhaustionInferiors = value;
    }

    public void setAfterAddExhaustionSuperiors(String[] value) {
        this.afterAddExhaustionSuperiors = value;
    }

    public void setAfterAddExhaustionInferiors(String[] value) {
        this.afterAddExhaustionInferiors = value;
    }

    public String[] getBeforeAddExperienceSuperiors() {
        return this.beforeAddExperienceSuperiors;
    }

    public String[] getBeforeAddExperienceInferiors() {
        return this.beforeAddExperienceInferiors;
    }

    public String[] getOverrideAddExperienceSuperiors() {
        return this.overrideAddExperienceSuperiors;
    }

    public String[] getOverrideAddExperienceInferiors() {
        return this.overrideAddExperienceInferiors;
    }

    public String[] getAfterAddExperienceSuperiors() {
        return this.afterAddExperienceSuperiors;
    }

    public String[] getAfterAddExperienceInferiors() {
        return this.afterAddExperienceInferiors;
    }

    public void setBeforeAddExperienceSuperiors(String[] value) {
        this.beforeAddExperienceSuperiors = value;
    }

    public void setBeforeAddExperienceInferiors(String[] value) {
        this.beforeAddExperienceInferiors = value;
    }

    public void setOverrideAddExperienceSuperiors(String[] value) {
        this.overrideAddExperienceSuperiors = value;
    }

    public void setOverrideAddExperienceInferiors(String[] value) {
        this.overrideAddExperienceInferiors = value;
    }

    public void setAfterAddExperienceSuperiors(String[] value) {
        this.afterAddExperienceSuperiors = value;
    }

    public void setAfterAddExperienceInferiors(String[] value) {
        this.afterAddExperienceInferiors = value;
    }

    public String[] getBeforeAddExperienceLevelSuperiors() {
        return this.beforeAddExperienceLevelSuperiors;
    }

    public String[] getBeforeAddExperienceLevelInferiors() {
        return this.beforeAddExperienceLevelInferiors;
    }

    public String[] getOverrideAddExperienceLevelSuperiors() {
        return this.overrideAddExperienceLevelSuperiors;
    }

    public String[] getOverrideAddExperienceLevelInferiors() {
        return this.overrideAddExperienceLevelInferiors;
    }

    public String[] getAfterAddExperienceLevelSuperiors() {
        return this.afterAddExperienceLevelSuperiors;
    }

    public String[] getAfterAddExperienceLevelInferiors() {
        return this.afterAddExperienceLevelInferiors;
    }

    public void setBeforeAddExperienceLevelSuperiors(String[] value) {
        this.beforeAddExperienceLevelSuperiors = value;
    }

    public void setBeforeAddExperienceLevelInferiors(String[] value) {
        this.beforeAddExperienceLevelInferiors = value;
    }

    public void setOverrideAddExperienceLevelSuperiors(String[] value) {
        this.overrideAddExperienceLevelSuperiors = value;
    }

    public void setOverrideAddExperienceLevelInferiors(String[] value) {
        this.overrideAddExperienceLevelInferiors = value;
    }

    public void setAfterAddExperienceLevelSuperiors(String[] value) {
        this.afterAddExperienceLevelSuperiors = value;
    }

    public void setAfterAddExperienceLevelInferiors(String[] value) {
        this.afterAddExperienceLevelInferiors = value;
    }

    public String[] getBeforeAddMovementStatSuperiors() {
        return this.beforeAddMovementStatSuperiors;
    }

    public String[] getBeforeAddMovementStatInferiors() {
        return this.beforeAddMovementStatInferiors;
    }

    public String[] getOverrideAddMovementStatSuperiors() {
        return this.overrideAddMovementStatSuperiors;
    }

    public String[] getOverrideAddMovementStatInferiors() {
        return this.overrideAddMovementStatInferiors;
    }

    public String[] getAfterAddMovementStatSuperiors() {
        return this.afterAddMovementStatSuperiors;
    }

    public String[] getAfterAddMovementStatInferiors() {
        return this.afterAddMovementStatInferiors;
    }

    public void setBeforeAddMovementStatSuperiors(String[] value) {
        this.beforeAddMovementStatSuperiors = value;
    }

    public void setBeforeAddMovementStatInferiors(String[] value) {
        this.beforeAddMovementStatInferiors = value;
    }

    public void setOverrideAddMovementStatSuperiors(String[] value) {
        this.overrideAddMovementStatSuperiors = value;
    }

    public void setOverrideAddMovementStatInferiors(String[] value) {
        this.overrideAddMovementStatInferiors = value;
    }

    public void setAfterAddMovementStatSuperiors(String[] value) {
        this.afterAddMovementStatSuperiors = value;
    }

    public void setAfterAddMovementStatInferiors(String[] value) {
        this.afterAddMovementStatInferiors = value;
    }

    public String[] getBeforeAttackEntityFromSuperiors() {
        return this.beforeAttackEntityFromSuperiors;
    }

    public String[] getBeforeAttackEntityFromInferiors() {
        return this.beforeAttackEntityFromInferiors;
    }

    public String[] getOverrideAttackEntityFromSuperiors() {
        return this.overrideAttackEntityFromSuperiors;
    }

    public String[] getOverrideAttackEntityFromInferiors() {
        return this.overrideAttackEntityFromInferiors;
    }

    public String[] getAfterAttackEntityFromSuperiors() {
        return this.afterAttackEntityFromSuperiors;
    }

    public String[] getAfterAttackEntityFromInferiors() {
        return this.afterAttackEntityFromInferiors;
    }

    public void setBeforeAttackEntityFromSuperiors(String[] value) {
        this.beforeAttackEntityFromSuperiors = value;
    }

    public void setBeforeAttackEntityFromInferiors(String[] value) {
        this.beforeAttackEntityFromInferiors = value;
    }

    public void setOverrideAttackEntityFromSuperiors(String[] value) {
        this.overrideAttackEntityFromSuperiors = value;
    }

    public void setOverrideAttackEntityFromInferiors(String[] value) {
        this.overrideAttackEntityFromInferiors = value;
    }

    public void setAfterAttackEntityFromSuperiors(String[] value) {
        this.afterAttackEntityFromSuperiors = value;
    }

    public void setAfterAttackEntityFromInferiors(String[] value) {
        this.afterAttackEntityFromInferiors = value;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemSuperiors() {
        return this.beforeAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemInferiors() {
        return this.beforeAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemSuperiors() {
        return this.overrideAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemInferiors() {
        return this.overrideAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemSuperiors() {
        return this.afterAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemInferiors() {
        return this.afterAttackTargetEntityWithCurrentItemInferiors;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemSuperiors(String[] value) {
        this.beforeAttackTargetEntityWithCurrentItemSuperiors = value;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemInferiors(String[] value) {
        this.beforeAttackTargetEntityWithCurrentItemInferiors = value;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemSuperiors(String[] value) {
        this.overrideAttackTargetEntityWithCurrentItemSuperiors = value;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemInferiors(String[] value) {
        this.overrideAttackTargetEntityWithCurrentItemInferiors = value;
    }

    public void setAfterAttackTargetEntityWithCurrentItemSuperiors(String[] value) {
        this.afterAttackTargetEntityWithCurrentItemSuperiors = value;
    }

    public void setAfterAttackTargetEntityWithCurrentItemInferiors(String[] value) {
        this.afterAttackTargetEntityWithCurrentItemInferiors = value;
    }

    public String[] getBeforeCanBreatheUnderwaterSuperiors() {
        return this.beforeCanBreatheUnderwaterSuperiors;
    }

    public String[] getBeforeCanBreatheUnderwaterInferiors() {
        return this.beforeCanBreatheUnderwaterInferiors;
    }

    public String[] getOverrideCanBreatheUnderwaterSuperiors() {
        return this.overrideCanBreatheUnderwaterSuperiors;
    }

    public String[] getOverrideCanBreatheUnderwaterInferiors() {
        return this.overrideCanBreatheUnderwaterInferiors;
    }

    public String[] getAfterCanBreatheUnderwaterSuperiors() {
        return this.afterCanBreatheUnderwaterSuperiors;
    }

    public String[] getAfterCanBreatheUnderwaterInferiors() {
        return this.afterCanBreatheUnderwaterInferiors;
    }

    public void setBeforeCanBreatheUnderwaterSuperiors(String[] value) {
        this.beforeCanBreatheUnderwaterSuperiors = value;
    }

    public void setBeforeCanBreatheUnderwaterInferiors(String[] value) {
        this.beforeCanBreatheUnderwaterInferiors = value;
    }

    public void setOverrideCanBreatheUnderwaterSuperiors(String[] value) {
        this.overrideCanBreatheUnderwaterSuperiors = value;
    }

    public void setOverrideCanBreatheUnderwaterInferiors(String[] value) {
        this.overrideCanBreatheUnderwaterInferiors = value;
    }

    public void setAfterCanBreatheUnderwaterSuperiors(String[] value) {
        this.afterCanBreatheUnderwaterSuperiors = value;
    }

    public void setAfterCanBreatheUnderwaterInferiors(String[] value) {
        this.afterCanBreatheUnderwaterInferiors = value;
    }

    public String[] getBeforeCanHarvestBlockSuperiors() {
        return this.beforeCanHarvestBlockSuperiors;
    }

    public String[] getBeforeCanHarvestBlockInferiors() {
        return this.beforeCanHarvestBlockInferiors;
    }

    public String[] getOverrideCanHarvestBlockSuperiors() {
        return this.overrideCanHarvestBlockSuperiors;
    }

    public String[] getOverrideCanHarvestBlockInferiors() {
        return this.overrideCanHarvestBlockInferiors;
    }

    public String[] getAfterCanHarvestBlockSuperiors() {
        return this.afterCanHarvestBlockSuperiors;
    }

    public String[] getAfterCanHarvestBlockInferiors() {
        return this.afterCanHarvestBlockInferiors;
    }

    public void setBeforeCanHarvestBlockSuperiors(String[] value) {
        this.beforeCanHarvestBlockSuperiors = value;
    }

    public void setBeforeCanHarvestBlockInferiors(String[] value) {
        this.beforeCanHarvestBlockInferiors = value;
    }

    public void setOverrideCanHarvestBlockSuperiors(String[] value) {
        this.overrideCanHarvestBlockSuperiors = value;
    }

    public void setOverrideCanHarvestBlockInferiors(String[] value) {
        this.overrideCanHarvestBlockInferiors = value;
    }

    public void setAfterCanHarvestBlockSuperiors(String[] value) {
        this.afterCanHarvestBlockSuperiors = value;
    }

    public void setAfterCanHarvestBlockInferiors(String[] value) {
        this.afterCanHarvestBlockInferiors = value;
    }

    public String[] getBeforeCanPlayerEditSuperiors() {
        return this.beforeCanPlayerEditSuperiors;
    }

    public String[] getBeforeCanPlayerEditInferiors() {
        return this.beforeCanPlayerEditInferiors;
    }

    public String[] getOverrideCanPlayerEditSuperiors() {
        return this.overrideCanPlayerEditSuperiors;
    }

    public String[] getOverrideCanPlayerEditInferiors() {
        return this.overrideCanPlayerEditInferiors;
    }

    public String[] getAfterCanPlayerEditSuperiors() {
        return this.afterCanPlayerEditSuperiors;
    }

    public String[] getAfterCanPlayerEditInferiors() {
        return this.afterCanPlayerEditInferiors;
    }

    public void setBeforeCanPlayerEditSuperiors(String[] value) {
        this.beforeCanPlayerEditSuperiors = value;
    }

    public void setBeforeCanPlayerEditInferiors(String[] value) {
        this.beforeCanPlayerEditInferiors = value;
    }

    public void setOverrideCanPlayerEditSuperiors(String[] value) {
        this.overrideCanPlayerEditSuperiors = value;
    }

    public void setOverrideCanPlayerEditInferiors(String[] value) {
        this.overrideCanPlayerEditInferiors = value;
    }

    public void setAfterCanPlayerEditSuperiors(String[] value) {
        this.afterCanPlayerEditSuperiors = value;
    }

    public void setAfterCanPlayerEditInferiors(String[] value) {
        this.afterCanPlayerEditInferiors = value;
    }

    public String[] getBeforeCanTriggerWalkingSuperiors() {
        return this.beforeCanTriggerWalkingSuperiors;
    }

    public String[] getBeforeCanTriggerWalkingInferiors() {
        return this.beforeCanTriggerWalkingInferiors;
    }

    public String[] getOverrideCanTriggerWalkingSuperiors() {
        return this.overrideCanTriggerWalkingSuperiors;
    }

    public String[] getOverrideCanTriggerWalkingInferiors() {
        return this.overrideCanTriggerWalkingInferiors;
    }

    public String[] getAfterCanTriggerWalkingSuperiors() {
        return this.afterCanTriggerWalkingSuperiors;
    }

    public String[] getAfterCanTriggerWalkingInferiors() {
        return this.afterCanTriggerWalkingInferiors;
    }

    public void setBeforeCanTriggerWalkingSuperiors(String[] value) {
        this.beforeCanTriggerWalkingSuperiors = value;
    }

    public void setBeforeCanTriggerWalkingInferiors(String[] value) {
        this.beforeCanTriggerWalkingInferiors = value;
    }

    public void setOverrideCanTriggerWalkingSuperiors(String[] value) {
        this.overrideCanTriggerWalkingSuperiors = value;
    }

    public void setOverrideCanTriggerWalkingInferiors(String[] value) {
        this.overrideCanTriggerWalkingInferiors = value;
    }

    public void setAfterCanTriggerWalkingSuperiors(String[] value) {
        this.afterCanTriggerWalkingSuperiors = value;
    }

    public void setAfterCanTriggerWalkingInferiors(String[] value) {
        this.afterCanTriggerWalkingInferiors = value;
    }

    public String[] getBeforeClonePlayerSuperiors() {
        return this.beforeClonePlayerSuperiors;
    }

    public String[] getBeforeClonePlayerInferiors() {
        return this.beforeClonePlayerInferiors;
    }

    public String[] getOverrideClonePlayerSuperiors() {
        return this.overrideClonePlayerSuperiors;
    }

    public String[] getOverrideClonePlayerInferiors() {
        return this.overrideClonePlayerInferiors;
    }

    public String[] getAfterClonePlayerSuperiors() {
        return this.afterClonePlayerSuperiors;
    }

    public String[] getAfterClonePlayerInferiors() {
        return this.afterClonePlayerInferiors;
    }

    public void setBeforeClonePlayerSuperiors(String[] value) {
        this.beforeClonePlayerSuperiors = value;
    }

    public void setBeforeClonePlayerInferiors(String[] value) {
        this.beforeClonePlayerInferiors = value;
    }

    public void setOverrideClonePlayerSuperiors(String[] value) {
        this.overrideClonePlayerSuperiors = value;
    }

    public void setOverrideClonePlayerInferiors(String[] value) {
        this.overrideClonePlayerInferiors = value;
    }

    public void setAfterClonePlayerSuperiors(String[] value) {
        this.afterClonePlayerSuperiors = value;
    }

    public void setAfterClonePlayerInferiors(String[] value) {
        this.afterClonePlayerInferiors = value;
    }

    public String[] getBeforeDamageEntitySuperiors() {
        return this.beforeDamageEntitySuperiors;
    }

    public String[] getBeforeDamageEntityInferiors() {
        return this.beforeDamageEntityInferiors;
    }

    public String[] getOverrideDamageEntitySuperiors() {
        return this.overrideDamageEntitySuperiors;
    }

    public String[] getOverrideDamageEntityInferiors() {
        return this.overrideDamageEntityInferiors;
    }

    public String[] getAfterDamageEntitySuperiors() {
        return this.afterDamageEntitySuperiors;
    }

    public String[] getAfterDamageEntityInferiors() {
        return this.afterDamageEntityInferiors;
    }

    public void setBeforeDamageEntitySuperiors(String[] value) {
        this.beforeDamageEntitySuperiors = value;
    }

    public void setBeforeDamageEntityInferiors(String[] value) {
        this.beforeDamageEntityInferiors = value;
    }

    public void setOverrideDamageEntitySuperiors(String[] value) {
        this.overrideDamageEntitySuperiors = value;
    }

    public void setOverrideDamageEntityInferiors(String[] value) {
        this.overrideDamageEntityInferiors = value;
    }

    public void setAfterDamageEntitySuperiors(String[] value) {
        this.afterDamageEntitySuperiors = value;
    }

    public void setAfterDamageEntityInferiors(String[] value) {
        this.afterDamageEntityInferiors = value;
    }

    public String[] getBeforeDisplayGUIChestSuperiors() {
        return this.beforeDisplayGUIChestSuperiors;
    }

    public String[] getBeforeDisplayGUIChestInferiors() {
        return this.beforeDisplayGUIChestInferiors;
    }

    public String[] getOverrideDisplayGUIChestSuperiors() {
        return this.overrideDisplayGUIChestSuperiors;
    }

    public String[] getOverrideDisplayGUIChestInferiors() {
        return this.overrideDisplayGUIChestInferiors;
    }

    public String[] getAfterDisplayGUIChestSuperiors() {
        return this.afterDisplayGUIChestSuperiors;
    }

    public String[] getAfterDisplayGUIChestInferiors() {
        return this.afterDisplayGUIChestInferiors;
    }

    public void setBeforeDisplayGUIChestSuperiors(String[] value) {
        this.beforeDisplayGUIChestSuperiors = value;
    }

    public void setBeforeDisplayGUIChestInferiors(String[] value) {
        this.beforeDisplayGUIChestInferiors = value;
    }

    public void setOverrideDisplayGUIChestSuperiors(String[] value) {
        this.overrideDisplayGUIChestSuperiors = value;
    }

    public void setOverrideDisplayGUIChestInferiors(String[] value) {
        this.overrideDisplayGUIChestInferiors = value;
    }

    public void setAfterDisplayGUIChestSuperiors(String[] value) {
        this.afterDisplayGUIChestSuperiors = value;
    }

    public void setAfterDisplayGUIChestInferiors(String[] value) {
        this.afterDisplayGUIChestInferiors = value;
    }

    public String[] getBeforeDisplayGUIDispenserSuperiors() {
        return this.beforeDisplayGUIDispenserSuperiors;
    }

    public String[] getBeforeDisplayGUIDispenserInferiors() {
        return this.beforeDisplayGUIDispenserInferiors;
    }

    public String[] getOverrideDisplayGUIDispenserSuperiors() {
        return this.overrideDisplayGUIDispenserSuperiors;
    }

    public String[] getOverrideDisplayGUIDispenserInferiors() {
        return this.overrideDisplayGUIDispenserInferiors;
    }

    public String[] getAfterDisplayGUIDispenserSuperiors() {
        return this.afterDisplayGUIDispenserSuperiors;
    }

    public String[] getAfterDisplayGUIDispenserInferiors() {
        return this.afterDisplayGUIDispenserInferiors;
    }

    public void setBeforeDisplayGUIDispenserSuperiors(String[] value) {
        this.beforeDisplayGUIDispenserSuperiors = value;
    }

    public void setBeforeDisplayGUIDispenserInferiors(String[] value) {
        this.beforeDisplayGUIDispenserInferiors = value;
    }

    public void setOverrideDisplayGUIDispenserSuperiors(String[] value) {
        this.overrideDisplayGUIDispenserSuperiors = value;
    }

    public void setOverrideDisplayGUIDispenserInferiors(String[] value) {
        this.overrideDisplayGUIDispenserInferiors = value;
    }

    public void setAfterDisplayGUIDispenserSuperiors(String[] value) {
        this.afterDisplayGUIDispenserSuperiors = value;
    }

    public void setAfterDisplayGUIDispenserInferiors(String[] value) {
        this.afterDisplayGUIDispenserInferiors = value;
    }

    public String[] getBeforeDisplayGUIFurnaceSuperiors() {
        return this.beforeDisplayGUIFurnaceSuperiors;
    }

    public String[] getBeforeDisplayGUIFurnaceInferiors() {
        return this.beforeDisplayGUIFurnaceInferiors;
    }

    public String[] getOverrideDisplayGUIFurnaceSuperiors() {
        return this.overrideDisplayGUIFurnaceSuperiors;
    }

    public String[] getOverrideDisplayGUIFurnaceInferiors() {
        return this.overrideDisplayGUIFurnaceInferiors;
    }

    public String[] getAfterDisplayGUIFurnaceSuperiors() {
        return this.afterDisplayGUIFurnaceSuperiors;
    }

    public String[] getAfterDisplayGUIFurnaceInferiors() {
        return this.afterDisplayGUIFurnaceInferiors;
    }

    public void setBeforeDisplayGUIFurnaceSuperiors(String[] value) {
        this.beforeDisplayGUIFurnaceSuperiors = value;
    }

    public void setBeforeDisplayGUIFurnaceInferiors(String[] value) {
        this.beforeDisplayGUIFurnaceInferiors = value;
    }

    public void setOverrideDisplayGUIFurnaceSuperiors(String[] value) {
        this.overrideDisplayGUIFurnaceSuperiors = value;
    }

    public void setOverrideDisplayGUIFurnaceInferiors(String[] value) {
        this.overrideDisplayGUIFurnaceInferiors = value;
    }

    public void setAfterDisplayGUIFurnaceSuperiors(String[] value) {
        this.afterDisplayGUIFurnaceSuperiors = value;
    }

    public void setAfterDisplayGUIFurnaceInferiors(String[] value) {
        this.afterDisplayGUIFurnaceInferiors = value;
    }

    public String[] getBeforeDisplayGUIWorkbenchSuperiors() {
        return this.beforeDisplayGUIWorkbenchSuperiors;
    }

    public String[] getBeforeDisplayGUIWorkbenchInferiors() {
        return this.beforeDisplayGUIWorkbenchInferiors;
    }

    public String[] getOverrideDisplayGUIWorkbenchSuperiors() {
        return this.overrideDisplayGUIWorkbenchSuperiors;
    }

    public String[] getOverrideDisplayGUIWorkbenchInferiors() {
        return this.overrideDisplayGUIWorkbenchInferiors;
    }

    public String[] getAfterDisplayGUIWorkbenchSuperiors() {
        return this.afterDisplayGUIWorkbenchSuperiors;
    }

    public String[] getAfterDisplayGUIWorkbenchInferiors() {
        return this.afterDisplayGUIWorkbenchInferiors;
    }

    public void setBeforeDisplayGUIWorkbenchSuperiors(String[] value) {
        this.beforeDisplayGUIWorkbenchSuperiors = value;
    }

    public void setBeforeDisplayGUIWorkbenchInferiors(String[] value) {
        this.beforeDisplayGUIWorkbenchInferiors = value;
    }

    public void setOverrideDisplayGUIWorkbenchSuperiors(String[] value) {
        this.overrideDisplayGUIWorkbenchSuperiors = value;
    }

    public void setOverrideDisplayGUIWorkbenchInferiors(String[] value) {
        this.overrideDisplayGUIWorkbenchInferiors = value;
    }

    public void setAfterDisplayGUIWorkbenchSuperiors(String[] value) {
        this.afterDisplayGUIWorkbenchSuperiors = value;
    }

    public void setAfterDisplayGUIWorkbenchInferiors(String[] value) {
        this.afterDisplayGUIWorkbenchInferiors = value;
    }

    public String[] getBeforeDropOneItemSuperiors() {
        return this.beforeDropOneItemSuperiors;
    }

    public String[] getBeforeDropOneItemInferiors() {
        return this.beforeDropOneItemInferiors;
    }

    public String[] getOverrideDropOneItemSuperiors() {
        return this.overrideDropOneItemSuperiors;
    }

    public String[] getOverrideDropOneItemInferiors() {
        return this.overrideDropOneItemInferiors;
    }

    public String[] getAfterDropOneItemSuperiors() {
        return this.afterDropOneItemSuperiors;
    }

    public String[] getAfterDropOneItemInferiors() {
        return this.afterDropOneItemInferiors;
    }

    public void setBeforeDropOneItemSuperiors(String[] value) {
        this.beforeDropOneItemSuperiors = value;
    }

    public void setBeforeDropOneItemInferiors(String[] value) {
        this.beforeDropOneItemInferiors = value;
    }

    public void setOverrideDropOneItemSuperiors(String[] value) {
        this.overrideDropOneItemSuperiors = value;
    }

    public void setOverrideDropOneItemInferiors(String[] value) {
        this.overrideDropOneItemInferiors = value;
    }

    public void setAfterDropOneItemSuperiors(String[] value) {
        this.afterDropOneItemSuperiors = value;
    }

    public void setAfterDropOneItemInferiors(String[] value) {
        this.afterDropOneItemInferiors = value;
    }

    public String[] getBeforeDropPlayerItemSuperiors() {
        return this.beforeDropPlayerItemSuperiors;
    }

    public String[] getBeforeDropPlayerItemInferiors() {
        return this.beforeDropPlayerItemInferiors;
    }

    public String[] getOverrideDropPlayerItemSuperiors() {
        return this.overrideDropPlayerItemSuperiors;
    }

    public String[] getOverrideDropPlayerItemInferiors() {
        return this.overrideDropPlayerItemInferiors;
    }

    public String[] getAfterDropPlayerItemSuperiors() {
        return this.afterDropPlayerItemSuperiors;
    }

    public String[] getAfterDropPlayerItemInferiors() {
        return this.afterDropPlayerItemInferiors;
    }

    public void setBeforeDropPlayerItemSuperiors(String[] value) {
        this.beforeDropPlayerItemSuperiors = value;
    }

    public void setBeforeDropPlayerItemInferiors(String[] value) {
        this.beforeDropPlayerItemInferiors = value;
    }

    public void setOverrideDropPlayerItemSuperiors(String[] value) {
        this.overrideDropPlayerItemSuperiors = value;
    }

    public void setOverrideDropPlayerItemInferiors(String[] value) {
        this.overrideDropPlayerItemInferiors = value;
    }

    public void setAfterDropPlayerItemSuperiors(String[] value) {
        this.afterDropPlayerItemSuperiors = value;
    }

    public void setAfterDropPlayerItemInferiors(String[] value) {
        this.afterDropPlayerItemInferiors = value;
    }

    public String[] getBeforeFallSuperiors() {
        return this.beforeFallSuperiors;
    }

    public String[] getBeforeFallInferiors() {
        return this.beforeFallInferiors;
    }

    public String[] getOverrideFallSuperiors() {
        return this.overrideFallSuperiors;
    }

    public String[] getOverrideFallInferiors() {
        return this.overrideFallInferiors;
    }

    public String[] getAfterFallSuperiors() {
        return this.afterFallSuperiors;
    }

    public String[] getAfterFallInferiors() {
        return this.afterFallInferiors;
    }

    public void setBeforeFallSuperiors(String[] value) {
        this.beforeFallSuperiors = value;
    }

    public void setBeforeFallInferiors(String[] value) {
        this.beforeFallInferiors = value;
    }

    public void setOverrideFallSuperiors(String[] value) {
        this.overrideFallSuperiors = value;
    }

    public void setOverrideFallInferiors(String[] value) {
        this.overrideFallInferiors = value;
    }

    public void setAfterFallSuperiors(String[] value) {
        this.afterFallSuperiors = value;
    }

    public void setAfterFallInferiors(String[] value) {
        this.afterFallInferiors = value;
    }

    public String[] getBeforeGetAIMoveSpeedSuperiors() {
        return this.beforeGetAIMoveSpeedSuperiors;
    }

    public String[] getBeforeGetAIMoveSpeedInferiors() {
        return this.beforeGetAIMoveSpeedInferiors;
    }

    public String[] getOverrideGetAIMoveSpeedSuperiors() {
        return this.overrideGetAIMoveSpeedSuperiors;
    }

    public String[] getOverrideGetAIMoveSpeedInferiors() {
        return this.overrideGetAIMoveSpeedInferiors;
    }

    public String[] getAfterGetAIMoveSpeedSuperiors() {
        return this.afterGetAIMoveSpeedSuperiors;
    }

    public String[] getAfterGetAIMoveSpeedInferiors() {
        return this.afterGetAIMoveSpeedInferiors;
    }

    public void setBeforeGetAIMoveSpeedSuperiors(String[] value) {
        this.beforeGetAIMoveSpeedSuperiors = value;
    }

    public void setBeforeGetAIMoveSpeedInferiors(String[] value) {
        this.beforeGetAIMoveSpeedInferiors = value;
    }

    public void setOverrideGetAIMoveSpeedSuperiors(String[] value) {
        this.overrideGetAIMoveSpeedSuperiors = value;
    }

    public void setOverrideGetAIMoveSpeedInferiors(String[] value) {
        this.overrideGetAIMoveSpeedInferiors = value;
    }

    public void setAfterGetAIMoveSpeedSuperiors(String[] value) {
        this.afterGetAIMoveSpeedSuperiors = value;
    }

    public void setAfterGetAIMoveSpeedInferiors(String[] value) {
        this.afterGetAIMoveSpeedInferiors = value;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockSuperiors() {
        return this.beforeGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockInferiors() {
        return this.beforeGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockSuperiors() {
        return this.overrideGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockInferiors() {
        return this.overrideGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockSuperiors() {
        return this.afterGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockInferiors() {
        return this.afterGetCurrentPlayerStrVsBlockInferiors;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockSuperiors(String[] value) {
        this.beforeGetCurrentPlayerStrVsBlockSuperiors = value;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockInferiors(String[] value) {
        this.beforeGetCurrentPlayerStrVsBlockInferiors = value;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockSuperiors(String[] value) {
        this.overrideGetCurrentPlayerStrVsBlockSuperiors = value;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockInferiors(String[] value) {
        this.overrideGetCurrentPlayerStrVsBlockInferiors = value;
    }

    public void setAfterGetCurrentPlayerStrVsBlockSuperiors(String[] value) {
        this.afterGetCurrentPlayerStrVsBlockSuperiors = value;
    }

    public void setAfterGetCurrentPlayerStrVsBlockInferiors(String[] value) {
        this.afterGetCurrentPlayerStrVsBlockInferiors = value;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.beforeGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.overrideGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.afterGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.afterGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockForgeSuperiors(String[] value) {
        this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors = value;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockForgeInferiors(String[] value) {
        this.beforeGetCurrentPlayerStrVsBlockForgeInferiors = value;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockForgeSuperiors(String[] value) {
        this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors = value;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockForgeInferiors(String[] value) {
        this.overrideGetCurrentPlayerStrVsBlockForgeInferiors = value;
    }

    public void setAfterGetCurrentPlayerStrVsBlockForgeSuperiors(String[] value) {
        this.afterGetCurrentPlayerStrVsBlockForgeSuperiors = value;
    }

    public void setAfterGetCurrentPlayerStrVsBlockForgeInferiors(String[] value) {
        this.afterGetCurrentPlayerStrVsBlockForgeInferiors = value;
    }

    public String[] getBeforeGetDistanceSqSuperiors() {
        return this.beforeGetDistanceSqSuperiors;
    }

    public String[] getBeforeGetDistanceSqInferiors() {
        return this.beforeGetDistanceSqInferiors;
    }

    public String[] getOverrideGetDistanceSqSuperiors() {
        return this.overrideGetDistanceSqSuperiors;
    }

    public String[] getOverrideGetDistanceSqInferiors() {
        return this.overrideGetDistanceSqInferiors;
    }

    public String[] getAfterGetDistanceSqSuperiors() {
        return this.afterGetDistanceSqSuperiors;
    }

    public String[] getAfterGetDistanceSqInferiors() {
        return this.afterGetDistanceSqInferiors;
    }

    public void setBeforeGetDistanceSqSuperiors(String[] value) {
        this.beforeGetDistanceSqSuperiors = value;
    }

    public void setBeforeGetDistanceSqInferiors(String[] value) {
        this.beforeGetDistanceSqInferiors = value;
    }

    public void setOverrideGetDistanceSqSuperiors(String[] value) {
        this.overrideGetDistanceSqSuperiors = value;
    }

    public void setOverrideGetDistanceSqInferiors(String[] value) {
        this.overrideGetDistanceSqInferiors = value;
    }

    public void setAfterGetDistanceSqSuperiors(String[] value) {
        this.afterGetDistanceSqSuperiors = value;
    }

    public void setAfterGetDistanceSqInferiors(String[] value) {
        this.afterGetDistanceSqInferiors = value;
    }

    public String[] getBeforeGetBrightnessSuperiors() {
        return this.beforeGetBrightnessSuperiors;
    }

    public String[] getBeforeGetBrightnessInferiors() {
        return this.beforeGetBrightnessInferiors;
    }

    public String[] getOverrideGetBrightnessSuperiors() {
        return this.overrideGetBrightnessSuperiors;
    }

    public String[] getOverrideGetBrightnessInferiors() {
        return this.overrideGetBrightnessInferiors;
    }

    public String[] getAfterGetBrightnessSuperiors() {
        return this.afterGetBrightnessSuperiors;
    }

    public String[] getAfterGetBrightnessInferiors() {
        return this.afterGetBrightnessInferiors;
    }

    public void setBeforeGetBrightnessSuperiors(String[] value) {
        this.beforeGetBrightnessSuperiors = value;
    }

    public void setBeforeGetBrightnessInferiors(String[] value) {
        this.beforeGetBrightnessInferiors = value;
    }

    public void setOverrideGetBrightnessSuperiors(String[] value) {
        this.overrideGetBrightnessSuperiors = value;
    }

    public void setOverrideGetBrightnessInferiors(String[] value) {
        this.overrideGetBrightnessInferiors = value;
    }

    public void setAfterGetBrightnessSuperiors(String[] value) {
        this.afterGetBrightnessSuperiors = value;
    }

    public void setAfterGetBrightnessInferiors(String[] value) {
        this.afterGetBrightnessInferiors = value;
    }

    public String[] getBeforeGetEyeHeightSuperiors() {
        return this.beforeGetEyeHeightSuperiors;
    }

    public String[] getBeforeGetEyeHeightInferiors() {
        return this.beforeGetEyeHeightInferiors;
    }

    public String[] getOverrideGetEyeHeightSuperiors() {
        return this.overrideGetEyeHeightSuperiors;
    }

    public String[] getOverrideGetEyeHeightInferiors() {
        return this.overrideGetEyeHeightInferiors;
    }

    public String[] getAfterGetEyeHeightSuperiors() {
        return this.afterGetEyeHeightSuperiors;
    }

    public String[] getAfterGetEyeHeightInferiors() {
        return this.afterGetEyeHeightInferiors;
    }

    public void setBeforeGetEyeHeightSuperiors(String[] value) {
        this.beforeGetEyeHeightSuperiors = value;
    }

    public void setBeforeGetEyeHeightInferiors(String[] value) {
        this.beforeGetEyeHeightInferiors = value;
    }

    public void setOverrideGetEyeHeightSuperiors(String[] value) {
        this.overrideGetEyeHeightSuperiors = value;
    }

    public void setOverrideGetEyeHeightInferiors(String[] value) {
        this.overrideGetEyeHeightInferiors = value;
    }

    public void setAfterGetEyeHeightSuperiors(String[] value) {
        this.afterGetEyeHeightSuperiors = value;
    }

    public void setAfterGetEyeHeightInferiors(String[] value) {
        this.afterGetEyeHeightInferiors = value;
    }

    public String[] getBeforeHealSuperiors() {
        return this.beforeHealSuperiors;
    }

    public String[] getBeforeHealInferiors() {
        return this.beforeHealInferiors;
    }

    public String[] getOverrideHealSuperiors() {
        return this.overrideHealSuperiors;
    }

    public String[] getOverrideHealInferiors() {
        return this.overrideHealInferiors;
    }

    public String[] getAfterHealSuperiors() {
        return this.afterHealSuperiors;
    }

    public String[] getAfterHealInferiors() {
        return this.afterHealInferiors;
    }

    public void setBeforeHealSuperiors(String[] value) {
        this.beforeHealSuperiors = value;
    }

    public void setBeforeHealInferiors(String[] value) {
        this.beforeHealInferiors = value;
    }

    public void setOverrideHealSuperiors(String[] value) {
        this.overrideHealSuperiors = value;
    }

    public void setOverrideHealInferiors(String[] value) {
        this.overrideHealInferiors = value;
    }

    public void setAfterHealSuperiors(String[] value) {
        this.afterHealSuperiors = value;
    }

    public void setAfterHealInferiors(String[] value) {
        this.afterHealInferiors = value;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockSuperiors() {
        return this.beforeIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockInferiors() {
        return this.beforeIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockSuperiors() {
        return this.overrideIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockInferiors() {
        return this.overrideIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockSuperiors() {
        return this.afterIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockInferiors() {
        return this.afterIsEntityInsideOpaqueBlockInferiors;
    }

    public void setBeforeIsEntityInsideOpaqueBlockSuperiors(String[] value) {
        this.beforeIsEntityInsideOpaqueBlockSuperiors = value;
    }

    public void setBeforeIsEntityInsideOpaqueBlockInferiors(String[] value) {
        this.beforeIsEntityInsideOpaqueBlockInferiors = value;
    }

    public void setOverrideIsEntityInsideOpaqueBlockSuperiors(String[] value) {
        this.overrideIsEntityInsideOpaqueBlockSuperiors = value;
    }

    public void setOverrideIsEntityInsideOpaqueBlockInferiors(String[] value) {
        this.overrideIsEntityInsideOpaqueBlockInferiors = value;
    }

    public void setAfterIsEntityInsideOpaqueBlockSuperiors(String[] value) {
        this.afterIsEntityInsideOpaqueBlockSuperiors = value;
    }

    public void setAfterIsEntityInsideOpaqueBlockInferiors(String[] value) {
        this.afterIsEntityInsideOpaqueBlockInferiors = value;
    }

    public String[] getBeforeIsInWaterSuperiors() {
        return this.beforeIsInWaterSuperiors;
    }

    public String[] getBeforeIsInWaterInferiors() {
        return this.beforeIsInWaterInferiors;
    }

    public String[] getOverrideIsInWaterSuperiors() {
        return this.overrideIsInWaterSuperiors;
    }

    public String[] getOverrideIsInWaterInferiors() {
        return this.overrideIsInWaterInferiors;
    }

    public String[] getAfterIsInWaterSuperiors() {
        return this.afterIsInWaterSuperiors;
    }

    public String[] getAfterIsInWaterInferiors() {
        return this.afterIsInWaterInferiors;
    }

    public void setBeforeIsInWaterSuperiors(String[] value) {
        this.beforeIsInWaterSuperiors = value;
    }

    public void setBeforeIsInWaterInferiors(String[] value) {
        this.beforeIsInWaterInferiors = value;
    }

    public void setOverrideIsInWaterSuperiors(String[] value) {
        this.overrideIsInWaterSuperiors = value;
    }

    public void setOverrideIsInWaterInferiors(String[] value) {
        this.overrideIsInWaterInferiors = value;
    }

    public void setAfterIsInWaterSuperiors(String[] value) {
        this.afterIsInWaterSuperiors = value;
    }

    public void setAfterIsInWaterInferiors(String[] value) {
        this.afterIsInWaterInferiors = value;
    }

    public String[] getBeforeIsInsideOfMaterialSuperiors() {
        return this.beforeIsInsideOfMaterialSuperiors;
    }

    public String[] getBeforeIsInsideOfMaterialInferiors() {
        return this.beforeIsInsideOfMaterialInferiors;
    }

    public String[] getOverrideIsInsideOfMaterialSuperiors() {
        return this.overrideIsInsideOfMaterialSuperiors;
    }

    public String[] getOverrideIsInsideOfMaterialInferiors() {
        return this.overrideIsInsideOfMaterialInferiors;
    }

    public String[] getAfterIsInsideOfMaterialSuperiors() {
        return this.afterIsInsideOfMaterialSuperiors;
    }

    public String[] getAfterIsInsideOfMaterialInferiors() {
        return this.afterIsInsideOfMaterialInferiors;
    }

    public void setBeforeIsInsideOfMaterialSuperiors(String[] value) {
        this.beforeIsInsideOfMaterialSuperiors = value;
    }

    public void setBeforeIsInsideOfMaterialInferiors(String[] value) {
        this.beforeIsInsideOfMaterialInferiors = value;
    }

    public void setOverrideIsInsideOfMaterialSuperiors(String[] value) {
        this.overrideIsInsideOfMaterialSuperiors = value;
    }

    public void setOverrideIsInsideOfMaterialInferiors(String[] value) {
        this.overrideIsInsideOfMaterialInferiors = value;
    }

    public void setAfterIsInsideOfMaterialSuperiors(String[] value) {
        this.afterIsInsideOfMaterialSuperiors = value;
    }

    public void setAfterIsInsideOfMaterialInferiors(String[] value) {
        this.afterIsInsideOfMaterialInferiors = value;
    }

    public String[] getBeforeIsOnLadderSuperiors() {
        return this.beforeIsOnLadderSuperiors;
    }

    public String[] getBeforeIsOnLadderInferiors() {
        return this.beforeIsOnLadderInferiors;
    }

    public String[] getOverrideIsOnLadderSuperiors() {
        return this.overrideIsOnLadderSuperiors;
    }

    public String[] getOverrideIsOnLadderInferiors() {
        return this.overrideIsOnLadderInferiors;
    }

    public String[] getAfterIsOnLadderSuperiors() {
        return this.afterIsOnLadderSuperiors;
    }

    public String[] getAfterIsOnLadderInferiors() {
        return this.afterIsOnLadderInferiors;
    }

    public void setBeforeIsOnLadderSuperiors(String[] value) {
        this.beforeIsOnLadderSuperiors = value;
    }

    public void setBeforeIsOnLadderInferiors(String[] value) {
        this.beforeIsOnLadderInferiors = value;
    }

    public void setOverrideIsOnLadderSuperiors(String[] value) {
        this.overrideIsOnLadderSuperiors = value;
    }

    public void setOverrideIsOnLadderInferiors(String[] value) {
        this.overrideIsOnLadderInferiors = value;
    }

    public void setAfterIsOnLadderSuperiors(String[] value) {
        this.afterIsOnLadderSuperiors = value;
    }

    public void setAfterIsOnLadderInferiors(String[] value) {
        this.afterIsOnLadderInferiors = value;
    }

    public String[] getBeforeIsPlayerSleepingSuperiors() {
        return this.beforeIsPlayerSleepingSuperiors;
    }

    public String[] getBeforeIsPlayerSleepingInferiors() {
        return this.beforeIsPlayerSleepingInferiors;
    }

    public String[] getOverrideIsPlayerSleepingSuperiors() {
        return this.overrideIsPlayerSleepingSuperiors;
    }

    public String[] getOverrideIsPlayerSleepingInferiors() {
        return this.overrideIsPlayerSleepingInferiors;
    }

    public String[] getAfterIsPlayerSleepingSuperiors() {
        return this.afterIsPlayerSleepingSuperiors;
    }

    public String[] getAfterIsPlayerSleepingInferiors() {
        return this.afterIsPlayerSleepingInferiors;
    }

    public void setBeforeIsPlayerSleepingSuperiors(String[] value) {
        this.beforeIsPlayerSleepingSuperiors = value;
    }

    public void setBeforeIsPlayerSleepingInferiors(String[] value) {
        this.beforeIsPlayerSleepingInferiors = value;
    }

    public void setOverrideIsPlayerSleepingSuperiors(String[] value) {
        this.overrideIsPlayerSleepingSuperiors = value;
    }

    public void setOverrideIsPlayerSleepingInferiors(String[] value) {
        this.overrideIsPlayerSleepingInferiors = value;
    }

    public void setAfterIsPlayerSleepingSuperiors(String[] value) {
        this.afterIsPlayerSleepingSuperiors = value;
    }

    public void setAfterIsPlayerSleepingInferiors(String[] value) {
        this.afterIsPlayerSleepingInferiors = value;
    }

    public String[] getBeforeIsSneakingSuperiors() {
        return this.beforeIsSneakingSuperiors;
    }

    public String[] getBeforeIsSneakingInferiors() {
        return this.beforeIsSneakingInferiors;
    }

    public String[] getOverrideIsSneakingSuperiors() {
        return this.overrideIsSneakingSuperiors;
    }

    public String[] getOverrideIsSneakingInferiors() {
        return this.overrideIsSneakingInferiors;
    }

    public String[] getAfterIsSneakingSuperiors() {
        return this.afterIsSneakingSuperiors;
    }

    public String[] getAfterIsSneakingInferiors() {
        return this.afterIsSneakingInferiors;
    }

    public void setBeforeIsSneakingSuperiors(String[] value) {
        this.beforeIsSneakingSuperiors = value;
    }

    public void setBeforeIsSneakingInferiors(String[] value) {
        this.beforeIsSneakingInferiors = value;
    }

    public void setOverrideIsSneakingSuperiors(String[] value) {
        this.overrideIsSneakingSuperiors = value;
    }

    public void setOverrideIsSneakingInferiors(String[] value) {
        this.overrideIsSneakingInferiors = value;
    }

    public void setAfterIsSneakingSuperiors(String[] value) {
        this.afterIsSneakingSuperiors = value;
    }

    public void setAfterIsSneakingInferiors(String[] value) {
        this.afterIsSneakingInferiors = value;
    }

    public String[] getBeforeJumpSuperiors() {
        return this.beforeJumpSuperiors;
    }

    public String[] getBeforeJumpInferiors() {
        return this.beforeJumpInferiors;
    }

    public String[] getOverrideJumpSuperiors() {
        return this.overrideJumpSuperiors;
    }

    public String[] getOverrideJumpInferiors() {
        return this.overrideJumpInferiors;
    }

    public String[] getAfterJumpSuperiors() {
        return this.afterJumpSuperiors;
    }

    public String[] getAfterJumpInferiors() {
        return this.afterJumpInferiors;
    }

    public void setBeforeJumpSuperiors(String[] value) {
        this.beforeJumpSuperiors = value;
    }

    public void setBeforeJumpInferiors(String[] value) {
        this.beforeJumpInferiors = value;
    }

    public void setOverrideJumpSuperiors(String[] value) {
        this.overrideJumpSuperiors = value;
    }

    public void setOverrideJumpInferiors(String[] value) {
        this.overrideJumpInferiors = value;
    }

    public void setAfterJumpSuperiors(String[] value) {
        this.afterJumpSuperiors = value;
    }

    public void setAfterJumpInferiors(String[] value) {
        this.afterJumpInferiors = value;
    }

    public String[] getBeforeKnockBackSuperiors() {
        return this.beforeKnockBackSuperiors;
    }

    public String[] getBeforeKnockBackInferiors() {
        return this.beforeKnockBackInferiors;
    }

    public String[] getOverrideKnockBackSuperiors() {
        return this.overrideKnockBackSuperiors;
    }

    public String[] getOverrideKnockBackInferiors() {
        return this.overrideKnockBackInferiors;
    }

    public String[] getAfterKnockBackSuperiors() {
        return this.afterKnockBackSuperiors;
    }

    public String[] getAfterKnockBackInferiors() {
        return this.afterKnockBackInferiors;
    }

    public void setBeforeKnockBackSuperiors(String[] value) {
        this.beforeKnockBackSuperiors = value;
    }

    public void setBeforeKnockBackInferiors(String[] value) {
        this.beforeKnockBackInferiors = value;
    }

    public void setOverrideKnockBackSuperiors(String[] value) {
        this.overrideKnockBackSuperiors = value;
    }

    public void setOverrideKnockBackInferiors(String[] value) {
        this.overrideKnockBackInferiors = value;
    }

    public void setAfterKnockBackSuperiors(String[] value) {
        this.afterKnockBackSuperiors = value;
    }

    public void setAfterKnockBackInferiors(String[] value) {
        this.afterKnockBackInferiors = value;
    }

    public String[] getBeforeMountEntitySuperiors() {
        return this.beforeMountEntitySuperiors;
    }

    public String[] getBeforeMountEntityInferiors() {
        return this.beforeMountEntityInferiors;
    }

    public String[] getOverrideMountEntitySuperiors() {
        return this.overrideMountEntitySuperiors;
    }

    public String[] getOverrideMountEntityInferiors() {
        return this.overrideMountEntityInferiors;
    }

    public String[] getAfterMountEntitySuperiors() {
        return this.afterMountEntitySuperiors;
    }

    public String[] getAfterMountEntityInferiors() {
        return this.afterMountEntityInferiors;
    }

    public void setBeforeMountEntitySuperiors(String[] value) {
        this.beforeMountEntitySuperiors = value;
    }

    public void setBeforeMountEntityInferiors(String[] value) {
        this.beforeMountEntityInferiors = value;
    }

    public void setOverrideMountEntitySuperiors(String[] value) {
        this.overrideMountEntitySuperiors = value;
    }

    public void setOverrideMountEntityInferiors(String[] value) {
        this.overrideMountEntityInferiors = value;
    }

    public void setAfterMountEntitySuperiors(String[] value) {
        this.afterMountEntitySuperiors = value;
    }

    public void setAfterMountEntityInferiors(String[] value) {
        this.afterMountEntityInferiors = value;
    }

    public String[] getBeforeMoveEntitySuperiors() {
        return this.beforeMoveEntitySuperiors;
    }

    public String[] getBeforeMoveEntityInferiors() {
        return this.beforeMoveEntityInferiors;
    }

    public String[] getOverrideMoveEntitySuperiors() {
        return this.overrideMoveEntitySuperiors;
    }

    public String[] getOverrideMoveEntityInferiors() {
        return this.overrideMoveEntityInferiors;
    }

    public String[] getAfterMoveEntitySuperiors() {
        return this.afterMoveEntitySuperiors;
    }

    public String[] getAfterMoveEntityInferiors() {
        return this.afterMoveEntityInferiors;
    }

    public void setBeforeMoveEntitySuperiors(String[] value) {
        this.beforeMoveEntitySuperiors = value;
    }

    public void setBeforeMoveEntityInferiors(String[] value) {
        this.beforeMoveEntityInferiors = value;
    }

    public void setOverrideMoveEntitySuperiors(String[] value) {
        this.overrideMoveEntitySuperiors = value;
    }

    public void setOverrideMoveEntityInferiors(String[] value) {
        this.overrideMoveEntityInferiors = value;
    }

    public void setAfterMoveEntitySuperiors(String[] value) {
        this.afterMoveEntitySuperiors = value;
    }

    public void setAfterMoveEntityInferiors(String[] value) {
        this.afterMoveEntityInferiors = value;
    }

    public String[] getBeforeMoveEntityWithHeadingSuperiors() {
        return this.beforeMoveEntityWithHeadingSuperiors;
    }

    public String[] getBeforeMoveEntityWithHeadingInferiors() {
        return this.beforeMoveEntityWithHeadingInferiors;
    }

    public String[] getOverrideMoveEntityWithHeadingSuperiors() {
        return this.overrideMoveEntityWithHeadingSuperiors;
    }

    public String[] getOverrideMoveEntityWithHeadingInferiors() {
        return this.overrideMoveEntityWithHeadingInferiors;
    }

    public String[] getAfterMoveEntityWithHeadingSuperiors() {
        return this.afterMoveEntityWithHeadingSuperiors;
    }

    public String[] getAfterMoveEntityWithHeadingInferiors() {
        return this.afterMoveEntityWithHeadingInferiors;
    }

    public void setBeforeMoveEntityWithHeadingSuperiors(String[] value) {
        this.beforeMoveEntityWithHeadingSuperiors = value;
    }

    public void setBeforeMoveEntityWithHeadingInferiors(String[] value) {
        this.beforeMoveEntityWithHeadingInferiors = value;
    }

    public void setOverrideMoveEntityWithHeadingSuperiors(String[] value) {
        this.overrideMoveEntityWithHeadingSuperiors = value;
    }

    public void setOverrideMoveEntityWithHeadingInferiors(String[] value) {
        this.overrideMoveEntityWithHeadingInferiors = value;
    }

    public void setAfterMoveEntityWithHeadingSuperiors(String[] value) {
        this.afterMoveEntityWithHeadingSuperiors = value;
    }

    public void setAfterMoveEntityWithHeadingInferiors(String[] value) {
        this.afterMoveEntityWithHeadingInferiors = value;
    }

    public String[] getBeforeMoveFlyingSuperiors() {
        return this.beforeMoveFlyingSuperiors;
    }

    public String[] getBeforeMoveFlyingInferiors() {
        return this.beforeMoveFlyingInferiors;
    }

    public String[] getOverrideMoveFlyingSuperiors() {
        return this.overrideMoveFlyingSuperiors;
    }

    public String[] getOverrideMoveFlyingInferiors() {
        return this.overrideMoveFlyingInferiors;
    }

    public String[] getAfterMoveFlyingSuperiors() {
        return this.afterMoveFlyingSuperiors;
    }

    public String[] getAfterMoveFlyingInferiors() {
        return this.afterMoveFlyingInferiors;
    }

    public void setBeforeMoveFlyingSuperiors(String[] value) {
        this.beforeMoveFlyingSuperiors = value;
    }

    public void setBeforeMoveFlyingInferiors(String[] value) {
        this.beforeMoveFlyingInferiors = value;
    }

    public void setOverrideMoveFlyingSuperiors(String[] value) {
        this.overrideMoveFlyingSuperiors = value;
    }

    public void setOverrideMoveFlyingInferiors(String[] value) {
        this.overrideMoveFlyingInferiors = value;
    }

    public void setAfterMoveFlyingSuperiors(String[] value) {
        this.afterMoveFlyingSuperiors = value;
    }

    public void setAfterMoveFlyingInferiors(String[] value) {
        this.afterMoveFlyingInferiors = value;
    }

    public String[] getBeforeOnDeathSuperiors() {
        return this.beforeOnDeathSuperiors;
    }

    public String[] getBeforeOnDeathInferiors() {
        return this.beforeOnDeathInferiors;
    }

    public String[] getOverrideOnDeathSuperiors() {
        return this.overrideOnDeathSuperiors;
    }

    public String[] getOverrideOnDeathInferiors() {
        return this.overrideOnDeathInferiors;
    }

    public String[] getAfterOnDeathSuperiors() {
        return this.afterOnDeathSuperiors;
    }

    public String[] getAfterOnDeathInferiors() {
        return this.afterOnDeathInferiors;
    }

    public void setBeforeOnDeathSuperiors(String[] value) {
        this.beforeOnDeathSuperiors = value;
    }

    public void setBeforeOnDeathInferiors(String[] value) {
        this.beforeOnDeathInferiors = value;
    }

    public void setOverrideOnDeathSuperiors(String[] value) {
        this.overrideOnDeathSuperiors = value;
    }

    public void setOverrideOnDeathInferiors(String[] value) {
        this.overrideOnDeathInferiors = value;
    }

    public void setAfterOnDeathSuperiors(String[] value) {
        this.afterOnDeathSuperiors = value;
    }

    public void setAfterOnDeathInferiors(String[] value) {
        this.afterOnDeathInferiors = value;
    }

    public String[] getBeforeOnLivingUpdateSuperiors() {
        return this.beforeOnLivingUpdateSuperiors;
    }

    public String[] getBeforeOnLivingUpdateInferiors() {
        return this.beforeOnLivingUpdateInferiors;
    }

    public String[] getOverrideOnLivingUpdateSuperiors() {
        return this.overrideOnLivingUpdateSuperiors;
    }

    public String[] getOverrideOnLivingUpdateInferiors() {
        return this.overrideOnLivingUpdateInferiors;
    }

    public String[] getAfterOnLivingUpdateSuperiors() {
        return this.afterOnLivingUpdateSuperiors;
    }

    public String[] getAfterOnLivingUpdateInferiors() {
        return this.afterOnLivingUpdateInferiors;
    }

    public void setBeforeOnLivingUpdateSuperiors(String[] value) {
        this.beforeOnLivingUpdateSuperiors = value;
    }

    public void setBeforeOnLivingUpdateInferiors(String[] value) {
        this.beforeOnLivingUpdateInferiors = value;
    }

    public void setOverrideOnLivingUpdateSuperiors(String[] value) {
        this.overrideOnLivingUpdateSuperiors = value;
    }

    public void setOverrideOnLivingUpdateInferiors(String[] value) {
        this.overrideOnLivingUpdateInferiors = value;
    }

    public void setAfterOnLivingUpdateSuperiors(String[] value) {
        this.afterOnLivingUpdateSuperiors = value;
    }

    public void setAfterOnLivingUpdateInferiors(String[] value) {
        this.afterOnLivingUpdateInferiors = value;
    }

    public String[] getBeforeOnKillEntitySuperiors() {
        return this.beforeOnKillEntitySuperiors;
    }

    public String[] getBeforeOnKillEntityInferiors() {
        return this.beforeOnKillEntityInferiors;
    }

    public String[] getOverrideOnKillEntitySuperiors() {
        return this.overrideOnKillEntitySuperiors;
    }

    public String[] getOverrideOnKillEntityInferiors() {
        return this.overrideOnKillEntityInferiors;
    }

    public String[] getAfterOnKillEntitySuperiors() {
        return this.afterOnKillEntitySuperiors;
    }

    public String[] getAfterOnKillEntityInferiors() {
        return this.afterOnKillEntityInferiors;
    }

    public void setBeforeOnKillEntitySuperiors(String[] value) {
        this.beforeOnKillEntitySuperiors = value;
    }

    public void setBeforeOnKillEntityInferiors(String[] value) {
        this.beforeOnKillEntityInferiors = value;
    }

    public void setOverrideOnKillEntitySuperiors(String[] value) {
        this.overrideOnKillEntitySuperiors = value;
    }

    public void setOverrideOnKillEntityInferiors(String[] value) {
        this.overrideOnKillEntityInferiors = value;
    }

    public void setAfterOnKillEntitySuperiors(String[] value) {
        this.afterOnKillEntitySuperiors = value;
    }

    public void setAfterOnKillEntityInferiors(String[] value) {
        this.afterOnKillEntityInferiors = value;
    }

    public String[] getBeforeOnStruckByLightningSuperiors() {
        return this.beforeOnStruckByLightningSuperiors;
    }

    public String[] getBeforeOnStruckByLightningInferiors() {
        return this.beforeOnStruckByLightningInferiors;
    }

    public String[] getOverrideOnStruckByLightningSuperiors() {
        return this.overrideOnStruckByLightningSuperiors;
    }

    public String[] getOverrideOnStruckByLightningInferiors() {
        return this.overrideOnStruckByLightningInferiors;
    }

    public String[] getAfterOnStruckByLightningSuperiors() {
        return this.afterOnStruckByLightningSuperiors;
    }

    public String[] getAfterOnStruckByLightningInferiors() {
        return this.afterOnStruckByLightningInferiors;
    }

    public void setBeforeOnStruckByLightningSuperiors(String[] value) {
        this.beforeOnStruckByLightningSuperiors = value;
    }

    public void setBeforeOnStruckByLightningInferiors(String[] value) {
        this.beforeOnStruckByLightningInferiors = value;
    }

    public void setOverrideOnStruckByLightningSuperiors(String[] value) {
        this.overrideOnStruckByLightningSuperiors = value;
    }

    public void setOverrideOnStruckByLightningInferiors(String[] value) {
        this.overrideOnStruckByLightningInferiors = value;
    }

    public void setAfterOnStruckByLightningSuperiors(String[] value) {
        this.afterOnStruckByLightningSuperiors = value;
    }

    public void setAfterOnStruckByLightningInferiors(String[] value) {
        this.afterOnStruckByLightningInferiors = value;
    }

    public String[] getBeforeOnUpdateSuperiors() {
        return this.beforeOnUpdateSuperiors;
    }

    public String[] getBeforeOnUpdateInferiors() {
        return this.beforeOnUpdateInferiors;
    }

    public String[] getOverrideOnUpdateSuperiors() {
        return this.overrideOnUpdateSuperiors;
    }

    public String[] getOverrideOnUpdateInferiors() {
        return this.overrideOnUpdateInferiors;
    }

    public String[] getAfterOnUpdateSuperiors() {
        return this.afterOnUpdateSuperiors;
    }

    public String[] getAfterOnUpdateInferiors() {
        return this.afterOnUpdateInferiors;
    }

    public void setBeforeOnUpdateSuperiors(String[] value) {
        this.beforeOnUpdateSuperiors = value;
    }

    public void setBeforeOnUpdateInferiors(String[] value) {
        this.beforeOnUpdateInferiors = value;
    }

    public void setOverrideOnUpdateSuperiors(String[] value) {
        this.overrideOnUpdateSuperiors = value;
    }

    public void setOverrideOnUpdateInferiors(String[] value) {
        this.overrideOnUpdateInferiors = value;
    }

    public void setAfterOnUpdateSuperiors(String[] value) {
        this.afterOnUpdateSuperiors = value;
    }

    public void setAfterOnUpdateInferiors(String[] value) {
        this.afterOnUpdateInferiors = value;
    }

    public String[] getBeforeOnUpdateEntitySuperiors() {
        return this.beforeOnUpdateEntitySuperiors;
    }

    public String[] getBeforeOnUpdateEntityInferiors() {
        return this.beforeOnUpdateEntityInferiors;
    }

    public String[] getOverrideOnUpdateEntitySuperiors() {
        return this.overrideOnUpdateEntitySuperiors;
    }

    public String[] getOverrideOnUpdateEntityInferiors() {
        return this.overrideOnUpdateEntityInferiors;
    }

    public String[] getAfterOnUpdateEntitySuperiors() {
        return this.afterOnUpdateEntitySuperiors;
    }

    public String[] getAfterOnUpdateEntityInferiors() {
        return this.afterOnUpdateEntityInferiors;
    }

    public void setBeforeOnUpdateEntitySuperiors(String[] value) {
        this.beforeOnUpdateEntitySuperiors = value;
    }

    public void setBeforeOnUpdateEntityInferiors(String[] value) {
        this.beforeOnUpdateEntityInferiors = value;
    }

    public void setOverrideOnUpdateEntitySuperiors(String[] value) {
        this.overrideOnUpdateEntitySuperiors = value;
    }

    public void setOverrideOnUpdateEntityInferiors(String[] value) {
        this.overrideOnUpdateEntityInferiors = value;
    }

    public void setAfterOnUpdateEntitySuperiors(String[] value) {
        this.afterOnUpdateEntitySuperiors = value;
    }

    public void setAfterOnUpdateEntityInferiors(String[] value) {
        this.afterOnUpdateEntityInferiors = value;
    }

    public String[] getBeforeReadEntityFromNBTSuperiors() {
        return this.beforeReadEntityFromNBTSuperiors;
    }

    public String[] getBeforeReadEntityFromNBTInferiors() {
        return this.beforeReadEntityFromNBTInferiors;
    }

    public String[] getOverrideReadEntityFromNBTSuperiors() {
        return this.overrideReadEntityFromNBTSuperiors;
    }

    public String[] getOverrideReadEntityFromNBTInferiors() {
        return this.overrideReadEntityFromNBTInferiors;
    }

    public String[] getAfterReadEntityFromNBTSuperiors() {
        return this.afterReadEntityFromNBTSuperiors;
    }

    public String[] getAfterReadEntityFromNBTInferiors() {
        return this.afterReadEntityFromNBTInferiors;
    }

    public void setBeforeReadEntityFromNBTSuperiors(String[] value) {
        this.beforeReadEntityFromNBTSuperiors = value;
    }

    public void setBeforeReadEntityFromNBTInferiors(String[] value) {
        this.beforeReadEntityFromNBTInferiors = value;
    }

    public void setOverrideReadEntityFromNBTSuperiors(String[] value) {
        this.overrideReadEntityFromNBTSuperiors = value;
    }

    public void setOverrideReadEntityFromNBTInferiors(String[] value) {
        this.overrideReadEntityFromNBTInferiors = value;
    }

    public void setAfterReadEntityFromNBTSuperiors(String[] value) {
        this.afterReadEntityFromNBTSuperiors = value;
    }

    public void setAfterReadEntityFromNBTInferiors(String[] value) {
        this.afterReadEntityFromNBTInferiors = value;
    }

    public String[] getBeforeSetDeadSuperiors() {
        return this.beforeSetDeadSuperiors;
    }

    public String[] getBeforeSetDeadInferiors() {
        return this.beforeSetDeadInferiors;
    }

    public String[] getOverrideSetDeadSuperiors() {
        return this.overrideSetDeadSuperiors;
    }

    public String[] getOverrideSetDeadInferiors() {
        return this.overrideSetDeadInferiors;
    }

    public String[] getAfterSetDeadSuperiors() {
        return this.afterSetDeadSuperiors;
    }

    public String[] getAfterSetDeadInferiors() {
        return this.afterSetDeadInferiors;
    }

    public void setBeforeSetDeadSuperiors(String[] value) {
        this.beforeSetDeadSuperiors = value;
    }

    public void setBeforeSetDeadInferiors(String[] value) {
        this.beforeSetDeadInferiors = value;
    }

    public void setOverrideSetDeadSuperiors(String[] value) {
        this.overrideSetDeadSuperiors = value;
    }

    public void setOverrideSetDeadInferiors(String[] value) {
        this.overrideSetDeadInferiors = value;
    }

    public void setAfterSetDeadSuperiors(String[] value) {
        this.afterSetDeadSuperiors = value;
    }

    public void setAfterSetDeadInferiors(String[] value) {
        this.afterSetDeadInferiors = value;
    }

    public String[] getBeforeSetEntityActionStateSuperiors() {
        return this.beforeSetEntityActionStateSuperiors;
    }

    public String[] getBeforeSetEntityActionStateInferiors() {
        return this.beforeSetEntityActionStateInferiors;
    }

    public String[] getOverrideSetEntityActionStateSuperiors() {
        return this.overrideSetEntityActionStateSuperiors;
    }

    public String[] getOverrideSetEntityActionStateInferiors() {
        return this.overrideSetEntityActionStateInferiors;
    }

    public String[] getAfterSetEntityActionStateSuperiors() {
        return this.afterSetEntityActionStateSuperiors;
    }

    public String[] getAfterSetEntityActionStateInferiors() {
        return this.afterSetEntityActionStateInferiors;
    }

    public void setBeforeSetEntityActionStateSuperiors(String[] value) {
        this.beforeSetEntityActionStateSuperiors = value;
    }

    public void setBeforeSetEntityActionStateInferiors(String[] value) {
        this.beforeSetEntityActionStateInferiors = value;
    }

    public void setOverrideSetEntityActionStateSuperiors(String[] value) {
        this.overrideSetEntityActionStateSuperiors = value;
    }

    public void setOverrideSetEntityActionStateInferiors(String[] value) {
        this.overrideSetEntityActionStateInferiors = value;
    }

    public void setAfterSetEntityActionStateSuperiors(String[] value) {
        this.afterSetEntityActionStateSuperiors = value;
    }

    public void setAfterSetEntityActionStateInferiors(String[] value) {
        this.afterSetEntityActionStateInferiors = value;
    }

    public String[] getBeforeSetPositionSuperiors() {
        return this.beforeSetPositionSuperiors;
    }

    public String[] getBeforeSetPositionInferiors() {
        return this.beforeSetPositionInferiors;
    }

    public String[] getOverrideSetPositionSuperiors() {
        return this.overrideSetPositionSuperiors;
    }

    public String[] getOverrideSetPositionInferiors() {
        return this.overrideSetPositionInferiors;
    }

    public String[] getAfterSetPositionSuperiors() {
        return this.afterSetPositionSuperiors;
    }

    public String[] getAfterSetPositionInferiors() {
        return this.afterSetPositionInferiors;
    }

    public void setBeforeSetPositionSuperiors(String[] value) {
        this.beforeSetPositionSuperiors = value;
    }

    public void setBeforeSetPositionInferiors(String[] value) {
        this.beforeSetPositionInferiors = value;
    }

    public void setOverrideSetPositionSuperiors(String[] value) {
        this.overrideSetPositionSuperiors = value;
    }

    public void setOverrideSetPositionInferiors(String[] value) {
        this.overrideSetPositionInferiors = value;
    }

    public void setAfterSetPositionSuperiors(String[] value) {
        this.afterSetPositionSuperiors = value;
    }

    public void setAfterSetPositionInferiors(String[] value) {
        this.afterSetPositionInferiors = value;
    }

    public String[] getBeforeSetSneakingSuperiors() {
        return this.beforeSetSneakingSuperiors;
    }

    public String[] getBeforeSetSneakingInferiors() {
        return this.beforeSetSneakingInferiors;
    }

    public String[] getOverrideSetSneakingSuperiors() {
        return this.overrideSetSneakingSuperiors;
    }

    public String[] getOverrideSetSneakingInferiors() {
        return this.overrideSetSneakingInferiors;
    }

    public String[] getAfterSetSneakingSuperiors() {
        return this.afterSetSneakingSuperiors;
    }

    public String[] getAfterSetSneakingInferiors() {
        return this.afterSetSneakingInferiors;
    }

    public void setBeforeSetSneakingSuperiors(String[] value) {
        this.beforeSetSneakingSuperiors = value;
    }

    public void setBeforeSetSneakingInferiors(String[] value) {
        this.beforeSetSneakingInferiors = value;
    }

    public void setOverrideSetSneakingSuperiors(String[] value) {
        this.overrideSetSneakingSuperiors = value;
    }

    public void setOverrideSetSneakingInferiors(String[] value) {
        this.overrideSetSneakingInferiors = value;
    }

    public void setAfterSetSneakingSuperiors(String[] value) {
        this.afterSetSneakingSuperiors = value;
    }

    public void setAfterSetSneakingInferiors(String[] value) {
        this.afterSetSneakingInferiors = value;
    }

    public String[] getBeforeSetSprintingSuperiors() {
        return this.beforeSetSprintingSuperiors;
    }

    public String[] getBeforeSetSprintingInferiors() {
        return this.beforeSetSprintingInferiors;
    }

    public String[] getOverrideSetSprintingSuperiors() {
        return this.overrideSetSprintingSuperiors;
    }

    public String[] getOverrideSetSprintingInferiors() {
        return this.overrideSetSprintingInferiors;
    }

    public String[] getAfterSetSprintingSuperiors() {
        return this.afterSetSprintingSuperiors;
    }

    public String[] getAfterSetSprintingInferiors() {
        return this.afterSetSprintingInferiors;
    }

    public void setBeforeSetSprintingSuperiors(String[] value) {
        this.beforeSetSprintingSuperiors = value;
    }

    public void setBeforeSetSprintingInferiors(String[] value) {
        this.beforeSetSprintingInferiors = value;
    }

    public void setOverrideSetSprintingSuperiors(String[] value) {
        this.overrideSetSprintingSuperiors = value;
    }

    public void setOverrideSetSprintingInferiors(String[] value) {
        this.overrideSetSprintingInferiors = value;
    }

    public void setAfterSetSprintingSuperiors(String[] value) {
        this.afterSetSprintingSuperiors = value;
    }

    public void setAfterSetSprintingInferiors(String[] value) {
        this.afterSetSprintingInferiors = value;
    }

    public String[] getBeforeSwingItemSuperiors() {
        return this.beforeSwingItemSuperiors;
    }

    public String[] getBeforeSwingItemInferiors() {
        return this.beforeSwingItemInferiors;
    }

    public String[] getOverrideSwingItemSuperiors() {
        return this.overrideSwingItemSuperiors;
    }

    public String[] getOverrideSwingItemInferiors() {
        return this.overrideSwingItemInferiors;
    }

    public String[] getAfterSwingItemSuperiors() {
        return this.afterSwingItemSuperiors;
    }

    public String[] getAfterSwingItemInferiors() {
        return this.afterSwingItemInferiors;
    }

    public void setBeforeSwingItemSuperiors(String[] value) {
        this.beforeSwingItemSuperiors = value;
    }

    public void setBeforeSwingItemInferiors(String[] value) {
        this.beforeSwingItemInferiors = value;
    }

    public void setOverrideSwingItemSuperiors(String[] value) {
        this.overrideSwingItemSuperiors = value;
    }

    public void setOverrideSwingItemInferiors(String[] value) {
        this.overrideSwingItemInferiors = value;
    }

    public void setAfterSwingItemSuperiors(String[] value) {
        this.afterSwingItemSuperiors = value;
    }

    public void setAfterSwingItemInferiors(String[] value) {
        this.afterSwingItemInferiors = value;
    }

    public String[] getBeforeUpdateEntityActionStateSuperiors() {
        return this.beforeUpdateEntityActionStateSuperiors;
    }

    public String[] getBeforeUpdateEntityActionStateInferiors() {
        return this.beforeUpdateEntityActionStateInferiors;
    }

    public String[] getOverrideUpdateEntityActionStateSuperiors() {
        return this.overrideUpdateEntityActionStateSuperiors;
    }

    public String[] getOverrideUpdateEntityActionStateInferiors() {
        return this.overrideUpdateEntityActionStateInferiors;
    }

    public String[] getAfterUpdateEntityActionStateSuperiors() {
        return this.afterUpdateEntityActionStateSuperiors;
    }

    public String[] getAfterUpdateEntityActionStateInferiors() {
        return this.afterUpdateEntityActionStateInferiors;
    }

    public void setBeforeUpdateEntityActionStateSuperiors(String[] value) {
        this.beforeUpdateEntityActionStateSuperiors = value;
    }

    public void setBeforeUpdateEntityActionStateInferiors(String[] value) {
        this.beforeUpdateEntityActionStateInferiors = value;
    }

    public void setOverrideUpdateEntityActionStateSuperiors(String[] value) {
        this.overrideUpdateEntityActionStateSuperiors = value;
    }

    public void setOverrideUpdateEntityActionStateInferiors(String[] value) {
        this.overrideUpdateEntityActionStateInferiors = value;
    }

    public void setAfterUpdateEntityActionStateSuperiors(String[] value) {
        this.afterUpdateEntityActionStateSuperiors = value;
    }

    public void setAfterUpdateEntityActionStateInferiors(String[] value) {
        this.afterUpdateEntityActionStateInferiors = value;
    }

    public String[] getBeforeUpdatePotionEffectsSuperiors() {
        return this.beforeUpdatePotionEffectsSuperiors;
    }

    public String[] getBeforeUpdatePotionEffectsInferiors() {
        return this.beforeUpdatePotionEffectsInferiors;
    }

    public String[] getOverrideUpdatePotionEffectsSuperiors() {
        return this.overrideUpdatePotionEffectsSuperiors;
    }

    public String[] getOverrideUpdatePotionEffectsInferiors() {
        return this.overrideUpdatePotionEffectsInferiors;
    }

    public String[] getAfterUpdatePotionEffectsSuperiors() {
        return this.afterUpdatePotionEffectsSuperiors;
    }

    public String[] getAfterUpdatePotionEffectsInferiors() {
        return this.afterUpdatePotionEffectsInferiors;
    }

    public void setBeforeUpdatePotionEffectsSuperiors(String[] value) {
        this.beforeUpdatePotionEffectsSuperiors = value;
    }

    public void setBeforeUpdatePotionEffectsInferiors(String[] value) {
        this.beforeUpdatePotionEffectsInferiors = value;
    }

    public void setOverrideUpdatePotionEffectsSuperiors(String[] value) {
        this.overrideUpdatePotionEffectsSuperiors = value;
    }

    public void setOverrideUpdatePotionEffectsInferiors(String[] value) {
        this.overrideUpdatePotionEffectsInferiors = value;
    }

    public void setAfterUpdatePotionEffectsSuperiors(String[] value) {
        this.afterUpdatePotionEffectsSuperiors = value;
    }

    public void setAfterUpdatePotionEffectsInferiors(String[] value) {
        this.afterUpdatePotionEffectsInferiors = value;
    }

    public String[] getBeforeUpdateRiddenSuperiors() {
        return this.beforeUpdateRiddenSuperiors;
    }

    public String[] getBeforeUpdateRiddenInferiors() {
        return this.beforeUpdateRiddenInferiors;
    }

    public String[] getOverrideUpdateRiddenSuperiors() {
        return this.overrideUpdateRiddenSuperiors;
    }

    public String[] getOverrideUpdateRiddenInferiors() {
        return this.overrideUpdateRiddenInferiors;
    }

    public String[] getAfterUpdateRiddenSuperiors() {
        return this.afterUpdateRiddenSuperiors;
    }

    public String[] getAfterUpdateRiddenInferiors() {
        return this.afterUpdateRiddenInferiors;
    }

    public void setBeforeUpdateRiddenSuperiors(String[] value) {
        this.beforeUpdateRiddenSuperiors = value;
    }

    public void setBeforeUpdateRiddenInferiors(String[] value) {
        this.beforeUpdateRiddenInferiors = value;
    }

    public void setOverrideUpdateRiddenSuperiors(String[] value) {
        this.overrideUpdateRiddenSuperiors = value;
    }

    public void setOverrideUpdateRiddenInferiors(String[] value) {
        this.overrideUpdateRiddenInferiors = value;
    }

    public void setAfterUpdateRiddenSuperiors(String[] value) {
        this.afterUpdateRiddenSuperiors = value;
    }

    public void setAfterUpdateRiddenInferiors(String[] value) {
        this.afterUpdateRiddenInferiors = value;
    }

    public String[] getBeforeWakeUpPlayerSuperiors() {
        return this.beforeWakeUpPlayerSuperiors;
    }

    public String[] getBeforeWakeUpPlayerInferiors() {
        return this.beforeWakeUpPlayerInferiors;
    }

    public String[] getOverrideWakeUpPlayerSuperiors() {
        return this.overrideWakeUpPlayerSuperiors;
    }

    public String[] getOverrideWakeUpPlayerInferiors() {
        return this.overrideWakeUpPlayerInferiors;
    }

    public String[] getAfterWakeUpPlayerSuperiors() {
        return this.afterWakeUpPlayerSuperiors;
    }

    public String[] getAfterWakeUpPlayerInferiors() {
        return this.afterWakeUpPlayerInferiors;
    }

    public void setBeforeWakeUpPlayerSuperiors(String[] value) {
        this.beforeWakeUpPlayerSuperiors = value;
    }

    public void setBeforeWakeUpPlayerInferiors(String[] value) {
        this.beforeWakeUpPlayerInferiors = value;
    }

    public void setOverrideWakeUpPlayerSuperiors(String[] value) {
        this.overrideWakeUpPlayerSuperiors = value;
    }

    public void setOverrideWakeUpPlayerInferiors(String[] value) {
        this.overrideWakeUpPlayerInferiors = value;
    }

    public void setAfterWakeUpPlayerSuperiors(String[] value) {
        this.afterWakeUpPlayerSuperiors = value;
    }

    public void setAfterWakeUpPlayerInferiors(String[] value) {
        this.afterWakeUpPlayerInferiors = value;
    }

    public String[] getBeforeWriteEntityToNBTSuperiors() {
        return this.beforeWriteEntityToNBTSuperiors;
    }

    public String[] getBeforeWriteEntityToNBTInferiors() {
        return this.beforeWriteEntityToNBTInferiors;
    }

    public String[] getOverrideWriteEntityToNBTSuperiors() {
        return this.overrideWriteEntityToNBTSuperiors;
    }

    public String[] getOverrideWriteEntityToNBTInferiors() {
        return this.overrideWriteEntityToNBTInferiors;
    }

    public String[] getAfterWriteEntityToNBTSuperiors() {
        return this.afterWriteEntityToNBTSuperiors;
    }

    public String[] getAfterWriteEntityToNBTInferiors() {
        return this.afterWriteEntityToNBTInferiors;
    }

    public void setBeforeWriteEntityToNBTSuperiors(String[] value) {
        this.beforeWriteEntityToNBTSuperiors = value;
    }

    public void setBeforeWriteEntityToNBTInferiors(String[] value) {
        this.beforeWriteEntityToNBTInferiors = value;
    }

    public void setOverrideWriteEntityToNBTSuperiors(String[] value) {
        this.overrideWriteEntityToNBTSuperiors = value;
    }

    public void setOverrideWriteEntityToNBTInferiors(String[] value) {
        this.overrideWriteEntityToNBTInferiors = value;
    }

    public void setAfterWriteEntityToNBTSuperiors(String[] value) {
        this.afterWriteEntityToNBTSuperiors = value;
    }

    public void setAfterWriteEntityToNBTInferiors(String[] value) {
        this.afterWriteEntityToNBTInferiors = value;
    }
}
