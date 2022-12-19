package api.player.server;

import api.player.forge.PlayerAPIPlugin;
import com.mojang.authlib.GameProfile;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;

public final class ServerPlayerAPI {
    private static final Class<?>[] Class = new Class[]{ServerPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{ServerPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger = Logger.getLogger("ServerPlayerAPI");
    private static final Map<String, String[]> EmptySortMap = Collections.unmodifiableMap(new HashMap<>());
    private static final List<String> beforeAddExhaustionHookTypes = new LinkedList<>();
    private static final List<String> overrideAddExhaustionHookTypes = new LinkedList<>();
    private static final List<String> afterAddExhaustionHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAddExhaustionHooks;
    private ServerPlayerBase[] overrideAddExhaustionHooks;
    private ServerPlayerBase[] afterAddExhaustionHooks;
    public boolean isAddExhaustionModded;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddExhaustionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExhaustionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExhaustionInferiors = new Hashtable<>(0);
    private static final List<String> beforeAddExperienceHookTypes = new LinkedList<>();
    private static final List<String> overrideAddExperienceHookTypes = new LinkedList<>();
    private static final List<String> afterAddExperienceHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAddExperienceHooks;
    private ServerPlayerBase[] overrideAddExperienceHooks;
    private ServerPlayerBase[] afterAddExperienceHooks;
    public boolean isAddExperienceModded;
    private static final Map<String, String[]> allBaseBeforeAddExperienceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddExperienceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExperienceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExperienceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExperienceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExperienceInferiors = new Hashtable<>(0);
    private static final List<String> beforeAddExperienceLevelHookTypes = new LinkedList<>();
    private static final List<String> overrideAddExperienceLevelHookTypes = new LinkedList<>();
    private static final List<String> afterAddExperienceLevelHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAddExperienceLevelHooks;
    private ServerPlayerBase[] overrideAddExperienceLevelHooks;
    private ServerPlayerBase[] afterAddExperienceLevelHooks;
    public boolean isAddExperienceLevelModded;
    private static final Map<String, String[]> allBaseBeforeAddExperienceLevelSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddExperienceLevelInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExperienceLevelSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExperienceLevelInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExperienceLevelSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExperienceLevelInferiors = new Hashtable<>(0);
    private static final List<String> beforeAddMovementStatHookTypes = new LinkedList<>();
    private static final List<String> overrideAddMovementStatHookTypes = new LinkedList<>();
    private static final List<String> afterAddMovementStatHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAddMovementStatHooks;
    private ServerPlayerBase[] overrideAddMovementStatHooks;
    private ServerPlayerBase[] afterAddMovementStatHooks;
    public boolean isAddMovementStatModded;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddMovementStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddMovementStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddMovementStatInferiors = new Hashtable<>(0);
    private static final List<String> beforeAttackEntityFromHookTypes = new LinkedList<>();
    private static final List<String> overrideAttackEntityFromHookTypes = new LinkedList<>();
    private static final List<String> afterAttackEntityFromHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAttackEntityFromHooks;
    private ServerPlayerBase[] overrideAttackEntityFromHooks;
    private ServerPlayerBase[] afterAttackEntityFromHooks;
    public boolean isAttackEntityFromModded;
    private static final Map<String, String[]> allBaseBeforeAttackEntityFromSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAttackEntityFromInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackEntityFromSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackEntityFromInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackEntityFromSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackEntityFromInferiors = new Hashtable<>(0);
    private static final List<String> beforeAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<>();
    private static final List<String> overrideAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<>();
    private static final List<String> afterAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
    private ServerPlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
    private ServerPlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
    public boolean isAttackTargetEntityWithCurrentItemModded;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemInferiors = new Hashtable<>(0);
    private static final List<String> beforeCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private static final List<String> overrideCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private static final List<String> afterCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeCanBreatheUnderwaterHooks;
    private ServerPlayerBase[] overrideCanBreatheUnderwaterHooks;
    private ServerPlayerBase[] afterCanBreatheUnderwaterHooks;
    public boolean isCanBreatheUnderwaterModded;
    private static final Map<String, String[]> allBaseBeforeCanBreatheUnderwaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCanBreatheUnderwaterInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanBreatheUnderwaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanBreatheUnderwaterInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanBreatheUnderwaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanBreatheUnderwaterInferiors = new Hashtable<>(0);
    private static final List<String> beforeCanHarvestBlockHookTypes = new LinkedList<>();
    private static final List<String> overrideCanHarvestBlockHookTypes = new LinkedList<>();
    private static final List<String> afterCanHarvestBlockHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeCanHarvestBlockHooks;
    private ServerPlayerBase[] overrideCanHarvestBlockHooks;
    private ServerPlayerBase[] afterCanHarvestBlockHooks;
    public boolean isCanHarvestBlockModded;
    private static final Map<String, String[]> allBaseBeforeCanHarvestBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCanHarvestBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanHarvestBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanHarvestBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanHarvestBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanHarvestBlockInferiors = new Hashtable<>(0);
    private static final List<String> beforeCanPlayerEditHookTypes = new LinkedList<>();
    private static final List<String> overrideCanPlayerEditHookTypes = new LinkedList<>();
    private static final List<String> afterCanPlayerEditHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeCanPlayerEditHooks;
    private ServerPlayerBase[] overrideCanPlayerEditHooks;
    private ServerPlayerBase[] afterCanPlayerEditHooks;
    public boolean isCanPlayerEditModded;
    private static final Map<String, String[]> allBaseBeforeCanPlayerEditSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCanPlayerEditInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanPlayerEditSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanPlayerEditInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanPlayerEditSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanPlayerEditInferiors = new Hashtable<>(0);
    private static final List<String> beforeCanTriggerWalkingHookTypes = new LinkedList<>();
    private static final List<String> overrideCanTriggerWalkingHookTypes = new LinkedList<>();
    private static final List<String> afterCanTriggerWalkingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeCanTriggerWalkingHooks;
    private ServerPlayerBase[] overrideCanTriggerWalkingHooks;
    private ServerPlayerBase[] afterCanTriggerWalkingHooks;
    public boolean isCanTriggerWalkingModded;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final List<String> beforeClonePlayerHookTypes = new LinkedList<>();
    private static final List<String> overrideClonePlayerHookTypes = new LinkedList<>();
    private static final List<String> afterClonePlayerHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeClonePlayerHooks;
    private ServerPlayerBase[] overrideClonePlayerHooks;
    private ServerPlayerBase[] afterClonePlayerHooks;
    public boolean isClonePlayerModded;
    private static final Map<String, String[]> allBaseBeforeClonePlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeClonePlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideClonePlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideClonePlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterClonePlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterClonePlayerInferiors = new Hashtable<>(0);
    private static final List<String> beforeDamageEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideDamageEntityHookTypes = new LinkedList<>();
    private static final List<String> afterDamageEntityHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDamageEntityHooks;
    private ServerPlayerBase[] overrideDamageEntityHooks;
    private ServerPlayerBase[] afterDamageEntityHooks;
    public boolean isDamageEntityModded;
    private static final Map<String, String[]> allBaseBeforeDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDamageEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDamageEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDamageEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIChestHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIChestHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIChestHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDisplayGUIChestHooks;
    private ServerPlayerBase[] overrideDisplayGUIChestHooks;
    private ServerPlayerBase[] afterDisplayGUIChestHooks;
    public boolean isDisplayGUIChestModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIChestSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIChestInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIChestSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIChestInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIChestSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIChestInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIDispenserHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIDispenserHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIDispenserHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDisplayGUIDispenserHooks;
    private ServerPlayerBase[] overrideDisplayGUIDispenserHooks;
    private ServerPlayerBase[] afterDisplayGUIDispenserHooks;
    public boolean isDisplayGUIDispenserModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDisplayGUIFurnaceHooks;
    private ServerPlayerBase[] overrideDisplayGUIFurnaceHooks;
    private ServerPlayerBase[] afterDisplayGUIFurnaceHooks;
    public boolean isDisplayGUIFurnaceModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIFurnaceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIFurnaceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIFurnaceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIFurnaceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIFurnaceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIFurnaceInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIWorkbenchHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIWorkbenchHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIWorkbenchHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDisplayGUIWorkbenchHooks;
    private ServerPlayerBase[] overrideDisplayGUIWorkbenchHooks;
    private ServerPlayerBase[] afterDisplayGUIWorkbenchHooks;
    public boolean isDisplayGUIWorkbenchModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIWorkbenchSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIWorkbenchInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIWorkbenchSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIWorkbenchInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIWorkbenchSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIWorkbenchInferiors = new Hashtable<>(0);
    private static final List<String> beforeDropOneItemHookTypes = new LinkedList<>();
    private static final List<String> overrideDropOneItemHookTypes = new LinkedList<>();
    private static final List<String> afterDropOneItemHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDropOneItemHooks;
    private ServerPlayerBase[] overrideDropOneItemHooks;
    private ServerPlayerBase[] afterDropOneItemHooks;
    public boolean isDropOneItemModded;
    private static final Map<String, String[]> allBaseBeforeDropOneItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDropOneItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropOneItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropOneItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropOneItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropOneItemInferiors = new Hashtable<>(0);
    private static final List<String> beforeDropPlayerItemHookTypes = new LinkedList<>();
    private static final List<String> overrideDropPlayerItemHookTypes = new LinkedList<>();
    private static final List<String> afterDropPlayerItemHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeDropPlayerItemHooks;
    private ServerPlayerBase[] overrideDropPlayerItemHooks;
    private ServerPlayerBase[] afterDropPlayerItemHooks;
    public boolean isDropPlayerItemModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemInferiors = new Hashtable<>(0);
    private static final List<String> beforeFallHookTypes = new LinkedList<>();
    private static final List<String> overrideFallHookTypes = new LinkedList<>();
    private static final List<String> afterFallHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeFallHooks;
    private ServerPlayerBase[] overrideFallHooks;
    private ServerPlayerBase[] afterFallHooks;
    public boolean isFallModded;
    private static final Map<String, String[]> allBaseBeforeFallSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeFallInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideFallSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideFallInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterFallSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterFallInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetAIMoveSpeedHookTypes = new LinkedList<>();
    private static final List<String> overrideGetAIMoveSpeedHookTypes = new LinkedList<>();
    private static final List<String> afterGetAIMoveSpeedHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetAIMoveSpeedHooks;
    private ServerPlayerBase[] overrideGetAIMoveSpeedHooks;
    private ServerPlayerBase[] afterGetAIMoveSpeedHooks;
    public boolean isGetAIMoveSpeedModded;
    private static final Map<String, String[]> allBaseBeforeGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private static final List<String> overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private static final List<String> afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
    private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
    private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
    public boolean isGetCurrentPlayerStrVsBlockModded;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<>();
    private static final List<String> overrideGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<>();
    private static final List<String> afterGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockForgeHooks;
    private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockForgeHooks;
    private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockForgeHooks;
    public boolean isGetCurrentPlayerStrVsBlockForgeModded;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetDistanceSqHookTypes = new LinkedList<>();
    private static final List<String> overrideGetDistanceSqHookTypes = new LinkedList<>();
    private static final List<String> afterGetDistanceSqHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetDistanceSqHooks;
    private ServerPlayerBase[] overrideGetDistanceSqHooks;
    private ServerPlayerBase[] afterGetDistanceSqHooks;
    public boolean isGetDistanceSqModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetBrightnessHookTypes = new LinkedList<>();
    private static final List<String> overrideGetBrightnessHookTypes = new LinkedList<>();
    private static final List<String> afterGetBrightnessHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetBrightnessHooks;
    private ServerPlayerBase[] overrideGetBrightnessHooks;
    private ServerPlayerBase[] afterGetBrightnessHooks;
    public boolean isGetBrightnessModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetBrightnessInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetEyeHeightHookTypes = new LinkedList<>();
    private static final List<String> overrideGetEyeHeightHookTypes = new LinkedList<>();
    private static final List<String> afterGetEyeHeightHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeGetEyeHeightHooks;
    private ServerPlayerBase[] overrideGetEyeHeightHooks;
    private ServerPlayerBase[] afterGetEyeHeightHooks;
    public boolean isGetEyeHeightModded;
    private static final Map<String, String[]> allBaseBeforeGetEyeHeightSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetEyeHeightInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetEyeHeightSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetEyeHeightInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetEyeHeightSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetEyeHeightInferiors = new Hashtable<>(0);
    private static final List<String> beforeHealHookTypes = new LinkedList<>();
    private static final List<String> overrideHealHookTypes = new LinkedList<>();
    private static final List<String> afterHealHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeHealHooks;
    private ServerPlayerBase[] overrideHealHooks;
    private ServerPlayerBase[] afterHealHooks;
    public boolean isHealModded;
    private static final Map<String, String[]> allBaseBeforeHealSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeHealInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHealSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHealInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHealSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHealInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsEntityInsideOpaqueBlockHookTypes = new LinkedList<>();
    private static final List<String> overrideIsEntityInsideOpaqueBlockHookTypes = new LinkedList<>();
    private static final List<String> afterIsEntityInsideOpaqueBlockHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
    private ServerPlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
    private ServerPlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
    public boolean isIsEntityInsideOpaqueBlockModded;
    private static final Map<String, String[]> allBaseBeforeIsEntityInsideOpaqueBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsEntityInsideOpaqueBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsEntityInsideOpaqueBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsEntityInsideOpaqueBlockInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsEntityInsideOpaqueBlockSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsEntityInsideOpaqueBlockInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsInWaterHookTypes = new LinkedList<>();
    private static final List<String> overrideIsInWaterHookTypes = new LinkedList<>();
    private static final List<String> afterIsInWaterHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsInWaterHooks;
    private ServerPlayerBase[] overrideIsInWaterHooks;
    private ServerPlayerBase[] afterIsInWaterHooks;
    public boolean isIsInWaterModded;
    private static final Map<String, String[]> allBaseBeforeIsInWaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsInWaterInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsInWaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsInWaterInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsInWaterSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsInWaterInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsInsideOfMaterialHookTypes = new LinkedList<>();
    private static final List<String> overrideIsInsideOfMaterialHookTypes = new LinkedList<>();
    private static final List<String> afterIsInsideOfMaterialHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsInsideOfMaterialHooks;
    private ServerPlayerBase[] overrideIsInsideOfMaterialHooks;
    private ServerPlayerBase[] afterIsInsideOfMaterialHooks;
    public boolean isIsInsideOfMaterialModded;
    private static final Map<String, String[]> allBaseBeforeIsInsideOfMaterialSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsInsideOfMaterialInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsInsideOfMaterialSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsInsideOfMaterialInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsInsideOfMaterialSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsInsideOfMaterialInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsOnLadderHookTypes = new LinkedList<>();
    private static final List<String> overrideIsOnLadderHookTypes = new LinkedList<>();
    private static final List<String> afterIsOnLadderHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsOnLadderHooks;
    private ServerPlayerBase[] overrideIsOnLadderHooks;
    private ServerPlayerBase[] afterIsOnLadderHooks;
    public boolean isIsOnLadderModded;
    private static final Map<String, String[]> allBaseBeforeIsOnLadderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsOnLadderInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsOnLadderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsOnLadderInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsOnLadderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsOnLadderInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsPlayerSleepingHookTypes = new LinkedList<>();
    private static final List<String> overrideIsPlayerSleepingHookTypes = new LinkedList<>();
    private static final List<String> afterIsPlayerSleepingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsPlayerSleepingHooks;
    private ServerPlayerBase[] overrideIsPlayerSleepingHooks;
    private ServerPlayerBase[] afterIsPlayerSleepingHooks;
    public boolean isIsPlayerSleepingModded;
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsSneakingHookTypes = new LinkedList<>();
    private static final List<String> overrideIsSneakingHookTypes = new LinkedList<>();
    private static final List<String> afterIsSneakingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeIsSneakingHooks;
    private ServerPlayerBase[] overrideIsSneakingHooks;
    private ServerPlayerBase[] afterIsSneakingHooks;
    public boolean isIsSneakingModded;
    private static final Map<String, String[]> allBaseBeforeIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSneakingInferiors = new Hashtable<>(0);
    private static final List<String> beforeJumpHookTypes = new LinkedList<>();
    private static final List<String> overrideJumpHookTypes = new LinkedList<>();
    private static final List<String> afterJumpHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeJumpHooks;
    private ServerPlayerBase[] overrideJumpHooks;
    private ServerPlayerBase[] afterJumpHooks;
    public boolean isJumpModded;
    private static final Map<String, String[]> allBaseBeforeJumpSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeJumpInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideJumpSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideJumpInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterJumpSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterJumpInferiors = new Hashtable<>(0);
    private static final List<String> beforeKnockBackHookTypes = new LinkedList<>();
    private static final List<String> overrideKnockBackHookTypes = new LinkedList<>();
    private static final List<String> afterKnockBackHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeKnockBackHooks;
    private ServerPlayerBase[] overrideKnockBackHooks;
    private ServerPlayerBase[] afterKnockBackHooks;
    public boolean isKnockBackModded;
    private static final Map<String, String[]> allBaseBeforeKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeKnockBackInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideKnockBackInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterKnockBackInferiors = new Hashtable<>(0);
    private static final List<String> beforeMountEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideMountEntityHookTypes = new LinkedList<>();
    private static final List<String> afterMountEntityHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeMountEntityHooks;
    private ServerPlayerBase[] overrideMountEntityHooks;
    private ServerPlayerBase[] afterMountEntityHooks;
    public boolean isMountEntityModded;
    private static final Map<String, String[]> allBaseBeforeMountEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeMountEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMountEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMountEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMountEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMountEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeMoveEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideMoveEntityHookTypes = new LinkedList<>();
    private static final List<String> afterMoveEntityHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeMoveEntityHooks;
    private ServerPlayerBase[] overrideMoveEntityHooks;
    private ServerPlayerBase[] afterMoveEntityHooks;
    public boolean isMoveEntityModded;
    private static final Map<String, String[]> allBaseBeforeMoveEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeMoveEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeMoveEntityWithHeadingHookTypes = new LinkedList<>();
    private static final List<String> overrideMoveEntityWithHeadingHookTypes = new LinkedList<>();
    private static final List<String> afterMoveEntityWithHeadingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeMoveEntityWithHeadingHooks;
    private ServerPlayerBase[] overrideMoveEntityWithHeadingHooks;
    private ServerPlayerBase[] afterMoveEntityWithHeadingHooks;
    public boolean isMoveEntityWithHeadingModded;
    private static final Map<String, String[]> allBaseBeforeMoveEntityWithHeadingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeMoveEntityWithHeadingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveEntityWithHeadingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveEntityWithHeadingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveEntityWithHeadingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveEntityWithHeadingInferiors = new Hashtable<>(0);
    private static final List<String> beforeMoveFlyingHookTypes = new LinkedList<>();
    private static final List<String> overrideMoveFlyingHookTypes = new LinkedList<>();
    private static final List<String> afterMoveFlyingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeMoveFlyingHooks;
    private ServerPlayerBase[] overrideMoveFlyingHooks;
    private ServerPlayerBase[] afterMoveFlyingHooks;
    public boolean isMoveFlyingModded;
    private static final Map<String, String[]> allBaseBeforeMoveFlyingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeMoveFlyingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveFlyingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideMoveFlyingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveFlyingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterMoveFlyingInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnDeathHookTypes = new LinkedList<>();
    private static final List<String> overrideOnDeathHookTypes = new LinkedList<>();
    private static final List<String> afterOnDeathHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnDeathHooks;
    private ServerPlayerBase[] overrideOnDeathHooks;
    private ServerPlayerBase[] afterOnDeathHooks;
    public boolean isOnDeathModded;
    private static final Map<String, String[]> allBaseBeforeOnDeathSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnDeathInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnDeathSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnDeathInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnDeathSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnDeathInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnLivingUpdateHookTypes = new LinkedList<>();
    private static final List<String> overrideOnLivingUpdateHookTypes = new LinkedList<>();
    private static final List<String> afterOnLivingUpdateHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnLivingUpdateHooks;
    private ServerPlayerBase[] overrideOnLivingUpdateHooks;
    private ServerPlayerBase[] afterOnLivingUpdateHooks;
    public boolean isOnLivingUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnLivingUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnLivingUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnLivingUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnLivingUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnLivingUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnLivingUpdateInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnKillEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideOnKillEntityHookTypes = new LinkedList<>();
    private static final List<String> afterOnKillEntityHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnKillEntityHooks;
    private ServerPlayerBase[] overrideOnKillEntityHooks;
    private ServerPlayerBase[] afterOnKillEntityHooks;
    public boolean isOnKillEntityModded;
    private static final Map<String, String[]> allBaseBeforeOnKillEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnKillEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnKillEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnKillEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnKillEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnKillEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnStruckByLightningHookTypes = new LinkedList<>();
    private static final List<String> overrideOnStruckByLightningHookTypes = new LinkedList<>();
    private static final List<String> afterOnStruckByLightningHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnStruckByLightningHooks;
    private ServerPlayerBase[] overrideOnStruckByLightningHooks;
    private ServerPlayerBase[] afterOnStruckByLightningHooks;
    public boolean isOnStruckByLightningModded;
    private static final Map<String, String[]> allBaseBeforeOnStruckByLightningSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnStruckByLightningInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnStruckByLightningSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnStruckByLightningInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnStruckByLightningSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnStruckByLightningInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnUpdateHookTypes = new LinkedList<>();
    private static final List<String> overrideOnUpdateHookTypes = new LinkedList<>();
    private static final List<String> afterOnUpdateHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnUpdateHooks;
    private ServerPlayerBase[] overrideOnUpdateHooks;
    private ServerPlayerBase[] afterOnUpdateHooks;
    public boolean isOnUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateInferiors = new Hashtable<>(0);
    private static final List<String> beforeOnUpdateEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideOnUpdateEntityHookTypes = new LinkedList<>();
    private static final List<String> afterOnUpdateEntityHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeOnUpdateEntityHooks;
    private ServerPlayerBase[] overrideOnUpdateEntityHooks;
    private ServerPlayerBase[] afterOnUpdateEntityHooks;
    public boolean isOnUpdateEntityModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnUpdateEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeReadEntityFromNBTHookTypes = new LinkedList<>();
    private static final List<String> overrideReadEntityFromNBTHookTypes = new LinkedList<>();
    private static final List<String> afterReadEntityFromNBTHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeReadEntityFromNBTHooks;
    private ServerPlayerBase[] overrideReadEntityFromNBTHooks;
    private ServerPlayerBase[] afterReadEntityFromNBTHooks;
    public boolean isReadEntityFromNBTModded;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetDeadHookTypes = new LinkedList<>();
    private static final List<String> overrideSetDeadHookTypes = new LinkedList<>();
    private static final List<String> afterSetDeadHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSetDeadHooks;
    private ServerPlayerBase[] overrideSetDeadHooks;
    private ServerPlayerBase[] afterSetDeadHooks;
    public boolean isSetDeadModded;
    private static final Map<String, String[]> allBaseBeforeSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetDeadInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetDeadInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetDeadInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetEntityActionStateHookTypes = new LinkedList<>();
    private static final List<String> overrideSetEntityActionStateHookTypes = new LinkedList<>();
    private static final List<String> afterSetEntityActionStateHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSetEntityActionStateHooks;
    private ServerPlayerBase[] overrideSetEntityActionStateHooks;
    private ServerPlayerBase[] afterSetEntityActionStateHooks;
    public boolean isSetEntityActionStateModded;
    private static final Map<String, String[]> allBaseBeforeSetEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetEntityActionStateInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetPositionHookTypes = new LinkedList<>();
    private static final List<String> overrideSetPositionHookTypes = new LinkedList<>();
    private static final List<String> afterSetPositionHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSetPositionHooks;
    private ServerPlayerBase[] overrideSetPositionHooks;
    private ServerPlayerBase[] afterSetPositionHooks;
    public boolean isSetPositionModded;
    private static final Map<String, String[]> allBaseBeforeSetPositionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetPositionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPositionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPositionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPositionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPositionInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetSneakingHookTypes = new LinkedList<>();
    private static final List<String> overrideSetSneakingHookTypes = new LinkedList<>();
    private static final List<String> afterSetSneakingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSetSneakingHooks;
    private ServerPlayerBase[] overrideSetSneakingHooks;
    private ServerPlayerBase[] afterSetSneakingHooks;
    public boolean isSetSneakingModded;
    private static final Map<String, String[]> allBaseBeforeSetSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSneakingInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetSprintingHookTypes = new LinkedList<>();
    private static final List<String> overrideSetSprintingHookTypes = new LinkedList<>();
    private static final List<String> afterSetSprintingHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSetSprintingHooks;
    private ServerPlayerBase[] overrideSetSprintingHooks;
    private ServerPlayerBase[] afterSetSprintingHooks;
    public boolean isSetSprintingModded;
    private static final Map<String, String[]> allBaseBeforeSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSprintingInferiors = new Hashtable<>(0);
    private static final List<String> beforeSwingItemHookTypes = new LinkedList<>();
    private static final List<String> overrideSwingItemHookTypes = new LinkedList<>();
    private static final List<String> afterSwingItemHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeSwingItemHooks;
    private ServerPlayerBase[] overrideSwingItemHooks;
    private ServerPlayerBase[] afterSwingItemHooks;
    public boolean isSwingItemModded;
    private static final Map<String, String[]> allBaseBeforeSwingItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSwingItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSwingItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSwingItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSwingItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSwingItemInferiors = new Hashtable<>(0);
    private static final List<String> beforeUpdateEntityActionStateHookTypes = new LinkedList<>();
    private static final List<String> overrideUpdateEntityActionStateHookTypes = new LinkedList<>();
    private static final List<String> afterUpdateEntityActionStateHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeUpdateEntityActionStateHooks;
    private ServerPlayerBase[] overrideUpdateEntityActionStateHooks;
    private ServerPlayerBase[] afterUpdateEntityActionStateHooks;
    public boolean isUpdateEntityActionStateModded;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final List<String> beforeUpdatePotionEffectsHookTypes = new LinkedList<>();
    private static final List<String> overrideUpdatePotionEffectsHookTypes = new LinkedList<>();
    private static final List<String> afterUpdatePotionEffectsHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeUpdatePotionEffectsHooks;
    private ServerPlayerBase[] overrideUpdatePotionEffectsHooks;
    private ServerPlayerBase[] afterUpdatePotionEffectsHooks;
    public boolean isUpdatePotionEffectsModded;
    private static final Map<String, String[]> allBaseBeforeUpdatePotionEffectsSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeUpdatePotionEffectsInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdatePotionEffectsSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdatePotionEffectsInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdatePotionEffectsSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdatePotionEffectsInferiors = new Hashtable<>(0);
    private static final List<String> beforeUpdateRiddenHookTypes = new LinkedList<>();
    private static final List<String> overrideUpdateRiddenHookTypes = new LinkedList<>();
    private static final List<String> afterUpdateRiddenHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeUpdateRiddenHooks;
    private ServerPlayerBase[] overrideUpdateRiddenHooks;
    private ServerPlayerBase[] afterUpdateRiddenHooks;
    public boolean isUpdateRiddenModded;
    private static final Map<String, String[]> allBaseBeforeUpdateRiddenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeUpdateRiddenInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateRiddenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateRiddenInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateRiddenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateRiddenInferiors = new Hashtable<>(0);
    private static final List<String> beforeWakeUpPlayerHookTypes = new LinkedList<>();
    private static final List<String> overrideWakeUpPlayerHookTypes = new LinkedList<>();
    private static final List<String> afterWakeUpPlayerHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeWakeUpPlayerHooks;
    private ServerPlayerBase[] overrideWakeUpPlayerHooks;
    private ServerPlayerBase[] afterWakeUpPlayerHooks;
    public boolean isWakeUpPlayerModded;
    private static final Map<String, String[]> allBaseBeforeWakeUpPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeWakeUpPlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWakeUpPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWakeUpPlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWakeUpPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWakeUpPlayerInferiors = new Hashtable<>(0);
    private static final List<String> beforeWriteEntityToNBTHookTypes = new LinkedList<>();
    private static final List<String> overrideWriteEntityToNBTHookTypes = new LinkedList<>();
    private static final List<String> afterWriteEntityToNBTHookTypes = new LinkedList<>();
    private ServerPlayerBase[] beforeWriteEntityToNBTHooks;
    private ServerPlayerBase[] overrideWriteEntityToNBTHooks;
    private ServerPlayerBase[] afterWriteEntityToNBTHooks;
    public boolean isWriteEntityToNBTModded;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTInferiors = new Hashtable<>(0);
    protected final IServerPlayerAPI player;
    private static final Set<String> keys = new HashSet<>();
    private static final Map<String, String> keysToVirtualIds = new HashMap<>();
    private static final Set<Class<?>> dynamicTypes = new HashSet<>();
    private static final Map<Class<?>, Map<String, Method>> virtualDynamicHookMethods = new HashMap<>();
    private static final Map<Class<?>, Map<String, Method>> beforeDynamicHookMethods = new HashMap<>();
    private static final Map<Class<?>, Map<String, Method>> overrideDynamicHookMethods = new HashMap<>();
    private static final Map<Class<?>, Map<String, Method>> afterDynamicHookMethods = new HashMap<>();
    private static final List<String> beforeLocalConstructingHookTypes = new LinkedList<>();
    private static final List<String> afterLocalConstructingHookTypes = new LinkedList<>();
    private static final Map<String, List<String>> beforeDynamicHookTypes = new Hashtable<>(0);
    private static final Map<String, List<String>> overrideDynamicHookTypes = new Hashtable<>(0);
    private static final Map<String, List<String>> afterDynamicHookTypes = new Hashtable<>(0);
    private ServerPlayerBase[] beforeLocalConstructingHooks;
    private ServerPlayerBase[] afterLocalConstructingHooks;
    private final Map<ServerPlayerBase, String> baseObjectsToId = new Hashtable<>();
    private final Map<String, ServerPlayerBase> allBaseObjects = new Hashtable<>();
    private final Set<String> unmodifiableAllBaseIds;
    private static final Map<String, Constructor<?>> allBaseConstructors = new Hashtable<>();
    private static final Set<String> unmodifiableAllIds = Collections.unmodifiableSet(allBaseConstructors.keySet());
    private static final Map<String, String[]> allBaseBeforeLocalConstructingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeLocalConstructingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterLocalConstructingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterLocalConstructingInferiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseBeforeDynamicSuperiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseBeforeDynamicInferiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseOverrideDynamicSuperiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseOverrideDynamicInferiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseAfterDynamicSuperiors = new Hashtable<>(0);
    private static final Map<String, Map<String, String[]>> allBaseAfterDynamicInferiors = new Hashtable<>(0);
    private static boolean initialized = false;

    private static void log(String text) {
        System.out.println(text);
        logger.fine(text);
    }

    public static void register(String id, Class<?> baseClass) {
        register(id, baseClass, (ServerPlayerBaseSorting)null);
    }

    public static void register(String id, Class<?> baseClass, ServerPlayerBaseSorting baseSorting) {
        try {
            register(baseClass, id, baseSorting);
        } catch (RuntimeException exception) {
            if (id != null) {
                log("Server Player: failed to register id '" + id + "'");
            } else {
                log("Server Player: failed to register ServerPlayerBase");
            }

            throw exception;
        }
    }

    private static void register(Class<?> baseClass, String id, ServerPlayerBaseSorting baseSorting) {
        if (!isCreated) {
            try {
                Method mandatory = EntityPlayerMP.class.getMethod("getServerPlayerBase", String.class);
                if (mandatory.getReturnType() != ServerPlayerBase.class) {
                    throw new NoSuchMethodException(ServerPlayerBase.class.getName() + " " + EntityPlayerMP.class.getName() + ".getServerPlayerBase(" + String.class.getName() + ")");
                }
            } catch (NoSuchMethodException exception) {
                String[] errorMessageParts = new String[]{"========================================", "The API \"Server Player\" version " + PlayerAPIPlugin.Version + " of the mod \"Player API Core " + PlayerAPIPlugin.Version + "\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getServerPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Player API Core which Minecraft version matches its own.", "  Download and install the latest Player API Core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Player API Core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Player API Core has not been installed correctly.", "  Deinstall Player API Core and install it again following the installation instructions in the readme file.", "========================================"};
                String baseEntityPlayerMPClassName = ServerPlayerBase.class.getName();
                String targetClassName = EntityPlayerMP.class.getName();
                String targetClassFileName = targetClassName.replace(".", File.separator);
                String stringClassName = String.class.getName();

                for(int i = 0; i < errorMessageParts.length; ++i) {
                    errorMessageParts[i] = MessageFormat.format(errorMessageParts[i], baseEntityPlayerMPClassName, targetClassName, targetClassFileName, stringClassName);
                }
                
                for(String errorMessagePart : errorMessageParts) {
                    logger.severe(errorMessagePart);
                }

                for(String errorMessagePart : errorMessageParts) {
                    System.err.println(errorMessagePart);
                }

                String errorMessage = "\n\n";
                for(String errorMessagePart : errorMessageParts) {
                    errorMessage = errorMessage + "\t" + errorMessagePart + "\n";
                }

                throw new RuntimeException(errorMessage, exception);
            }

            log("Server Player " + PlayerAPIPlugin.Version + " Created");
            isCreated = true;
        }

        if (id == null) {
            throw new NullPointerException("Argument 'id' can not be null");
        } else if (baseClass == null) {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        } else {
            Constructor<?> allreadyRegistered = allBaseConstructors.get(id);
            if (allreadyRegistered != null) {
                throw new IllegalArgumentException("The class '" + baseClass.getName() + "' can not be registered with the id '" + id + "' because the class '" + allreadyRegistered.getDeclaringClass().getName() + "' has allready been registered with the same id");
            } else {
                Constructor<?> baseConstructor;
                try {
                    baseConstructor = baseClass.getDeclaredConstructor(Classes);
                } catch (Throwable t) {
                    try {
                        baseConstructor = baseClass.getDeclaredConstructor(Class);
                    } catch (Throwable s) {
                        throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + ServerPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + baseClass.getName() + "'", t);
                    }
                }

                allBaseConstructors.put(id, baseConstructor);
                if (baseSorting != null) {
                    addSorting(id, allBaseBeforeLocalConstructingSuperiors, baseSorting.getBeforeLocalConstructingSuperiors());
                    addSorting(id, allBaseBeforeLocalConstructingInferiors, baseSorting.getBeforeLocalConstructingInferiors());
                    addSorting(id, allBaseAfterLocalConstructingSuperiors, baseSorting.getAfterLocalConstructingSuperiors());
                    addSorting(id, allBaseAfterLocalConstructingInferiors, baseSorting.getAfterLocalConstructingInferiors());
                    addDynamicSorting(id, allBaseBeforeDynamicSuperiors, baseSorting.getDynamicBeforeSuperiors());
                    addDynamicSorting(id, allBaseBeforeDynamicInferiors, baseSorting.getDynamicBeforeInferiors());
                    addDynamicSorting(id, allBaseOverrideDynamicSuperiors, baseSorting.getDynamicOverrideSuperiors());
                    addDynamicSorting(id, allBaseOverrideDynamicInferiors, baseSorting.getDynamicOverrideInferiors());
                    addDynamicSorting(id, allBaseAfterDynamicSuperiors, baseSorting.getDynamicAfterSuperiors());
                    addDynamicSorting(id, allBaseAfterDynamicInferiors, baseSorting.getDynamicAfterInferiors());
                    addSorting(id, allBaseBeforeAddExhaustionSuperiors, baseSorting.getBeforeAddExhaustionSuperiors());
                    addSorting(id, allBaseBeforeAddExhaustionInferiors, baseSorting.getBeforeAddExhaustionInferiors());
                    addSorting(id, allBaseOverrideAddExhaustionSuperiors, baseSorting.getOverrideAddExhaustionSuperiors());
                    addSorting(id, allBaseOverrideAddExhaustionInferiors, baseSorting.getOverrideAddExhaustionInferiors());
                    addSorting(id, allBaseAfterAddExhaustionSuperiors, baseSorting.getAfterAddExhaustionSuperiors());
                    addSorting(id, allBaseAfterAddExhaustionInferiors, baseSorting.getAfterAddExhaustionInferiors());
                    addSorting(id, allBaseBeforeAddExperienceSuperiors, baseSorting.getBeforeAddExperienceSuperiors());
                    addSorting(id, allBaseBeforeAddExperienceInferiors, baseSorting.getBeforeAddExperienceInferiors());
                    addSorting(id, allBaseOverrideAddExperienceSuperiors, baseSorting.getOverrideAddExperienceSuperiors());
                    addSorting(id, allBaseOverrideAddExperienceInferiors, baseSorting.getOverrideAddExperienceInferiors());
                    addSorting(id, allBaseAfterAddExperienceSuperiors, baseSorting.getAfterAddExperienceSuperiors());
                    addSorting(id, allBaseAfterAddExperienceInferiors, baseSorting.getAfterAddExperienceInferiors());
                    addSorting(id, allBaseBeforeAddExperienceLevelSuperiors, baseSorting.getBeforeAddExperienceLevelSuperiors());
                    addSorting(id, allBaseBeforeAddExperienceLevelInferiors, baseSorting.getBeforeAddExperienceLevelInferiors());
                    addSorting(id, allBaseOverrideAddExperienceLevelSuperiors, baseSorting.getOverrideAddExperienceLevelSuperiors());
                    addSorting(id, allBaseOverrideAddExperienceLevelInferiors, baseSorting.getOverrideAddExperienceLevelInferiors());
                    addSorting(id, allBaseAfterAddExperienceLevelSuperiors, baseSorting.getAfterAddExperienceLevelSuperiors());
                    addSorting(id, allBaseAfterAddExperienceLevelInferiors, baseSorting.getAfterAddExperienceLevelInferiors());
                    addSorting(id, allBaseBeforeAddMovementStatSuperiors, baseSorting.getBeforeAddMovementStatSuperiors());
                    addSorting(id, allBaseBeforeAddMovementStatInferiors, baseSorting.getBeforeAddMovementStatInferiors());
                    addSorting(id, allBaseOverrideAddMovementStatSuperiors, baseSorting.getOverrideAddMovementStatSuperiors());
                    addSorting(id, allBaseOverrideAddMovementStatInferiors, baseSorting.getOverrideAddMovementStatInferiors());
                    addSorting(id, allBaseAfterAddMovementStatSuperiors, baseSorting.getAfterAddMovementStatSuperiors());
                    addSorting(id, allBaseAfterAddMovementStatInferiors, baseSorting.getAfterAddMovementStatInferiors());
                    addSorting(id, allBaseBeforeAttackEntityFromSuperiors, baseSorting.getBeforeAttackEntityFromSuperiors());
                    addSorting(id, allBaseBeforeAttackEntityFromInferiors, baseSorting.getBeforeAttackEntityFromInferiors());
                    addSorting(id, allBaseOverrideAttackEntityFromSuperiors, baseSorting.getOverrideAttackEntityFromSuperiors());
                    addSorting(id, allBaseOverrideAttackEntityFromInferiors, baseSorting.getOverrideAttackEntityFromInferiors());
                    addSorting(id, allBaseAfterAttackEntityFromSuperiors, baseSorting.getAfterAttackEntityFromSuperiors());
                    addSorting(id, allBaseAfterAttackEntityFromInferiors, baseSorting.getAfterAttackEntityFromInferiors());
                    addSorting(id, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, baseSorting.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(id, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, baseSorting.getBeforeAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(id, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, baseSorting.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(id, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, baseSorting.getOverrideAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(id, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, baseSorting.getAfterAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(id, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, baseSorting.getAfterAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(id, allBaseBeforeCanBreatheUnderwaterSuperiors, baseSorting.getBeforeCanBreatheUnderwaterSuperiors());
                    addSorting(id, allBaseBeforeCanBreatheUnderwaterInferiors, baseSorting.getBeforeCanBreatheUnderwaterInferiors());
                    addSorting(id, allBaseOverrideCanBreatheUnderwaterSuperiors, baseSorting.getOverrideCanBreatheUnderwaterSuperiors());
                    addSorting(id, allBaseOverrideCanBreatheUnderwaterInferiors, baseSorting.getOverrideCanBreatheUnderwaterInferiors());
                    addSorting(id, allBaseAfterCanBreatheUnderwaterSuperiors, baseSorting.getAfterCanBreatheUnderwaterSuperiors());
                    addSorting(id, allBaseAfterCanBreatheUnderwaterInferiors, baseSorting.getAfterCanBreatheUnderwaterInferiors());
                    addSorting(id, allBaseBeforeCanHarvestBlockSuperiors, baseSorting.getBeforeCanHarvestBlockSuperiors());
                    addSorting(id, allBaseBeforeCanHarvestBlockInferiors, baseSorting.getBeforeCanHarvestBlockInferiors());
                    addSorting(id, allBaseOverrideCanHarvestBlockSuperiors, baseSorting.getOverrideCanHarvestBlockSuperiors());
                    addSorting(id, allBaseOverrideCanHarvestBlockInferiors, baseSorting.getOverrideCanHarvestBlockInferiors());
                    addSorting(id, allBaseAfterCanHarvestBlockSuperiors, baseSorting.getAfterCanHarvestBlockSuperiors());
                    addSorting(id, allBaseAfterCanHarvestBlockInferiors, baseSorting.getAfterCanHarvestBlockInferiors());
                    addSorting(id, allBaseBeforeCanPlayerEditSuperiors, baseSorting.getBeforeCanPlayerEditSuperiors());
                    addSorting(id, allBaseBeforeCanPlayerEditInferiors, baseSorting.getBeforeCanPlayerEditInferiors());
                    addSorting(id, allBaseOverrideCanPlayerEditSuperiors, baseSorting.getOverrideCanPlayerEditSuperiors());
                    addSorting(id, allBaseOverrideCanPlayerEditInferiors, baseSorting.getOverrideCanPlayerEditInferiors());
                    addSorting(id, allBaseAfterCanPlayerEditSuperiors, baseSorting.getAfterCanPlayerEditSuperiors());
                    addSorting(id, allBaseAfterCanPlayerEditInferiors, baseSorting.getAfterCanPlayerEditInferiors());
                    addSorting(id, allBaseBeforeCanTriggerWalkingSuperiors, baseSorting.getBeforeCanTriggerWalkingSuperiors());
                    addSorting(id, allBaseBeforeCanTriggerWalkingInferiors, baseSorting.getBeforeCanTriggerWalkingInferiors());
                    addSorting(id, allBaseOverrideCanTriggerWalkingSuperiors, baseSorting.getOverrideCanTriggerWalkingSuperiors());
                    addSorting(id, allBaseOverrideCanTriggerWalkingInferiors, baseSorting.getOverrideCanTriggerWalkingInferiors());
                    addSorting(id, allBaseAfterCanTriggerWalkingSuperiors, baseSorting.getAfterCanTriggerWalkingSuperiors());
                    addSorting(id, allBaseAfterCanTriggerWalkingInferiors, baseSorting.getAfterCanTriggerWalkingInferiors());
                    addSorting(id, allBaseBeforeClonePlayerSuperiors, baseSorting.getBeforeClonePlayerSuperiors());
                    addSorting(id, allBaseBeforeClonePlayerInferiors, baseSorting.getBeforeClonePlayerInferiors());
                    addSorting(id, allBaseOverrideClonePlayerSuperiors, baseSorting.getOverrideClonePlayerSuperiors());
                    addSorting(id, allBaseOverrideClonePlayerInferiors, baseSorting.getOverrideClonePlayerInferiors());
                    addSorting(id, allBaseAfterClonePlayerSuperiors, baseSorting.getAfterClonePlayerSuperiors());
                    addSorting(id, allBaseAfterClonePlayerInferiors, baseSorting.getAfterClonePlayerInferiors());
                    addSorting(id, allBaseBeforeDamageEntitySuperiors, baseSorting.getBeforeDamageEntitySuperiors());
                    addSorting(id, allBaseBeforeDamageEntityInferiors, baseSorting.getBeforeDamageEntityInferiors());
                    addSorting(id, allBaseOverrideDamageEntitySuperiors, baseSorting.getOverrideDamageEntitySuperiors());
                    addSorting(id, allBaseOverrideDamageEntityInferiors, baseSorting.getOverrideDamageEntityInferiors());
                    addSorting(id, allBaseAfterDamageEntitySuperiors, baseSorting.getAfterDamageEntitySuperiors());
                    addSorting(id, allBaseAfterDamageEntityInferiors, baseSorting.getAfterDamageEntityInferiors());
                    addSorting(id, allBaseBeforeDisplayGUIChestSuperiors, baseSorting.getBeforeDisplayGUIChestSuperiors());
                    addSorting(id, allBaseBeforeDisplayGUIChestInferiors, baseSorting.getBeforeDisplayGUIChestInferiors());
                    addSorting(id, allBaseOverrideDisplayGUIChestSuperiors, baseSorting.getOverrideDisplayGUIChestSuperiors());
                    addSorting(id, allBaseOverrideDisplayGUIChestInferiors, baseSorting.getOverrideDisplayGUIChestInferiors());
                    addSorting(id, allBaseAfterDisplayGUIChestSuperiors, baseSorting.getAfterDisplayGUIChestSuperiors());
                    addSorting(id, allBaseAfterDisplayGUIChestInferiors, baseSorting.getAfterDisplayGUIChestInferiors());
                    addSorting(id, allBaseBeforeDisplayGUIDispenserSuperiors, baseSorting.getBeforeDisplayGUIDispenserSuperiors());
                    addSorting(id, allBaseBeforeDisplayGUIDispenserInferiors, baseSorting.getBeforeDisplayGUIDispenserInferiors());
                    addSorting(id, allBaseOverrideDisplayGUIDispenserSuperiors, baseSorting.getOverrideDisplayGUIDispenserSuperiors());
                    addSorting(id, allBaseOverrideDisplayGUIDispenserInferiors, baseSorting.getOverrideDisplayGUIDispenserInferiors());
                    addSorting(id, allBaseAfterDisplayGUIDispenserSuperiors, baseSorting.getAfterDisplayGUIDispenserSuperiors());
                    addSorting(id, allBaseAfterDisplayGUIDispenserInferiors, baseSorting.getAfterDisplayGUIDispenserInferiors());
                    addSorting(id, allBaseBeforeDisplayGUIFurnaceSuperiors, baseSorting.getBeforeDisplayGUIFurnaceSuperiors());
                    addSorting(id, allBaseBeforeDisplayGUIFurnaceInferiors, baseSorting.getBeforeDisplayGUIFurnaceInferiors());
                    addSorting(id, allBaseOverrideDisplayGUIFurnaceSuperiors, baseSorting.getOverrideDisplayGUIFurnaceSuperiors());
                    addSorting(id, allBaseOverrideDisplayGUIFurnaceInferiors, baseSorting.getOverrideDisplayGUIFurnaceInferiors());
                    addSorting(id, allBaseAfterDisplayGUIFurnaceSuperiors, baseSorting.getAfterDisplayGUIFurnaceSuperiors());
                    addSorting(id, allBaseAfterDisplayGUIFurnaceInferiors, baseSorting.getAfterDisplayGUIFurnaceInferiors());
                    addSorting(id, allBaseBeforeDisplayGUIWorkbenchSuperiors, baseSorting.getBeforeDisplayGUIWorkbenchSuperiors());
                    addSorting(id, allBaseBeforeDisplayGUIWorkbenchInferiors, baseSorting.getBeforeDisplayGUIWorkbenchInferiors());
                    addSorting(id, allBaseOverrideDisplayGUIWorkbenchSuperiors, baseSorting.getOverrideDisplayGUIWorkbenchSuperiors());
                    addSorting(id, allBaseOverrideDisplayGUIWorkbenchInferiors, baseSorting.getOverrideDisplayGUIWorkbenchInferiors());
                    addSorting(id, allBaseAfterDisplayGUIWorkbenchSuperiors, baseSorting.getAfterDisplayGUIWorkbenchSuperiors());
                    addSorting(id, allBaseAfterDisplayGUIWorkbenchInferiors, baseSorting.getAfterDisplayGUIWorkbenchInferiors());
                    addSorting(id, allBaseBeforeDropOneItemSuperiors, baseSorting.getBeforeDropOneItemSuperiors());
                    addSorting(id, allBaseBeforeDropOneItemInferiors, baseSorting.getBeforeDropOneItemInferiors());
                    addSorting(id, allBaseOverrideDropOneItemSuperiors, baseSorting.getOverrideDropOneItemSuperiors());
                    addSorting(id, allBaseOverrideDropOneItemInferiors, baseSorting.getOverrideDropOneItemInferiors());
                    addSorting(id, allBaseAfterDropOneItemSuperiors, baseSorting.getAfterDropOneItemSuperiors());
                    addSorting(id, allBaseAfterDropOneItemInferiors, baseSorting.getAfterDropOneItemInferiors());
                    addSorting(id, allBaseBeforeDropPlayerItemSuperiors, baseSorting.getBeforeDropPlayerItemSuperiors());
                    addSorting(id, allBaseBeforeDropPlayerItemInferiors, baseSorting.getBeforeDropPlayerItemInferiors());
                    addSorting(id, allBaseOverrideDropPlayerItemSuperiors, baseSorting.getOverrideDropPlayerItemSuperiors());
                    addSorting(id, allBaseOverrideDropPlayerItemInferiors, baseSorting.getOverrideDropPlayerItemInferiors());
                    addSorting(id, allBaseAfterDropPlayerItemSuperiors, baseSorting.getAfterDropPlayerItemSuperiors());
                    addSorting(id, allBaseAfterDropPlayerItemInferiors, baseSorting.getAfterDropPlayerItemInferiors());
                    addSorting(id, allBaseBeforeFallSuperiors, baseSorting.getBeforeFallSuperiors());
                    addSorting(id, allBaseBeforeFallInferiors, baseSorting.getBeforeFallInferiors());
                    addSorting(id, allBaseOverrideFallSuperiors, baseSorting.getOverrideFallSuperiors());
                    addSorting(id, allBaseOverrideFallInferiors, baseSorting.getOverrideFallInferiors());
                    addSorting(id, allBaseAfterFallSuperiors, baseSorting.getAfterFallSuperiors());
                    addSorting(id, allBaseAfterFallInferiors, baseSorting.getAfterFallInferiors());
                    addSorting(id, allBaseBeforeGetAIMoveSpeedSuperiors, baseSorting.getBeforeGetAIMoveSpeedSuperiors());
                    addSorting(id, allBaseBeforeGetAIMoveSpeedInferiors, baseSorting.getBeforeGetAIMoveSpeedInferiors());
                    addSorting(id, allBaseOverrideGetAIMoveSpeedSuperiors, baseSorting.getOverrideGetAIMoveSpeedSuperiors());
                    addSorting(id, allBaseOverrideGetAIMoveSpeedInferiors, baseSorting.getOverrideGetAIMoveSpeedInferiors());
                    addSorting(id, allBaseAfterGetAIMoveSpeedSuperiors, baseSorting.getAfterGetAIMoveSpeedSuperiors());
                    addSorting(id, allBaseAfterGetAIMoveSpeedInferiors, baseSorting.getAfterGetAIMoveSpeedInferiors());
                    addSorting(id, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, baseSorting.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(id, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, baseSorting.getBeforeGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(id, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, baseSorting.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(id, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, baseSorting.getOverrideGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(id, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, baseSorting.getAfterGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(id, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, baseSorting.getAfterGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(id, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, baseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(id, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, baseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(id, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, baseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(id, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, baseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(id, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, baseSorting.getAfterGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(id, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, baseSorting.getAfterGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(id, allBaseBeforeGetDistanceSqSuperiors, baseSorting.getBeforeGetDistanceSqSuperiors());
                    addSorting(id, allBaseBeforeGetDistanceSqInferiors, baseSorting.getBeforeGetDistanceSqInferiors());
                    addSorting(id, allBaseOverrideGetDistanceSqSuperiors, baseSorting.getOverrideGetDistanceSqSuperiors());
                    addSorting(id, allBaseOverrideGetDistanceSqInferiors, baseSorting.getOverrideGetDistanceSqInferiors());
                    addSorting(id, allBaseAfterGetDistanceSqSuperiors, baseSorting.getAfterGetDistanceSqSuperiors());
                    addSorting(id, allBaseAfterGetDistanceSqInferiors, baseSorting.getAfterGetDistanceSqInferiors());
                    addSorting(id, allBaseBeforeGetBrightnessSuperiors, baseSorting.getBeforeGetBrightnessSuperiors());
                    addSorting(id, allBaseBeforeGetBrightnessInferiors, baseSorting.getBeforeGetBrightnessInferiors());
                    addSorting(id, allBaseOverrideGetBrightnessSuperiors, baseSorting.getOverrideGetBrightnessSuperiors());
                    addSorting(id, allBaseOverrideGetBrightnessInferiors, baseSorting.getOverrideGetBrightnessInferiors());
                    addSorting(id, allBaseAfterGetBrightnessSuperiors, baseSorting.getAfterGetBrightnessSuperiors());
                    addSorting(id, allBaseAfterGetBrightnessInferiors, baseSorting.getAfterGetBrightnessInferiors());
                    addSorting(id, allBaseBeforeGetEyeHeightSuperiors, baseSorting.getBeforeGetEyeHeightSuperiors());
                    addSorting(id, allBaseBeforeGetEyeHeightInferiors, baseSorting.getBeforeGetEyeHeightInferiors());
                    addSorting(id, allBaseOverrideGetEyeHeightSuperiors, baseSorting.getOverrideGetEyeHeightSuperiors());
                    addSorting(id, allBaseOverrideGetEyeHeightInferiors, baseSorting.getOverrideGetEyeHeightInferiors());
                    addSorting(id, allBaseAfterGetEyeHeightSuperiors, baseSorting.getAfterGetEyeHeightSuperiors());
                    addSorting(id, allBaseAfterGetEyeHeightInferiors, baseSorting.getAfterGetEyeHeightInferiors());
                    addSorting(id, allBaseBeforeHealSuperiors, baseSorting.getBeforeHealSuperiors());
                    addSorting(id, allBaseBeforeHealInferiors, baseSorting.getBeforeHealInferiors());
                    addSorting(id, allBaseOverrideHealSuperiors, baseSorting.getOverrideHealSuperiors());
                    addSorting(id, allBaseOverrideHealInferiors, baseSorting.getOverrideHealInferiors());
                    addSorting(id, allBaseAfterHealSuperiors, baseSorting.getAfterHealSuperiors());
                    addSorting(id, allBaseAfterHealInferiors, baseSorting.getAfterHealInferiors());
                    addSorting(id, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, baseSorting.getBeforeIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(id, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, baseSorting.getBeforeIsEntityInsideOpaqueBlockInferiors());
                    addSorting(id, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, baseSorting.getOverrideIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(id, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, baseSorting.getOverrideIsEntityInsideOpaqueBlockInferiors());
                    addSorting(id, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, baseSorting.getAfterIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(id, allBaseAfterIsEntityInsideOpaqueBlockInferiors, baseSorting.getAfterIsEntityInsideOpaqueBlockInferiors());
                    addSorting(id, allBaseBeforeIsInWaterSuperiors, baseSorting.getBeforeIsInWaterSuperiors());
                    addSorting(id, allBaseBeforeIsInWaterInferiors, baseSorting.getBeforeIsInWaterInferiors());
                    addSorting(id, allBaseOverrideIsInWaterSuperiors, baseSorting.getOverrideIsInWaterSuperiors());
                    addSorting(id, allBaseOverrideIsInWaterInferiors, baseSorting.getOverrideIsInWaterInferiors());
                    addSorting(id, allBaseAfterIsInWaterSuperiors, baseSorting.getAfterIsInWaterSuperiors());
                    addSorting(id, allBaseAfterIsInWaterInferiors, baseSorting.getAfterIsInWaterInferiors());
                    addSorting(id, allBaseBeforeIsInsideOfMaterialSuperiors, baseSorting.getBeforeIsInsideOfMaterialSuperiors());
                    addSorting(id, allBaseBeforeIsInsideOfMaterialInferiors, baseSorting.getBeforeIsInsideOfMaterialInferiors());
                    addSorting(id, allBaseOverrideIsInsideOfMaterialSuperiors, baseSorting.getOverrideIsInsideOfMaterialSuperiors());
                    addSorting(id, allBaseOverrideIsInsideOfMaterialInferiors, baseSorting.getOverrideIsInsideOfMaterialInferiors());
                    addSorting(id, allBaseAfterIsInsideOfMaterialSuperiors, baseSorting.getAfterIsInsideOfMaterialSuperiors());
                    addSorting(id, allBaseAfterIsInsideOfMaterialInferiors, baseSorting.getAfterIsInsideOfMaterialInferiors());
                    addSorting(id, allBaseBeforeIsOnLadderSuperiors, baseSorting.getBeforeIsOnLadderSuperiors());
                    addSorting(id, allBaseBeforeIsOnLadderInferiors, baseSorting.getBeforeIsOnLadderInferiors());
                    addSorting(id, allBaseOverrideIsOnLadderSuperiors, baseSorting.getOverrideIsOnLadderSuperiors());
                    addSorting(id, allBaseOverrideIsOnLadderInferiors, baseSorting.getOverrideIsOnLadderInferiors());
                    addSorting(id, allBaseAfterIsOnLadderSuperiors, baseSorting.getAfterIsOnLadderSuperiors());
                    addSorting(id, allBaseAfterIsOnLadderInferiors, baseSorting.getAfterIsOnLadderInferiors());
                    addSorting(id, allBaseBeforeIsPlayerSleepingSuperiors, baseSorting.getBeforeIsPlayerSleepingSuperiors());
                    addSorting(id, allBaseBeforeIsPlayerSleepingInferiors, baseSorting.getBeforeIsPlayerSleepingInferiors());
                    addSorting(id, allBaseOverrideIsPlayerSleepingSuperiors, baseSorting.getOverrideIsPlayerSleepingSuperiors());
                    addSorting(id, allBaseOverrideIsPlayerSleepingInferiors, baseSorting.getOverrideIsPlayerSleepingInferiors());
                    addSorting(id, allBaseAfterIsPlayerSleepingSuperiors, baseSorting.getAfterIsPlayerSleepingSuperiors());
                    addSorting(id, allBaseAfterIsPlayerSleepingInferiors, baseSorting.getAfterIsPlayerSleepingInferiors());
                    addSorting(id, allBaseBeforeIsSneakingSuperiors, baseSorting.getBeforeIsSneakingSuperiors());
                    addSorting(id, allBaseBeforeIsSneakingInferiors, baseSorting.getBeforeIsSneakingInferiors());
                    addSorting(id, allBaseOverrideIsSneakingSuperiors, baseSorting.getOverrideIsSneakingSuperiors());
                    addSorting(id, allBaseOverrideIsSneakingInferiors, baseSorting.getOverrideIsSneakingInferiors());
                    addSorting(id, allBaseAfterIsSneakingSuperiors, baseSorting.getAfterIsSneakingSuperiors());
                    addSorting(id, allBaseAfterIsSneakingInferiors, baseSorting.getAfterIsSneakingInferiors());
                    addSorting(id, allBaseBeforeJumpSuperiors, baseSorting.getBeforeJumpSuperiors());
                    addSorting(id, allBaseBeforeJumpInferiors, baseSorting.getBeforeJumpInferiors());
                    addSorting(id, allBaseOverrideJumpSuperiors, baseSorting.getOverrideJumpSuperiors());
                    addSorting(id, allBaseOverrideJumpInferiors, baseSorting.getOverrideJumpInferiors());
                    addSorting(id, allBaseAfterJumpSuperiors, baseSorting.getAfterJumpSuperiors());
                    addSorting(id, allBaseAfterJumpInferiors, baseSorting.getAfterJumpInferiors());
                    addSorting(id, allBaseBeforeKnockBackSuperiors, baseSorting.getBeforeKnockBackSuperiors());
                    addSorting(id, allBaseBeforeKnockBackInferiors, baseSorting.getBeforeKnockBackInferiors());
                    addSorting(id, allBaseOverrideKnockBackSuperiors, baseSorting.getOverrideKnockBackSuperiors());
                    addSorting(id, allBaseOverrideKnockBackInferiors, baseSorting.getOverrideKnockBackInferiors());
                    addSorting(id, allBaseAfterKnockBackSuperiors, baseSorting.getAfterKnockBackSuperiors());
                    addSorting(id, allBaseAfterKnockBackInferiors, baseSorting.getAfterKnockBackInferiors());
                    addSorting(id, allBaseBeforeMountEntitySuperiors, baseSorting.getBeforeMountEntitySuperiors());
                    addSorting(id, allBaseBeforeMountEntityInferiors, baseSorting.getBeforeMountEntityInferiors());
                    addSorting(id, allBaseOverrideMountEntitySuperiors, baseSorting.getOverrideMountEntitySuperiors());
                    addSorting(id, allBaseOverrideMountEntityInferiors, baseSorting.getOverrideMountEntityInferiors());
                    addSorting(id, allBaseAfterMountEntitySuperiors, baseSorting.getAfterMountEntitySuperiors());
                    addSorting(id, allBaseAfterMountEntityInferiors, baseSorting.getAfterMountEntityInferiors());
                    addSorting(id, allBaseBeforeMoveEntitySuperiors, baseSorting.getBeforeMoveEntitySuperiors());
                    addSorting(id, allBaseBeforeMoveEntityInferiors, baseSorting.getBeforeMoveEntityInferiors());
                    addSorting(id, allBaseOverrideMoveEntitySuperiors, baseSorting.getOverrideMoveEntitySuperiors());
                    addSorting(id, allBaseOverrideMoveEntityInferiors, baseSorting.getOverrideMoveEntityInferiors());
                    addSorting(id, allBaseAfterMoveEntitySuperiors, baseSorting.getAfterMoveEntitySuperiors());
                    addSorting(id, allBaseAfterMoveEntityInferiors, baseSorting.getAfterMoveEntityInferiors());
                    addSorting(id, allBaseBeforeMoveEntityWithHeadingSuperiors, baseSorting.getBeforeMoveEntityWithHeadingSuperiors());
                    addSorting(id, allBaseBeforeMoveEntityWithHeadingInferiors, baseSorting.getBeforeMoveEntityWithHeadingInferiors());
                    addSorting(id, allBaseOverrideMoveEntityWithHeadingSuperiors, baseSorting.getOverrideMoveEntityWithHeadingSuperiors());
                    addSorting(id, allBaseOverrideMoveEntityWithHeadingInferiors, baseSorting.getOverrideMoveEntityWithHeadingInferiors());
                    addSorting(id, allBaseAfterMoveEntityWithHeadingSuperiors, baseSorting.getAfterMoveEntityWithHeadingSuperiors());
                    addSorting(id, allBaseAfterMoveEntityWithHeadingInferiors, baseSorting.getAfterMoveEntityWithHeadingInferiors());
                    addSorting(id, allBaseBeforeMoveFlyingSuperiors, baseSorting.getBeforeMoveFlyingSuperiors());
                    addSorting(id, allBaseBeforeMoveFlyingInferiors, baseSorting.getBeforeMoveFlyingInferiors());
                    addSorting(id, allBaseOverrideMoveFlyingSuperiors, baseSorting.getOverrideMoveFlyingSuperiors());
                    addSorting(id, allBaseOverrideMoveFlyingInferiors, baseSorting.getOverrideMoveFlyingInferiors());
                    addSorting(id, allBaseAfterMoveFlyingSuperiors, baseSorting.getAfterMoveFlyingSuperiors());
                    addSorting(id, allBaseAfterMoveFlyingInferiors, baseSorting.getAfterMoveFlyingInferiors());
                    addSorting(id, allBaseBeforeOnDeathSuperiors, baseSorting.getBeforeOnDeathSuperiors());
                    addSorting(id, allBaseBeforeOnDeathInferiors, baseSorting.getBeforeOnDeathInferiors());
                    addSorting(id, allBaseOverrideOnDeathSuperiors, baseSorting.getOverrideOnDeathSuperiors());
                    addSorting(id, allBaseOverrideOnDeathInferiors, baseSorting.getOverrideOnDeathInferiors());
                    addSorting(id, allBaseAfterOnDeathSuperiors, baseSorting.getAfterOnDeathSuperiors());
                    addSorting(id, allBaseAfterOnDeathInferiors, baseSorting.getAfterOnDeathInferiors());
                    addSorting(id, allBaseBeforeOnLivingUpdateSuperiors, baseSorting.getBeforeOnLivingUpdateSuperiors());
                    addSorting(id, allBaseBeforeOnLivingUpdateInferiors, baseSorting.getBeforeOnLivingUpdateInferiors());
                    addSorting(id, allBaseOverrideOnLivingUpdateSuperiors, baseSorting.getOverrideOnLivingUpdateSuperiors());
                    addSorting(id, allBaseOverrideOnLivingUpdateInferiors, baseSorting.getOverrideOnLivingUpdateInferiors());
                    addSorting(id, allBaseAfterOnLivingUpdateSuperiors, baseSorting.getAfterOnLivingUpdateSuperiors());
                    addSorting(id, allBaseAfterOnLivingUpdateInferiors, baseSorting.getAfterOnLivingUpdateInferiors());
                    addSorting(id, allBaseBeforeOnKillEntitySuperiors, baseSorting.getBeforeOnKillEntitySuperiors());
                    addSorting(id, allBaseBeforeOnKillEntityInferiors, baseSorting.getBeforeOnKillEntityInferiors());
                    addSorting(id, allBaseOverrideOnKillEntitySuperiors, baseSorting.getOverrideOnKillEntitySuperiors());
                    addSorting(id, allBaseOverrideOnKillEntityInferiors, baseSorting.getOverrideOnKillEntityInferiors());
                    addSorting(id, allBaseAfterOnKillEntitySuperiors, baseSorting.getAfterOnKillEntitySuperiors());
                    addSorting(id, allBaseAfterOnKillEntityInferiors, baseSorting.getAfterOnKillEntityInferiors());
                    addSorting(id, allBaseBeforeOnStruckByLightningSuperiors, baseSorting.getBeforeOnStruckByLightningSuperiors());
                    addSorting(id, allBaseBeforeOnStruckByLightningInferiors, baseSorting.getBeforeOnStruckByLightningInferiors());
                    addSorting(id, allBaseOverrideOnStruckByLightningSuperiors, baseSorting.getOverrideOnStruckByLightningSuperiors());
                    addSorting(id, allBaseOverrideOnStruckByLightningInferiors, baseSorting.getOverrideOnStruckByLightningInferiors());
                    addSorting(id, allBaseAfterOnStruckByLightningSuperiors, baseSorting.getAfterOnStruckByLightningSuperiors());
                    addSorting(id, allBaseAfterOnStruckByLightningInferiors, baseSorting.getAfterOnStruckByLightningInferiors());
                    addSorting(id, allBaseBeforeOnUpdateSuperiors, baseSorting.getBeforeOnUpdateSuperiors());
                    addSorting(id, allBaseBeforeOnUpdateInferiors, baseSorting.getBeforeOnUpdateInferiors());
                    addSorting(id, allBaseOverrideOnUpdateSuperiors, baseSorting.getOverrideOnUpdateSuperiors());
                    addSorting(id, allBaseOverrideOnUpdateInferiors, baseSorting.getOverrideOnUpdateInferiors());
                    addSorting(id, allBaseAfterOnUpdateSuperiors, baseSorting.getAfterOnUpdateSuperiors());
                    addSorting(id, allBaseAfterOnUpdateInferiors, baseSorting.getAfterOnUpdateInferiors());
                    addSorting(id, allBaseBeforeOnUpdateEntitySuperiors, baseSorting.getBeforeOnUpdateEntitySuperiors());
                    addSorting(id, allBaseBeforeOnUpdateEntityInferiors, baseSorting.getBeforeOnUpdateEntityInferiors());
                    addSorting(id, allBaseOverrideOnUpdateEntitySuperiors, baseSorting.getOverrideOnUpdateEntitySuperiors());
                    addSorting(id, allBaseOverrideOnUpdateEntityInferiors, baseSorting.getOverrideOnUpdateEntityInferiors());
                    addSorting(id, allBaseAfterOnUpdateEntitySuperiors, baseSorting.getAfterOnUpdateEntitySuperiors());
                    addSorting(id, allBaseAfterOnUpdateEntityInferiors, baseSorting.getAfterOnUpdateEntityInferiors());
                    addSorting(id, allBaseBeforeReadEntityFromNBTSuperiors, baseSorting.getBeforeReadEntityFromNBTSuperiors());
                    addSorting(id, allBaseBeforeReadEntityFromNBTInferiors, baseSorting.getBeforeReadEntityFromNBTInferiors());
                    addSorting(id, allBaseOverrideReadEntityFromNBTSuperiors, baseSorting.getOverrideReadEntityFromNBTSuperiors());
                    addSorting(id, allBaseOverrideReadEntityFromNBTInferiors, baseSorting.getOverrideReadEntityFromNBTInferiors());
                    addSorting(id, allBaseAfterReadEntityFromNBTSuperiors, baseSorting.getAfterReadEntityFromNBTSuperiors());
                    addSorting(id, allBaseAfterReadEntityFromNBTInferiors, baseSorting.getAfterReadEntityFromNBTInferiors());
                    addSorting(id, allBaseBeforeSetDeadSuperiors, baseSorting.getBeforeSetDeadSuperiors());
                    addSorting(id, allBaseBeforeSetDeadInferiors, baseSorting.getBeforeSetDeadInferiors());
                    addSorting(id, allBaseOverrideSetDeadSuperiors, baseSorting.getOverrideSetDeadSuperiors());
                    addSorting(id, allBaseOverrideSetDeadInferiors, baseSorting.getOverrideSetDeadInferiors());
                    addSorting(id, allBaseAfterSetDeadSuperiors, baseSorting.getAfterSetDeadSuperiors());
                    addSorting(id, allBaseAfterSetDeadInferiors, baseSorting.getAfterSetDeadInferiors());
                    addSorting(id, allBaseBeforeSetEntityActionStateSuperiors, baseSorting.getBeforeSetEntityActionStateSuperiors());
                    addSorting(id, allBaseBeforeSetEntityActionStateInferiors, baseSorting.getBeforeSetEntityActionStateInferiors());
                    addSorting(id, allBaseOverrideSetEntityActionStateSuperiors, baseSorting.getOverrideSetEntityActionStateSuperiors());
                    addSorting(id, allBaseOverrideSetEntityActionStateInferiors, baseSorting.getOverrideSetEntityActionStateInferiors());
                    addSorting(id, allBaseAfterSetEntityActionStateSuperiors, baseSorting.getAfterSetEntityActionStateSuperiors());
                    addSorting(id, allBaseAfterSetEntityActionStateInferiors, baseSorting.getAfterSetEntityActionStateInferiors());
                    addSorting(id, allBaseBeforeSetPositionSuperiors, baseSorting.getBeforeSetPositionSuperiors());
                    addSorting(id, allBaseBeforeSetPositionInferiors, baseSorting.getBeforeSetPositionInferiors());
                    addSorting(id, allBaseOverrideSetPositionSuperiors, baseSorting.getOverrideSetPositionSuperiors());
                    addSorting(id, allBaseOverrideSetPositionInferiors, baseSorting.getOverrideSetPositionInferiors());
                    addSorting(id, allBaseAfterSetPositionSuperiors, baseSorting.getAfterSetPositionSuperiors());
                    addSorting(id, allBaseAfterSetPositionInferiors, baseSorting.getAfterSetPositionInferiors());
                    addSorting(id, allBaseBeforeSetSneakingSuperiors, baseSorting.getBeforeSetSneakingSuperiors());
                    addSorting(id, allBaseBeforeSetSneakingInferiors, baseSorting.getBeforeSetSneakingInferiors());
                    addSorting(id, allBaseOverrideSetSneakingSuperiors, baseSorting.getOverrideSetSneakingSuperiors());
                    addSorting(id, allBaseOverrideSetSneakingInferiors, baseSorting.getOverrideSetSneakingInferiors());
                    addSorting(id, allBaseAfterSetSneakingSuperiors, baseSorting.getAfterSetSneakingSuperiors());
                    addSorting(id, allBaseAfterSetSneakingInferiors, baseSorting.getAfterSetSneakingInferiors());
                    addSorting(id, allBaseBeforeSetSprintingSuperiors, baseSorting.getBeforeSetSprintingSuperiors());
                    addSorting(id, allBaseBeforeSetSprintingInferiors, baseSorting.getBeforeSetSprintingInferiors());
                    addSorting(id, allBaseOverrideSetSprintingSuperiors, baseSorting.getOverrideSetSprintingSuperiors());
                    addSorting(id, allBaseOverrideSetSprintingInferiors, baseSorting.getOverrideSetSprintingInferiors());
                    addSorting(id, allBaseAfterSetSprintingSuperiors, baseSorting.getAfterSetSprintingSuperiors());
                    addSorting(id, allBaseAfterSetSprintingInferiors, baseSorting.getAfterSetSprintingInferiors());
                    addSorting(id, allBaseBeforeSwingItemSuperiors, baseSorting.getBeforeSwingItemSuperiors());
                    addSorting(id, allBaseBeforeSwingItemInferiors, baseSorting.getBeforeSwingItemInferiors());
                    addSorting(id, allBaseOverrideSwingItemSuperiors, baseSorting.getOverrideSwingItemSuperiors());
                    addSorting(id, allBaseOverrideSwingItemInferiors, baseSorting.getOverrideSwingItemInferiors());
                    addSorting(id, allBaseAfterSwingItemSuperiors, baseSorting.getAfterSwingItemSuperiors());
                    addSorting(id, allBaseAfterSwingItemInferiors, baseSorting.getAfterSwingItemInferiors());
                    addSorting(id, allBaseBeforeUpdateEntityActionStateSuperiors, baseSorting.getBeforeUpdateEntityActionStateSuperiors());
                    addSorting(id, allBaseBeforeUpdateEntityActionStateInferiors, baseSorting.getBeforeUpdateEntityActionStateInferiors());
                    addSorting(id, allBaseOverrideUpdateEntityActionStateSuperiors, baseSorting.getOverrideUpdateEntityActionStateSuperiors());
                    addSorting(id, allBaseOverrideUpdateEntityActionStateInferiors, baseSorting.getOverrideUpdateEntityActionStateInferiors());
                    addSorting(id, allBaseAfterUpdateEntityActionStateSuperiors, baseSorting.getAfterUpdateEntityActionStateSuperiors());
                    addSorting(id, allBaseAfterUpdateEntityActionStateInferiors, baseSorting.getAfterUpdateEntityActionStateInferiors());
                    addSorting(id, allBaseBeforeUpdatePotionEffectsSuperiors, baseSorting.getBeforeUpdatePotionEffectsSuperiors());
                    addSorting(id, allBaseBeforeUpdatePotionEffectsInferiors, baseSorting.getBeforeUpdatePotionEffectsInferiors());
                    addSorting(id, allBaseOverrideUpdatePotionEffectsSuperiors, baseSorting.getOverrideUpdatePotionEffectsSuperiors());
                    addSorting(id, allBaseOverrideUpdatePotionEffectsInferiors, baseSorting.getOverrideUpdatePotionEffectsInferiors());
                    addSorting(id, allBaseAfterUpdatePotionEffectsSuperiors, baseSorting.getAfterUpdatePotionEffectsSuperiors());
                    addSorting(id, allBaseAfterUpdatePotionEffectsInferiors, baseSorting.getAfterUpdatePotionEffectsInferiors());
                    addSorting(id, allBaseBeforeUpdateRiddenSuperiors, baseSorting.getBeforeUpdateRiddenSuperiors());
                    addSorting(id, allBaseBeforeUpdateRiddenInferiors, baseSorting.getBeforeUpdateRiddenInferiors());
                    addSorting(id, allBaseOverrideUpdateRiddenSuperiors, baseSorting.getOverrideUpdateRiddenSuperiors());
                    addSorting(id, allBaseOverrideUpdateRiddenInferiors, baseSorting.getOverrideUpdateRiddenInferiors());
                    addSorting(id, allBaseAfterUpdateRiddenSuperiors, baseSorting.getAfterUpdateRiddenSuperiors());
                    addSorting(id, allBaseAfterUpdateRiddenInferiors, baseSorting.getAfterUpdateRiddenInferiors());
                    addSorting(id, allBaseBeforeWakeUpPlayerSuperiors, baseSorting.getBeforeWakeUpPlayerSuperiors());
                    addSorting(id, allBaseBeforeWakeUpPlayerInferiors, baseSorting.getBeforeWakeUpPlayerInferiors());
                    addSorting(id, allBaseOverrideWakeUpPlayerSuperiors, baseSorting.getOverrideWakeUpPlayerSuperiors());
                    addSorting(id, allBaseOverrideWakeUpPlayerInferiors, baseSorting.getOverrideWakeUpPlayerInferiors());
                    addSorting(id, allBaseAfterWakeUpPlayerSuperiors, baseSorting.getAfterWakeUpPlayerSuperiors());
                    addSorting(id, allBaseAfterWakeUpPlayerInferiors, baseSorting.getAfterWakeUpPlayerInferiors());
                    addSorting(id, allBaseBeforeWriteEntityToNBTSuperiors, baseSorting.getBeforeWriteEntityToNBTSuperiors());
                    addSorting(id, allBaseBeforeWriteEntityToNBTInferiors, baseSorting.getBeforeWriteEntityToNBTInferiors());
                    addSorting(id, allBaseOverrideWriteEntityToNBTSuperiors, baseSorting.getOverrideWriteEntityToNBTSuperiors());
                    addSorting(id, allBaseOverrideWriteEntityToNBTInferiors, baseSorting.getOverrideWriteEntityToNBTInferiors());
                    addSorting(id, allBaseAfterWriteEntityToNBTSuperiors, baseSorting.getAfterWriteEntityToNBTSuperiors());
                    addSorting(id, allBaseAfterWriteEntityToNBTInferiors, baseSorting.getAfterWriteEntityToNBTInferiors());
                }

                addMethod(id, baseClass, beforeLocalConstructingHookTypes, "beforeLocalConstructing", MinecraftServer.class, WorldServer.class, GameProfile.class, ItemInWorldManager.class);
                addMethod(id, baseClass, afterLocalConstructingHookTypes, "afterLocalConstructing", MinecraftServer.class, WorldServer.class, GameProfile.class, ItemInWorldManager.class);
                addMethod(id, baseClass, beforeAddExhaustionHookTypes, "beforeAddExhaustion", float.class);
                addMethod(id, baseClass, overrideAddExhaustionHookTypes, "addExhaustion", float.class);
                addMethod(id, baseClass, afterAddExhaustionHookTypes, "afterAddExhaustion", float.class);
                addMethod(id, baseClass, beforeAddExperienceHookTypes, "beforeAddExperience", int.class);
                addMethod(id, baseClass, overrideAddExperienceHookTypes, "addExperience", int.class);
                addMethod(id, baseClass, afterAddExperienceHookTypes, "afterAddExperience", int.class);
                addMethod(id, baseClass, beforeAddExperienceLevelHookTypes, "beforeAddExperienceLevel", int.class);
                addMethod(id, baseClass, overrideAddExperienceLevelHookTypes, "addExperienceLevel", int.class);
                addMethod(id, baseClass, afterAddExperienceLevelHookTypes, "afterAddExperienceLevel", int.class);
                addMethod(id, baseClass, beforeAddMovementStatHookTypes, "beforeAddMovementStat", double.class, double.class, double.class);
                addMethod(id, baseClass, overrideAddMovementStatHookTypes, "addMovementStat", double.class, double.class, double.class);
                addMethod(id, baseClass, afterAddMovementStatHookTypes, "afterAddMovementStat", double.class, double.class, double.class);
                addMethod(id, baseClass, beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", DamageSource.class, float.class);
                addMethod(id, baseClass, overrideAttackEntityFromHookTypes, "attackEntityFrom", DamageSource.class, float.class);
                addMethod(id, baseClass, afterAttackEntityFromHookTypes, "afterAttackEntityFrom", DamageSource.class, float.class);
                addMethod(id, baseClass, beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", Entity.class);
                addMethod(id, baseClass, overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", Entity.class);
                addMethod(id, baseClass, afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", Entity.class);
                addMethod(id, baseClass, beforeCanBreatheUnderwaterHookTypes, "beforeCanBreatheUnderwater");
                addMethod(id, baseClass, overrideCanBreatheUnderwaterHookTypes, "canBreatheUnderwater");
                addMethod(id, baseClass, afterCanBreatheUnderwaterHookTypes, "afterCanBreatheUnderwater");
                addMethod(id, baseClass, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", Block.class);
                addMethod(id, baseClass, overrideCanHarvestBlockHookTypes, "canHarvestBlock", Block.class);
                addMethod(id, baseClass, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", Block.class);
                addMethod(id, baseClass, beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", int.class, int.class, int.class, int.class, ItemStack.class);
                addMethod(id, baseClass, overrideCanPlayerEditHookTypes, "canPlayerEdit", int.class, int.class, int.class, int.class, ItemStack.class);
                addMethod(id, baseClass, afterCanPlayerEditHookTypes, "afterCanPlayerEdit", int.class, int.class, int.class, int.class, ItemStack.class);
                addMethod(id, baseClass, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking");
                addMethod(id, baseClass, overrideCanTriggerWalkingHookTypes, "canTriggerWalking");
                addMethod(id, baseClass, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking");
                addMethod(id, baseClass, beforeClonePlayerHookTypes, "beforeClonePlayer", EntityPlayer.class, boolean.class);
                addMethod(id, baseClass, overrideClonePlayerHookTypes, "clonePlayer", EntityPlayer.class, boolean.class);
                addMethod(id, baseClass, afterClonePlayerHookTypes, "afterClonePlayer", EntityPlayer.class, boolean.class);
                addMethod(id, baseClass, beforeDamageEntityHookTypes, "beforeDamageEntity", DamageSource.class, float.class);
                addMethod(id, baseClass, overrideDamageEntityHookTypes, "damageEntity", DamageSource.class, float.class);
                addMethod(id, baseClass, afterDamageEntityHookTypes, "afterDamageEntity", DamageSource.class, float.class);
                addMethod(id, baseClass, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", IInventory.class);
                addMethod(id, baseClass, overrideDisplayGUIChestHookTypes, "displayGUIChest", IInventory.class);
                addMethod(id, baseClass, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", IInventory.class);
                addMethod(id, baseClass, beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", TileEntityDispenser.class);
                addMethod(id, baseClass, overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", TileEntityDispenser.class);
                addMethod(id, baseClass, afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", TileEntityDispenser.class);
                addMethod(id, baseClass, beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", TileEntityFurnace.class);
                addMethod(id, baseClass, overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", TileEntityFurnace.class);
                addMethod(id, baseClass, afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", TileEntityFurnace.class);
                addMethod(id, baseClass, beforeDisplayGUIWorkbenchHookTypes, "beforeDisplayGUIWorkbench", int.class, int.class, int.class);
                addMethod(id, baseClass, overrideDisplayGUIWorkbenchHookTypes, "displayGUIWorkbench", int.class, int.class, int.class);
                addMethod(id, baseClass, afterDisplayGUIWorkbenchHookTypes, "afterDisplayGUIWorkbench", int.class, int.class, int.class);
                addMethod(id, baseClass, beforeDropOneItemHookTypes, "beforeDropOneItem", boolean.class);
                addMethod(id, baseClass, overrideDropOneItemHookTypes, "dropOneItem", boolean.class);
                addMethod(id, baseClass, afterDropOneItemHookTypes, "afterDropOneItem", boolean.class);
                addMethod(id, baseClass, beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", ItemStack.class, boolean.class);
                addMethod(id, baseClass, overrideDropPlayerItemHookTypes, "dropPlayerItem", ItemStack.class, boolean.class);
                addMethod(id, baseClass, afterDropPlayerItemHookTypes, "afterDropPlayerItem", ItemStack.class, boolean.class);
                addMethod(id, baseClass, beforeFallHookTypes, "beforeFall", float.class);
                addMethod(id, baseClass, overrideFallHookTypes, "fall", float.class);
                addMethod(id, baseClass, afterFallHookTypes, "afterFall", float.class);
                addMethod(id, baseClass, beforeGetAIMoveSpeedHookTypes, "beforeGetAIMoveSpeed");
                addMethod(id, baseClass, overrideGetAIMoveSpeedHookTypes, "getAIMoveSpeed");
                addMethod(id, baseClass, afterGetAIMoveSpeedHookTypes, "afterGetAIMoveSpeed");
                addMethod(id, baseClass, beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", Block.class, boolean.class);
                addMethod(id, baseClass, overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", Block.class, boolean.class);
                addMethod(id, baseClass, afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", Block.class, boolean.class);
                addMethod(id, baseClass, beforeGetCurrentPlayerStrVsBlockForgeHookTypes, "beforeGetCurrentPlayerStrVsBlockForge", Block.class, boolean.class, int.class);
                addMethod(id, baseClass, overrideGetCurrentPlayerStrVsBlockForgeHookTypes, "getCurrentPlayerStrVsBlockForge", Block.class, boolean.class, int.class);
                addMethod(id, baseClass, afterGetCurrentPlayerStrVsBlockForgeHookTypes, "afterGetCurrentPlayerStrVsBlockForge", Block.class, boolean.class, int.class);
                addMethod(id, baseClass, beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", double.class, double.class, double.class);
                addMethod(id, baseClass, overrideGetDistanceSqHookTypes, "getDistanceSq", double.class, double.class, double.class);
                addMethod(id, baseClass, afterGetDistanceSqHookTypes, "afterGetDistanceSq", double.class, double.class, double.class);
                addMethod(id, baseClass, beforeGetBrightnessHookTypes, "beforeGetBrightness", float.class);
                addMethod(id, baseClass, overrideGetBrightnessHookTypes, "getBrightness", float.class);
                addMethod(id, baseClass, afterGetBrightnessHookTypes, "afterGetBrightness", float.class);
                addMethod(id, baseClass, beforeGetEyeHeightHookTypes, "beforeGetEyeHeight");
                addMethod(id, baseClass, overrideGetEyeHeightHookTypes, "getEyeHeight");
                addMethod(id, baseClass, afterGetEyeHeightHookTypes, "afterGetEyeHeight");
                addMethod(id, baseClass, beforeHealHookTypes, "beforeHeal", float.class);
                addMethod(id, baseClass, overrideHealHookTypes, "heal", float.class);
                addMethod(id, baseClass, afterHealHookTypes, "afterHeal", float.class);
                addMethod(id, baseClass, beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock");
                addMethod(id, baseClass, overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock");
                addMethod(id, baseClass, afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock");
                addMethod(id, baseClass, beforeIsInWaterHookTypes, "beforeIsInWater");
                addMethod(id, baseClass, overrideIsInWaterHookTypes, "isInWater");
                addMethod(id, baseClass, afterIsInWaterHookTypes, "afterIsInWater");
                addMethod(id, baseClass, beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", Material.class);
                addMethod(id, baseClass, overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", Material.class);
                addMethod(id, baseClass, afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", Material.class);
                addMethod(id, baseClass, beforeIsOnLadderHookTypes, "beforeIsOnLadder");
                addMethod(id, baseClass, overrideIsOnLadderHookTypes, "isOnLadder");
                addMethod(id, baseClass, afterIsOnLadderHookTypes, "afterIsOnLadder");
                addMethod(id, baseClass, beforeIsPlayerSleepingHookTypes, "beforeIsPlayerSleeping");
                addMethod(id, baseClass, overrideIsPlayerSleepingHookTypes, "isPlayerSleeping");
                addMethod(id, baseClass, afterIsPlayerSleepingHookTypes, "afterIsPlayerSleeping");
                addMethod(id, baseClass, beforeIsSneakingHookTypes, "beforeIsSneaking");
                addMethod(id, baseClass, overrideIsSneakingHookTypes, "isSneaking");
                addMethod(id, baseClass, afterIsSneakingHookTypes, "afterIsSneaking");
                addMethod(id, baseClass, beforeJumpHookTypes, "beforeJump");
                addMethod(id, baseClass, overrideJumpHookTypes, "jump");
                addMethod(id, baseClass, afterJumpHookTypes, "afterJump");
                addMethod(id, baseClass, beforeKnockBackHookTypes, "beforeKnockBack", Entity.class, float.class, double.class, double.class);
                addMethod(id, baseClass, overrideKnockBackHookTypes, "knockBack", Entity.class, float.class, double.class, double.class);
                addMethod(id, baseClass, afterKnockBackHookTypes, "afterKnockBack", Entity.class, float.class, double.class, double.class);
                addMethod(id, baseClass, beforeMountEntityHookTypes, "beforeMountEntity", Entity.class);
                addMethod(id, baseClass, overrideMountEntityHookTypes, "mountEntity", Entity.class);
                addMethod(id, baseClass, afterMountEntityHookTypes, "afterMountEntity", Entity.class);
                addMethod(id, baseClass, beforeMoveEntityHookTypes, "beforeMoveEntity", double.class, double.class, double.class);
                addMethod(id, baseClass, overrideMoveEntityHookTypes, "moveEntity", double.class, double.class, double.class);
                addMethod(id, baseClass, afterMoveEntityHookTypes, "afterMoveEntity", double.class, double.class, double.class);
                addMethod(id, baseClass, beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", float.class, float.class);
                addMethod(id, baseClass, overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", float.class, float.class);
                addMethod(id, baseClass, afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", float.class, float.class);
                addMethod(id, baseClass, beforeMoveFlyingHookTypes, "beforeMoveFlying", float.class, float.class, float.class);
                addMethod(id, baseClass, overrideMoveFlyingHookTypes, "moveFlying", float.class, float.class, float.class);
                addMethod(id, baseClass, afterMoveFlyingHookTypes, "afterMoveFlying", float.class, float.class, float.class);
                addMethod(id, baseClass, beforeOnDeathHookTypes, "beforeOnDeath", DamageSource.class);
                addMethod(id, baseClass, overrideOnDeathHookTypes, "onDeath", DamageSource.class);
                addMethod(id, baseClass, afterOnDeathHookTypes, "afterOnDeath", DamageSource.class);
                addMethod(id, baseClass, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate");
                addMethod(id, baseClass, overrideOnLivingUpdateHookTypes, "onLivingUpdate");
                addMethod(id, baseClass, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate");
                addMethod(id, baseClass, beforeOnKillEntityHookTypes, "beforeOnKillEntity", EntityLivingBase.class);
                addMethod(id, baseClass, overrideOnKillEntityHookTypes, "onKillEntity", EntityLivingBase.class);
                addMethod(id, baseClass, afterOnKillEntityHookTypes, "afterOnKillEntity", EntityLivingBase.class);
                addMethod(id, baseClass, beforeOnStruckByLightningHookTypes, "beforeOnStruckByLightning", EntityLightningBolt.class);
                addMethod(id, baseClass, overrideOnStruckByLightningHookTypes, "onStruckByLightning", EntityLightningBolt.class);
                addMethod(id, baseClass, afterOnStruckByLightningHookTypes, "afterOnStruckByLightning", EntityLightningBolt.class);
                addMethod(id, baseClass, beforeOnUpdateHookTypes, "beforeOnUpdate");
                addMethod(id, baseClass, overrideOnUpdateHookTypes, "onUpdate");
                addMethod(id, baseClass, afterOnUpdateHookTypes, "afterOnUpdate");
                addMethod(id, baseClass, beforeOnUpdateEntityHookTypes, "beforeOnUpdateEntity");
                addMethod(id, baseClass, overrideOnUpdateEntityHookTypes, "onUpdateEntity");
                addMethod(id, baseClass, afterOnUpdateEntityHookTypes, "afterOnUpdateEntity");
                addMethod(id, baseClass, beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", NBTTagCompound.class);
                addMethod(id, baseClass, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", NBTTagCompound.class);
                addMethod(id, baseClass, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", NBTTagCompound.class);
                addMethod(id, baseClass, beforeSetDeadHookTypes, "beforeSetDead");
                addMethod(id, baseClass, overrideSetDeadHookTypes, "setDead");
                addMethod(id, baseClass, afterSetDeadHookTypes, "afterSetDead");
                addMethod(id, baseClass, beforeSetEntityActionStateHookTypes, "beforeSetEntityActionState", float.class, float.class, boolean.class, boolean.class);
                addMethod(id, baseClass, overrideSetEntityActionStateHookTypes, "setEntityActionState", float.class, float.class, boolean.class, boolean.class);
                addMethod(id, baseClass, afterSetEntityActionStateHookTypes, "afterSetEntityActionState", float.class, float.class, boolean.class, boolean.class);
                addMethod(id, baseClass, beforeSetPositionHookTypes, "beforeSetPosition", double.class, double.class, double.class);
                addMethod(id, baseClass, overrideSetPositionHookTypes, "setPosition", double.class, double.class, double.class);
                addMethod(id, baseClass, afterSetPositionHookTypes, "afterSetPosition", double.class, double.class, double.class);
                addMethod(id, baseClass, beforeSetSneakingHookTypes, "beforeSetSneaking", boolean.class);
                addMethod(id, baseClass, overrideSetSneakingHookTypes, "setSneaking", boolean.class);
                addMethod(id, baseClass, afterSetSneakingHookTypes, "afterSetSneaking", boolean.class);
                addMethod(id, baseClass, beforeSetSprintingHookTypes, "beforeSetSprinting", boolean.class);
                addMethod(id, baseClass, overrideSetSprintingHookTypes, "setSprinting", boolean.class);
                addMethod(id, baseClass, afterSetSprintingHookTypes, "afterSetSprinting", boolean.class);
                addMethod(id, baseClass, beforeSwingItemHookTypes, "beforeSwingItem");
                addMethod(id, baseClass, overrideSwingItemHookTypes, "swingItem");
                addMethod(id, baseClass, afterSwingItemHookTypes, "afterSwingItem");
                addMethod(id, baseClass, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState");
                addMethod(id, baseClass, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState");
                addMethod(id, baseClass, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState");
                addMethod(id, baseClass, beforeUpdatePotionEffectsHookTypes, "beforeUpdatePotionEffects");
                addMethod(id, baseClass, overrideUpdatePotionEffectsHookTypes, "updatePotionEffects");
                addMethod(id, baseClass, afterUpdatePotionEffectsHookTypes, "afterUpdatePotionEffects");
                addMethod(id, baseClass, beforeUpdateRiddenHookTypes, "beforeUpdateRidden");
                addMethod(id, baseClass, overrideUpdateRiddenHookTypes, "updateRidden");
                addMethod(id, baseClass, afterUpdateRiddenHookTypes, "afterUpdateRidden");
                addMethod(id, baseClass, beforeWakeUpPlayerHookTypes, "beforeWakeUpPlayer", boolean.class, boolean.class, boolean.class);
                addMethod(id, baseClass, overrideWakeUpPlayerHookTypes, "wakeUpPlayer", boolean.class, boolean.class, boolean.class);
                addMethod(id, baseClass, afterWakeUpPlayerHookTypes, "afterWakeUpPlayer", boolean.class, boolean.class, boolean.class);
                addMethod(id, baseClass, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", NBTTagCompound.class);
                addMethod(id, baseClass, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", NBTTagCompound.class);
                addMethod(id, baseClass, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", NBTTagCompound.class);
                
                addDynamicMethods(id, baseClass);
                addDynamicKeys(id, baseClass, beforeDynamicHookMethods, beforeDynamicHookTypes);
                addDynamicKeys(id, baseClass, overrideDynamicHookMethods, overrideDynamicHookTypes);
                addDynamicKeys(id, baseClass, afterDynamicHookMethods, afterDynamicHookTypes);
                
                initialize();
                
                for (IServerPlayerAPI instance : getAllInstancesList()) {
                    instance.getServerPlayerAPI().attachServerPlayerBase(id);
                }

                System.out.println("Server Player: registered " + id);
                logger.fine("Server Player: registered class '" + baseClass.getName() + "' with id '" + id + "'");
                
                initialized = false;
            }
        }
    }

    public static boolean unregister(String id) {
        if (id == null) {
            return false;
        } else {
            Constructor<?> constructor = allBaseConstructors.remove(id);
            if (constructor == null) {
                return false;
            } else {
                
                for (IServerPlayerAPI instance : getAllInstancesList()) {
                    instance.getServerPlayerAPI().detachServerPlayerBase(id);
                }

                beforeLocalConstructingHookTypes.remove(id);
                afterLocalConstructingHookTypes.remove(id);
                allBaseBeforeAddExhaustionSuperiors.remove(id);
                allBaseBeforeAddExhaustionInferiors.remove(id);
                allBaseOverrideAddExhaustionSuperiors.remove(id);
                allBaseOverrideAddExhaustionInferiors.remove(id);
                allBaseAfterAddExhaustionSuperiors.remove(id);
                allBaseAfterAddExhaustionInferiors.remove(id);
                beforeAddExhaustionHookTypes.remove(id);
                overrideAddExhaustionHookTypes.remove(id);
                afterAddExhaustionHookTypes.remove(id);
                allBaseBeforeAddExperienceSuperiors.remove(id);
                allBaseBeforeAddExperienceInferiors.remove(id);
                allBaseOverrideAddExperienceSuperiors.remove(id);
                allBaseOverrideAddExperienceInferiors.remove(id);
                allBaseAfterAddExperienceSuperiors.remove(id);
                allBaseAfterAddExperienceInferiors.remove(id);
                beforeAddExperienceHookTypes.remove(id);
                overrideAddExperienceHookTypes.remove(id);
                afterAddExperienceHookTypes.remove(id);
                allBaseBeforeAddExperienceLevelSuperiors.remove(id);
                allBaseBeforeAddExperienceLevelInferiors.remove(id);
                allBaseOverrideAddExperienceLevelSuperiors.remove(id);
                allBaseOverrideAddExperienceLevelInferiors.remove(id);
                allBaseAfterAddExperienceLevelSuperiors.remove(id);
                allBaseAfterAddExperienceLevelInferiors.remove(id);
                beforeAddExperienceLevelHookTypes.remove(id);
                overrideAddExperienceLevelHookTypes.remove(id);
                afterAddExperienceLevelHookTypes.remove(id);
                allBaseBeforeAddMovementStatSuperiors.remove(id);
                allBaseBeforeAddMovementStatInferiors.remove(id);
                allBaseOverrideAddMovementStatSuperiors.remove(id);
                allBaseOverrideAddMovementStatInferiors.remove(id);
                allBaseAfterAddMovementStatSuperiors.remove(id);
                allBaseAfterAddMovementStatInferiors.remove(id);
                beforeAddMovementStatHookTypes.remove(id);
                overrideAddMovementStatHookTypes.remove(id);
                afterAddMovementStatHookTypes.remove(id);
                allBaseBeforeAttackEntityFromSuperiors.remove(id);
                allBaseBeforeAttackEntityFromInferiors.remove(id);
                allBaseOverrideAttackEntityFromSuperiors.remove(id);
                allBaseOverrideAttackEntityFromInferiors.remove(id);
                allBaseAfterAttackEntityFromSuperiors.remove(id);
                allBaseAfterAttackEntityFromInferiors.remove(id);
                beforeAttackEntityFromHookTypes.remove(id);
                overrideAttackEntityFromHookTypes.remove(id);
                afterAttackEntityFromHookTypes.remove(id);
                allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors.remove(id);
                allBaseBeforeAttackTargetEntityWithCurrentItemInferiors.remove(id);
                allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors.remove(id);
                allBaseOverrideAttackTargetEntityWithCurrentItemInferiors.remove(id);
                allBaseAfterAttackTargetEntityWithCurrentItemSuperiors.remove(id);
                allBaseAfterAttackTargetEntityWithCurrentItemInferiors.remove(id);
                beforeAttackTargetEntityWithCurrentItemHookTypes.remove(id);
                overrideAttackTargetEntityWithCurrentItemHookTypes.remove(id);
                afterAttackTargetEntityWithCurrentItemHookTypes.remove(id);
                allBaseBeforeCanBreatheUnderwaterSuperiors.remove(id);
                allBaseBeforeCanBreatheUnderwaterInferiors.remove(id);
                allBaseOverrideCanBreatheUnderwaterSuperiors.remove(id);
                allBaseOverrideCanBreatheUnderwaterInferiors.remove(id);
                allBaseAfterCanBreatheUnderwaterSuperiors.remove(id);
                allBaseAfterCanBreatheUnderwaterInferiors.remove(id);
                beforeCanBreatheUnderwaterHookTypes.remove(id);
                overrideCanBreatheUnderwaterHookTypes.remove(id);
                afterCanBreatheUnderwaterHookTypes.remove(id);
                allBaseBeforeCanHarvestBlockSuperiors.remove(id);
                allBaseBeforeCanHarvestBlockInferiors.remove(id);
                allBaseOverrideCanHarvestBlockSuperiors.remove(id);
                allBaseOverrideCanHarvestBlockInferiors.remove(id);
                allBaseAfterCanHarvestBlockSuperiors.remove(id);
                allBaseAfterCanHarvestBlockInferiors.remove(id);
                beforeCanHarvestBlockHookTypes.remove(id);
                overrideCanHarvestBlockHookTypes.remove(id);
                afterCanHarvestBlockHookTypes.remove(id);
                allBaseBeforeCanPlayerEditSuperiors.remove(id);
                allBaseBeforeCanPlayerEditInferiors.remove(id);
                allBaseOverrideCanPlayerEditSuperiors.remove(id);
                allBaseOverrideCanPlayerEditInferiors.remove(id);
                allBaseAfterCanPlayerEditSuperiors.remove(id);
                allBaseAfterCanPlayerEditInferiors.remove(id);
                beforeCanPlayerEditHookTypes.remove(id);
                overrideCanPlayerEditHookTypes.remove(id);
                afterCanPlayerEditHookTypes.remove(id);
                allBaseBeforeCanTriggerWalkingSuperiors.remove(id);
                allBaseBeforeCanTriggerWalkingInferiors.remove(id);
                allBaseOverrideCanTriggerWalkingSuperiors.remove(id);
                allBaseOverrideCanTriggerWalkingInferiors.remove(id);
                allBaseAfterCanTriggerWalkingSuperiors.remove(id);
                allBaseAfterCanTriggerWalkingInferiors.remove(id);
                beforeCanTriggerWalkingHookTypes.remove(id);
                overrideCanTriggerWalkingHookTypes.remove(id);
                afterCanTriggerWalkingHookTypes.remove(id);
                allBaseBeforeClonePlayerSuperiors.remove(id);
                allBaseBeforeClonePlayerInferiors.remove(id);
                allBaseOverrideClonePlayerSuperiors.remove(id);
                allBaseOverrideClonePlayerInferiors.remove(id);
                allBaseAfterClonePlayerSuperiors.remove(id);
                allBaseAfterClonePlayerInferiors.remove(id);
                beforeClonePlayerHookTypes.remove(id);
                overrideClonePlayerHookTypes.remove(id);
                afterClonePlayerHookTypes.remove(id);
                allBaseBeforeDamageEntitySuperiors.remove(id);
                allBaseBeforeDamageEntityInferiors.remove(id);
                allBaseOverrideDamageEntitySuperiors.remove(id);
                allBaseOverrideDamageEntityInferiors.remove(id);
                allBaseAfterDamageEntitySuperiors.remove(id);
                allBaseAfterDamageEntityInferiors.remove(id);
                beforeDamageEntityHookTypes.remove(id);
                overrideDamageEntityHookTypes.remove(id);
                afterDamageEntityHookTypes.remove(id);
                allBaseBeforeDisplayGUIChestSuperiors.remove(id);
                allBaseBeforeDisplayGUIChestInferiors.remove(id);
                allBaseOverrideDisplayGUIChestSuperiors.remove(id);
                allBaseOverrideDisplayGUIChestInferiors.remove(id);
                allBaseAfterDisplayGUIChestSuperiors.remove(id);
                allBaseAfterDisplayGUIChestInferiors.remove(id);
                beforeDisplayGUIChestHookTypes.remove(id);
                overrideDisplayGUIChestHookTypes.remove(id);
                afterDisplayGUIChestHookTypes.remove(id);
                allBaseBeforeDisplayGUIDispenserSuperiors.remove(id);
                allBaseBeforeDisplayGUIDispenserInferiors.remove(id);
                allBaseOverrideDisplayGUIDispenserSuperiors.remove(id);
                allBaseOverrideDisplayGUIDispenserInferiors.remove(id);
                allBaseAfterDisplayGUIDispenserSuperiors.remove(id);
                allBaseAfterDisplayGUIDispenserInferiors.remove(id);
                beforeDisplayGUIDispenserHookTypes.remove(id);
                overrideDisplayGUIDispenserHookTypes.remove(id);
                afterDisplayGUIDispenserHookTypes.remove(id);
                allBaseBeforeDisplayGUIFurnaceSuperiors.remove(id);
                allBaseBeforeDisplayGUIFurnaceInferiors.remove(id);
                allBaseOverrideDisplayGUIFurnaceSuperiors.remove(id);
                allBaseOverrideDisplayGUIFurnaceInferiors.remove(id);
                allBaseAfterDisplayGUIFurnaceSuperiors.remove(id);
                allBaseAfterDisplayGUIFurnaceInferiors.remove(id);
                beforeDisplayGUIFurnaceHookTypes.remove(id);
                overrideDisplayGUIFurnaceHookTypes.remove(id);
                afterDisplayGUIFurnaceHookTypes.remove(id);
                allBaseBeforeDisplayGUIWorkbenchSuperiors.remove(id);
                allBaseBeforeDisplayGUIWorkbenchInferiors.remove(id);
                allBaseOverrideDisplayGUIWorkbenchSuperiors.remove(id);
                allBaseOverrideDisplayGUIWorkbenchInferiors.remove(id);
                allBaseAfterDisplayGUIWorkbenchSuperiors.remove(id);
                allBaseAfterDisplayGUIWorkbenchInferiors.remove(id);
                beforeDisplayGUIWorkbenchHookTypes.remove(id);
                overrideDisplayGUIWorkbenchHookTypes.remove(id);
                afterDisplayGUIWorkbenchHookTypes.remove(id);
                allBaseBeforeDropOneItemSuperiors.remove(id);
                allBaseBeforeDropOneItemInferiors.remove(id);
                allBaseOverrideDropOneItemSuperiors.remove(id);
                allBaseOverrideDropOneItemInferiors.remove(id);
                allBaseAfterDropOneItemSuperiors.remove(id);
                allBaseAfterDropOneItemInferiors.remove(id);
                beforeDropOneItemHookTypes.remove(id);
                overrideDropOneItemHookTypes.remove(id);
                afterDropOneItemHookTypes.remove(id);
                allBaseBeforeDropPlayerItemSuperiors.remove(id);
                allBaseBeforeDropPlayerItemInferiors.remove(id);
                allBaseOverrideDropPlayerItemSuperiors.remove(id);
                allBaseOverrideDropPlayerItemInferiors.remove(id);
                allBaseAfterDropPlayerItemSuperiors.remove(id);
                allBaseAfterDropPlayerItemInferiors.remove(id);
                beforeDropPlayerItemHookTypes.remove(id);
                overrideDropPlayerItemHookTypes.remove(id);
                afterDropPlayerItemHookTypes.remove(id);
                allBaseBeforeFallSuperiors.remove(id);
                allBaseBeforeFallInferiors.remove(id);
                allBaseOverrideFallSuperiors.remove(id);
                allBaseOverrideFallInferiors.remove(id);
                allBaseAfterFallSuperiors.remove(id);
                allBaseAfterFallInferiors.remove(id);
                beforeFallHookTypes.remove(id);
                overrideFallHookTypes.remove(id);
                afterFallHookTypes.remove(id);
                allBaseBeforeGetAIMoveSpeedSuperiors.remove(id);
                allBaseBeforeGetAIMoveSpeedInferiors.remove(id);
                allBaseOverrideGetAIMoveSpeedSuperiors.remove(id);
                allBaseOverrideGetAIMoveSpeedInferiors.remove(id);
                allBaseAfterGetAIMoveSpeedSuperiors.remove(id);
                allBaseAfterGetAIMoveSpeedInferiors.remove(id);
                beforeGetAIMoveSpeedHookTypes.remove(id);
                overrideGetAIMoveSpeedHookTypes.remove(id);
                afterGetAIMoveSpeedHookTypes.remove(id);
                allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors.remove(id);
                allBaseBeforeGetCurrentPlayerStrVsBlockInferiors.remove(id);
                allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors.remove(id);
                allBaseOverrideGetCurrentPlayerStrVsBlockInferiors.remove(id);
                allBaseAfterGetCurrentPlayerStrVsBlockSuperiors.remove(id);
                allBaseAfterGetCurrentPlayerStrVsBlockInferiors.remove(id);
                beforeGetCurrentPlayerStrVsBlockHookTypes.remove(id);
                overrideGetCurrentPlayerStrVsBlockHookTypes.remove(id);
                afterGetCurrentPlayerStrVsBlockHookTypes.remove(id);
                allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors.remove(id);
                allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors.remove(id);
                allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors.remove(id);
                allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors.remove(id);
                allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors.remove(id);
                allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors.remove(id);
                beforeGetCurrentPlayerStrVsBlockForgeHookTypes.remove(id);
                overrideGetCurrentPlayerStrVsBlockForgeHookTypes.remove(id);
                afterGetCurrentPlayerStrVsBlockForgeHookTypes.remove(id);
                allBaseBeforeGetDistanceSqSuperiors.remove(id);
                allBaseBeforeGetDistanceSqInferiors.remove(id);
                allBaseOverrideGetDistanceSqSuperiors.remove(id);
                allBaseOverrideGetDistanceSqInferiors.remove(id);
                allBaseAfterGetDistanceSqSuperiors.remove(id);
                allBaseAfterGetDistanceSqInferiors.remove(id);
                beforeGetDistanceSqHookTypes.remove(id);
                overrideGetDistanceSqHookTypes.remove(id);
                afterGetDistanceSqHookTypes.remove(id);
                allBaseBeforeGetBrightnessSuperiors.remove(id);
                allBaseBeforeGetBrightnessInferiors.remove(id);
                allBaseOverrideGetBrightnessSuperiors.remove(id);
                allBaseOverrideGetBrightnessInferiors.remove(id);
                allBaseAfterGetBrightnessSuperiors.remove(id);
                allBaseAfterGetBrightnessInferiors.remove(id);
                beforeGetBrightnessHookTypes.remove(id);
                overrideGetBrightnessHookTypes.remove(id);
                afterGetBrightnessHookTypes.remove(id);
                allBaseBeforeGetEyeHeightSuperiors.remove(id);
                allBaseBeforeGetEyeHeightInferiors.remove(id);
                allBaseOverrideGetEyeHeightSuperiors.remove(id);
                allBaseOverrideGetEyeHeightInferiors.remove(id);
                allBaseAfterGetEyeHeightSuperiors.remove(id);
                allBaseAfterGetEyeHeightInferiors.remove(id);
                beforeGetEyeHeightHookTypes.remove(id);
                overrideGetEyeHeightHookTypes.remove(id);
                afterGetEyeHeightHookTypes.remove(id);
                allBaseBeforeHealSuperiors.remove(id);
                allBaseBeforeHealInferiors.remove(id);
                allBaseOverrideHealSuperiors.remove(id);
                allBaseOverrideHealInferiors.remove(id);
                allBaseAfterHealSuperiors.remove(id);
                allBaseAfterHealInferiors.remove(id);
                beforeHealHookTypes.remove(id);
                overrideHealHookTypes.remove(id);
                afterHealHookTypes.remove(id);
                allBaseBeforeIsEntityInsideOpaqueBlockSuperiors.remove(id);
                allBaseBeforeIsEntityInsideOpaqueBlockInferiors.remove(id);
                allBaseOverrideIsEntityInsideOpaqueBlockSuperiors.remove(id);
                allBaseOverrideIsEntityInsideOpaqueBlockInferiors.remove(id);
                allBaseAfterIsEntityInsideOpaqueBlockSuperiors.remove(id);
                allBaseAfterIsEntityInsideOpaqueBlockInferiors.remove(id);
                beforeIsEntityInsideOpaqueBlockHookTypes.remove(id);
                overrideIsEntityInsideOpaqueBlockHookTypes.remove(id);
                afterIsEntityInsideOpaqueBlockHookTypes.remove(id);
                allBaseBeforeIsInWaterSuperiors.remove(id);
                allBaseBeforeIsInWaterInferiors.remove(id);
                allBaseOverrideIsInWaterSuperiors.remove(id);
                allBaseOverrideIsInWaterInferiors.remove(id);
                allBaseAfterIsInWaterSuperiors.remove(id);
                allBaseAfterIsInWaterInferiors.remove(id);
                beforeIsInWaterHookTypes.remove(id);
                overrideIsInWaterHookTypes.remove(id);
                afterIsInWaterHookTypes.remove(id);
                allBaseBeforeIsInsideOfMaterialSuperiors.remove(id);
                allBaseBeforeIsInsideOfMaterialInferiors.remove(id);
                allBaseOverrideIsInsideOfMaterialSuperiors.remove(id);
                allBaseOverrideIsInsideOfMaterialInferiors.remove(id);
                allBaseAfterIsInsideOfMaterialSuperiors.remove(id);
                allBaseAfterIsInsideOfMaterialInferiors.remove(id);
                beforeIsInsideOfMaterialHookTypes.remove(id);
                overrideIsInsideOfMaterialHookTypes.remove(id);
                afterIsInsideOfMaterialHookTypes.remove(id);
                allBaseBeforeIsOnLadderSuperiors.remove(id);
                allBaseBeforeIsOnLadderInferiors.remove(id);
                allBaseOverrideIsOnLadderSuperiors.remove(id);
                allBaseOverrideIsOnLadderInferiors.remove(id);
                allBaseAfterIsOnLadderSuperiors.remove(id);
                allBaseAfterIsOnLadderInferiors.remove(id);
                beforeIsOnLadderHookTypes.remove(id);
                overrideIsOnLadderHookTypes.remove(id);
                afterIsOnLadderHookTypes.remove(id);
                allBaseBeforeIsPlayerSleepingSuperiors.remove(id);
                allBaseBeforeIsPlayerSleepingInferiors.remove(id);
                allBaseOverrideIsPlayerSleepingSuperiors.remove(id);
                allBaseOverrideIsPlayerSleepingInferiors.remove(id);
                allBaseAfterIsPlayerSleepingSuperiors.remove(id);
                allBaseAfterIsPlayerSleepingInferiors.remove(id);
                beforeIsPlayerSleepingHookTypes.remove(id);
                overrideIsPlayerSleepingHookTypes.remove(id);
                afterIsPlayerSleepingHookTypes.remove(id);
                allBaseBeforeIsSneakingSuperiors.remove(id);
                allBaseBeforeIsSneakingInferiors.remove(id);
                allBaseOverrideIsSneakingSuperiors.remove(id);
                allBaseOverrideIsSneakingInferiors.remove(id);
                allBaseAfterIsSneakingSuperiors.remove(id);
                allBaseAfterIsSneakingInferiors.remove(id);
                beforeIsSneakingHookTypes.remove(id);
                overrideIsSneakingHookTypes.remove(id);
                afterIsSneakingHookTypes.remove(id);
                allBaseBeforeJumpSuperiors.remove(id);
                allBaseBeforeJumpInferiors.remove(id);
                allBaseOverrideJumpSuperiors.remove(id);
                allBaseOverrideJumpInferiors.remove(id);
                allBaseAfterJumpSuperiors.remove(id);
                allBaseAfterJumpInferiors.remove(id);
                beforeJumpHookTypes.remove(id);
                overrideJumpHookTypes.remove(id);
                afterJumpHookTypes.remove(id);
                allBaseBeforeKnockBackSuperiors.remove(id);
                allBaseBeforeKnockBackInferiors.remove(id);
                allBaseOverrideKnockBackSuperiors.remove(id);
                allBaseOverrideKnockBackInferiors.remove(id);
                allBaseAfterKnockBackSuperiors.remove(id);
                allBaseAfterKnockBackInferiors.remove(id);
                beforeKnockBackHookTypes.remove(id);
                overrideKnockBackHookTypes.remove(id);
                afterKnockBackHookTypes.remove(id);
                allBaseBeforeMountEntitySuperiors.remove(id);
                allBaseBeforeMountEntityInferiors.remove(id);
                allBaseOverrideMountEntitySuperiors.remove(id);
                allBaseOverrideMountEntityInferiors.remove(id);
                allBaseAfterMountEntitySuperiors.remove(id);
                allBaseAfterMountEntityInferiors.remove(id);
                beforeMountEntityHookTypes.remove(id);
                overrideMountEntityHookTypes.remove(id);
                afterMountEntityHookTypes.remove(id);
                allBaseBeforeMoveEntitySuperiors.remove(id);
                allBaseBeforeMoveEntityInferiors.remove(id);
                allBaseOverrideMoveEntitySuperiors.remove(id);
                allBaseOverrideMoveEntityInferiors.remove(id);
                allBaseAfterMoveEntitySuperiors.remove(id);
                allBaseAfterMoveEntityInferiors.remove(id);
                beforeMoveEntityHookTypes.remove(id);
                overrideMoveEntityHookTypes.remove(id);
                afterMoveEntityHookTypes.remove(id);
                allBaseBeforeMoveEntityWithHeadingSuperiors.remove(id);
                allBaseBeforeMoveEntityWithHeadingInferiors.remove(id);
                allBaseOverrideMoveEntityWithHeadingSuperiors.remove(id);
                allBaseOverrideMoveEntityWithHeadingInferiors.remove(id);
                allBaseAfterMoveEntityWithHeadingSuperiors.remove(id);
                allBaseAfterMoveEntityWithHeadingInferiors.remove(id);
                beforeMoveEntityWithHeadingHookTypes.remove(id);
                overrideMoveEntityWithHeadingHookTypes.remove(id);
                afterMoveEntityWithHeadingHookTypes.remove(id);
                allBaseBeforeMoveFlyingSuperiors.remove(id);
                allBaseBeforeMoveFlyingInferiors.remove(id);
                allBaseOverrideMoveFlyingSuperiors.remove(id);
                allBaseOverrideMoveFlyingInferiors.remove(id);
                allBaseAfterMoveFlyingSuperiors.remove(id);
                allBaseAfterMoveFlyingInferiors.remove(id);
                beforeMoveFlyingHookTypes.remove(id);
                overrideMoveFlyingHookTypes.remove(id);
                afterMoveFlyingHookTypes.remove(id);
                allBaseBeforeOnDeathSuperiors.remove(id);
                allBaseBeforeOnDeathInferiors.remove(id);
                allBaseOverrideOnDeathSuperiors.remove(id);
                allBaseOverrideOnDeathInferiors.remove(id);
                allBaseAfterOnDeathSuperiors.remove(id);
                allBaseAfterOnDeathInferiors.remove(id);
                beforeOnDeathHookTypes.remove(id);
                overrideOnDeathHookTypes.remove(id);
                afterOnDeathHookTypes.remove(id);
                allBaseBeforeOnLivingUpdateSuperiors.remove(id);
                allBaseBeforeOnLivingUpdateInferiors.remove(id);
                allBaseOverrideOnLivingUpdateSuperiors.remove(id);
                allBaseOverrideOnLivingUpdateInferiors.remove(id);
                allBaseAfterOnLivingUpdateSuperiors.remove(id);
                allBaseAfterOnLivingUpdateInferiors.remove(id);
                beforeOnLivingUpdateHookTypes.remove(id);
                overrideOnLivingUpdateHookTypes.remove(id);
                afterOnLivingUpdateHookTypes.remove(id);
                allBaseBeforeOnKillEntitySuperiors.remove(id);
                allBaseBeforeOnKillEntityInferiors.remove(id);
                allBaseOverrideOnKillEntitySuperiors.remove(id);
                allBaseOverrideOnKillEntityInferiors.remove(id);
                allBaseAfterOnKillEntitySuperiors.remove(id);
                allBaseAfterOnKillEntityInferiors.remove(id);
                beforeOnKillEntityHookTypes.remove(id);
                overrideOnKillEntityHookTypes.remove(id);
                afterOnKillEntityHookTypes.remove(id);
                allBaseBeforeOnStruckByLightningSuperiors.remove(id);
                allBaseBeforeOnStruckByLightningInferiors.remove(id);
                allBaseOverrideOnStruckByLightningSuperiors.remove(id);
                allBaseOverrideOnStruckByLightningInferiors.remove(id);
                allBaseAfterOnStruckByLightningSuperiors.remove(id);
                allBaseAfterOnStruckByLightningInferiors.remove(id);
                beforeOnStruckByLightningHookTypes.remove(id);
                overrideOnStruckByLightningHookTypes.remove(id);
                afterOnStruckByLightningHookTypes.remove(id);
                allBaseBeforeOnUpdateSuperiors.remove(id);
                allBaseBeforeOnUpdateInferiors.remove(id);
                allBaseOverrideOnUpdateSuperiors.remove(id);
                allBaseOverrideOnUpdateInferiors.remove(id);
                allBaseAfterOnUpdateSuperiors.remove(id);
                allBaseAfterOnUpdateInferiors.remove(id);
                beforeOnUpdateHookTypes.remove(id);
                overrideOnUpdateHookTypes.remove(id);
                afterOnUpdateHookTypes.remove(id);
                allBaseBeforeOnUpdateEntitySuperiors.remove(id);
                allBaseBeforeOnUpdateEntityInferiors.remove(id);
                allBaseOverrideOnUpdateEntitySuperiors.remove(id);
                allBaseOverrideOnUpdateEntityInferiors.remove(id);
                allBaseAfterOnUpdateEntitySuperiors.remove(id);
                allBaseAfterOnUpdateEntityInferiors.remove(id);
                beforeOnUpdateEntityHookTypes.remove(id);
                overrideOnUpdateEntityHookTypes.remove(id);
                afterOnUpdateEntityHookTypes.remove(id);
                allBaseBeforeReadEntityFromNBTSuperiors.remove(id);
                allBaseBeforeReadEntityFromNBTInferiors.remove(id);
                allBaseOverrideReadEntityFromNBTSuperiors.remove(id);
                allBaseOverrideReadEntityFromNBTInferiors.remove(id);
                allBaseAfterReadEntityFromNBTSuperiors.remove(id);
                allBaseAfterReadEntityFromNBTInferiors.remove(id);
                beforeReadEntityFromNBTHookTypes.remove(id);
                overrideReadEntityFromNBTHookTypes.remove(id);
                afterReadEntityFromNBTHookTypes.remove(id);
                allBaseBeforeSetDeadSuperiors.remove(id);
                allBaseBeforeSetDeadInferiors.remove(id);
                allBaseOverrideSetDeadSuperiors.remove(id);
                allBaseOverrideSetDeadInferiors.remove(id);
                allBaseAfterSetDeadSuperiors.remove(id);
                allBaseAfterSetDeadInferiors.remove(id);
                beforeSetDeadHookTypes.remove(id);
                overrideSetDeadHookTypes.remove(id);
                afterSetDeadHookTypes.remove(id);
                allBaseBeforeSetEntityActionStateSuperiors.remove(id);
                allBaseBeforeSetEntityActionStateInferiors.remove(id);
                allBaseOverrideSetEntityActionStateSuperiors.remove(id);
                allBaseOverrideSetEntityActionStateInferiors.remove(id);
                allBaseAfterSetEntityActionStateSuperiors.remove(id);
                allBaseAfterSetEntityActionStateInferiors.remove(id);
                beforeSetEntityActionStateHookTypes.remove(id);
                overrideSetEntityActionStateHookTypes.remove(id);
                afterSetEntityActionStateHookTypes.remove(id);
                allBaseBeforeSetPositionSuperiors.remove(id);
                allBaseBeforeSetPositionInferiors.remove(id);
                allBaseOverrideSetPositionSuperiors.remove(id);
                allBaseOverrideSetPositionInferiors.remove(id);
                allBaseAfterSetPositionSuperiors.remove(id);
                allBaseAfterSetPositionInferiors.remove(id);
                beforeSetPositionHookTypes.remove(id);
                overrideSetPositionHookTypes.remove(id);
                afterSetPositionHookTypes.remove(id);
                allBaseBeforeSetSneakingSuperiors.remove(id);
                allBaseBeforeSetSneakingInferiors.remove(id);
                allBaseOverrideSetSneakingSuperiors.remove(id);
                allBaseOverrideSetSneakingInferiors.remove(id);
                allBaseAfterSetSneakingSuperiors.remove(id);
                allBaseAfterSetSneakingInferiors.remove(id);
                beforeSetSneakingHookTypes.remove(id);
                overrideSetSneakingHookTypes.remove(id);
                afterSetSneakingHookTypes.remove(id);
                allBaseBeforeSetSprintingSuperiors.remove(id);
                allBaseBeforeSetSprintingInferiors.remove(id);
                allBaseOverrideSetSprintingSuperiors.remove(id);
                allBaseOverrideSetSprintingInferiors.remove(id);
                allBaseAfterSetSprintingSuperiors.remove(id);
                allBaseAfterSetSprintingInferiors.remove(id);
                beforeSetSprintingHookTypes.remove(id);
                overrideSetSprintingHookTypes.remove(id);
                afterSetSprintingHookTypes.remove(id);
                allBaseBeforeSwingItemSuperiors.remove(id);
                allBaseBeforeSwingItemInferiors.remove(id);
                allBaseOverrideSwingItemSuperiors.remove(id);
                allBaseOverrideSwingItemInferiors.remove(id);
                allBaseAfterSwingItemSuperiors.remove(id);
                allBaseAfterSwingItemInferiors.remove(id);
                beforeSwingItemHookTypes.remove(id);
                overrideSwingItemHookTypes.remove(id);
                afterSwingItemHookTypes.remove(id);
                allBaseBeforeUpdateEntityActionStateSuperiors.remove(id);
                allBaseBeforeUpdateEntityActionStateInferiors.remove(id);
                allBaseOverrideUpdateEntityActionStateSuperiors.remove(id);
                allBaseOverrideUpdateEntityActionStateInferiors.remove(id);
                allBaseAfterUpdateEntityActionStateSuperiors.remove(id);
                allBaseAfterUpdateEntityActionStateInferiors.remove(id);
                beforeUpdateEntityActionStateHookTypes.remove(id);
                overrideUpdateEntityActionStateHookTypes.remove(id);
                afterUpdateEntityActionStateHookTypes.remove(id);
                allBaseBeforeUpdatePotionEffectsSuperiors.remove(id);
                allBaseBeforeUpdatePotionEffectsInferiors.remove(id);
                allBaseOverrideUpdatePotionEffectsSuperiors.remove(id);
                allBaseOverrideUpdatePotionEffectsInferiors.remove(id);
                allBaseAfterUpdatePotionEffectsSuperiors.remove(id);
                allBaseAfterUpdatePotionEffectsInferiors.remove(id);
                beforeUpdatePotionEffectsHookTypes.remove(id);
                overrideUpdatePotionEffectsHookTypes.remove(id);
                afterUpdatePotionEffectsHookTypes.remove(id);
                allBaseBeforeUpdateRiddenSuperiors.remove(id);
                allBaseBeforeUpdateRiddenInferiors.remove(id);
                allBaseOverrideUpdateRiddenSuperiors.remove(id);
                allBaseOverrideUpdateRiddenInferiors.remove(id);
                allBaseAfterUpdateRiddenSuperiors.remove(id);
                allBaseAfterUpdateRiddenInferiors.remove(id);
                beforeUpdateRiddenHookTypes.remove(id);
                overrideUpdateRiddenHookTypes.remove(id);
                afterUpdateRiddenHookTypes.remove(id);
                allBaseBeforeWakeUpPlayerSuperiors.remove(id);
                allBaseBeforeWakeUpPlayerInferiors.remove(id);
                allBaseOverrideWakeUpPlayerSuperiors.remove(id);
                allBaseOverrideWakeUpPlayerInferiors.remove(id);
                allBaseAfterWakeUpPlayerSuperiors.remove(id);
                allBaseAfterWakeUpPlayerInferiors.remove(id);
                beforeWakeUpPlayerHookTypes.remove(id);
                overrideWakeUpPlayerHookTypes.remove(id);
                afterWakeUpPlayerHookTypes.remove(id);
                allBaseBeforeWriteEntityToNBTSuperiors.remove(id);
                allBaseBeforeWriteEntityToNBTInferiors.remove(id);
                allBaseOverrideWriteEntityToNBTSuperiors.remove(id);
                allBaseOverrideWriteEntityToNBTInferiors.remove(id);
                allBaseAfterWriteEntityToNBTSuperiors.remove(id);
                allBaseAfterWriteEntityToNBTInferiors.remove(id);
                beforeWriteEntityToNBTHookTypes.remove(id);
                overrideWriteEntityToNBTHookTypes.remove(id);
                afterWriteEntityToNBTHookTypes.remove(id);
                
                for(IServerPlayerAPI instance : getAllInstancesList()) {
                    instance.getServerPlayerAPI().updateServerPlayerBases();
                }

                Iterator<String> iterator = keysToVirtualIds.keySet().iterator();
                while(iterator.hasNext()) {
                    String key = (String)iterator.next();
                    if (keysToVirtualIds.get(key).equals(id)) {
                        keysToVirtualIds.remove(key);
                    }
                }

                boolean otherFound = false;
                Class<?> type = constructor.getDeclaringClass();
                iterator = allBaseConstructors.keySet().iterator();

                while(iterator.hasNext()) {
                    String otherId = (String)iterator.next();
                    Class<?> otherType = ((Constructor<?>)allBaseConstructors.get(otherId)).getDeclaringClass();
                    if (!otherId.equals(id) && otherType.equals(type)) {
                        otherFound = true;
                        break;
                    }
                }

                if (!otherFound) {
                    dynamicTypes.remove(type);
                    virtualDynamicHookMethods.remove(type);
                    beforeDynamicHookMethods.remove(type);
                    overrideDynamicHookMethods.remove(type);
                    afterDynamicHookMethods.remove(type);
                }

                removeDynamicHookTypes(id, beforeDynamicHookTypes);
                removeDynamicHookTypes(id, overrideDynamicHookTypes);
                removeDynamicHookTypes(id, afterDynamicHookTypes);
                
                allBaseBeforeDynamicSuperiors.remove(id);
                allBaseBeforeDynamicInferiors.remove(id);
                allBaseOverrideDynamicSuperiors.remove(id);
                allBaseOverrideDynamicInferiors.remove(id);
                allBaseAfterDynamicSuperiors.remove(id);
                allBaseAfterDynamicInferiors.remove(id);
                
                log("ServerPlayerAPI: unregistered id '" + id + "'");
                
                return true;
            }
        }
    }

    public static void removeDynamicHookTypes(String id, Map<String, List<String>> map) {
        Iterator<String> keys = map.keySet().iterator();

        while(keys.hasNext()) {
            ((List<String>)map.get(keys.next())).remove(id);
        }

    }

    public static Set<String> getRegisteredIds() {
        return unmodifiableAllIds;
    }

    private static void addSorting(String id, Map<String, String[]> map, String[] values) {
        if (values != null && values.length > 0) {
            map.put(id, values);
        }

    }

    private static void addDynamicSorting(String id, Map<String, Map<String, String[]>> map, Map<String, String[]> values) {
        if (values != null && values.size() > 0) {
            map.put(id, values);
        }

    }

    private static boolean addMethod(String id, Class<?> baseClass, List<String> list, String methodName, Class<?>... _parameterTypes) {
        try {
            Method method = baseClass.getMethod(methodName, _parameterTypes);
            boolean isOverridden = method.getDeclaringClass() != ServerPlayerBase.class;
            if (isOverridden) {
                list.add(id);
            }

            return isOverridden;
        } catch (Exception e) {
            throw new RuntimeException("Can not reflect method '" + methodName + "' of class '" + baseClass.getName() + "'", e);
        }
    }

    private static void addDynamicMethods(String id, Class<?> baseClass) {
        if (dynamicTypes.add(baseClass)) {
            Map<String, Method> virtuals = null;
            Map<String, Method> befores = null;
            Map<String, Method> overrides = null;
            Map<String, Method> afters = null;
            Method[] methods = baseClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.getDeclaringClass() == baseClass) {
                    int modifiers = method.getModifiers();
                    if (!Modifier.isAbstract(modifiers) && !Modifier.isStatic(modifiers)) {
                        String name = method.getName();
                        if (name.length() >= 7 && name.substring(0, 7).equalsIgnoreCase("dynamic")) {
                            for(name = name.substring(7); name.charAt(0) == '_'; name = name.substring(1)) {
                            }

                            boolean before = false;
                            boolean virtual = false;
                            boolean override = false;
                            boolean after = false;
                            if (name.substring(0, 7).equalsIgnoreCase("virtual")) {
                                virtual = true;
                                name = name.substring(7);
                            } else if (name.length() >= 8 && name.substring(0, 8).equalsIgnoreCase("override")) {
                                name = name.substring(8);
                                override = true;
                            } else if (name.length() >= 6 && name.substring(0, 6).equalsIgnoreCase("before")) {
                                before = true;
                                name = name.substring(6);
                            } else if (name.length() >= 5 && name.substring(0, 5).equalsIgnoreCase("after")) {
                                after = true;
                                name = name.substring(5);
                            }

                            if (name.length() >= 1 && (before || virtual || override || after)) {
                                name = name.substring(0, 1).toLowerCase() + name.substring(1);
                            }

                            while(name.charAt(0) == '_') {
                                name = name.substring(1);
                            }

                            if (name.length() == 0) {
                                throw new RuntimeException("Can not process dynamic hook method with no key");
                            }

                            keys.add(name);
                            if (virtual) {
                                if (keysToVirtualIds.containsKey(name)) {
                                    throw new RuntimeException("Can not process more than one dynamic virtual method");
                                }

                                keysToVirtualIds.put(name, id);
                                virtuals = addDynamicMethod(name, method, virtuals);
                            } else if (before) {
                                befores = addDynamicMethod(name, method, befores);
                            } else if (after) {
                                afters = addDynamicMethod(name, method, afters);
                            } else {
                                overrides = addDynamicMethod(name, method, overrides);
                            }
                        }
                    }
                }
            }

            if (virtuals != null) {
                virtualDynamicHookMethods.put(baseClass, virtuals);
            }

            if (befores != null) {
                beforeDynamicHookMethods.put(baseClass, befores);
            }

            if (overrides != null) {
                overrideDynamicHookMethods.put(baseClass, overrides);
            }

            if (afters != null) {
                afterDynamicHookMethods.put(baseClass, afters);
            }

        }
    }

    private static void addDynamicKeys(String id, Class<?> baseClass, Map<Class<?>, Map<String, Method>> dynamicHookMethods, Map<String, List<String>> dynamicHookTypes) {
        Map<String, Method> methods = dynamicHookMethods.get(baseClass);
        if (methods != null && methods.size() != 0) {
            String key;
            for(Iterator<String> keys = methods.keySet().iterator(); keys.hasNext(); ((List<String>)dynamicHookTypes.get(key)).add(id)) {
                key = (String)keys.next();
                if (!dynamicHookTypes.containsKey(key)) {
                    dynamicHookTypes.put(key, new ArrayList<>(1));
                }
            }

        }
    }

    private static Map<String, Method> addDynamicMethod(String key, Method method, Map<String, Method> methods) {
        if (methods == null) {
            methods = new HashMap<>();
        }

        if (((Map<String, Method>)methods).containsKey(key)) {
            throw new RuntimeException("method with key '" + key + "' allready exists");
        } else {
            ((Map<String, Method>)methods).put(key, method);
            return methods;
        }
    }

    public static ServerPlayerAPI create(IServerPlayerAPI serverPlayer) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            initialize();
        }

        return new ServerPlayerAPI(serverPlayer);
    }

    private static void initialize() {
        sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        Iterator<String> keyIterator = keys.iterator();

        while(keyIterator.hasNext()) {
            String key = (String)keyIterator.next();
            sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, key);
            sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, key);
            sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, key);
        }

        sortBases(beforeAddExhaustionHookTypes, allBaseBeforeAddExhaustionSuperiors, allBaseBeforeAddExhaustionInferiors, "beforeAddExhaustion");
        sortBases(overrideAddExhaustionHookTypes, allBaseOverrideAddExhaustionSuperiors, allBaseOverrideAddExhaustionInferiors, "overrideAddExhaustion");
        sortBases(afterAddExhaustionHookTypes, allBaseAfterAddExhaustionSuperiors, allBaseAfterAddExhaustionInferiors, "afterAddExhaustion");
        sortBases(beforeAddExperienceHookTypes, allBaseBeforeAddExperienceSuperiors, allBaseBeforeAddExperienceInferiors, "beforeAddExperience");
        sortBases(overrideAddExperienceHookTypes, allBaseOverrideAddExperienceSuperiors, allBaseOverrideAddExperienceInferiors, "overrideAddExperience");
        sortBases(afterAddExperienceHookTypes, allBaseAfterAddExperienceSuperiors, allBaseAfterAddExperienceInferiors, "afterAddExperience");
        sortBases(beforeAddExperienceLevelHookTypes, allBaseBeforeAddExperienceLevelSuperiors, allBaseBeforeAddExperienceLevelInferiors, "beforeAddExperienceLevel");
        sortBases(overrideAddExperienceLevelHookTypes, allBaseOverrideAddExperienceLevelSuperiors, allBaseOverrideAddExperienceLevelInferiors, "overrideAddExperienceLevel");
        sortBases(afterAddExperienceLevelHookTypes, allBaseAfterAddExperienceLevelSuperiors, allBaseAfterAddExperienceLevelInferiors, "afterAddExperienceLevel");
        sortBases(beforeAddMovementStatHookTypes, allBaseBeforeAddMovementStatSuperiors, allBaseBeforeAddMovementStatInferiors, "beforeAddMovementStat");
        sortBases(overrideAddMovementStatHookTypes, allBaseOverrideAddMovementStatSuperiors, allBaseOverrideAddMovementStatInferiors, "overrideAddMovementStat");
        sortBases(afterAddMovementStatHookTypes, allBaseAfterAddMovementStatSuperiors, allBaseAfterAddMovementStatInferiors, "afterAddMovementStat");
        sortBases(beforeAttackEntityFromHookTypes, allBaseBeforeAttackEntityFromSuperiors, allBaseBeforeAttackEntityFromInferiors, "beforeAttackEntityFrom");
        sortBases(overrideAttackEntityFromHookTypes, allBaseOverrideAttackEntityFromSuperiors, allBaseOverrideAttackEntityFromInferiors, "overrideAttackEntityFrom");
        sortBases(afterAttackEntityFromHookTypes, allBaseAfterAttackEntityFromSuperiors, allBaseAfterAttackEntityFromInferiors, "afterAttackEntityFrom");
        sortBases(beforeAttackTargetEntityWithCurrentItemHookTypes, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, "beforeAttackTargetEntityWithCurrentItem");
        sortBases(overrideAttackTargetEntityWithCurrentItemHookTypes, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, "overrideAttackTargetEntityWithCurrentItem");
        sortBases(afterAttackTargetEntityWithCurrentItemHookTypes, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, "afterAttackTargetEntityWithCurrentItem");
        sortBases(beforeCanBreatheUnderwaterHookTypes, allBaseBeforeCanBreatheUnderwaterSuperiors, allBaseBeforeCanBreatheUnderwaterInferiors, "beforeCanBreatheUnderwater");
        sortBases(overrideCanBreatheUnderwaterHookTypes, allBaseOverrideCanBreatheUnderwaterSuperiors, allBaseOverrideCanBreatheUnderwaterInferiors, "overrideCanBreatheUnderwater");
        sortBases(afterCanBreatheUnderwaterHookTypes, allBaseAfterCanBreatheUnderwaterSuperiors, allBaseAfterCanBreatheUnderwaterInferiors, "afterCanBreatheUnderwater");
        sortBases(beforeCanHarvestBlockHookTypes, allBaseBeforeCanHarvestBlockSuperiors, allBaseBeforeCanHarvestBlockInferiors, "beforeCanHarvestBlock");
        sortBases(overrideCanHarvestBlockHookTypes, allBaseOverrideCanHarvestBlockSuperiors, allBaseOverrideCanHarvestBlockInferiors, "overrideCanHarvestBlock");
        sortBases(afterCanHarvestBlockHookTypes, allBaseAfterCanHarvestBlockSuperiors, allBaseAfterCanHarvestBlockInferiors, "afterCanHarvestBlock");
        sortBases(beforeCanPlayerEditHookTypes, allBaseBeforeCanPlayerEditSuperiors, allBaseBeforeCanPlayerEditInferiors, "beforeCanPlayerEdit");
        sortBases(overrideCanPlayerEditHookTypes, allBaseOverrideCanPlayerEditSuperiors, allBaseOverrideCanPlayerEditInferiors, "overrideCanPlayerEdit");
        sortBases(afterCanPlayerEditHookTypes, allBaseAfterCanPlayerEditSuperiors, allBaseAfterCanPlayerEditInferiors, "afterCanPlayerEdit");
        sortBases(beforeCanTriggerWalkingHookTypes, allBaseBeforeCanTriggerWalkingSuperiors, allBaseBeforeCanTriggerWalkingInferiors, "beforeCanTriggerWalking");
        sortBases(overrideCanTriggerWalkingHookTypes, allBaseOverrideCanTriggerWalkingSuperiors, allBaseOverrideCanTriggerWalkingInferiors, "overrideCanTriggerWalking");
        sortBases(afterCanTriggerWalkingHookTypes, allBaseAfterCanTriggerWalkingSuperiors, allBaseAfterCanTriggerWalkingInferiors, "afterCanTriggerWalking");
        sortBases(beforeClonePlayerHookTypes, allBaseBeforeClonePlayerSuperiors, allBaseBeforeClonePlayerInferiors, "beforeClonePlayer");
        sortBases(overrideClonePlayerHookTypes, allBaseOverrideClonePlayerSuperiors, allBaseOverrideClonePlayerInferiors, "overrideClonePlayer");
        sortBases(afterClonePlayerHookTypes, allBaseAfterClonePlayerSuperiors, allBaseAfterClonePlayerInferiors, "afterClonePlayer");
        sortBases(beforeDamageEntityHookTypes, allBaseBeforeDamageEntitySuperiors, allBaseBeforeDamageEntityInferiors, "beforeDamageEntity");
        sortBases(overrideDamageEntityHookTypes, allBaseOverrideDamageEntitySuperiors, allBaseOverrideDamageEntityInferiors, "overrideDamageEntity");
        sortBases(afterDamageEntityHookTypes, allBaseAfterDamageEntitySuperiors, allBaseAfterDamageEntityInferiors, "afterDamageEntity");
        sortBases(beforeDisplayGUIChestHookTypes, allBaseBeforeDisplayGUIChestSuperiors, allBaseBeforeDisplayGUIChestInferiors, "beforeDisplayGUIChest");
        sortBases(overrideDisplayGUIChestHookTypes, allBaseOverrideDisplayGUIChestSuperiors, allBaseOverrideDisplayGUIChestInferiors, "overrideDisplayGUIChest");
        sortBases(afterDisplayGUIChestHookTypes, allBaseAfterDisplayGUIChestSuperiors, allBaseAfterDisplayGUIChestInferiors, "afterDisplayGUIChest");
        sortBases(beforeDisplayGUIDispenserHookTypes, allBaseBeforeDisplayGUIDispenserSuperiors, allBaseBeforeDisplayGUIDispenserInferiors, "beforeDisplayGUIDispenser");
        sortBases(overrideDisplayGUIDispenserHookTypes, allBaseOverrideDisplayGUIDispenserSuperiors, allBaseOverrideDisplayGUIDispenserInferiors, "overrideDisplayGUIDispenser");
        sortBases(afterDisplayGUIDispenserHookTypes, allBaseAfterDisplayGUIDispenserSuperiors, allBaseAfterDisplayGUIDispenserInferiors, "afterDisplayGUIDispenser");
        sortBases(beforeDisplayGUIFurnaceHookTypes, allBaseBeforeDisplayGUIFurnaceSuperiors, allBaseBeforeDisplayGUIFurnaceInferiors, "beforeDisplayGUIFurnace");
        sortBases(overrideDisplayGUIFurnaceHookTypes, allBaseOverrideDisplayGUIFurnaceSuperiors, allBaseOverrideDisplayGUIFurnaceInferiors, "overrideDisplayGUIFurnace");
        sortBases(afterDisplayGUIFurnaceHookTypes, allBaseAfterDisplayGUIFurnaceSuperiors, allBaseAfterDisplayGUIFurnaceInferiors, "afterDisplayGUIFurnace");
        sortBases(beforeDisplayGUIWorkbenchHookTypes, allBaseBeforeDisplayGUIWorkbenchSuperiors, allBaseBeforeDisplayGUIWorkbenchInferiors, "beforeDisplayGUIWorkbench");
        sortBases(overrideDisplayGUIWorkbenchHookTypes, allBaseOverrideDisplayGUIWorkbenchSuperiors, allBaseOverrideDisplayGUIWorkbenchInferiors, "overrideDisplayGUIWorkbench");
        sortBases(afterDisplayGUIWorkbenchHookTypes, allBaseAfterDisplayGUIWorkbenchSuperiors, allBaseAfterDisplayGUIWorkbenchInferiors, "afterDisplayGUIWorkbench");
        sortBases(beforeDropOneItemHookTypes, allBaseBeforeDropOneItemSuperiors, allBaseBeforeDropOneItemInferiors, "beforeDropOneItem");
        sortBases(overrideDropOneItemHookTypes, allBaseOverrideDropOneItemSuperiors, allBaseOverrideDropOneItemInferiors, "overrideDropOneItem");
        sortBases(afterDropOneItemHookTypes, allBaseAfterDropOneItemSuperiors, allBaseAfterDropOneItemInferiors, "afterDropOneItem");
        sortBases(beforeDropPlayerItemHookTypes, allBaseBeforeDropPlayerItemSuperiors, allBaseBeforeDropPlayerItemInferiors, "beforeDropPlayerItem");
        sortBases(overrideDropPlayerItemHookTypes, allBaseOverrideDropPlayerItemSuperiors, allBaseOverrideDropPlayerItemInferiors, "overrideDropPlayerItem");
        sortBases(afterDropPlayerItemHookTypes, allBaseAfterDropPlayerItemSuperiors, allBaseAfterDropPlayerItemInferiors, "afterDropPlayerItem");
        sortBases(beforeFallHookTypes, allBaseBeforeFallSuperiors, allBaseBeforeFallInferiors, "beforeFall");
        sortBases(overrideFallHookTypes, allBaseOverrideFallSuperiors, allBaseOverrideFallInferiors, "overrideFall");
        sortBases(afterFallHookTypes, allBaseAfterFallSuperiors, allBaseAfterFallInferiors, "afterFall");
        sortBases(beforeGetAIMoveSpeedHookTypes, allBaseBeforeGetAIMoveSpeedSuperiors, allBaseBeforeGetAIMoveSpeedInferiors, "beforeGetAIMoveSpeed");
        sortBases(overrideGetAIMoveSpeedHookTypes, allBaseOverrideGetAIMoveSpeedSuperiors, allBaseOverrideGetAIMoveSpeedInferiors, "overrideGetAIMoveSpeed");
        sortBases(afterGetAIMoveSpeedHookTypes, allBaseAfterGetAIMoveSpeedSuperiors, allBaseAfterGetAIMoveSpeedInferiors, "afterGetAIMoveSpeed");
        sortBases(beforeGetCurrentPlayerStrVsBlockHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, "beforeGetCurrentPlayerStrVsBlock");
        sortBases(overrideGetCurrentPlayerStrVsBlockHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, "overrideGetCurrentPlayerStrVsBlock");
        sortBases(afterGetCurrentPlayerStrVsBlockHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, "afterGetCurrentPlayerStrVsBlock");
        sortBases(beforeGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, "beforeGetCurrentPlayerStrVsBlockForge");
        sortBases(overrideGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, "overrideGetCurrentPlayerStrVsBlockForge");
        sortBases(afterGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, "afterGetCurrentPlayerStrVsBlockForge");
        sortBases(beforeGetDistanceSqHookTypes, allBaseBeforeGetDistanceSqSuperiors, allBaseBeforeGetDistanceSqInferiors, "beforeGetDistanceSq");
        sortBases(overrideGetDistanceSqHookTypes, allBaseOverrideGetDistanceSqSuperiors, allBaseOverrideGetDistanceSqInferiors, "overrideGetDistanceSq");
        sortBases(afterGetDistanceSqHookTypes, allBaseAfterGetDistanceSqSuperiors, allBaseAfterGetDistanceSqInferiors, "afterGetDistanceSq");
        sortBases(beforeGetBrightnessHookTypes, allBaseBeforeGetBrightnessSuperiors, allBaseBeforeGetBrightnessInferiors, "beforeGetBrightness");
        sortBases(overrideGetBrightnessHookTypes, allBaseOverrideGetBrightnessSuperiors, allBaseOverrideGetBrightnessInferiors, "overrideGetBrightness");
        sortBases(afterGetBrightnessHookTypes, allBaseAfterGetBrightnessSuperiors, allBaseAfterGetBrightnessInferiors, "afterGetBrightness");
        sortBases(beforeGetEyeHeightHookTypes, allBaseBeforeGetEyeHeightSuperiors, allBaseBeforeGetEyeHeightInferiors, "beforeGetEyeHeight");
        sortBases(overrideGetEyeHeightHookTypes, allBaseOverrideGetEyeHeightSuperiors, allBaseOverrideGetEyeHeightInferiors, "overrideGetEyeHeight");
        sortBases(afterGetEyeHeightHookTypes, allBaseAfterGetEyeHeightSuperiors, allBaseAfterGetEyeHeightInferiors, "afterGetEyeHeight");
        sortBases(beforeHealHookTypes, allBaseBeforeHealSuperiors, allBaseBeforeHealInferiors, "beforeHeal");
        sortBases(overrideHealHookTypes, allBaseOverrideHealSuperiors, allBaseOverrideHealInferiors, "overrideHeal");
        sortBases(afterHealHookTypes, allBaseAfterHealSuperiors, allBaseAfterHealInferiors, "afterHeal");
        sortBases(beforeIsEntityInsideOpaqueBlockHookTypes, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, "beforeIsEntityInsideOpaqueBlock");
        sortBases(overrideIsEntityInsideOpaqueBlockHookTypes, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, "overrideIsEntityInsideOpaqueBlock");
        sortBases(afterIsEntityInsideOpaqueBlockHookTypes, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, allBaseAfterIsEntityInsideOpaqueBlockInferiors, "afterIsEntityInsideOpaqueBlock");
        sortBases(beforeIsInWaterHookTypes, allBaseBeforeIsInWaterSuperiors, allBaseBeforeIsInWaterInferiors, "beforeIsInWater");
        sortBases(overrideIsInWaterHookTypes, allBaseOverrideIsInWaterSuperiors, allBaseOverrideIsInWaterInferiors, "overrideIsInWater");
        sortBases(afterIsInWaterHookTypes, allBaseAfterIsInWaterSuperiors, allBaseAfterIsInWaterInferiors, "afterIsInWater");
        sortBases(beforeIsInsideOfMaterialHookTypes, allBaseBeforeIsInsideOfMaterialSuperiors, allBaseBeforeIsInsideOfMaterialInferiors, "beforeIsInsideOfMaterial");
        sortBases(overrideIsInsideOfMaterialHookTypes, allBaseOverrideIsInsideOfMaterialSuperiors, allBaseOverrideIsInsideOfMaterialInferiors, "overrideIsInsideOfMaterial");
        sortBases(afterIsInsideOfMaterialHookTypes, allBaseAfterIsInsideOfMaterialSuperiors, allBaseAfterIsInsideOfMaterialInferiors, "afterIsInsideOfMaterial");
        sortBases(beforeIsOnLadderHookTypes, allBaseBeforeIsOnLadderSuperiors, allBaseBeforeIsOnLadderInferiors, "beforeIsOnLadder");
        sortBases(overrideIsOnLadderHookTypes, allBaseOverrideIsOnLadderSuperiors, allBaseOverrideIsOnLadderInferiors, "overrideIsOnLadder");
        sortBases(afterIsOnLadderHookTypes, allBaseAfterIsOnLadderSuperiors, allBaseAfterIsOnLadderInferiors, "afterIsOnLadder");
        sortBases(beforeIsPlayerSleepingHookTypes, allBaseBeforeIsPlayerSleepingSuperiors, allBaseBeforeIsPlayerSleepingInferiors, "beforeIsPlayerSleeping");
        sortBases(overrideIsPlayerSleepingHookTypes, allBaseOverrideIsPlayerSleepingSuperiors, allBaseOverrideIsPlayerSleepingInferiors, "overrideIsPlayerSleeping");
        sortBases(afterIsPlayerSleepingHookTypes, allBaseAfterIsPlayerSleepingSuperiors, allBaseAfterIsPlayerSleepingInferiors, "afterIsPlayerSleeping");
        sortBases(beforeIsSneakingHookTypes, allBaseBeforeIsSneakingSuperiors, allBaseBeforeIsSneakingInferiors, "beforeIsSneaking");
        sortBases(overrideIsSneakingHookTypes, allBaseOverrideIsSneakingSuperiors, allBaseOverrideIsSneakingInferiors, "overrideIsSneaking");
        sortBases(afterIsSneakingHookTypes, allBaseAfterIsSneakingSuperiors, allBaseAfterIsSneakingInferiors, "afterIsSneaking");
        sortBases(beforeJumpHookTypes, allBaseBeforeJumpSuperiors, allBaseBeforeJumpInferiors, "beforeJump");
        sortBases(overrideJumpHookTypes, allBaseOverrideJumpSuperiors, allBaseOverrideJumpInferiors, "overrideJump");
        sortBases(afterJumpHookTypes, allBaseAfterJumpSuperiors, allBaseAfterJumpInferiors, "afterJump");
        sortBases(beforeKnockBackHookTypes, allBaseBeforeKnockBackSuperiors, allBaseBeforeKnockBackInferiors, "beforeKnockBack");
        sortBases(overrideKnockBackHookTypes, allBaseOverrideKnockBackSuperiors, allBaseOverrideKnockBackInferiors, "overrideKnockBack");
        sortBases(afterKnockBackHookTypes, allBaseAfterKnockBackSuperiors, allBaseAfterKnockBackInferiors, "afterKnockBack");
        sortBases(beforeMountEntityHookTypes, allBaseBeforeMountEntitySuperiors, allBaseBeforeMountEntityInferiors, "beforeMountEntity");
        sortBases(overrideMountEntityHookTypes, allBaseOverrideMountEntitySuperiors, allBaseOverrideMountEntityInferiors, "overrideMountEntity");
        sortBases(afterMountEntityHookTypes, allBaseAfterMountEntitySuperiors, allBaseAfterMountEntityInferiors, "afterMountEntity");
        sortBases(beforeMoveEntityHookTypes, allBaseBeforeMoveEntitySuperiors, allBaseBeforeMoveEntityInferiors, "beforeMoveEntity");
        sortBases(overrideMoveEntityHookTypes, allBaseOverrideMoveEntitySuperiors, allBaseOverrideMoveEntityInferiors, "overrideMoveEntity");
        sortBases(afterMoveEntityHookTypes, allBaseAfterMoveEntitySuperiors, allBaseAfterMoveEntityInferiors, "afterMoveEntity");
        sortBases(beforeMoveEntityWithHeadingHookTypes, allBaseBeforeMoveEntityWithHeadingSuperiors, allBaseBeforeMoveEntityWithHeadingInferiors, "beforeMoveEntityWithHeading");
        sortBases(overrideMoveEntityWithHeadingHookTypes, allBaseOverrideMoveEntityWithHeadingSuperiors, allBaseOverrideMoveEntityWithHeadingInferiors, "overrideMoveEntityWithHeading");
        sortBases(afterMoveEntityWithHeadingHookTypes, allBaseAfterMoveEntityWithHeadingSuperiors, allBaseAfterMoveEntityWithHeadingInferiors, "afterMoveEntityWithHeading");
        sortBases(beforeMoveFlyingHookTypes, allBaseBeforeMoveFlyingSuperiors, allBaseBeforeMoveFlyingInferiors, "beforeMoveFlying");
        sortBases(overrideMoveFlyingHookTypes, allBaseOverrideMoveFlyingSuperiors, allBaseOverrideMoveFlyingInferiors, "overrideMoveFlying");
        sortBases(afterMoveFlyingHookTypes, allBaseAfterMoveFlyingSuperiors, allBaseAfterMoveFlyingInferiors, "afterMoveFlying");
        sortBases(beforeOnDeathHookTypes, allBaseBeforeOnDeathSuperiors, allBaseBeforeOnDeathInferiors, "beforeOnDeath");
        sortBases(overrideOnDeathHookTypes, allBaseOverrideOnDeathSuperiors, allBaseOverrideOnDeathInferiors, "overrideOnDeath");
        sortBases(afterOnDeathHookTypes, allBaseAfterOnDeathSuperiors, allBaseAfterOnDeathInferiors, "afterOnDeath");
        sortBases(beforeOnLivingUpdateHookTypes, allBaseBeforeOnLivingUpdateSuperiors, allBaseBeforeOnLivingUpdateInferiors, "beforeOnLivingUpdate");
        sortBases(overrideOnLivingUpdateHookTypes, allBaseOverrideOnLivingUpdateSuperiors, allBaseOverrideOnLivingUpdateInferiors, "overrideOnLivingUpdate");
        sortBases(afterOnLivingUpdateHookTypes, allBaseAfterOnLivingUpdateSuperiors, allBaseAfterOnLivingUpdateInferiors, "afterOnLivingUpdate");
        sortBases(beforeOnKillEntityHookTypes, allBaseBeforeOnKillEntitySuperiors, allBaseBeforeOnKillEntityInferiors, "beforeOnKillEntity");
        sortBases(overrideOnKillEntityHookTypes, allBaseOverrideOnKillEntitySuperiors, allBaseOverrideOnKillEntityInferiors, "overrideOnKillEntity");
        sortBases(afterOnKillEntityHookTypes, allBaseAfterOnKillEntitySuperiors, allBaseAfterOnKillEntityInferiors, "afterOnKillEntity");
        sortBases(beforeOnStruckByLightningHookTypes, allBaseBeforeOnStruckByLightningSuperiors, allBaseBeforeOnStruckByLightningInferiors, "beforeOnStruckByLightning");
        sortBases(overrideOnStruckByLightningHookTypes, allBaseOverrideOnStruckByLightningSuperiors, allBaseOverrideOnStruckByLightningInferiors, "overrideOnStruckByLightning");
        sortBases(afterOnStruckByLightningHookTypes, allBaseAfterOnStruckByLightningSuperiors, allBaseAfterOnStruckByLightningInferiors, "afterOnStruckByLightning");
        sortBases(beforeOnUpdateHookTypes, allBaseBeforeOnUpdateSuperiors, allBaseBeforeOnUpdateInferiors, "beforeOnUpdate");
        sortBases(overrideOnUpdateHookTypes, allBaseOverrideOnUpdateSuperiors, allBaseOverrideOnUpdateInferiors, "overrideOnUpdate");
        sortBases(afterOnUpdateHookTypes, allBaseAfterOnUpdateSuperiors, allBaseAfterOnUpdateInferiors, "afterOnUpdate");
        sortBases(beforeOnUpdateEntityHookTypes, allBaseBeforeOnUpdateEntitySuperiors, allBaseBeforeOnUpdateEntityInferiors, "beforeOnUpdateEntity");
        sortBases(overrideOnUpdateEntityHookTypes, allBaseOverrideOnUpdateEntitySuperiors, allBaseOverrideOnUpdateEntityInferiors, "overrideOnUpdateEntity");
        sortBases(afterOnUpdateEntityHookTypes, allBaseAfterOnUpdateEntitySuperiors, allBaseAfterOnUpdateEntityInferiors, "afterOnUpdateEntity");
        sortBases(beforeReadEntityFromNBTHookTypes, allBaseBeforeReadEntityFromNBTSuperiors, allBaseBeforeReadEntityFromNBTInferiors, "beforeReadEntityFromNBT");
        sortBases(overrideReadEntityFromNBTHookTypes, allBaseOverrideReadEntityFromNBTSuperiors, allBaseOverrideReadEntityFromNBTInferiors, "overrideReadEntityFromNBT");
        sortBases(afterReadEntityFromNBTHookTypes, allBaseAfterReadEntityFromNBTSuperiors, allBaseAfterReadEntityFromNBTInferiors, "afterReadEntityFromNBT");
        sortBases(beforeSetDeadHookTypes, allBaseBeforeSetDeadSuperiors, allBaseBeforeSetDeadInferiors, "beforeSetDead");
        sortBases(overrideSetDeadHookTypes, allBaseOverrideSetDeadSuperiors, allBaseOverrideSetDeadInferiors, "overrideSetDead");
        sortBases(afterSetDeadHookTypes, allBaseAfterSetDeadSuperiors, allBaseAfterSetDeadInferiors, "afterSetDead");
        sortBases(beforeSetEntityActionStateHookTypes, allBaseBeforeSetEntityActionStateSuperiors, allBaseBeforeSetEntityActionStateInferiors, "beforeSetEntityActionState");
        sortBases(overrideSetEntityActionStateHookTypes, allBaseOverrideSetEntityActionStateSuperiors, allBaseOverrideSetEntityActionStateInferiors, "overrideSetEntityActionState");
        sortBases(afterSetEntityActionStateHookTypes, allBaseAfterSetEntityActionStateSuperiors, allBaseAfterSetEntityActionStateInferiors, "afterSetEntityActionState");
        sortBases(beforeSetPositionHookTypes, allBaseBeforeSetPositionSuperiors, allBaseBeforeSetPositionInferiors, "beforeSetPosition");
        sortBases(overrideSetPositionHookTypes, allBaseOverrideSetPositionSuperiors, allBaseOverrideSetPositionInferiors, "overrideSetPosition");
        sortBases(afterSetPositionHookTypes, allBaseAfterSetPositionSuperiors, allBaseAfterSetPositionInferiors, "afterSetPosition");
        sortBases(beforeSetSneakingHookTypes, allBaseBeforeSetSneakingSuperiors, allBaseBeforeSetSneakingInferiors, "beforeSetSneaking");
        sortBases(overrideSetSneakingHookTypes, allBaseOverrideSetSneakingSuperiors, allBaseOverrideSetSneakingInferiors, "overrideSetSneaking");
        sortBases(afterSetSneakingHookTypes, allBaseAfterSetSneakingSuperiors, allBaseAfterSetSneakingInferiors, "afterSetSneaking");
        sortBases(beforeSetSprintingHookTypes, allBaseBeforeSetSprintingSuperiors, allBaseBeforeSetSprintingInferiors, "beforeSetSprinting");
        sortBases(overrideSetSprintingHookTypes, allBaseOverrideSetSprintingSuperiors, allBaseOverrideSetSprintingInferiors, "overrideSetSprinting");
        sortBases(afterSetSprintingHookTypes, allBaseAfterSetSprintingSuperiors, allBaseAfterSetSprintingInferiors, "afterSetSprinting");
        sortBases(beforeSwingItemHookTypes, allBaseBeforeSwingItemSuperiors, allBaseBeforeSwingItemInferiors, "beforeSwingItem");
        sortBases(overrideSwingItemHookTypes, allBaseOverrideSwingItemSuperiors, allBaseOverrideSwingItemInferiors, "overrideSwingItem");
        sortBases(afterSwingItemHookTypes, allBaseAfterSwingItemSuperiors, allBaseAfterSwingItemInferiors, "afterSwingItem");
        sortBases(beforeUpdateEntityActionStateHookTypes, allBaseBeforeUpdateEntityActionStateSuperiors, allBaseBeforeUpdateEntityActionStateInferiors, "beforeUpdateEntityActionState");
        sortBases(overrideUpdateEntityActionStateHookTypes, allBaseOverrideUpdateEntityActionStateSuperiors, allBaseOverrideUpdateEntityActionStateInferiors, "overrideUpdateEntityActionState");
        sortBases(afterUpdateEntityActionStateHookTypes, allBaseAfterUpdateEntityActionStateSuperiors, allBaseAfterUpdateEntityActionStateInferiors, "afterUpdateEntityActionState");
        sortBases(beforeUpdatePotionEffectsHookTypes, allBaseBeforeUpdatePotionEffectsSuperiors, allBaseBeforeUpdatePotionEffectsInferiors, "beforeUpdatePotionEffects");
        sortBases(overrideUpdatePotionEffectsHookTypes, allBaseOverrideUpdatePotionEffectsSuperiors, allBaseOverrideUpdatePotionEffectsInferiors, "overrideUpdatePotionEffects");
        sortBases(afterUpdatePotionEffectsHookTypes, allBaseAfterUpdatePotionEffectsSuperiors, allBaseAfterUpdatePotionEffectsInferiors, "afterUpdatePotionEffects");
        sortBases(beforeUpdateRiddenHookTypes, allBaseBeforeUpdateRiddenSuperiors, allBaseBeforeUpdateRiddenInferiors, "beforeUpdateRidden");
        sortBases(overrideUpdateRiddenHookTypes, allBaseOverrideUpdateRiddenSuperiors, allBaseOverrideUpdateRiddenInferiors, "overrideUpdateRidden");
        sortBases(afterUpdateRiddenHookTypes, allBaseAfterUpdateRiddenSuperiors, allBaseAfterUpdateRiddenInferiors, "afterUpdateRidden");
        sortBases(beforeWakeUpPlayerHookTypes, allBaseBeforeWakeUpPlayerSuperiors, allBaseBeforeWakeUpPlayerInferiors, "beforeWakeUpPlayer");
        sortBases(overrideWakeUpPlayerHookTypes, allBaseOverrideWakeUpPlayerSuperiors, allBaseOverrideWakeUpPlayerInferiors, "overrideWakeUpPlayer");
        sortBases(afterWakeUpPlayerHookTypes, allBaseAfterWakeUpPlayerSuperiors, allBaseAfterWakeUpPlayerInferiors, "afterWakeUpPlayer");
        sortBases(beforeWriteEntityToNBTHookTypes, allBaseBeforeWriteEntityToNBTSuperiors, allBaseBeforeWriteEntityToNBTInferiors, "beforeWriteEntityToNBT");
        sortBases(overrideWriteEntityToNBTHookTypes, allBaseOverrideWriteEntityToNBTSuperiors, allBaseOverrideWriteEntityToNBTInferiors, "overrideWriteEntityToNBT");
        sortBases(afterWriteEntityToNBTHookTypes, allBaseAfterWriteEntityToNBTSuperiors, allBaseAfterWriteEntityToNBTInferiors, "afterWriteEntityToNBT");
        initialized = true;
    }

    private static List<IServerPlayerAPI> getAllInstancesList() {
        ArrayList<IServerPlayerAPI> result = new ArrayList<>();

        Object entityPlayerList;
        try {
            Object minecraftServer = MinecraftServer.class.getMethod("func_71276_C").invoke((Object)null);
            Object serverConfigurationManager = minecraftServer != null ? MinecraftServer.class.getMethod("func_71203_ab").invoke(minecraftServer) : null;
            entityPlayerList = serverConfigurationManager != null ? serverConfigurationManager.getClass().getField("field_72404_b").get(serverConfigurationManager) : null;
        } catch (Exception obfuscatedException) {
            try {
                Object minecraftServer = MinecraftServer.class.getMethod("getServer").invoke((Object)null);
                Object serverConfigurationManager = minecraftServer != null ? MinecraftServer.class.getMethod("getConfigurationManager").invoke(minecraftServer) : null;
                entityPlayerList = serverConfigurationManager != null ? serverConfigurationManager.getClass().getField("playerEntityList").get(serverConfigurationManager) : null;
            } catch (Exception deobfuscatedException) {
                throw new RuntimeException("Unable to aquire list of current server players.", obfuscatedException);
            }
        }

        if (entityPlayerList != null) {
            for(Object entityPlayer : (List<?>) entityPlayerList) {
                result.add((IServerPlayerAPI) entityPlayer);
            }
        }

        return result;
    }

    public static EntityPlayerMP[] getAllInstances() {
        List<IServerPlayerAPI> allInstances = getAllInstancesList();
        return (EntityPlayerMP[])allInstances.toArray(new EntityPlayerMP[allInstances.size()]);
    }

    public static void beforeLocalConstructing(IServerPlayerAPI serverPlayer, MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
        ServerPlayerAPI serverPlayerAPI = serverPlayer.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            serverPlayerAPI.load();
        }

        if (serverPlayerAPI != null) {
            serverPlayerAPI.beforeLocalConstructing(var1, var2, var3, var4);
        }

    }

    public static void afterLocalConstructing(IServerPlayerAPI serverPlayer, MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
        ServerPlayerAPI serverPlayerAPI = serverPlayer.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            serverPlayerAPI.afterLocalConstructing(var1, var2, var3, var4);
        }

    }

    public static ServerPlayerBase getServerPlayerBase(IServerPlayerAPI serverPlayer, String baseId) {
        ServerPlayerAPI serverPlayerAPI = serverPlayer.getServerPlayerAPI();
        return serverPlayerAPI != null ? serverPlayerAPI.getServerPlayerBase(baseId) : null;
    }

    public static Set<String> getServerPlayerBaseIds(IServerPlayerAPI serverPlayer) {
        ServerPlayerAPI serverPlayerAPI = serverPlayer.getServerPlayerAPI();
        Set<String> result = null;
        if (serverPlayerAPI != null) {
            result = serverPlayerAPI.getServerPlayerBaseIds();
        } else {
            result = Collections.emptySet();
        }

        return result;
    }

    public static Object dynamic(IServerPlayerAPI serverPlayer, String key, Object[] parameters) {
        ServerPlayerAPI serverPlayerAPI = serverPlayer.getServerPlayerAPI();
        return serverPlayerAPI != null ? serverPlayerAPI.dynamic(key, parameters) : null;
    }

    private static void sortBases(List<String> list, Map<String, String[]> allBaseSuperiors, Map<String, String[]> allBaseInferiors, String methodName) {
        new ServerPlayerBaseSorter(list, allBaseSuperiors, allBaseInferiors, methodName).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> lists, Map<String, Map<String, String[]>> allBaseSuperiors, Map<String, Map<String, String[]>> allBaseInferiors, String key) {
        List<String> types = lists.get(key);
        if (types != null && types.size() > 1) {
            sortBases(types, getDynamicSorters(key, types, allBaseSuperiors), getDynamicSorters(key, types, allBaseInferiors), key);
        }

    }

    private static Map<String, String[]> getDynamicSorters(String key, List<String> var1, Map<String, Map<String, String[]>> allBaseValues) {
        HashMap<String, String[]> superiors = null;
        Iterator<String> ids = var1.iterator();

        while(ids.hasNext()) {
            String id = (String)ids.next();
            Map<String, String[]> idSuperiors = allBaseValues.get(id);
            if (idSuperiors != null) {
                String[] keySuperiorIds = (String[])idSuperiors.get(key);
                if (keySuperiorIds != null && keySuperiorIds.length > 0) {
                    if (superiors == null) {
                        superiors = new HashMap<>(1);
                    }

                    superiors.put(id, keySuperiorIds);
                }
            }
        }

        return superiors != null ? superiors : EmptySortMap;
    }

    private ServerPlayerAPI(IServerPlayerAPI player) {
        this.unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
        this.player = player;
    }

    private void load() {
        Iterator<String> iterator = allBaseConstructors.keySet().iterator();

        while(iterator.hasNext()) {
            String id = (String)iterator.next();
            ServerPlayerBase toAttach = this.createServerPlayerBase(id);
            toAttach.beforeBaseAttach(false);
            this.allBaseObjects.put(id, toAttach);
            this.baseObjectsToId.put(toAttach, id);
        }

        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateServerPlayerBases();
        iterator = this.allBaseObjects.keySet().iterator();

        while(iterator.hasNext()) {
            this.allBaseObjects.get(iterator.next()).afterBaseAttach(false);
        }

    }

    private ServerPlayerBase createServerPlayerBase(String id) {
        Constructor<?> contructor = allBaseConstructors.get(id);

        try {
            ServerPlayerBase base;
            if (contructor.getParameterTypes().length == 1) {
                base = (ServerPlayerBase)contructor.newInstance(this);
            } else {
                base = (ServerPlayerBase)contructor.newInstance(this, id);
            }

            return base;
        } catch (Exception e) {
            throw new RuntimeException("Exception while creating a ServerPlayerBase of type '" + contructor.getDeclaringClass() + "'", e);
        }
    }

    private void updateServerPlayerBases() {
        this.beforeAddExhaustionHooks = this.create(beforeAddExhaustionHookTypes);
        this.overrideAddExhaustionHooks = this.create(overrideAddExhaustionHookTypes);
        this.afterAddExhaustionHooks = this.create(afterAddExhaustionHookTypes);
        this.isAddExhaustionModded = this.beforeAddExhaustionHooks != null || this.overrideAddExhaustionHooks != null || this.afterAddExhaustionHooks != null;
        this.beforeAddExperienceHooks = this.create(beforeAddExperienceHookTypes);
        this.overrideAddExperienceHooks = this.create(overrideAddExperienceHookTypes);
        this.afterAddExperienceHooks = this.create(afterAddExperienceHookTypes);
        this.isAddExperienceModded = this.beforeAddExperienceHooks != null || this.overrideAddExperienceHooks != null || this.afterAddExperienceHooks != null;
        this.beforeAddExperienceLevelHooks = this.create(beforeAddExperienceLevelHookTypes);
        this.overrideAddExperienceLevelHooks = this.create(overrideAddExperienceLevelHookTypes);
        this.afterAddExperienceLevelHooks = this.create(afterAddExperienceLevelHookTypes);
        this.isAddExperienceLevelModded = this.beforeAddExperienceLevelHooks != null || this.overrideAddExperienceLevelHooks != null || this.afterAddExperienceLevelHooks != null;
        this.beforeAddMovementStatHooks = this.create(beforeAddMovementStatHookTypes);
        this.overrideAddMovementStatHooks = this.create(overrideAddMovementStatHookTypes);
        this.afterAddMovementStatHooks = this.create(afterAddMovementStatHookTypes);
        this.isAddMovementStatModded = this.beforeAddMovementStatHooks != null || this.overrideAddMovementStatHooks != null || this.afterAddMovementStatHooks != null;
        this.beforeAttackEntityFromHooks = this.create(beforeAttackEntityFromHookTypes);
        this.overrideAttackEntityFromHooks = this.create(overrideAttackEntityFromHookTypes);
        this.afterAttackEntityFromHooks = this.create(afterAttackEntityFromHookTypes);
        this.isAttackEntityFromModded = this.beforeAttackEntityFromHooks != null || this.overrideAttackEntityFromHooks != null || this.afterAttackEntityFromHooks != null;
        this.beforeAttackTargetEntityWithCurrentItemHooks = this.create(beforeAttackTargetEntityWithCurrentItemHookTypes);
        this.overrideAttackTargetEntityWithCurrentItemHooks = this.create(overrideAttackTargetEntityWithCurrentItemHookTypes);
        this.afterAttackTargetEntityWithCurrentItemHooks = this.create(afterAttackTargetEntityWithCurrentItemHookTypes);
        this.isAttackTargetEntityWithCurrentItemModded = this.beforeAttackTargetEntityWithCurrentItemHooks != null || this.overrideAttackTargetEntityWithCurrentItemHooks != null || this.afterAttackTargetEntityWithCurrentItemHooks != null;
        this.beforeCanBreatheUnderwaterHooks = this.create(beforeCanBreatheUnderwaterHookTypes);
        this.overrideCanBreatheUnderwaterHooks = this.create(overrideCanBreatheUnderwaterHookTypes);
        this.afterCanBreatheUnderwaterHooks = this.create(afterCanBreatheUnderwaterHookTypes);
        this.isCanBreatheUnderwaterModded = this.beforeCanBreatheUnderwaterHooks != null || this.overrideCanBreatheUnderwaterHooks != null || this.afterCanBreatheUnderwaterHooks != null;
        this.beforeCanHarvestBlockHooks = this.create(beforeCanHarvestBlockHookTypes);
        this.overrideCanHarvestBlockHooks = this.create(overrideCanHarvestBlockHookTypes);
        this.afterCanHarvestBlockHooks = this.create(afterCanHarvestBlockHookTypes);
        this.isCanHarvestBlockModded = this.beforeCanHarvestBlockHooks != null || this.overrideCanHarvestBlockHooks != null || this.afterCanHarvestBlockHooks != null;
        this.beforeCanPlayerEditHooks = this.create(beforeCanPlayerEditHookTypes);
        this.overrideCanPlayerEditHooks = this.create(overrideCanPlayerEditHookTypes);
        this.afterCanPlayerEditHooks = this.create(afterCanPlayerEditHookTypes);
        this.isCanPlayerEditModded = this.beforeCanPlayerEditHooks != null || this.overrideCanPlayerEditHooks != null || this.afterCanPlayerEditHooks != null;
        this.beforeCanTriggerWalkingHooks = this.create(beforeCanTriggerWalkingHookTypes);
        this.overrideCanTriggerWalkingHooks = this.create(overrideCanTriggerWalkingHookTypes);
        this.afterCanTriggerWalkingHooks = this.create(afterCanTriggerWalkingHookTypes);
        this.isCanTriggerWalkingModded = this.beforeCanTriggerWalkingHooks != null || this.overrideCanTriggerWalkingHooks != null || this.afterCanTriggerWalkingHooks != null;
        this.beforeClonePlayerHooks = this.create(beforeClonePlayerHookTypes);
        this.overrideClonePlayerHooks = this.create(overrideClonePlayerHookTypes);
        this.afterClonePlayerHooks = this.create(afterClonePlayerHookTypes);
        this.isClonePlayerModded = this.beforeClonePlayerHooks != null || this.overrideClonePlayerHooks != null || this.afterClonePlayerHooks != null;
        this.beforeDamageEntityHooks = this.create(beforeDamageEntityHookTypes);
        this.overrideDamageEntityHooks = this.create(overrideDamageEntityHookTypes);
        this.afterDamageEntityHooks = this.create(afterDamageEntityHookTypes);
        this.isDamageEntityModded = this.beforeDamageEntityHooks != null || this.overrideDamageEntityHooks != null || this.afterDamageEntityHooks != null;
        this.beforeDisplayGUIChestHooks = this.create(beforeDisplayGUIChestHookTypes);
        this.overrideDisplayGUIChestHooks = this.create(overrideDisplayGUIChestHookTypes);
        this.afterDisplayGUIChestHooks = this.create(afterDisplayGUIChestHookTypes);
        this.isDisplayGUIChestModded = this.beforeDisplayGUIChestHooks != null || this.overrideDisplayGUIChestHooks != null || this.afterDisplayGUIChestHooks != null;
        this.beforeDisplayGUIDispenserHooks = this.create(beforeDisplayGUIDispenserHookTypes);
        this.overrideDisplayGUIDispenserHooks = this.create(overrideDisplayGUIDispenserHookTypes);
        this.afterDisplayGUIDispenserHooks = this.create(afterDisplayGUIDispenserHookTypes);
        this.isDisplayGUIDispenserModded = this.beforeDisplayGUIDispenserHooks != null || this.overrideDisplayGUIDispenserHooks != null || this.afterDisplayGUIDispenserHooks != null;
        this.beforeDisplayGUIFurnaceHooks = this.create(beforeDisplayGUIFurnaceHookTypes);
        this.overrideDisplayGUIFurnaceHooks = this.create(overrideDisplayGUIFurnaceHookTypes);
        this.afterDisplayGUIFurnaceHooks = this.create(afterDisplayGUIFurnaceHookTypes);
        this.isDisplayGUIFurnaceModded = this.beforeDisplayGUIFurnaceHooks != null || this.overrideDisplayGUIFurnaceHooks != null || this.afterDisplayGUIFurnaceHooks != null;
        this.beforeDisplayGUIWorkbenchHooks = this.create(beforeDisplayGUIWorkbenchHookTypes);
        this.overrideDisplayGUIWorkbenchHooks = this.create(overrideDisplayGUIWorkbenchHookTypes);
        this.afterDisplayGUIWorkbenchHooks = this.create(afterDisplayGUIWorkbenchHookTypes);
        this.isDisplayGUIWorkbenchModded = this.beforeDisplayGUIWorkbenchHooks != null || this.overrideDisplayGUIWorkbenchHooks != null || this.afterDisplayGUIWorkbenchHooks != null;
        this.beforeDropOneItemHooks = this.create(beforeDropOneItemHookTypes);
        this.overrideDropOneItemHooks = this.create(overrideDropOneItemHookTypes);
        this.afterDropOneItemHooks = this.create(afterDropOneItemHookTypes);
        this.isDropOneItemModded = this.beforeDropOneItemHooks != null || this.overrideDropOneItemHooks != null || this.afterDropOneItemHooks != null;
        this.beforeDropPlayerItemHooks = this.create(beforeDropPlayerItemHookTypes);
        this.overrideDropPlayerItemHooks = this.create(overrideDropPlayerItemHookTypes);
        this.afterDropPlayerItemHooks = this.create(afterDropPlayerItemHookTypes);
        this.isDropPlayerItemModded = this.beforeDropPlayerItemHooks != null || this.overrideDropPlayerItemHooks != null || this.afterDropPlayerItemHooks != null;
        this.beforeFallHooks = this.create(beforeFallHookTypes);
        this.overrideFallHooks = this.create(overrideFallHookTypes);
        this.afterFallHooks = this.create(afterFallHookTypes);
        this.isFallModded = this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null;
        this.beforeGetAIMoveSpeedHooks = this.create(beforeGetAIMoveSpeedHookTypes);
        this.overrideGetAIMoveSpeedHooks = this.create(overrideGetAIMoveSpeedHookTypes);
        this.afterGetAIMoveSpeedHooks = this.create(afterGetAIMoveSpeedHookTypes);
        this.isGetAIMoveSpeedModded = this.beforeGetAIMoveSpeedHooks != null || this.overrideGetAIMoveSpeedHooks != null || this.afterGetAIMoveSpeedHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockHooks = this.create(beforeGetCurrentPlayerStrVsBlockHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockHooks = this.create(overrideGetCurrentPlayerStrVsBlockHookTypes);
        this.afterGetCurrentPlayerStrVsBlockHooks = this.create(afterGetCurrentPlayerStrVsBlockHookTypes);
        this.isGetCurrentPlayerStrVsBlockModded = this.beforeGetCurrentPlayerStrVsBlockHooks != null || this.overrideGetCurrentPlayerStrVsBlockHooks != null || this.afterGetCurrentPlayerStrVsBlockHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockForgeHooks = this.create(beforeGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockForgeHooks = this.create(overrideGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.afterGetCurrentPlayerStrVsBlockForgeHooks = this.create(afterGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.isGetCurrentPlayerStrVsBlockForgeModded = this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null || this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null || this.afterGetCurrentPlayerStrVsBlockForgeHooks != null;
        this.beforeGetDistanceSqHooks = this.create(beforeGetDistanceSqHookTypes);
        this.overrideGetDistanceSqHooks = this.create(overrideGetDistanceSqHookTypes);
        this.afterGetDistanceSqHooks = this.create(afterGetDistanceSqHookTypes);
        this.isGetDistanceSqModded = this.beforeGetDistanceSqHooks != null || this.overrideGetDistanceSqHooks != null || this.afterGetDistanceSqHooks != null;
        this.beforeGetBrightnessHooks = this.create(beforeGetBrightnessHookTypes);
        this.overrideGetBrightnessHooks = this.create(overrideGetBrightnessHookTypes);
        this.afterGetBrightnessHooks = this.create(afterGetBrightnessHookTypes);
        this.isGetBrightnessModded = this.beforeGetBrightnessHooks != null || this.overrideGetBrightnessHooks != null || this.afterGetBrightnessHooks != null;
        this.beforeGetEyeHeightHooks = this.create(beforeGetEyeHeightHookTypes);
        this.overrideGetEyeHeightHooks = this.create(overrideGetEyeHeightHookTypes);
        this.afterGetEyeHeightHooks = this.create(afterGetEyeHeightHookTypes);
        this.isGetEyeHeightModded = this.beforeGetEyeHeightHooks != null || this.overrideGetEyeHeightHooks != null || this.afterGetEyeHeightHooks != null;
        this.beforeHealHooks = this.create(beforeHealHookTypes);
        this.overrideHealHooks = this.create(overrideHealHookTypes);
        this.afterHealHooks = this.create(afterHealHookTypes);
        this.isHealModded = this.beforeHealHooks != null || this.overrideHealHooks != null || this.afterHealHooks != null;
        this.beforeIsEntityInsideOpaqueBlockHooks = this.create(beforeIsEntityInsideOpaqueBlockHookTypes);
        this.overrideIsEntityInsideOpaqueBlockHooks = this.create(overrideIsEntityInsideOpaqueBlockHookTypes);
        this.afterIsEntityInsideOpaqueBlockHooks = this.create(afterIsEntityInsideOpaqueBlockHookTypes);
        this.isIsEntityInsideOpaqueBlockModded = this.beforeIsEntityInsideOpaqueBlockHooks != null || this.overrideIsEntityInsideOpaqueBlockHooks != null || this.afterIsEntityInsideOpaqueBlockHooks != null;
        this.beforeIsInWaterHooks = this.create(beforeIsInWaterHookTypes);
        this.overrideIsInWaterHooks = this.create(overrideIsInWaterHookTypes);
        this.afterIsInWaterHooks = this.create(afterIsInWaterHookTypes);
        this.isIsInWaterModded = this.beforeIsInWaterHooks != null || this.overrideIsInWaterHooks != null || this.afterIsInWaterHooks != null;
        this.beforeIsInsideOfMaterialHooks = this.create(beforeIsInsideOfMaterialHookTypes);
        this.overrideIsInsideOfMaterialHooks = this.create(overrideIsInsideOfMaterialHookTypes);
        this.afterIsInsideOfMaterialHooks = this.create(afterIsInsideOfMaterialHookTypes);
        this.isIsInsideOfMaterialModded = this.beforeIsInsideOfMaterialHooks != null || this.overrideIsInsideOfMaterialHooks != null || this.afterIsInsideOfMaterialHooks != null;
        this.beforeIsOnLadderHooks = this.create(beforeIsOnLadderHookTypes);
        this.overrideIsOnLadderHooks = this.create(overrideIsOnLadderHookTypes);
        this.afterIsOnLadderHooks = this.create(afterIsOnLadderHookTypes);
        this.isIsOnLadderModded = this.beforeIsOnLadderHooks != null || this.overrideIsOnLadderHooks != null || this.afterIsOnLadderHooks != null;
        this.beforeIsPlayerSleepingHooks = this.create(beforeIsPlayerSleepingHookTypes);
        this.overrideIsPlayerSleepingHooks = this.create(overrideIsPlayerSleepingHookTypes);
        this.afterIsPlayerSleepingHooks = this.create(afterIsPlayerSleepingHookTypes);
        this.isIsPlayerSleepingModded = this.beforeIsPlayerSleepingHooks != null || this.overrideIsPlayerSleepingHooks != null || this.afterIsPlayerSleepingHooks != null;
        this.beforeIsSneakingHooks = this.create(beforeIsSneakingHookTypes);
        this.overrideIsSneakingHooks = this.create(overrideIsSneakingHookTypes);
        this.afterIsSneakingHooks = this.create(afterIsSneakingHookTypes);
        this.isIsSneakingModded = this.beforeIsSneakingHooks != null || this.overrideIsSneakingHooks != null || this.afterIsSneakingHooks != null;
        this.beforeJumpHooks = this.create(beforeJumpHookTypes);
        this.overrideJumpHooks = this.create(overrideJumpHookTypes);
        this.afterJumpHooks = this.create(afterJumpHookTypes);
        this.isJumpModded = this.beforeJumpHooks != null || this.overrideJumpHooks != null || this.afterJumpHooks != null;
        this.beforeKnockBackHooks = this.create(beforeKnockBackHookTypes);
        this.overrideKnockBackHooks = this.create(overrideKnockBackHookTypes);
        this.afterKnockBackHooks = this.create(afterKnockBackHookTypes);
        this.isKnockBackModded = this.beforeKnockBackHooks != null || this.overrideKnockBackHooks != null || this.afterKnockBackHooks != null;
        this.beforeMountEntityHooks = this.create(beforeMountEntityHookTypes);
        this.overrideMountEntityHooks = this.create(overrideMountEntityHookTypes);
        this.afterMountEntityHooks = this.create(afterMountEntityHookTypes);
        this.isMountEntityModded = this.beforeMountEntityHooks != null || this.overrideMountEntityHooks != null || this.afterMountEntityHooks != null;
        this.beforeMoveEntityHooks = this.create(beforeMoveEntityHookTypes);
        this.overrideMoveEntityHooks = this.create(overrideMoveEntityHookTypes);
        this.afterMoveEntityHooks = this.create(afterMoveEntityHookTypes);
        this.isMoveEntityModded = this.beforeMoveEntityHooks != null || this.overrideMoveEntityHooks != null || this.afterMoveEntityHooks != null;
        this.beforeMoveEntityWithHeadingHooks = this.create(beforeMoveEntityWithHeadingHookTypes);
        this.overrideMoveEntityWithHeadingHooks = this.create(overrideMoveEntityWithHeadingHookTypes);
        this.afterMoveEntityWithHeadingHooks = this.create(afterMoveEntityWithHeadingHookTypes);
        this.isMoveEntityWithHeadingModded = this.beforeMoveEntityWithHeadingHooks != null || this.overrideMoveEntityWithHeadingHooks != null || this.afterMoveEntityWithHeadingHooks != null;
        this.beforeMoveFlyingHooks = this.create(beforeMoveFlyingHookTypes);
        this.overrideMoveFlyingHooks = this.create(overrideMoveFlyingHookTypes);
        this.afterMoveFlyingHooks = this.create(afterMoveFlyingHookTypes);
        this.isMoveFlyingModded = this.beforeMoveFlyingHooks != null || this.overrideMoveFlyingHooks != null || this.afterMoveFlyingHooks != null;
        this.beforeOnDeathHooks = this.create(beforeOnDeathHookTypes);
        this.overrideOnDeathHooks = this.create(overrideOnDeathHookTypes);
        this.afterOnDeathHooks = this.create(afterOnDeathHookTypes);
        this.isOnDeathModded = this.beforeOnDeathHooks != null || this.overrideOnDeathHooks != null || this.afterOnDeathHooks != null;
        this.beforeOnLivingUpdateHooks = this.create(beforeOnLivingUpdateHookTypes);
        this.overrideOnLivingUpdateHooks = this.create(overrideOnLivingUpdateHookTypes);
        this.afterOnLivingUpdateHooks = this.create(afterOnLivingUpdateHookTypes);
        this.isOnLivingUpdateModded = this.beforeOnLivingUpdateHooks != null || this.overrideOnLivingUpdateHooks != null || this.afterOnLivingUpdateHooks != null;
        this.beforeOnKillEntityHooks = this.create(beforeOnKillEntityHookTypes);
        this.overrideOnKillEntityHooks = this.create(overrideOnKillEntityHookTypes);
        this.afterOnKillEntityHooks = this.create(afterOnKillEntityHookTypes);
        this.isOnKillEntityModded = this.beforeOnKillEntityHooks != null || this.overrideOnKillEntityHooks != null || this.afterOnKillEntityHooks != null;
        this.beforeOnStruckByLightningHooks = this.create(beforeOnStruckByLightningHookTypes);
        this.overrideOnStruckByLightningHooks = this.create(overrideOnStruckByLightningHookTypes);
        this.afterOnStruckByLightningHooks = this.create(afterOnStruckByLightningHookTypes);
        this.isOnStruckByLightningModded = this.beforeOnStruckByLightningHooks != null || this.overrideOnStruckByLightningHooks != null || this.afterOnStruckByLightningHooks != null;
        this.beforeOnUpdateHooks = this.create(beforeOnUpdateHookTypes);
        this.overrideOnUpdateHooks = this.create(overrideOnUpdateHookTypes);
        this.afterOnUpdateHooks = this.create(afterOnUpdateHookTypes);
        this.isOnUpdateModded = this.beforeOnUpdateHooks != null || this.overrideOnUpdateHooks != null || this.afterOnUpdateHooks != null;
        this.beforeOnUpdateEntityHooks = this.create(beforeOnUpdateEntityHookTypes);
        this.overrideOnUpdateEntityHooks = this.create(overrideOnUpdateEntityHookTypes);
        this.afterOnUpdateEntityHooks = this.create(afterOnUpdateEntityHookTypes);
        this.isOnUpdateEntityModded = this.beforeOnUpdateEntityHooks != null || this.overrideOnUpdateEntityHooks != null || this.afterOnUpdateEntityHooks != null;
        this.beforeReadEntityFromNBTHooks = this.create(beforeReadEntityFromNBTHookTypes);
        this.overrideReadEntityFromNBTHooks = this.create(overrideReadEntityFromNBTHookTypes);
        this.afterReadEntityFromNBTHooks = this.create(afterReadEntityFromNBTHookTypes);
        this.isReadEntityFromNBTModded = this.beforeReadEntityFromNBTHooks != null || this.overrideReadEntityFromNBTHooks != null || this.afterReadEntityFromNBTHooks != null;
        this.beforeSetDeadHooks = this.create(beforeSetDeadHookTypes);
        this.overrideSetDeadHooks = this.create(overrideSetDeadHookTypes);
        this.afterSetDeadHooks = this.create(afterSetDeadHookTypes);
        this.isSetDeadModded = this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null;
        this.beforeSetEntityActionStateHooks = this.create(beforeSetEntityActionStateHookTypes);
        this.overrideSetEntityActionStateHooks = this.create(overrideSetEntityActionStateHookTypes);
        this.afterSetEntityActionStateHooks = this.create(afterSetEntityActionStateHookTypes);
        this.isSetEntityActionStateModded = this.beforeSetEntityActionStateHooks != null || this.overrideSetEntityActionStateHooks != null || this.afterSetEntityActionStateHooks != null;
        this.beforeSetPositionHooks = this.create(beforeSetPositionHookTypes);
        this.overrideSetPositionHooks = this.create(overrideSetPositionHookTypes);
        this.afterSetPositionHooks = this.create(afterSetPositionHookTypes);
        this.isSetPositionModded = this.beforeSetPositionHooks != null || this.overrideSetPositionHooks != null || this.afterSetPositionHooks != null;
        this.beforeSetSneakingHooks = this.create(beforeSetSneakingHookTypes);
        this.overrideSetSneakingHooks = this.create(overrideSetSneakingHookTypes);
        this.afterSetSneakingHooks = this.create(afterSetSneakingHookTypes);
        this.isSetSneakingModded = this.beforeSetSneakingHooks != null || this.overrideSetSneakingHooks != null || this.afterSetSneakingHooks != null;
        this.beforeSetSprintingHooks = this.create(beforeSetSprintingHookTypes);
        this.overrideSetSprintingHooks = this.create(overrideSetSprintingHookTypes);
        this.afterSetSprintingHooks = this.create(afterSetSprintingHookTypes);
        this.isSetSprintingModded = this.beforeSetSprintingHooks != null || this.overrideSetSprintingHooks != null || this.afterSetSprintingHooks != null;
        this.beforeSwingItemHooks = this.create(beforeSwingItemHookTypes);
        this.overrideSwingItemHooks = this.create(overrideSwingItemHookTypes);
        this.afterSwingItemHooks = this.create(afterSwingItemHookTypes);
        this.isSwingItemModded = this.beforeSwingItemHooks != null || this.overrideSwingItemHooks != null || this.afterSwingItemHooks != null;
        this.beforeUpdateEntityActionStateHooks = this.create(beforeUpdateEntityActionStateHookTypes);
        this.overrideUpdateEntityActionStateHooks = this.create(overrideUpdateEntityActionStateHookTypes);
        this.afterUpdateEntityActionStateHooks = this.create(afterUpdateEntityActionStateHookTypes);
        this.isUpdateEntityActionStateModded = this.beforeUpdateEntityActionStateHooks != null || this.overrideUpdateEntityActionStateHooks != null || this.afterUpdateEntityActionStateHooks != null;
        this.beforeUpdatePotionEffectsHooks = this.create(beforeUpdatePotionEffectsHookTypes);
        this.overrideUpdatePotionEffectsHooks = this.create(overrideUpdatePotionEffectsHookTypes);
        this.afterUpdatePotionEffectsHooks = this.create(afterUpdatePotionEffectsHookTypes);
        this.isUpdatePotionEffectsModded = this.beforeUpdatePotionEffectsHooks != null || this.overrideUpdatePotionEffectsHooks != null || this.afterUpdatePotionEffectsHooks != null;
        this.beforeUpdateRiddenHooks = this.create(beforeUpdateRiddenHookTypes);
        this.overrideUpdateRiddenHooks = this.create(overrideUpdateRiddenHookTypes);
        this.afterUpdateRiddenHooks = this.create(afterUpdateRiddenHookTypes);
        this.isUpdateRiddenModded = this.beforeUpdateRiddenHooks != null || this.overrideUpdateRiddenHooks != null || this.afterUpdateRiddenHooks != null;
        this.beforeWakeUpPlayerHooks = this.create(beforeWakeUpPlayerHookTypes);
        this.overrideWakeUpPlayerHooks = this.create(overrideWakeUpPlayerHookTypes);
        this.afterWakeUpPlayerHooks = this.create(afterWakeUpPlayerHookTypes);
        this.isWakeUpPlayerModded = this.beforeWakeUpPlayerHooks != null || this.overrideWakeUpPlayerHooks != null || this.afterWakeUpPlayerHooks != null;
        this.beforeWriteEntityToNBTHooks = this.create(beforeWriteEntityToNBTHookTypes);
        this.overrideWriteEntityToNBTHooks = this.create(overrideWriteEntityToNBTHookTypes);
        this.afterWriteEntityToNBTHooks = this.create(afterWriteEntityToNBTHookTypes);
        this.isWriteEntityToNBTModded = this.beforeWriteEntityToNBTHooks != null || this.overrideWriteEntityToNBTHooks != null || this.afterWriteEntityToNBTHooks != null;
    }

    private void attachServerPlayerBase(String id) {
        ServerPlayerBase toAttach = this.createServerPlayerBase(id);
        toAttach.beforeBaseAttach(true);
        this.allBaseObjects.put(id, toAttach);
        this.updateServerPlayerBases();
        toAttach.afterBaseAttach(true);
    }

    private void detachServerPlayerBase(String id) {
        ServerPlayerBase toDetach = this.allBaseObjects.get(id);
        toDetach.beforeBaseDetach(true);
        this.allBaseObjects.remove(id);
        toDetach.afterBaseDetach(true);
    }

    private ServerPlayerBase[] create(List<String> types) {
        if (types.isEmpty()) {
            return null;
        } else {
            ServerPlayerBase[] result = new ServerPlayerBase[types.size()];

            for(int i = 0; i < result.length; ++i) {
                result[i] = this.getServerPlayerBase(types.get(i));
            }

            return result;
        }
    }

    private void beforeLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
        if (this.beforeLocalConstructingHooks != null) {
            for(int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing(var1, var2, var3, var4);
            }
        }

        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
        if (this.afterLocalConstructingHooks != null) {
            for (ServerPlayerBase afterLocalConstructingHook : this.afterLocalConstructingHooks) {
                afterLocalConstructingHook.afterLocalConstructing(var1, var2, var3, var4);
            }
        }

        this.afterLocalConstructingHooks = null;
    }

    public ServerPlayerBase getServerPlayerBase(String id) {
        return this.allBaseObjects.get(id);
    }

    public Set<String> getServerPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String key, Object[] parameters) {
        key = key.replace('.', '_').replace(' ', '_');
        this.executeAll(key, parameters, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object result = this.dynamicOverwritten(key, parameters, (ServerPlayerBase)null);
        this.executeAll(key, parameters, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return result;
    }

    public Object dynamicOverwritten(String key, Object[] parameters, ServerPlayerBase overwriter) {
        List<String> overrideIds = overrideDynamicHookTypes.get(key);
        String id = null;
        if (overrideIds != null) {
            if (overwriter != null) {
                id = this.baseObjectsToId.get(overwriter);
                int var6 = overrideIds.indexOf(id);
                if (var6 > 0) {
                    id = (String)overrideIds.get(var6 - 1);
                } else {
                    id = null;
                }
            } else if (overrideIds.size() > 0) {
                id = (String)overrideIds.get(overrideIds.size() - 1);
            }
        }

        Map<Class<?>, Map<String, Method>> methodMap;
        if (id == null) {
            id = keysToVirtualIds.get(key);
            if (id == null) {
                return null;
            }

            methodMap = virtualDynamicHookMethods;
        } else {
            methodMap = overrideDynamicHookMethods;
        }

        Map<String, Method> methods = (Map<String, Method>)methodMap.get(((Constructor<?>)allBaseConstructors.get(id)).getDeclaringClass());
        if (methods == null) {
            return null;
        } else {
            Method method = (Method)methods.get(key);
            return method == null ? null : this.execute(this.getServerPlayerBase(id), method, parameters);
        }
    }

    private void executeAll(String key, Object[] parameters, Map<String, List<String>> dynamicHookTypes, Map<Class<?>, Map<String, Method>> dynamicHookMethods, boolean reverse) {
        List<String> beforeIds = dynamicHookTypes.get(key);
        if (beforeIds != null) {
            int var7 = reverse ? beforeIds.size() - 1 : 0;

            while(true) {
                if (reverse) {
                    if (var7 < 0) {
                        break;
                    }
                } else if (var7 >= beforeIds.size()) {
                    break;
                }

                String id = (String)beforeIds.get(var7);
                ServerPlayerBase base = this.getServerPlayerBase(id);
                Class<?> type = base.getClass();
                Map<String, Method> methods = dynamicHookMethods.get(type);
                if (methods != null) {
                    Method method = (Method)methods.get(key);
                    if (method != null) {
                        this.execute(base, method, parameters);
                    }
                }

                var7 += reverse ? -1 : 1;
            }

        }
    }

    private Object execute(ServerPlayerBase base, Method method, Object[] parameters) {
        try {
            return method.invoke(base, parameters);
        } catch (Exception e) {
            throw new RuntimeException("Exception while invoking dynamic method", e);
        }
    }

    public static void addExhaustion(IServerPlayerAPI var0, float var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isAddExhaustionModded) {
            var2.addExhaustion(var1);
        } else {
            var0.localAddExhaustion(var1);
        }

    }

    private void addExhaustion(float var1) {
        int var2;
        if (this.beforeAddExhaustionHooks != null) {
            for(var2 = this.beforeAddExhaustionHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAddExhaustionHooks[var2].beforeAddExhaustion(var1);
            }
        }

        if (this.overrideAddExhaustionHooks != null) {
            this.overrideAddExhaustionHooks[this.overrideAddExhaustionHooks.length - 1].addExhaustion(var1);
        } else {
            this.player.localAddExhaustion(var1);
        }

        if (this.afterAddExhaustionHooks != null) {
            for(var2 = 0; var2 < this.afterAddExhaustionHooks.length; ++var2) {
                this.afterAddExhaustionHooks[var2].afterAddExhaustion(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenAddExhaustion(ServerPlayerBase var1) {
        if (this.overrideAddExhaustionHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAddExhaustionHooks.length; ++var2) {
                if (this.overrideAddExhaustionHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddExhaustionHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void addExperience(IServerPlayerAPI var0, int var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isAddExperienceModded) {
            var2.addExperience(var1);
        } else {
            var0.localAddExperience(var1);
        }

    }

    private void addExperience(int var1) {
        int var2;
        if (this.beforeAddExperienceHooks != null) {
            for(var2 = this.beforeAddExperienceHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAddExperienceHooks[var2].beforeAddExperience(var1);
            }
        }

        if (this.overrideAddExperienceHooks != null) {
            this.overrideAddExperienceHooks[this.overrideAddExperienceHooks.length - 1].addExperience(var1);
        } else {
            this.player.localAddExperience(var1);
        }

        if (this.afterAddExperienceHooks != null) {
            for(var2 = 0; var2 < this.afterAddExperienceHooks.length; ++var2) {
                this.afterAddExperienceHooks[var2].afterAddExperience(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenAddExperience(ServerPlayerBase var1) {
        if (this.overrideAddExperienceHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAddExperienceHooks.length; ++var2) {
                if (this.overrideAddExperienceHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddExperienceHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void addExperienceLevel(IServerPlayerAPI var0, int var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isAddExperienceLevelModded) {
            var2.addExperienceLevel(var1);
        } else {
            var0.localAddExperienceLevel(var1);
        }

    }

    private void addExperienceLevel(int var1) {
        int var2;
        if (this.beforeAddExperienceLevelHooks != null) {
            for(var2 = this.beforeAddExperienceLevelHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAddExperienceLevelHooks[var2].beforeAddExperienceLevel(var1);
            }
        }

        if (this.overrideAddExperienceLevelHooks != null) {
            this.overrideAddExperienceLevelHooks[this.overrideAddExperienceLevelHooks.length - 1].addExperienceLevel(var1);
        } else {
            this.player.localAddExperienceLevel(var1);
        }

        if (this.afterAddExperienceLevelHooks != null) {
            for(var2 = 0; var2 < this.afterAddExperienceLevelHooks.length; ++var2) {
                this.afterAddExperienceLevelHooks[var2].afterAddExperienceLevel(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenAddExperienceLevel(ServerPlayerBase var1) {
        if (this.overrideAddExperienceLevelHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAddExperienceLevelHooks.length; ++var2) {
                if (this.overrideAddExperienceLevelHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddExperienceLevelHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void addMovementStat(IServerPlayerAPI var0, double var1, double var3, double var5) {
        ServerPlayerAPI var7 = var0.getServerPlayerAPI();
        if (var7 != null && var7.isAddMovementStatModded) {
            var7.addMovementStat(var1, var3, var5);
        } else {
            var0.localAddMovementStat(var1, var3, var5);
        }

    }

    private void addMovementStat(double var1, double var3, double var5) {
        int var7;
        if (this.beforeAddMovementStatHooks != null) {
            for(var7 = this.beforeAddMovementStatHooks.length - 1; var7 >= 0; --var7) {
                this.beforeAddMovementStatHooks[var7].beforeAddMovementStat(var1, var3, var5);
            }
        }

        if (this.overrideAddMovementStatHooks != null) {
            this.overrideAddMovementStatHooks[this.overrideAddMovementStatHooks.length - 1].addMovementStat(var1, var3, var5);
        } else {
            this.player.localAddMovementStat(var1, var3, var5);
        }

        if (this.afterAddMovementStatHooks != null) {
            for(var7 = 0; var7 < this.afterAddMovementStatHooks.length; ++var7) {
                this.afterAddMovementStatHooks[var7].afterAddMovementStat(var1, var3, var5);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenAddMovementStat(ServerPlayerBase var1) {
        if (this.overrideAddMovementStatHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAddMovementStatHooks.length; ++var2) {
                if (this.overrideAddMovementStatHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddMovementStatHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean attackEntityFrom(IServerPlayerAPI var0, DamageSource var1, float var2) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        boolean var3;
        if (var4 != null && var4.isAttackEntityFromModded) {
            var3 = var4.attackEntityFrom(var1, var2);
        } else {
            var3 = var0.localAttackEntityFrom(var1, var2);
        }

        return var3;
    }

    private boolean attackEntityFrom(DamageSource var1, float var2) {
        if (this.beforeAttackEntityFromHooks != null) {
            for(int var3 = this.beforeAttackEntityFromHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAttackEntityFromHooks[var3].beforeAttackEntityFrom(var1, var2);
            }
        }

        boolean var5;
        if (this.overrideAttackEntityFromHooks != null) {
            var5 = this.overrideAttackEntityFromHooks[this.overrideAttackEntityFromHooks.length - 1].attackEntityFrom(var1, var2);
        } else {
            var5 = this.player.localAttackEntityFrom(var1, var2);
        }

        if (this.afterAttackEntityFromHooks != null) {
            for (ServerPlayerBase afterAttackEntityFromHook : this.afterAttackEntityFromHooks) {
                afterAttackEntityFromHook.afterAttackEntityFrom(var1, var2);
            }
        }

        return var5;
    }

    protected ServerPlayerBase GetOverwrittenAttackEntityFrom(ServerPlayerBase var1) {
        if (this.overrideAttackEntityFromHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAttackEntityFromHooks.length; ++var2) {
                if (this.overrideAttackEntityFromHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAttackEntityFromHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void attackTargetEntityWithCurrentItem(IServerPlayerAPI var0, Entity var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isAttackTargetEntityWithCurrentItemModded) {
            var2.attackTargetEntityWithCurrentItem(var1);
        } else {
            var0.localAttackTargetEntityWithCurrentItem(var1);
        }

    }

    private void attackTargetEntityWithCurrentItem(Entity var1) {
        int var2;
        if (this.beforeAttackTargetEntityWithCurrentItemHooks != null) {
            for(var2 = this.beforeAttackTargetEntityWithCurrentItemHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAttackTargetEntityWithCurrentItemHooks[var2].beforeAttackTargetEntityWithCurrentItem(var1);
            }
        }

        if (this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
            this.overrideAttackTargetEntityWithCurrentItemHooks[this.overrideAttackTargetEntityWithCurrentItemHooks.length - 1].attackTargetEntityWithCurrentItem(var1);
        } else {
            this.player.localAttackTargetEntityWithCurrentItem(var1);
        }

        if (this.afterAttackTargetEntityWithCurrentItemHooks != null) {
            for(var2 = 0; var2 < this.afterAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
                this.afterAttackTargetEntityWithCurrentItemHooks[var2].afterAttackTargetEntityWithCurrentItem(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(ServerPlayerBase var1) {
        if (this.overrideAttackTargetEntityWithCurrentItemHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
                if (this.overrideAttackTargetEntityWithCurrentItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAttackTargetEntityWithCurrentItemHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean canBreatheUnderwater(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isCanBreatheUnderwaterModded) {
            var1 = var2.canBreatheUnderwater();
        } else {
            var1 = var0.localCanBreatheUnderwater();
        }

        return var1;
    }

    private boolean canBreatheUnderwater() {
        if (this.beforeCanBreatheUnderwaterHooks != null) {
            for(int var1 = this.beforeCanBreatheUnderwaterHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanBreatheUnderwaterHooks[var1].beforeCanBreatheUnderwater();
            }
        }

        boolean var3;
        if (this.overrideCanBreatheUnderwaterHooks != null) {
            var3 = this.overrideCanBreatheUnderwaterHooks[this.overrideCanBreatheUnderwaterHooks.length - 1].canBreatheUnderwater();
        } else {
            var3 = this.player.localCanBreatheUnderwater();
        }

        if (this.afterCanBreatheUnderwaterHooks != null) {
            for (ServerPlayerBase afterCanBreatheUnderwaterHook : this.afterCanBreatheUnderwaterHooks) {
                afterCanBreatheUnderwaterHook.afterCanBreatheUnderwater();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenCanBreatheUnderwater(ServerPlayerBase var1) {
        if (this.overrideCanBreatheUnderwaterHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideCanBreatheUnderwaterHooks.length; ++var2) {
                if (this.overrideCanBreatheUnderwaterHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanBreatheUnderwaterHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean canHarvestBlock(IServerPlayerAPI var0, Block var1) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        boolean var2;
        if (var3 != null && var3.isCanHarvestBlockModded) {
            var2 = var3.canHarvestBlock(var1);
        } else {
            var2 = var0.localCanHarvestBlock(var1);
        }

        return var2;
    }

    private boolean canHarvestBlock(Block var1) {
        if (this.beforeCanHarvestBlockHooks != null) {
            for(int var2 = this.beforeCanHarvestBlockHooks.length - 1; var2 >= 0; --var2) {
                this.beforeCanHarvestBlockHooks[var2].beforeCanHarvestBlock(var1);
            }
        }

        boolean var4;
        if (this.overrideCanHarvestBlockHooks != null) {
            var4 = this.overrideCanHarvestBlockHooks[this.overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(var1);
        } else {
            var4 = this.player.localCanHarvestBlock(var1);
        }

        if (this.afterCanHarvestBlockHooks != null) {
            for (ServerPlayerBase afterCanHarvestBlockHook : this.afterCanHarvestBlockHooks) {
                afterCanHarvestBlockHook.afterCanHarvestBlock(var1);
            }
        }

        return var4;
    }

    protected ServerPlayerBase GetOverwrittenCanHarvestBlock(ServerPlayerBase var1) {
        if (this.overrideCanHarvestBlockHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideCanHarvestBlockHooks.length; ++var2) {
                if (this.overrideCanHarvestBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanHarvestBlockHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean canPlayerEdit(IServerPlayerAPI var0, int var1, int var2, int var3, int var4, ItemStack var5) {
        ServerPlayerAPI var7 = var0.getServerPlayerAPI();
        boolean var6;
        if (var7 != null && var7.isCanPlayerEditModded) {
            var6 = var7.canPlayerEdit(var1, var2, var3, var4, var5);
        } else {
            var6 = var0.localCanPlayerEdit(var1, var2, var3, var4, var5);
        }

        return var6;
    }

    private boolean canPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
        if (this.beforeCanPlayerEditHooks != null) {
            for(int var6 = this.beforeCanPlayerEditHooks.length - 1; var6 >= 0; --var6) {
                this.beforeCanPlayerEditHooks[var6].beforeCanPlayerEdit(var1, var2, var3, var4, var5);
            }
        }

        boolean var8;
        if (this.overrideCanPlayerEditHooks != null) {
            var8 = this.overrideCanPlayerEditHooks[this.overrideCanPlayerEditHooks.length - 1].canPlayerEdit(var1, var2, var3, var4, var5);
        } else {
            var8 = this.player.localCanPlayerEdit(var1, var2, var3, var4, var5);
        }

        if (this.afterCanPlayerEditHooks != null) {
            for (ServerPlayerBase afterCanPlayerEditHook : this.afterCanPlayerEditHooks) {
                afterCanPlayerEditHook.afterCanPlayerEdit(var1, var2, var3, var4, var5);
            }
        }

        return var8;
    }

    protected ServerPlayerBase GetOverwrittenCanPlayerEdit(ServerPlayerBase var1) {
        if (this.overrideCanPlayerEditHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideCanPlayerEditHooks.length; ++var2) {
                if (this.overrideCanPlayerEditHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanPlayerEditHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean canTriggerWalking(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isCanTriggerWalkingModded) {
            var1 = var2.canTriggerWalking();
        } else {
            var1 = var0.localCanTriggerWalking();
        }

        return var1;
    }

    private boolean canTriggerWalking() {
        if (this.beforeCanTriggerWalkingHooks != null) {
            for(int var1 = this.beforeCanTriggerWalkingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanTriggerWalkingHooks[var1].beforeCanTriggerWalking();
            }
        }

        boolean var3;
        if (this.overrideCanTriggerWalkingHooks != null) {
            var3 = this.overrideCanTriggerWalkingHooks[this.overrideCanTriggerWalkingHooks.length - 1].canTriggerWalking();
        } else {
            var3 = this.player.localCanTriggerWalking();
        }

        if (this.afterCanTriggerWalkingHooks != null) {
            for (ServerPlayerBase afterCanTriggerWalkingHook : this.afterCanTriggerWalkingHooks) {
                afterCanTriggerWalkingHook.afterCanTriggerWalking();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenCanTriggerWalking(ServerPlayerBase var1) {
        if (this.overrideCanTriggerWalkingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideCanTriggerWalkingHooks.length; ++var2) {
                if (this.overrideCanTriggerWalkingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanTriggerWalkingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void clonePlayer(IServerPlayerAPI var0, EntityPlayer var1, boolean var2) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        if (var3 != null && var3.isClonePlayerModded) {
            var3.clonePlayer(var1, var2);
        } else {
            var0.localClonePlayer(var1, var2);
        }

    }

    private void clonePlayer(EntityPlayer var1, boolean var2) {
        int var3;
        if (this.beforeClonePlayerHooks != null) {
            for(var3 = this.beforeClonePlayerHooks.length - 1; var3 >= 0; --var3) {
                this.beforeClonePlayerHooks[var3].beforeClonePlayer(var1, var2);
            }
        }

        if (this.overrideClonePlayerHooks != null) {
            this.overrideClonePlayerHooks[this.overrideClonePlayerHooks.length - 1].clonePlayer(var1, var2);
        } else {
            this.player.localClonePlayer(var1, var2);
        }

        if (this.afterClonePlayerHooks != null) {
            for(var3 = 0; var3 < this.afterClonePlayerHooks.length; ++var3) {
                this.afterClonePlayerHooks[var3].afterClonePlayer(var1, var2);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenClonePlayer(ServerPlayerBase var1) {
        if (this.overrideClonePlayerHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideClonePlayerHooks.length; ++var2) {
                if (this.overrideClonePlayerHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideClonePlayerHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void damageEntity(IServerPlayerAPI var0, DamageSource var1, float var2) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        if (var3 != null && var3.isDamageEntityModded) {
            var3.damageEntity(var1, var2);
        } else {
            var0.localDamageEntity(var1, var2);
        }

    }

    private void damageEntity(DamageSource var1, float var2) {
        int var3;
        if (this.beforeDamageEntityHooks != null) {
            for(var3 = this.beforeDamageEntityHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDamageEntityHooks[var3].beforeDamageEntity(var1, var2);
            }
        }

        if (this.overrideDamageEntityHooks != null) {
            this.overrideDamageEntityHooks[this.overrideDamageEntityHooks.length - 1].damageEntity(var1, var2);
        } else {
            this.player.localDamageEntity(var1, var2);
        }

        if (this.afterDamageEntityHooks != null) {
            for(var3 = 0; var3 < this.afterDamageEntityHooks.length; ++var3) {
                this.afterDamageEntityHooks[var3].afterDamageEntity(var1, var2);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenDamageEntity(ServerPlayerBase var1) {
        if (this.overrideDamageEntityHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDamageEntityHooks.length; ++var2) {
                if (this.overrideDamageEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDamageEntityHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void displayGUIChest(IServerPlayerAPI var0, IInventory var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isDisplayGUIChestModded) {
            var2.displayGUIChest(var1);
        } else {
            var0.localDisplayGUIChest(var1);
        }

    }

    private void displayGUIChest(IInventory var1) {
        int var2;
        if (this.beforeDisplayGUIChestHooks != null) {
            for(var2 = this.beforeDisplayGUIChestHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIChestHooks[var2].beforeDisplayGUIChest(var1);
            }
        }

        if (this.overrideDisplayGUIChestHooks != null) {
            this.overrideDisplayGUIChestHooks[this.overrideDisplayGUIChestHooks.length - 1].displayGUIChest(var1);
        } else {
            this.player.localDisplayGUIChest(var1);
        }

        if (this.afterDisplayGUIChestHooks != null) {
            for(var2 = 0; var2 < this.afterDisplayGUIChestHooks.length; ++var2) {
                this.afterDisplayGUIChestHooks[var2].afterDisplayGUIChest(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIChest(ServerPlayerBase var1) {
        if (this.overrideDisplayGUIChestHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDisplayGUIChestHooks.length; ++var2) {
                if (this.overrideDisplayGUIChestHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIChestHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void displayGUIDispenser(IServerPlayerAPI var0, TileEntityDispenser var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isDisplayGUIDispenserModded) {
            var2.displayGUIDispenser(var1);
        } else {
            var0.localDisplayGUIDispenser(var1);
        }

    }

    private void displayGUIDispenser(TileEntityDispenser var1) {
        int var2;
        if (this.beforeDisplayGUIDispenserHooks != null) {
            for(var2 = this.beforeDisplayGUIDispenserHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIDispenserHooks[var2].beforeDisplayGUIDispenser(var1);
            }
        }

        if (this.overrideDisplayGUIDispenserHooks != null) {
            this.overrideDisplayGUIDispenserHooks[this.overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(var1);
        } else {
            this.player.localDisplayGUIDispenser(var1);
        }

        if (this.afterDisplayGUIDispenserHooks != null) {
            for(var2 = 0; var2 < this.afterDisplayGUIDispenserHooks.length; ++var2) {
                this.afterDisplayGUIDispenserHooks[var2].afterDisplayGUIDispenser(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIDispenser(ServerPlayerBase var1) {
        if (this.overrideDisplayGUIDispenserHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDisplayGUIDispenserHooks.length; ++var2) {
                if (this.overrideDisplayGUIDispenserHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIDispenserHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void displayGUIFurnace(IServerPlayerAPI var0, TileEntityFurnace var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isDisplayGUIFurnaceModded) {
            var2.displayGUIFurnace(var1);
        } else {
            var0.localDisplayGUIFurnace(var1);
        }

    }

    private void displayGUIFurnace(TileEntityFurnace var1) {
        int var2;
        if (this.beforeDisplayGUIFurnaceHooks != null) {
            for(var2 = this.beforeDisplayGUIFurnaceHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIFurnaceHooks[var2].beforeDisplayGUIFurnace(var1);
            }
        }

        if (this.overrideDisplayGUIFurnaceHooks != null) {
            this.overrideDisplayGUIFurnaceHooks[this.overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(var1);
        } else {
            this.player.localDisplayGUIFurnace(var1);
        }

        if (this.afterDisplayGUIFurnaceHooks != null) {
            for(var2 = 0; var2 < this.afterDisplayGUIFurnaceHooks.length; ++var2) {
                this.afterDisplayGUIFurnaceHooks[var2].afterDisplayGUIFurnace(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIFurnace(ServerPlayerBase var1) {
        if (this.overrideDisplayGUIFurnaceHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDisplayGUIFurnaceHooks.length; ++var2) {
                if (this.overrideDisplayGUIFurnaceHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIFurnaceHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void displayGUIWorkbench(IServerPlayerAPI var0, int var1, int var2, int var3) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        if (var4 != null && var4.isDisplayGUIWorkbenchModded) {
            var4.displayGUIWorkbench(var1, var2, var3);
        } else {
            var0.localDisplayGUIWorkbench(var1, var2, var3);
        }

    }

    private void displayGUIWorkbench(int var1, int var2, int var3) {
        int var4;
        if (this.beforeDisplayGUIWorkbenchHooks != null) {
            for(var4 = this.beforeDisplayGUIWorkbenchHooks.length - 1; var4 >= 0; --var4) {
                this.beforeDisplayGUIWorkbenchHooks[var4].beforeDisplayGUIWorkbench(var1, var2, var3);
            }
        }

        if (this.overrideDisplayGUIWorkbenchHooks != null) {
            this.overrideDisplayGUIWorkbenchHooks[this.overrideDisplayGUIWorkbenchHooks.length - 1].displayGUIWorkbench(var1, var2, var3);
        } else {
            this.player.localDisplayGUIWorkbench(var1, var2, var3);
        }

        if (this.afterDisplayGUIWorkbenchHooks != null) {
            for(var4 = 0; var4 < this.afterDisplayGUIWorkbenchHooks.length; ++var4) {
                this.afterDisplayGUIWorkbenchHooks[var4].afterDisplayGUIWorkbench(var1, var2, var3);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIWorkbench(ServerPlayerBase var1) {
        if (this.overrideDisplayGUIWorkbenchHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDisplayGUIWorkbenchHooks.length; ++var2) {
                if (this.overrideDisplayGUIWorkbenchHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIWorkbenchHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static EntityItem dropOneItem(IServerPlayerAPI var0, boolean var1) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        EntityItem var2;
        if (var3 != null && var3.isDropOneItemModded) {
            var2 = var3.dropOneItem(var1);
        } else {
            var2 = var0.localDropOneItem(var1);
        }

        return var2;
    }

    private EntityItem dropOneItem(boolean var1) {
        if (this.beforeDropOneItemHooks != null) {
            for(int var2 = this.beforeDropOneItemHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDropOneItemHooks[var2].beforeDropOneItem(var1);
            }
        }

        EntityItem var4;
        if (this.overrideDropOneItemHooks != null) {
            var4 = this.overrideDropOneItemHooks[this.overrideDropOneItemHooks.length - 1].dropOneItem(var1);
        } else {
            var4 = this.player.localDropOneItem(var1);
        }

        if (this.afterDropOneItemHooks != null) {
            for (ServerPlayerBase afterDropOneItemHook : this.afterDropOneItemHooks) {
                afterDropOneItemHook.afterDropOneItem(var1);
            }
        }

        return var4;
    }

    protected ServerPlayerBase GetOverwrittenDropOneItem(ServerPlayerBase var1) {
        if (this.overrideDropOneItemHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDropOneItemHooks.length; ++var2) {
                if (this.overrideDropOneItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDropOneItemHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static EntityItem dropPlayerItem(IServerPlayerAPI var0, ItemStack var1, boolean var2) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        EntityItem var3;
        if (var4 != null && var4.isDropPlayerItemModded) {
            var3 = var4.dropPlayerItem(var1, var2);
        } else {
            var3 = var0.localDropPlayerItem(var1, var2);
        }

        return var3;
    }

    private EntityItem dropPlayerItem(ItemStack var1, boolean var2) {
        if (this.beforeDropPlayerItemHooks != null) {
            for(int var3 = this.beforeDropPlayerItemHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDropPlayerItemHooks[var3].beforeDropPlayerItem(var1, var2);
            }
        }

        EntityItem var5;
        if (this.overrideDropPlayerItemHooks != null) {
            var5 = this.overrideDropPlayerItemHooks[this.overrideDropPlayerItemHooks.length - 1].dropPlayerItem(var1, var2);
        } else {
            var5 = this.player.localDropPlayerItem(var1, var2);
        }

        if (this.afterDropPlayerItemHooks != null) {
            for (ServerPlayerBase afterDropPlayerItemHook : this.afterDropPlayerItemHooks) {
                afterDropPlayerItemHook.afterDropPlayerItem(var1, var2);
            }
        }

        return var5;
    }

    protected ServerPlayerBase GetOverwrittenDropPlayerItem(ServerPlayerBase var1) {
        if (this.overrideDropPlayerItemHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideDropPlayerItemHooks.length; ++var2) {
                if (this.overrideDropPlayerItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDropPlayerItemHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void fall(IServerPlayerAPI var0, float var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isFallModded) {
            var2.fall(var1);
        } else {
            var0.localFall(var1);
        }

    }

    private void fall(float var1) {
        int var2;
        if (this.beforeFallHooks != null) {
            for(var2 = this.beforeFallHooks.length - 1; var2 >= 0; --var2) {
                this.beforeFallHooks[var2].beforeFall(var1);
            }
        }

        if (this.overrideFallHooks != null) {
            this.overrideFallHooks[this.overrideFallHooks.length - 1].fall(var1);
        } else {
            this.player.localFall(var1);
        }

        if (this.afterFallHooks != null) {
            for(var2 = 0; var2 < this.afterFallHooks.length; ++var2) {
                this.afterFallHooks[var2].afterFall(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenFall(ServerPlayerBase var1) {
        if (this.overrideFallHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideFallHooks.length; ++var2) {
                if (this.overrideFallHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideFallHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static float getAIMoveSpeed(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        float var1;
        if (var2 != null && var2.isGetAIMoveSpeedModded) {
            var1 = var2.getAIMoveSpeed();
        } else {
            var1 = var0.localGetAIMoveSpeed();
        }

        return var1;
    }

    private float getAIMoveSpeed() {
        if (this.beforeGetAIMoveSpeedHooks != null) {
            for(int var1 = this.beforeGetAIMoveSpeedHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetAIMoveSpeedHooks[var1].beforeGetAIMoveSpeed();
            }
        }

        float var3;
        if (this.overrideGetAIMoveSpeedHooks != null) {
            var3 = this.overrideGetAIMoveSpeedHooks[this.overrideGetAIMoveSpeedHooks.length - 1].getAIMoveSpeed();
        } else {
            var3 = this.player.localGetAIMoveSpeed();
        }

        if (this.afterGetAIMoveSpeedHooks != null) {
            for (ServerPlayerBase afterGetAIMoveSpeedHook : this.afterGetAIMoveSpeedHooks) {
                afterGetAIMoveSpeedHook.afterGetAIMoveSpeed();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenGetAIMoveSpeed(ServerPlayerBase var1) {
        if (this.overrideGetAIMoveSpeedHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetAIMoveSpeedHooks.length; ++var2) {
                if (this.overrideGetAIMoveSpeedHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetAIMoveSpeedHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static float getCurrentPlayerStrVsBlock(IServerPlayerAPI var0, Block var1, boolean var2) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        float var3;
        if (var4 != null && var4.isGetCurrentPlayerStrVsBlockModded) {
            var3 = var4.getCurrentPlayerStrVsBlock(var1, var2);
        } else {
            var3 = var0.localGetCurrentPlayerStrVsBlock(var1, var2);
        }

        return var3;
    }

    private float getCurrentPlayerStrVsBlock(Block var1, boolean var2) {
        if (this.beforeGetCurrentPlayerStrVsBlockHooks != null) {
            for(int var3 = this.beforeGetCurrentPlayerStrVsBlockHooks.length - 1; var3 >= 0; --var3) {
                this.beforeGetCurrentPlayerStrVsBlockHooks[var3].beforeGetCurrentPlayerStrVsBlock(var1, var2);
            }
        }

        float var5;
        if (this.overrideGetCurrentPlayerStrVsBlockHooks != null) {
            var5 = this.overrideGetCurrentPlayerStrVsBlockHooks[this.overrideGetCurrentPlayerStrVsBlockHooks.length - 1].getCurrentPlayerStrVsBlock(var1, var2);
        } else {
            var5 = this.player.localGetCurrentPlayerStrVsBlock(var1, var2);
        }

        if (this.afterGetCurrentPlayerStrVsBlockHooks != null) {
            for (ServerPlayerBase afterGetCurrentPlayerStrVsBlockHook : this.afterGetCurrentPlayerStrVsBlockHooks) {
                afterGetCurrentPlayerStrVsBlockHook.afterGetCurrentPlayerStrVsBlock(var1, var2);
            }
        }

        return var5;
    }

    protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(ServerPlayerBase var1) {
        if (this.overrideGetCurrentPlayerStrVsBlockHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockHooks.length; ++var2) {
                if (this.overrideGetCurrentPlayerStrVsBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetCurrentPlayerStrVsBlockHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static float getCurrentPlayerStrVsBlockForge(IServerPlayerAPI var0, Block var1, boolean var2, int var3) {
        ServerPlayerAPI var5 = var0.getServerPlayerAPI();
        float var4;
        if (var5 != null && var5.isGetCurrentPlayerStrVsBlockForgeModded) {
            var4 = var5.getCurrentPlayerStrVsBlockForge(var1, var2, var3);
        } else {
            var4 = var0.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
        }

        return var4;
    }

    private float getCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
        if (this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for(int var4 = this.beforeGetCurrentPlayerStrVsBlockForgeHooks.length - 1; var4 >= 0; --var4) {
                this.beforeGetCurrentPlayerStrVsBlockForgeHooks[var4].beforeGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
            }
        }

        float var6;
        if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null) {
            var6 = this.overrideGetCurrentPlayerStrVsBlockForgeHooks[this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length - 1].getCurrentPlayerStrVsBlockForge(var1, var2, var3);
        } else {
            var6 = this.player.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
        }

        if (this.afterGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for (ServerPlayerBase afterGetCurrentPlayerStrVsBlockForgeHook : this.afterGetCurrentPlayerStrVsBlockForgeHooks) {
                afterGetCurrentPlayerStrVsBlockForgeHook.afterGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
            }
        }

        return var6;
    }

    protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlockForge(ServerPlayerBase var1) {
        if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length; ++var2) {
                if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static double getDistanceSq(IServerPlayerAPI var0, double var1, double var3, double var5) {
        ServerPlayerAPI var9 = var0.getServerPlayerAPI();
        double var7;
        if (var9 != null && var9.isGetDistanceSqModded) {
            var7 = var9.getDistanceSq(var1, var3, var5);
        } else {
            var7 = var0.localGetDistanceSq(var1, var3, var5);
        }

        return var7;
    }

    private double getDistanceSq(double var1, double var3, double var5) {
        if (this.beforeGetDistanceSqHooks != null) {
            for(int var7 = this.beforeGetDistanceSqHooks.length - 1; var7 >= 0; --var7) {
                this.beforeGetDistanceSqHooks[var7].beforeGetDistanceSq(var1, var3, var5);
            }
        }

        double var10;
        if (this.overrideGetDistanceSqHooks != null) {
            var10 = this.overrideGetDistanceSqHooks[this.overrideGetDistanceSqHooks.length - 1].getDistanceSq(var1, var3, var5);
        } else {
            var10 = this.player.localGetDistanceSq(var1, var3, var5);
        }

        if (this.afterGetDistanceSqHooks != null) {
            for (ServerPlayerBase afterGetDistanceSqHook : this.afterGetDistanceSqHooks) {
                afterGetDistanceSqHook.afterGetDistanceSq(var1, var3, var5);
            }
        }

        return var10;
    }

    protected ServerPlayerBase GetOverwrittenGetDistanceSq(ServerPlayerBase var1) {
        if (this.overrideGetDistanceSqHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetDistanceSqHooks.length; ++var2) {
                if (this.overrideGetDistanceSqHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetDistanceSqHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static float getBrightness(IServerPlayerAPI var0, float var1) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        float var2;
        if (var3 != null && var3.isGetBrightnessModded) {
            var2 = var3.getBrightness(var1);
        } else {
            var2 = var0.localGetBrightness(var1);
        }

        return var2;
    }

    private float getBrightness(float var1) {
        if (this.beforeGetBrightnessHooks != null) {
            for(int var2 = this.beforeGetBrightnessHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetBrightnessHooks[var2].beforeGetBrightness(var1);
            }
        }

        float var4;
        if (this.overrideGetBrightnessHooks != null) {
            var4 = this.overrideGetBrightnessHooks[this.overrideGetBrightnessHooks.length - 1].getBrightness(var1);
        } else {
            var4 = this.player.localGetBrightness(var1);
        }

        if (this.afterGetBrightnessHooks != null) {
            for (ServerPlayerBase afterGetBrightnessHook : this.afterGetBrightnessHooks) {
                afterGetBrightnessHook.afterGetBrightness(var1);
            }
        }

        return var4;
    }

    protected ServerPlayerBase GetOverwrittenGetBrightness(ServerPlayerBase var1) {
        if (this.overrideGetBrightnessHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetBrightnessHooks.length; ++var2) {
                if (this.overrideGetBrightnessHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetBrightnessHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static float getEyeHeight(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        float var1;
        if (var2 != null && var2.isGetEyeHeightModded) {
            var1 = var2.getEyeHeight();
        } else {
            var1 = var0.localGetEyeHeight();
        }

        return var1;
    }

    private float getEyeHeight() {
        if (this.beforeGetEyeHeightHooks != null) {
            for(int var1 = this.beforeGetEyeHeightHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetEyeHeightHooks[var1].beforeGetEyeHeight();
            }
        }

        float var3;
        if (this.overrideGetEyeHeightHooks != null) {
            var3 = this.overrideGetEyeHeightHooks[this.overrideGetEyeHeightHooks.length - 1].getEyeHeight();
        } else {
            var3 = this.player.localGetEyeHeight();
        }

        if (this.afterGetEyeHeightHooks != null) {
            for (ServerPlayerBase afterGetEyeHeightHook : this.afterGetEyeHeightHooks) {
                afterGetEyeHeightHook.afterGetEyeHeight();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenGetEyeHeight(ServerPlayerBase var1) {
        if (this.overrideGetEyeHeightHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideGetEyeHeightHooks.length; ++var2) {
                if (this.overrideGetEyeHeightHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetEyeHeightHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void heal(IServerPlayerAPI var0, float var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isHealModded) {
            var2.heal(var1);
        } else {
            var0.localHeal(var1);
        }

    }

    private void heal(float var1) {
        int var2;
        if (this.beforeHealHooks != null) {
            for(var2 = this.beforeHealHooks.length - 1; var2 >= 0; --var2) {
                this.beforeHealHooks[var2].beforeHeal(var1);
            }
        }

        if (this.overrideHealHooks != null) {
            this.overrideHealHooks[this.overrideHealHooks.length - 1].heal(var1);
        } else {
            this.player.localHeal(var1);
        }

        if (this.afterHealHooks != null) {
            for(var2 = 0; var2 < this.afterHealHooks.length; ++var2) {
                this.afterHealHooks[var2].afterHeal(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenHeal(ServerPlayerBase var1) {
        if (this.overrideHealHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideHealHooks.length; ++var2) {
                if (this.overrideHealHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideHealHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isEntityInsideOpaqueBlock(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsEntityInsideOpaqueBlockModded) {
            var1 = var2.isEntityInsideOpaqueBlock();
        } else {
            var1 = var0.localIsEntityInsideOpaqueBlock();
        }

        return var1;
    }

    private boolean isEntityInsideOpaqueBlock() {
        if (this.beforeIsEntityInsideOpaqueBlockHooks != null) {
            for(int var1 = this.beforeIsEntityInsideOpaqueBlockHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsEntityInsideOpaqueBlockHooks[var1].beforeIsEntityInsideOpaqueBlock();
            }
        }

        boolean var3;
        if (this.overrideIsEntityInsideOpaqueBlockHooks != null) {
            var3 = this.overrideIsEntityInsideOpaqueBlockHooks[this.overrideIsEntityInsideOpaqueBlockHooks.length - 1].isEntityInsideOpaqueBlock();
        } else {
            var3 = this.player.localIsEntityInsideOpaqueBlock();
        }

        if (this.afterIsEntityInsideOpaqueBlockHooks != null) {
            for (ServerPlayerBase afterIsEntityInsideOpaqueBlockHook : this.afterIsEntityInsideOpaqueBlockHooks) {
                afterIsEntityInsideOpaqueBlockHook.afterIsEntityInsideOpaqueBlock();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(ServerPlayerBase var1) {
        if (this.overrideIsEntityInsideOpaqueBlockHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsEntityInsideOpaqueBlockHooks.length; ++var2) {
                if (this.overrideIsEntityInsideOpaqueBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsEntityInsideOpaqueBlockHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isInWater(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsInWaterModded) {
            var1 = var2.isInWater();
        } else {
            var1 = var0.localIsInWater();
        }

        return var1;
    }

    private boolean isInWater() {
        if (this.beforeIsInWaterHooks != null) {
            for(int var1 = this.beforeIsInWaterHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsInWaterHooks[var1].beforeIsInWater();
            }
        }

        boolean var3;
        if (this.overrideIsInWaterHooks != null) {
            var3 = this.overrideIsInWaterHooks[this.overrideIsInWaterHooks.length - 1].isInWater();
        } else {
            var3 = this.player.localIsInWater();
        }

        if (this.afterIsInWaterHooks != null) {
            for (ServerPlayerBase afterIsInWaterHook : this.afterIsInWaterHooks) {
                afterIsInWaterHook.afterIsInWater();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenIsInWater(ServerPlayerBase var1) {
        if (this.overrideIsInWaterHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsInWaterHooks.length; ++var2) {
                if (this.overrideIsInWaterHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsInWaterHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isInsideOfMaterial(IServerPlayerAPI var0, Material var1) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        boolean var2;
        if (var3 != null && var3.isIsInsideOfMaterialModded) {
            var2 = var3.isInsideOfMaterial(var1);
        } else {
            var2 = var0.localIsInsideOfMaterial(var1);
        }

        return var2;
    }

    private boolean isInsideOfMaterial(Material var1) {
        if (this.beforeIsInsideOfMaterialHooks != null) {
            for(int var2 = this.beforeIsInsideOfMaterialHooks.length - 1; var2 >= 0; --var2) {
                this.beforeIsInsideOfMaterialHooks[var2].beforeIsInsideOfMaterial(var1);
            }
        }

        boolean var4;
        if (this.overrideIsInsideOfMaterialHooks != null) {
            var4 = this.overrideIsInsideOfMaterialHooks[this.overrideIsInsideOfMaterialHooks.length - 1].isInsideOfMaterial(var1);
        } else {
            var4 = this.player.localIsInsideOfMaterial(var1);
        }

        if (this.afterIsInsideOfMaterialHooks != null) {
            for (ServerPlayerBase afterIsInsideOfMaterialHook : this.afterIsInsideOfMaterialHooks) {
                afterIsInsideOfMaterialHook.afterIsInsideOfMaterial(var1);
            }
        }

        return var4;
    }

    protected ServerPlayerBase GetOverwrittenIsInsideOfMaterial(ServerPlayerBase var1) {
        if (this.overrideIsInsideOfMaterialHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsInsideOfMaterialHooks.length; ++var2) {
                if (this.overrideIsInsideOfMaterialHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsInsideOfMaterialHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isOnLadder(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsOnLadderModded) {
            var1 = var2.isOnLadder();
        } else {
            var1 = var0.localIsOnLadder();
        }

        return var1;
    }

    private boolean isOnLadder() {
        if (this.beforeIsOnLadderHooks != null) {
            for(int var1 = this.beforeIsOnLadderHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsOnLadderHooks[var1].beforeIsOnLadder();
            }
        }

        boolean var3;
        if (this.overrideIsOnLadderHooks != null) {
            var3 = this.overrideIsOnLadderHooks[this.overrideIsOnLadderHooks.length - 1].isOnLadder();
        } else {
            var3 = this.player.localIsOnLadder();
        }

        if (this.afterIsOnLadderHooks != null) {
            for (ServerPlayerBase afterIsOnLadderHook : this.afterIsOnLadderHooks) {
                afterIsOnLadderHook.afterIsOnLadder();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenIsOnLadder(ServerPlayerBase var1) {
        if (this.overrideIsOnLadderHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsOnLadderHooks.length; ++var2) {
                if (this.overrideIsOnLadderHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsOnLadderHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isPlayerSleeping(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsPlayerSleepingModded) {
            var1 = var2.isPlayerSleeping();
        } else {
            var1 = var0.localIsPlayerSleeping();
        }

        return var1;
    }

    private boolean isPlayerSleeping() {
        if (this.beforeIsPlayerSleepingHooks != null) {
            for(int var1 = this.beforeIsPlayerSleepingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsPlayerSleepingHooks[var1].beforeIsPlayerSleeping();
            }
        }

        boolean var3;
        if (this.overrideIsPlayerSleepingHooks != null) {
            var3 = this.overrideIsPlayerSleepingHooks[this.overrideIsPlayerSleepingHooks.length - 1].isPlayerSleeping();
        } else {
            var3 = this.player.localIsPlayerSleeping();
        }

        if (this.afterIsPlayerSleepingHooks != null) {
            for (ServerPlayerBase afterIsPlayerSleepingHook : this.afterIsPlayerSleepingHooks) {
                afterIsPlayerSleepingHook.afterIsPlayerSleeping();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenIsPlayerSleeping(ServerPlayerBase var1) {
        if (this.overrideIsPlayerSleepingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsPlayerSleepingHooks.length; ++var2) {
                if (this.overrideIsPlayerSleepingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsPlayerSleepingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static boolean isSneaking(IServerPlayerAPI var0) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsSneakingModded) {
            var1 = var2.isSneaking();
        } else {
            var1 = var0.localIsSneaking();
        }

        return var1;
    }

    private boolean isSneaking() {
        if (this.beforeIsSneakingHooks != null) {
            for(int var1 = this.beforeIsSneakingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsSneakingHooks[var1].beforeIsSneaking();
            }
        }

        boolean var3;
        if (this.overrideIsSneakingHooks != null) {
            var3 = this.overrideIsSneakingHooks[this.overrideIsSneakingHooks.length - 1].isSneaking();
        } else {
            var3 = this.player.localIsSneaking();
        }

        if (this.afterIsSneakingHooks != null) {
            for (ServerPlayerBase afterIsSneakingHook : this.afterIsSneakingHooks) {
                afterIsSneakingHook.afterIsSneaking();
            }
        }

        return var3;
    }

    protected ServerPlayerBase GetOverwrittenIsSneaking(ServerPlayerBase var1) {
        if (this.overrideIsSneakingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideIsSneakingHooks.length; ++var2) {
                if (this.overrideIsSneakingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsSneakingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void jump(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isJumpModded) {
            var1.jump();
        } else {
            var0.localJump();
        }

    }

    private void jump() {
        int var1;
        if (this.beforeJumpHooks != null) {
            for(var1 = this.beforeJumpHooks.length - 1; var1 >= 0; --var1) {
                this.beforeJumpHooks[var1].beforeJump();
            }
        }

        if (this.overrideJumpHooks != null) {
            this.overrideJumpHooks[this.overrideJumpHooks.length - 1].jump();
        } else {
            this.player.localJump();
        }

        if (this.afterJumpHooks != null) {
            for(var1 = 0; var1 < this.afterJumpHooks.length; ++var1) {
                this.afterJumpHooks[var1].afterJump();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenJump(ServerPlayerBase var1) {
        if (this.overrideJumpHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideJumpHooks.length; ++var2) {
                if (this.overrideJumpHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideJumpHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void knockBack(IServerPlayerAPI var0, Entity var1, float var2, double var3, double var5) {
        ServerPlayerAPI var7 = var0.getServerPlayerAPI();
        if (var7 != null && var7.isKnockBackModded) {
            var7.knockBack(var1, var2, var3, var5);
        } else {
            var0.localKnockBack(var1, var2, var3, var5);
        }

    }

    private void knockBack(Entity var1, float var2, double var3, double var5) {
        int var7;
        if (this.beforeKnockBackHooks != null) {
            for(var7 = this.beforeKnockBackHooks.length - 1; var7 >= 0; --var7) {
                this.beforeKnockBackHooks[var7].beforeKnockBack(var1, var2, var3, var5);
            }
        }

        if (this.overrideKnockBackHooks != null) {
            this.overrideKnockBackHooks[this.overrideKnockBackHooks.length - 1].knockBack(var1, var2, var3, var5);
        } else {
            this.player.localKnockBack(var1, var2, var3, var5);
        }

        if (this.afterKnockBackHooks != null) {
            for(var7 = 0; var7 < this.afterKnockBackHooks.length; ++var7) {
                this.afterKnockBackHooks[var7].afterKnockBack(var1, var2, var3, var5);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenKnockBack(ServerPlayerBase var1) {
        if (this.overrideKnockBackHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideKnockBackHooks.length; ++var2) {
                if (this.overrideKnockBackHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideKnockBackHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void mountEntity(IServerPlayerAPI var0, Entity var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isMountEntityModded) {
            var2.mountEntity(var1);
        } else {
            var0.localMountEntity(var1);
        }

    }

    private void mountEntity(Entity var1) {
        int var2;
        if (this.beforeMountEntityHooks != null) {
            for(var2 = this.beforeMountEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeMountEntityHooks[var2].beforeMountEntity(var1);
            }
        }

        if (this.overrideMountEntityHooks != null) {
            this.overrideMountEntityHooks[this.overrideMountEntityHooks.length - 1].mountEntity(var1);
        } else {
            this.player.localMountEntity(var1);
        }

        if (this.afterMountEntityHooks != null) {
            for(var2 = 0; var2 < this.afterMountEntityHooks.length; ++var2) {
                this.afterMountEntityHooks[var2].afterMountEntity(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenMountEntity(ServerPlayerBase var1) {
        if (this.overrideMountEntityHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideMountEntityHooks.length; ++var2) {
                if (this.overrideMountEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMountEntityHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void moveEntity(IServerPlayerAPI var0, double var1, double var3, double var5) {
        ServerPlayerAPI var7 = var0.getServerPlayerAPI();
        if (var7 != null && var7.isMoveEntityModded) {
            var7.moveEntity(var1, var3, var5);
        } else {
            var0.localMoveEntity(var1, var3, var5);
        }

    }

    private void moveEntity(double var1, double var3, double var5) {
        int var7;
        if (this.beforeMoveEntityHooks != null) {
            for(var7 = this.beforeMoveEntityHooks.length - 1; var7 >= 0; --var7) {
                this.beforeMoveEntityHooks[var7].beforeMoveEntity(var1, var3, var5);
            }
        }

        if (this.overrideMoveEntityHooks != null) {
            this.overrideMoveEntityHooks[this.overrideMoveEntityHooks.length - 1].moveEntity(var1, var3, var5);
        } else {
            this.player.localMoveEntity(var1, var3, var5);
        }

        if (this.afterMoveEntityHooks != null) {
            for(var7 = 0; var7 < this.afterMoveEntityHooks.length; ++var7) {
                this.afterMoveEntityHooks[var7].afterMoveEntity(var1, var3, var5);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenMoveEntity(ServerPlayerBase var1) {
        if (this.overrideMoveEntityHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideMoveEntityHooks.length; ++var2) {
                if (this.overrideMoveEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveEntityHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void moveEntityWithHeading(IServerPlayerAPI var0, float var1, float var2) {
        ServerPlayerAPI var3 = var0.getServerPlayerAPI();
        if (var3 != null && var3.isMoveEntityWithHeadingModded) {
            var3.moveEntityWithHeading(var1, var2);
        } else {
            var0.localMoveEntityWithHeading(var1, var2);
        }

    }

    private void moveEntityWithHeading(float var1, float var2) {
        int var3;
        if (this.beforeMoveEntityWithHeadingHooks != null) {
            for(var3 = this.beforeMoveEntityWithHeadingHooks.length - 1; var3 >= 0; --var3) {
                this.beforeMoveEntityWithHeadingHooks[var3].beforeMoveEntityWithHeading(var1, var2);
            }
        }

        if (this.overrideMoveEntityWithHeadingHooks != null) {
            this.overrideMoveEntityWithHeadingHooks[this.overrideMoveEntityWithHeadingHooks.length - 1].moveEntityWithHeading(var1, var2);
        } else {
            this.player.localMoveEntityWithHeading(var1, var2);
        }

        if (this.afterMoveEntityWithHeadingHooks != null) {
            for(var3 = 0; var3 < this.afterMoveEntityWithHeadingHooks.length; ++var3) {
                this.afterMoveEntityWithHeadingHooks[var3].afterMoveEntityWithHeading(var1, var2);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenMoveEntityWithHeading(ServerPlayerBase var1) {
        if (this.overrideMoveEntityWithHeadingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideMoveEntityWithHeadingHooks.length; ++var2) {
                if (this.overrideMoveEntityWithHeadingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveEntityWithHeadingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void moveFlying(IServerPlayerAPI var0, float var1, float var2, float var3) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        if (var4 != null && var4.isMoveFlyingModded) {
            var4.moveFlying(var1, var2, var3);
        } else {
            var0.localMoveFlying(var1, var2, var3);
        }

    }

    private void moveFlying(float var1, float var2, float var3) {
        int var4;
        if (this.beforeMoveFlyingHooks != null) {
            for(var4 = this.beforeMoveFlyingHooks.length - 1; var4 >= 0; --var4) {
                this.beforeMoveFlyingHooks[var4].beforeMoveFlying(var1, var2, var3);
            }
        }

        if (this.overrideMoveFlyingHooks != null) {
            this.overrideMoveFlyingHooks[this.overrideMoveFlyingHooks.length - 1].moveFlying(var1, var2, var3);
        } else {
            this.player.localMoveFlying(var1, var2, var3);
        }

        if (this.afterMoveFlyingHooks != null) {
            for(var4 = 0; var4 < this.afterMoveFlyingHooks.length; ++var4) {
                this.afterMoveFlyingHooks[var4].afterMoveFlying(var1, var2, var3);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenMoveFlying(ServerPlayerBase var1) {
        if (this.overrideMoveFlyingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideMoveFlyingHooks.length; ++var2) {
                if (this.overrideMoveFlyingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveFlyingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onDeath(IServerPlayerAPI var0, DamageSource var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isOnDeathModded) {
            var2.onDeath(var1);
        } else {
            var0.localOnDeath(var1);
        }

    }

    private void onDeath(DamageSource var1) {
        int var2;
        if (this.beforeOnDeathHooks != null) {
            for(var2 = this.beforeOnDeathHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnDeathHooks[var2].beforeOnDeath(var1);
            }
        }

        if (this.overrideOnDeathHooks != null) {
            this.overrideOnDeathHooks[this.overrideOnDeathHooks.length - 1].onDeath(var1);
        } else {
            this.player.localOnDeath(var1);
        }

        if (this.afterOnDeathHooks != null) {
            for(var2 = 0; var2 < this.afterOnDeathHooks.length; ++var2) {
                this.afterOnDeathHooks[var2].afterOnDeath(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnDeath(ServerPlayerBase var1) {
        if (this.overrideOnDeathHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnDeathHooks.length; ++var2) {
                if (this.overrideOnDeathHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnDeathHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onLivingUpdate(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isOnLivingUpdateModded) {
            var1.onLivingUpdate();
        } else {
            var0.localOnLivingUpdate();
        }

    }

    private void onLivingUpdate() {
        int var1;
        if (this.beforeOnLivingUpdateHooks != null) {
            for(var1 = this.beforeOnLivingUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnLivingUpdateHooks[var1].beforeOnLivingUpdate();
            }
        }

        if (this.overrideOnLivingUpdateHooks != null) {
            this.overrideOnLivingUpdateHooks[this.overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
        } else {
            this.player.localOnLivingUpdate();
        }

        if (this.afterOnLivingUpdateHooks != null) {
            for(var1 = 0; var1 < this.afterOnLivingUpdateHooks.length; ++var1) {
                this.afterOnLivingUpdateHooks[var1].afterOnLivingUpdate();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnLivingUpdate(ServerPlayerBase var1) {
        if (this.overrideOnLivingUpdateHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnLivingUpdateHooks.length; ++var2) {
                if (this.overrideOnLivingUpdateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnLivingUpdateHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onKillEntity(IServerPlayerAPI var0, EntityLivingBase var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isOnKillEntityModded) {
            var2.onKillEntity(var1);
        } else {
            var0.localOnKillEntity(var1);
        }

    }

    private void onKillEntity(EntityLivingBase var1) {
        int var2;
        if (this.beforeOnKillEntityHooks != null) {
            for(var2 = this.beforeOnKillEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnKillEntityHooks[var2].beforeOnKillEntity(var1);
            }
        }

        if (this.overrideOnKillEntityHooks != null) {
            this.overrideOnKillEntityHooks[this.overrideOnKillEntityHooks.length - 1].onKillEntity(var1);
        } else {
            this.player.localOnKillEntity(var1);
        }

        if (this.afterOnKillEntityHooks != null) {
            for(var2 = 0; var2 < this.afterOnKillEntityHooks.length; ++var2) {
                this.afterOnKillEntityHooks[var2].afterOnKillEntity(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnKillEntity(ServerPlayerBase var1) {
        if (this.overrideOnKillEntityHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnKillEntityHooks.length; ++var2) {
                if (this.overrideOnKillEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnKillEntityHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onStruckByLightning(IServerPlayerAPI var0, EntityLightningBolt var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isOnStruckByLightningModded) {
            var2.onStruckByLightning(var1);
        } else {
            var0.localOnStruckByLightning(var1);
        }

    }

    private void onStruckByLightning(EntityLightningBolt var1) {
        int var2;
        if (this.beforeOnStruckByLightningHooks != null) {
            for(var2 = this.beforeOnStruckByLightningHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnStruckByLightningHooks[var2].beforeOnStruckByLightning(var1);
            }
        }

        if (this.overrideOnStruckByLightningHooks != null) {
            this.overrideOnStruckByLightningHooks[this.overrideOnStruckByLightningHooks.length - 1].onStruckByLightning(var1);
        } else {
            this.player.localOnStruckByLightning(var1);
        }

        if (this.afterOnStruckByLightningHooks != null) {
            for(var2 = 0; var2 < this.afterOnStruckByLightningHooks.length; ++var2) {
                this.afterOnStruckByLightningHooks[var2].afterOnStruckByLightning(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnStruckByLightning(ServerPlayerBase var1) {
        if (this.overrideOnStruckByLightningHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnStruckByLightningHooks.length; ++var2) {
                if (this.overrideOnStruckByLightningHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnStruckByLightningHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onUpdate(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isOnUpdateModded) {
            var1.onUpdate();
        } else {
            var0.localOnUpdate();
        }

    }

    private void onUpdate() {
        int var1;
        if (this.beforeOnUpdateHooks != null) {
            for(var1 = this.beforeOnUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnUpdateHooks[var1].beforeOnUpdate();
            }
        }

        if (this.overrideOnUpdateHooks != null) {
            this.overrideOnUpdateHooks[this.overrideOnUpdateHooks.length - 1].onUpdate();
        } else {
            this.player.localOnUpdate();
        }

        if (this.afterOnUpdateHooks != null) {
            for(var1 = 0; var1 < this.afterOnUpdateHooks.length; ++var1) {
                this.afterOnUpdateHooks[var1].afterOnUpdate();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnUpdate(ServerPlayerBase var1) {
        if (this.overrideOnUpdateHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnUpdateHooks.length; ++var2) {
                if (this.overrideOnUpdateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnUpdateHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void onUpdateEntity(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isOnUpdateEntityModded) {
            var1.onUpdateEntity();
        } else {
            var0.localOnUpdateEntity();
        }

    }

    private void onUpdateEntity() {
        int var1;
        if (this.beforeOnUpdateEntityHooks != null) {
            for(var1 = this.beforeOnUpdateEntityHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnUpdateEntityHooks[var1].beforeOnUpdateEntity();
            }
        }

        if (this.overrideOnUpdateEntityHooks != null) {
            this.overrideOnUpdateEntityHooks[this.overrideOnUpdateEntityHooks.length - 1].onUpdateEntity();
        } else {
            this.player.localOnUpdateEntity();
        }

        if (this.afterOnUpdateEntityHooks != null) {
            for(var1 = 0; var1 < this.afterOnUpdateEntityHooks.length; ++var1) {
                this.afterOnUpdateEntityHooks[var1].afterOnUpdateEntity();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenOnUpdateEntity(ServerPlayerBase var1) {
        if (this.overrideOnUpdateEntityHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideOnUpdateEntityHooks.length; ++var2) {
                if (this.overrideOnUpdateEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnUpdateEntityHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void readEntityFromNBT(IServerPlayerAPI var0, NBTTagCompound var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isReadEntityFromNBTModded) {
            var2.readEntityFromNBT(var1);
        } else {
            var0.localReadEntityFromNBT(var1);
        }

    }

    private void readEntityFromNBT(NBTTagCompound var1) {
        int var2;
        if (this.beforeReadEntityFromNBTHooks != null) {
            for(var2 = this.beforeReadEntityFromNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeReadEntityFromNBTHooks[var2].beforeReadEntityFromNBT(var1);
            }
        }

        if (this.overrideReadEntityFromNBTHooks != null) {
            this.overrideReadEntityFromNBTHooks[this.overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(var1);
        } else {
            this.player.localReadEntityFromNBT(var1);
        }

        if (this.afterReadEntityFromNBTHooks != null) {
            for(var2 = 0; var2 < this.afterReadEntityFromNBTHooks.length; ++var2) {
                this.afterReadEntityFromNBTHooks[var2].afterReadEntityFromNBT(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenReadEntityFromNBT(ServerPlayerBase var1) {
        if (this.overrideReadEntityFromNBTHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideReadEntityFromNBTHooks.length; ++var2) {
                if (this.overrideReadEntityFromNBTHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideReadEntityFromNBTHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void setDead(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isSetDeadModded) {
            var1.setDead();
        } else {
            var0.localSetDead();
        }

    }

    private void setDead() {
        int var1;
        if (this.beforeSetDeadHooks != null) {
            for(var1 = this.beforeSetDeadHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSetDeadHooks[var1].beforeSetDead();
            }
        }

        if (this.overrideSetDeadHooks != null) {
            this.overrideSetDeadHooks[this.overrideSetDeadHooks.length - 1].setDead();
        } else {
            this.player.localSetDead();
        }

        if (this.afterSetDeadHooks != null) {
            for(var1 = 0; var1 < this.afterSetDeadHooks.length; ++var1) {
                this.afterSetDeadHooks[var1].afterSetDead();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSetDead(ServerPlayerBase var1) {
        if (this.overrideSetDeadHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSetDeadHooks.length; ++var2) {
                if (this.overrideSetDeadHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetDeadHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void setEntityActionState(IServerPlayerAPI var0, float var1, float var2, boolean var3, boolean var4) {
        ServerPlayerAPI var5 = var0.getServerPlayerAPI();
        if (var5 != null && var5.isSetEntityActionStateModded) {
            var5.setEntityActionState(var1, var2, var3, var4);
        } else {
            var0.localSetEntityActionState(var1, var2, var3, var4);
        }

    }

    private void setEntityActionState(float var1, float var2, boolean var3, boolean var4) {
        int var5;
        if (this.beforeSetEntityActionStateHooks != null) {
            for(var5 = this.beforeSetEntityActionStateHooks.length - 1; var5 >= 0; --var5) {
                this.beforeSetEntityActionStateHooks[var5].beforeSetEntityActionState(var1, var2, var3, var4);
            }
        }

        if (this.overrideSetEntityActionStateHooks != null) {
            this.overrideSetEntityActionStateHooks[this.overrideSetEntityActionStateHooks.length - 1].setEntityActionState(var1, var2, var3, var4);
        } else {
            this.player.localSetEntityActionState(var1, var2, var3, var4);
        }

        if (this.afterSetEntityActionStateHooks != null) {
            for(var5 = 0; var5 < this.afterSetEntityActionStateHooks.length; ++var5) {
                this.afterSetEntityActionStateHooks[var5].afterSetEntityActionState(var1, var2, var3, var4);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSetEntityActionState(ServerPlayerBase var1) {
        if (this.overrideSetEntityActionStateHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSetEntityActionStateHooks.length; ++var2) {
                if (this.overrideSetEntityActionStateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetEntityActionStateHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void setPosition(IServerPlayerAPI var0, double var1, double var3, double var5) {
        ServerPlayerAPI var7 = var0.getServerPlayerAPI();
        if (var7 != null && var7.isSetPositionModded) {
            var7.setPosition(var1, var3, var5);
        } else {
            var0.localSetPosition(var1, var3, var5);
        }

    }

    private void setPosition(double var1, double var3, double var5) {
        int var7;
        if (this.beforeSetPositionHooks != null) {
            for(var7 = this.beforeSetPositionHooks.length - 1; var7 >= 0; --var7) {
                this.beforeSetPositionHooks[var7].beforeSetPosition(var1, var3, var5);
            }
        }

        if (this.overrideSetPositionHooks != null) {
            this.overrideSetPositionHooks[this.overrideSetPositionHooks.length - 1].setPosition(var1, var3, var5);
        } else {
            this.player.localSetPosition(var1, var3, var5);
        }

        if (this.afterSetPositionHooks != null) {
            for(var7 = 0; var7 < this.afterSetPositionHooks.length; ++var7) {
                this.afterSetPositionHooks[var7].afterSetPosition(var1, var3, var5);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSetPosition(ServerPlayerBase var1) {
        if (this.overrideSetPositionHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSetPositionHooks.length; ++var2) {
                if (this.overrideSetPositionHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetPositionHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void setSneaking(IServerPlayerAPI var0, boolean var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isSetSneakingModded) {
            var2.setSneaking(var1);
        } else {
            var0.localSetSneaking(var1);
        }

    }

    private void setSneaking(boolean var1) {
        int var2;
        if (this.beforeSetSneakingHooks != null) {
            for(var2 = this.beforeSetSneakingHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetSneakingHooks[var2].beforeSetSneaking(var1);
            }
        }

        if (this.overrideSetSneakingHooks != null) {
            this.overrideSetSneakingHooks[this.overrideSetSneakingHooks.length - 1].setSneaking(var1);
        } else {
            this.player.localSetSneaking(var1);
        }

        if (this.afterSetSneakingHooks != null) {
            for(var2 = 0; var2 < this.afterSetSneakingHooks.length; ++var2) {
                this.afterSetSneakingHooks[var2].afterSetSneaking(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSetSneaking(ServerPlayerBase var1) {
        if (this.overrideSetSneakingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSetSneakingHooks.length; ++var2) {
                if (this.overrideSetSneakingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetSneakingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void setSprinting(IServerPlayerAPI var0, boolean var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isSetSprintingModded) {
            var2.setSprinting(var1);
        } else {
            var0.localSetSprinting(var1);
        }

    }

    private void setSprinting(boolean var1) {
        int var2;
        if (this.beforeSetSprintingHooks != null) {
            for(var2 = this.beforeSetSprintingHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetSprintingHooks[var2].beforeSetSprinting(var1);
            }
        }

        if (this.overrideSetSprintingHooks != null) {
            this.overrideSetSprintingHooks[this.overrideSetSprintingHooks.length - 1].setSprinting(var1);
        } else {
            this.player.localSetSprinting(var1);
        }

        if (this.afterSetSprintingHooks != null) {
            for(var2 = 0; var2 < this.afterSetSprintingHooks.length; ++var2) {
                this.afterSetSprintingHooks[var2].afterSetSprinting(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSetSprinting(ServerPlayerBase var1) {
        if (this.overrideSetSprintingHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSetSprintingHooks.length; ++var2) {
                if (this.overrideSetSprintingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetSprintingHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void swingItem(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isSwingItemModded) {
            var1.swingItem();
        } else {
            var0.localSwingItem();
        }

    }

    private void swingItem() {
        int var1;
        if (this.beforeSwingItemHooks != null) {
            for(var1 = this.beforeSwingItemHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSwingItemHooks[var1].beforeSwingItem();
            }
        }

        if (this.overrideSwingItemHooks != null) {
            this.overrideSwingItemHooks[this.overrideSwingItemHooks.length - 1].swingItem();
        } else {
            this.player.localSwingItem();
        }

        if (this.afterSwingItemHooks != null) {
            for(var1 = 0; var1 < this.afterSwingItemHooks.length; ++var1) {
                this.afterSwingItemHooks[var1].afterSwingItem();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenSwingItem(ServerPlayerBase var1) {
        if (this.overrideSwingItemHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideSwingItemHooks.length; ++var2) {
                if (this.overrideSwingItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSwingItemHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void updateEntityActionState(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isUpdateEntityActionStateModded) {
            var1.updateEntityActionState();
        } else {
            var0.localUpdateEntityActionState();
        }

    }

    private void updateEntityActionState() {
        int var1;
        if (this.beforeUpdateEntityActionStateHooks != null) {
            for(var1 = this.beforeUpdateEntityActionStateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdateEntityActionStateHooks[var1].beforeUpdateEntityActionState();
            }
        }

        if (this.overrideUpdateEntityActionStateHooks != null) {
            this.overrideUpdateEntityActionStateHooks[this.overrideUpdateEntityActionStateHooks.length - 1].updateEntityActionState();
        } else {
            this.player.localUpdateEntityActionState();
        }

        if (this.afterUpdateEntityActionStateHooks != null) {
            for(var1 = 0; var1 < this.afterUpdateEntityActionStateHooks.length; ++var1) {
                this.afterUpdateEntityActionStateHooks[var1].afterUpdateEntityActionState();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenUpdateEntityActionState(ServerPlayerBase var1) {
        if (this.overrideUpdateEntityActionStateHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideUpdateEntityActionStateHooks.length; ++var2) {
                if (this.overrideUpdateEntityActionStateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideUpdateEntityActionStateHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void updatePotionEffects(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isUpdatePotionEffectsModded) {
            var1.updatePotionEffects();
        } else {
            var0.localUpdatePotionEffects();
        }

    }

    private void updatePotionEffects() {
        int var1;
        if (this.beforeUpdatePotionEffectsHooks != null) {
            for(var1 = this.beforeUpdatePotionEffectsHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdatePotionEffectsHooks[var1].beforeUpdatePotionEffects();
            }
        }

        if (this.overrideUpdatePotionEffectsHooks != null) {
            this.overrideUpdatePotionEffectsHooks[this.overrideUpdatePotionEffectsHooks.length - 1].updatePotionEffects();
        } else {
            this.player.localUpdatePotionEffects();
        }

        if (this.afterUpdatePotionEffectsHooks != null) {
            for(var1 = 0; var1 < this.afterUpdatePotionEffectsHooks.length; ++var1) {
                this.afterUpdatePotionEffectsHooks[var1].afterUpdatePotionEffects();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenUpdatePotionEffects(ServerPlayerBase var1) {
        if (this.overrideUpdatePotionEffectsHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideUpdatePotionEffectsHooks.length; ++var2) {
                if (this.overrideUpdatePotionEffectsHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideUpdatePotionEffectsHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void updateRidden(IServerPlayerAPI var0) {
        ServerPlayerAPI var1 = var0.getServerPlayerAPI();
        if (var1 != null && var1.isUpdateRiddenModded) {
            var1.updateRidden();
        } else {
            var0.localUpdateRidden();
        }

    }

    private void updateRidden() {
        int var1;
        if (this.beforeUpdateRiddenHooks != null) {
            for(var1 = this.beforeUpdateRiddenHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdateRiddenHooks[var1].beforeUpdateRidden();
            }
        }

        if (this.overrideUpdateRiddenHooks != null) {
            this.overrideUpdateRiddenHooks[this.overrideUpdateRiddenHooks.length - 1].updateRidden();
        } else {
            this.player.localUpdateRidden();
        }

        if (this.afterUpdateRiddenHooks != null) {
            for(var1 = 0; var1 < this.afterUpdateRiddenHooks.length; ++var1) {
                this.afterUpdateRiddenHooks[var1].afterUpdateRidden();
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenUpdateRidden(ServerPlayerBase var1) {
        if (this.overrideUpdateRiddenHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideUpdateRiddenHooks.length; ++var2) {
                if (this.overrideUpdateRiddenHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideUpdateRiddenHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void wakeUpPlayer(IServerPlayerAPI var0, boolean var1, boolean var2, boolean var3) {
        ServerPlayerAPI var4 = var0.getServerPlayerAPI();
        if (var4 != null && var4.isWakeUpPlayerModded) {
            var4.wakeUpPlayer(var1, var2, var3);
        } else {
            var0.localWakeUpPlayer(var1, var2, var3);
        }

    }

    private void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
        int var4;
        if (this.beforeWakeUpPlayerHooks != null) {
            for(var4 = this.beforeWakeUpPlayerHooks.length - 1; var4 >= 0; --var4) {
                this.beforeWakeUpPlayerHooks[var4].beforeWakeUpPlayer(var1, var2, var3);
            }
        }

        if (this.overrideWakeUpPlayerHooks != null) {
            this.overrideWakeUpPlayerHooks[this.overrideWakeUpPlayerHooks.length - 1].wakeUpPlayer(var1, var2, var3);
        } else {
            this.player.localWakeUpPlayer(var1, var2, var3);
        }

        if (this.afterWakeUpPlayerHooks != null) {
            for(var4 = 0; var4 < this.afterWakeUpPlayerHooks.length; ++var4) {
                this.afterWakeUpPlayerHooks[var4].afterWakeUpPlayer(var1, var2, var3);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenWakeUpPlayer(ServerPlayerBase var1) {
        if (this.overrideWakeUpPlayerHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideWakeUpPlayerHooks.length; ++var2) {
                if (this.overrideWakeUpPlayerHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideWakeUpPlayerHooks[var2 - 1];
                }
            }

            return var1;
        }
    }

    public static void writeEntityToNBT(IServerPlayerAPI var0, NBTTagCompound var1) {
        ServerPlayerAPI var2 = var0.getServerPlayerAPI();
        if (var2 != null && var2.isWriteEntityToNBTModded) {
            var2.writeEntityToNBT(var1);
        } else {
            var0.localWriteEntityToNBT(var1);
        }

    }

    private void writeEntityToNBT(NBTTagCompound var1) {
        int var2;
        if (this.beforeWriteEntityToNBTHooks != null) {
            for(var2 = this.beforeWriteEntityToNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeWriteEntityToNBTHooks[var2].beforeWriteEntityToNBT(var1);
            }
        }

        if (this.overrideWriteEntityToNBTHooks != null) {
            this.overrideWriteEntityToNBTHooks[this.overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(var1);
        } else {
            this.player.localWriteEntityToNBT(var1);
        }

        if (this.afterWriteEntityToNBTHooks != null) {
            for(var2 = 0; var2 < this.afterWriteEntityToNBTHooks.length; ++var2) {
                this.afterWriteEntityToNBTHooks[var2].afterWriteEntityToNBT(var1);
            }
        }

    }

    protected ServerPlayerBase GetOverwrittenWriteEntityToNBT(ServerPlayerBase var1) {
        if (this.overrideWriteEntityToNBTHooks == null) {
            return var1;
        } else {
            for(int var2 = 0; var2 < this.overrideWriteEntityToNBTHooks.length; ++var2) {
                if (this.overrideWriteEntityToNBTHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideWriteEntityToNBTHooks[var2 - 1];
                }
            }

            return var1;
        }
    }
}
