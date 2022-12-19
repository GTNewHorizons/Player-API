package api.player.client;

import api.player.forge.PlayerAPIPlugin;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Session;
import net.minecraft.world.World;

public final class ClientPlayerAPI {

    private static final Class<?>[] Class = new Class[] {ClientPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[] {ClientPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger = Logger.getLogger("ClientPlayerAPI");
    private static final Map<String, String[]> EmptySortMap = Collections.unmodifiableMap(new HashMap<>());
    private static final List<String> beforeAddExhaustionHookTypes = new LinkedList<>();
    private static final List<String> overrideAddExhaustionHookTypes = new LinkedList<>();
    private static final List<String> afterAddExhaustionHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeAddExhaustionHooks;
    private ClientPlayerBase[] overrideAddExhaustionHooks;
    private ClientPlayerBase[] afterAddExhaustionHooks;
    public boolean isAddExhaustionModded;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddExhaustionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddExhaustionInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExhaustionSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddExhaustionInferiors = new Hashtable<>(0);
    private static final List<String> beforeAddMovementStatHookTypes = new LinkedList<>();
    private static final List<String> overrideAddMovementStatHookTypes = new LinkedList<>();
    private static final List<String> afterAddMovementStatHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeAddMovementStatHooks;
    private ClientPlayerBase[] overrideAddMovementStatHooks;
    private ClientPlayerBase[] afterAddMovementStatHooks;
    public boolean isAddMovementStatModded;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddMovementStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddMovementStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddMovementStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddMovementStatInferiors = new Hashtable<>(0);
    private static final List<String> beforeAddStatHookTypes = new LinkedList<>();
    private static final List<String> overrideAddStatHookTypes = new LinkedList<>();
    private static final List<String> afterAddStatHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeAddStatHooks;
    private ClientPlayerBase[] overrideAddStatHooks;
    private ClientPlayerBase[] afterAddStatHooks;
    public boolean isAddStatModded;
    private static final Map<String, String[]> allBaseBeforeAddStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAddStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAddStatInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddStatSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAddStatInferiors = new Hashtable<>(0);
    private static final List<String> beforeAttackEntityFromHookTypes = new LinkedList<>();
    private static final List<String> overrideAttackEntityFromHookTypes = new LinkedList<>();
    private static final List<String> afterAttackEntityFromHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeAttackEntityFromHooks;
    private ClientPlayerBase[] overrideAttackEntityFromHooks;
    private ClientPlayerBase[] afterAttackEntityFromHooks;
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
    private ClientPlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
    private ClientPlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
    private ClientPlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
    public boolean isAttackTargetEntityWithCurrentItemModded;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemInferiors =
            new Hashtable<>(0);
    private static final List<String> beforeCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private static final List<String> overrideCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private static final List<String> afterCanBreatheUnderwaterHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeCanBreatheUnderwaterHooks;
    private ClientPlayerBase[] overrideCanBreatheUnderwaterHooks;
    private ClientPlayerBase[] afterCanBreatheUnderwaterHooks;
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
    private ClientPlayerBase[] beforeCanHarvestBlockHooks;
    private ClientPlayerBase[] overrideCanHarvestBlockHooks;
    private ClientPlayerBase[] afterCanHarvestBlockHooks;
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
    private ClientPlayerBase[] beforeCanPlayerEditHooks;
    private ClientPlayerBase[] overrideCanPlayerEditHooks;
    private ClientPlayerBase[] afterCanPlayerEditHooks;
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
    private ClientPlayerBase[] beforeCanTriggerWalkingHooks;
    private ClientPlayerBase[] overrideCanTriggerWalkingHooks;
    private ClientPlayerBase[] afterCanTriggerWalkingHooks;
    public boolean isCanTriggerWalkingModded;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingInferiors = new Hashtable<>(0);
    private static final List<String> beforeCloseScreenHookTypes = new LinkedList<>();
    private static final List<String> overrideCloseScreenHookTypes = new LinkedList<>();
    private static final List<String> afterCloseScreenHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeCloseScreenHooks;
    private ClientPlayerBase[] overrideCloseScreenHooks;
    private ClientPlayerBase[] afterCloseScreenHooks;
    public boolean isCloseScreenModded;
    private static final Map<String, String[]> allBaseBeforeCloseScreenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeCloseScreenInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCloseScreenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideCloseScreenInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCloseScreenSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterCloseScreenInferiors = new Hashtable<>(0);
    private static final List<String> beforeDamageEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideDamageEntityHookTypes = new LinkedList<>();
    private static final List<String> afterDamageEntityHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDamageEntityHooks;
    private ClientPlayerBase[] overrideDamageEntityHooks;
    private ClientPlayerBase[] afterDamageEntityHooks;
    public boolean isDamageEntityModded;
    private static final Map<String, String[]> allBaseBeforeDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDamageEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDamageEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDamageEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDamageEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIBrewingStandHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIBrewingStandHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIBrewingStandHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDisplayGUIBrewingStandHooks;
    private ClientPlayerBase[] overrideDisplayGUIBrewingStandHooks;
    private ClientPlayerBase[] afterDisplayGUIBrewingStandHooks;
    public boolean isDisplayGUIBrewingStandModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIBrewingStandSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIBrewingStandInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIBrewingStandSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIBrewingStandInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIBrewingStandSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIBrewingStandInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIChestHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIChestHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIChestHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDisplayGUIChestHooks;
    private ClientPlayerBase[] overrideDisplayGUIChestHooks;
    private ClientPlayerBase[] afterDisplayGUIChestHooks;
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
    private ClientPlayerBase[] beforeDisplayGUIDispenserHooks;
    private ClientPlayerBase[] overrideDisplayGUIDispenserHooks;
    private ClientPlayerBase[] afterDisplayGUIDispenserHooks;
    public boolean isDisplayGUIDispenserModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIEditSignHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIEditSignHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIEditSignHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDisplayGUIEditSignHooks;
    private ClientPlayerBase[] overrideDisplayGUIEditSignHooks;
    private ClientPlayerBase[] afterDisplayGUIEditSignHooks;
    public boolean isDisplayGUIEditSignModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEditSignSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEditSignInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEditSignSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEditSignInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIEditSignSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIEditSignInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIEnchantmentHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIEnchantmentHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIEnchantmentHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDisplayGUIEnchantmentHooks;
    private ClientPlayerBase[] overrideDisplayGUIEnchantmentHooks;
    private ClientPlayerBase[] afterDisplayGUIEnchantmentHooks;
    public boolean isDisplayGUIEnchantmentModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEnchantmentSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEnchantmentInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEnchantmentSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEnchantmentInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIEnchantmentSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDisplayGUIEnchantmentInferiors = new Hashtable<>(0);
    private static final List<String> beforeDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private static final List<String> overrideDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private static final List<String> afterDisplayGUIFurnaceHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDisplayGUIFurnaceHooks;
    private ClientPlayerBase[] overrideDisplayGUIFurnaceHooks;
    private ClientPlayerBase[] afterDisplayGUIFurnaceHooks;
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
    private ClientPlayerBase[] beforeDisplayGUIWorkbenchHooks;
    private ClientPlayerBase[] overrideDisplayGUIWorkbenchHooks;
    private ClientPlayerBase[] afterDisplayGUIWorkbenchHooks;
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
    private ClientPlayerBase[] beforeDropOneItemHooks;
    private ClientPlayerBase[] overrideDropOneItemHooks;
    private ClientPlayerBase[] afterDropOneItemHooks;
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
    private ClientPlayerBase[] beforeDropPlayerItemHooks;
    private ClientPlayerBase[] overrideDropPlayerItemHooks;
    private ClientPlayerBase[] afterDropPlayerItemHooks;
    public boolean isDropPlayerItemModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemInferiors = new Hashtable<>(0);
    private static final List<String> beforeDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<>();
    private static final List<String> overrideDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<>();
    private static final List<String> afterDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeDropPlayerItemWithRandomChoiceHooks;
    private ClientPlayerBase[] overrideDropPlayerItemWithRandomChoiceHooks;
    private ClientPlayerBase[] afterDropPlayerItemWithRandomChoiceHooks;
    public boolean isDropPlayerItemWithRandomChoiceModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemWithRandomChoiceInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemWithRandomChoiceInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemWithRandomChoiceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterDropPlayerItemWithRandomChoiceInferiors = new Hashtable<>(0);
    private static final List<String> beforeFallHookTypes = new LinkedList<>();
    private static final List<String> overrideFallHookTypes = new LinkedList<>();
    private static final List<String> afterFallHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeFallHooks;
    private ClientPlayerBase[] overrideFallHooks;
    private ClientPlayerBase[] afterFallHooks;
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
    private ClientPlayerBase[] beforeGetAIMoveSpeedHooks;
    private ClientPlayerBase[] overrideGetAIMoveSpeedHooks;
    private ClientPlayerBase[] afterGetAIMoveSpeedHooks;
    public boolean isGetAIMoveSpeedModded;
    private static final Map<String, String[]> allBaseBeforeGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetAIMoveSpeedSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetAIMoveSpeedInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetBedOrientationInDegreesHookTypes = new LinkedList<>();
    private static final List<String> overrideGetBedOrientationInDegreesHookTypes = new LinkedList<>();
    private static final List<String> afterGetBedOrientationInDegreesHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetBedOrientationInDegreesHooks;
    private ClientPlayerBase[] overrideGetBedOrientationInDegreesHooks;
    private ClientPlayerBase[] afterGetBedOrientationInDegreesHooks;
    public boolean isGetBedOrientationInDegreesModded;
    private static final Map<String, String[]> allBaseBeforeGetBedOrientationInDegreesSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetBedOrientationInDegreesInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBedOrientationInDegreesSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBedOrientationInDegreesInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBedOrientationInDegreesSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBedOrientationInDegreesInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetBrightnessHookTypes = new LinkedList<>();
    private static final List<String> overrideGetBrightnessHookTypes = new LinkedList<>();
    private static final List<String> afterGetBrightnessHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetBrightnessHooks;
    private ClientPlayerBase[] overrideGetBrightnessHooks;
    private ClientPlayerBase[] afterGetBrightnessHooks;
    public boolean isGetBrightnessModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetBrightnessInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetBrightnessForRenderHookTypes = new LinkedList<>();
    private static final List<String> overrideGetBrightnessForRenderHookTypes = new LinkedList<>();
    private static final List<String> afterGetBrightnessForRenderHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetBrightnessForRenderHooks;
    private ClientPlayerBase[] overrideGetBrightnessForRenderHooks;
    private ClientPlayerBase[] afterGetBrightnessForRenderHooks;
    public boolean isGetBrightnessForRenderModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessForRenderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetBrightnessForRenderInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessForRenderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetBrightnessForRenderInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessForRenderSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetBrightnessForRenderInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private static final List<String> overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private static final List<String> afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
    private ClientPlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
    private ClientPlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
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
    private ClientPlayerBase[] beforeGetCurrentPlayerStrVsBlockForgeHooks;
    private ClientPlayerBase[] overrideGetCurrentPlayerStrVsBlockForgeHooks;
    private ClientPlayerBase[] afterGetCurrentPlayerStrVsBlockForgeHooks;
    public boolean isGetCurrentPlayerStrVsBlockForgeModded;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors =
            new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors =
            new Hashtable<>(0);
    private static final List<String> beforeGetDistanceSqHookTypes = new LinkedList<>();
    private static final List<String> overrideGetDistanceSqHookTypes = new LinkedList<>();
    private static final List<String> afterGetDistanceSqHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetDistanceSqHooks;
    private ClientPlayerBase[] overrideGetDistanceSqHooks;
    private ClientPlayerBase[] afterGetDistanceSqHooks;
    public boolean isGetDistanceSqModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetDistanceSqToEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideGetDistanceSqToEntityHookTypes = new LinkedList<>();
    private static final List<String> afterGetDistanceSqToEntityHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetDistanceSqToEntityHooks;
    private ClientPlayerBase[] overrideGetDistanceSqToEntityHooks;
    private ClientPlayerBase[] afterGetDistanceSqToEntityHooks;
    public boolean isGetDistanceSqToEntityModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqToEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqToEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqToEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqToEntityInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqToEntitySuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetDistanceSqToEntityInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetFOVMultiplierHookTypes = new LinkedList<>();
    private static final List<String> overrideGetFOVMultiplierHookTypes = new LinkedList<>();
    private static final List<String> afterGetFOVMultiplierHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetFOVMultiplierHooks;
    private ClientPlayerBase[] overrideGetFOVMultiplierHooks;
    private ClientPlayerBase[] afterGetFOVMultiplierHooks;
    public boolean isGetFOVMultiplierModded;
    private static final Map<String, String[]> allBaseBeforeGetFOVMultiplierSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetFOVMultiplierInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetFOVMultiplierSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetFOVMultiplierInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetFOVMultiplierSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetFOVMultiplierInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetHurtSoundHookTypes = new LinkedList<>();
    private static final List<String> overrideGetHurtSoundHookTypes = new LinkedList<>();
    private static final List<String> afterGetHurtSoundHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetHurtSoundHooks;
    private ClientPlayerBase[] overrideGetHurtSoundHooks;
    private ClientPlayerBase[] afterGetHurtSoundHooks;
    public boolean isGetHurtSoundModded;
    private static final Map<String, String[]> allBaseBeforeGetHurtSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetHurtSoundInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetHurtSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetHurtSoundInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetHurtSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetHurtSoundInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetItemIconHookTypes = new LinkedList<>();
    private static final List<String> overrideGetItemIconHookTypes = new LinkedList<>();
    private static final List<String> afterGetItemIconHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetItemIconHooks;
    private ClientPlayerBase[] overrideGetItemIconHooks;
    private ClientPlayerBase[] afterGetItemIconHooks;
    public boolean isGetItemIconModded;
    private static final Map<String, String[]> allBaseBeforeGetItemIconSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetItemIconInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetItemIconSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetItemIconInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetItemIconSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetItemIconInferiors = new Hashtable<>(0);
    private static final List<String> beforeGetSleepTimerHookTypes = new LinkedList<>();
    private static final List<String> overrideGetSleepTimerHookTypes = new LinkedList<>();
    private static final List<String> afterGetSleepTimerHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeGetSleepTimerHooks;
    private ClientPlayerBase[] overrideGetSleepTimerHooks;
    private ClientPlayerBase[] afterGetSleepTimerHooks;
    public boolean isGetSleepTimerModded;
    private static final Map<String, String[]> allBaseBeforeGetSleepTimerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeGetSleepTimerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetSleepTimerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideGetSleepTimerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetSleepTimerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterGetSleepTimerInferiors = new Hashtable<>(0);
    private static final List<String> beforeHandleLavaMovementHookTypes = new LinkedList<>();
    private static final List<String> overrideHandleLavaMovementHookTypes = new LinkedList<>();
    private static final List<String> afterHandleLavaMovementHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeHandleLavaMovementHooks;
    private ClientPlayerBase[] overrideHandleLavaMovementHooks;
    private ClientPlayerBase[] afterHandleLavaMovementHooks;
    public boolean isHandleLavaMovementModded;
    private static final Map<String, String[]> allBaseBeforeHandleLavaMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeHandleLavaMovementInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHandleLavaMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHandleLavaMovementInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHandleLavaMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHandleLavaMovementInferiors = new Hashtable<>(0);
    private static final List<String> beforeHandleWaterMovementHookTypes = new LinkedList<>();
    private static final List<String> overrideHandleWaterMovementHookTypes = new LinkedList<>();
    private static final List<String> afterHandleWaterMovementHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeHandleWaterMovementHooks;
    private ClientPlayerBase[] overrideHandleWaterMovementHooks;
    private ClientPlayerBase[] afterHandleWaterMovementHooks;
    public boolean isHandleWaterMovementModded;
    private static final Map<String, String[]> allBaseBeforeHandleWaterMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeHandleWaterMovementInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHandleWaterMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideHandleWaterMovementInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHandleWaterMovementSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterHandleWaterMovementInferiors = new Hashtable<>(0);
    private static final List<String> beforeHealHookTypes = new LinkedList<>();
    private static final List<String> overrideHealHookTypes = new LinkedList<>();
    private static final List<String> afterHealHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeHealHooks;
    private ClientPlayerBase[] overrideHealHooks;
    private ClientPlayerBase[] afterHealHooks;
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
    private ClientPlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
    private ClientPlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
    private ClientPlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
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
    private ClientPlayerBase[] beforeIsInWaterHooks;
    private ClientPlayerBase[] overrideIsInWaterHooks;
    private ClientPlayerBase[] afterIsInWaterHooks;
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
    private ClientPlayerBase[] beforeIsInsideOfMaterialHooks;
    private ClientPlayerBase[] overrideIsInsideOfMaterialHooks;
    private ClientPlayerBase[] afterIsInsideOfMaterialHooks;
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
    private ClientPlayerBase[] beforeIsOnLadderHooks;
    private ClientPlayerBase[] overrideIsOnLadderHooks;
    private ClientPlayerBase[] afterIsOnLadderHooks;
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
    private ClientPlayerBase[] beforeIsPlayerSleepingHooks;
    private ClientPlayerBase[] overrideIsPlayerSleepingHooks;
    private ClientPlayerBase[] afterIsPlayerSleepingHooks;
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
    private ClientPlayerBase[] beforeIsSneakingHooks;
    private ClientPlayerBase[] overrideIsSneakingHooks;
    private ClientPlayerBase[] afterIsSneakingHooks;
    public boolean isIsSneakingModded;
    private static final Map<String, String[]> allBaseBeforeIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSneakingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSneakingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSneakingInferiors = new Hashtable<>(0);
    private static final List<String> beforeIsSprintingHookTypes = new LinkedList<>();
    private static final List<String> overrideIsSprintingHookTypes = new LinkedList<>();
    private static final List<String> afterIsSprintingHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeIsSprintingHooks;
    private ClientPlayerBase[] overrideIsSprintingHooks;
    private ClientPlayerBase[] afterIsSprintingHooks;
    public boolean isIsSprintingModded;
    private static final Map<String, String[]> allBaseBeforeIsSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeIsSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideIsSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterIsSprintingInferiors = new Hashtable<>(0);
    private static final List<String> beforeJumpHookTypes = new LinkedList<>();
    private static final List<String> overrideJumpHookTypes = new LinkedList<>();
    private static final List<String> afterJumpHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeJumpHooks;
    private ClientPlayerBase[] overrideJumpHooks;
    private ClientPlayerBase[] afterJumpHooks;
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
    private ClientPlayerBase[] beforeKnockBackHooks;
    private ClientPlayerBase[] overrideKnockBackHooks;
    private ClientPlayerBase[] afterKnockBackHooks;
    public boolean isKnockBackModded;
    private static final Map<String, String[]> allBaseBeforeKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeKnockBackInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideKnockBackInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterKnockBackSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterKnockBackInferiors = new Hashtable<>(0);
    private static final List<String> beforeMoveEntityHookTypes = new LinkedList<>();
    private static final List<String> overrideMoveEntityHookTypes = new LinkedList<>();
    private static final List<String> afterMoveEntityHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeMoveEntityHooks;
    private ClientPlayerBase[] overrideMoveEntityHooks;
    private ClientPlayerBase[] afterMoveEntityHooks;
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
    private ClientPlayerBase[] beforeMoveEntityWithHeadingHooks;
    private ClientPlayerBase[] overrideMoveEntityWithHeadingHooks;
    private ClientPlayerBase[] afterMoveEntityWithHeadingHooks;
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
    private ClientPlayerBase[] beforeMoveFlyingHooks;
    private ClientPlayerBase[] overrideMoveFlyingHooks;
    private ClientPlayerBase[] afterMoveFlyingHooks;
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
    private ClientPlayerBase[] beforeOnDeathHooks;
    private ClientPlayerBase[] overrideOnDeathHooks;
    private ClientPlayerBase[] afterOnDeathHooks;
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
    private ClientPlayerBase[] beforeOnLivingUpdateHooks;
    private ClientPlayerBase[] overrideOnLivingUpdateHooks;
    private ClientPlayerBase[] afterOnLivingUpdateHooks;
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
    private ClientPlayerBase[] beforeOnKillEntityHooks;
    private ClientPlayerBase[] overrideOnKillEntityHooks;
    private ClientPlayerBase[] afterOnKillEntityHooks;
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
    private ClientPlayerBase[] beforeOnStruckByLightningHooks;
    private ClientPlayerBase[] overrideOnStruckByLightningHooks;
    private ClientPlayerBase[] afterOnStruckByLightningHooks;
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
    private ClientPlayerBase[] beforeOnUpdateHooks;
    private ClientPlayerBase[] overrideOnUpdateHooks;
    private ClientPlayerBase[] afterOnUpdateHooks;
    public boolean isOnUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeOnUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideOnUpdateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterOnUpdateInferiors = new Hashtable<>(0);
    private static final List<String> beforePlayStepSoundHookTypes = new LinkedList<>();
    private static final List<String> overridePlayStepSoundHookTypes = new LinkedList<>();
    private static final List<String> afterPlayStepSoundHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforePlayStepSoundHooks;
    private ClientPlayerBase[] overridePlayStepSoundHooks;
    private ClientPlayerBase[] afterPlayStepSoundHooks;
    public boolean isPlayStepSoundModded;
    private static final Map<String, String[]> allBaseBeforePlayStepSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforePlayStepSoundInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverridePlayStepSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverridePlayStepSoundInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterPlayStepSoundSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterPlayStepSoundInferiors = new Hashtable<>(0);
    private static final List<String> beforePushOutOfBlocksHookTypes = new LinkedList<>();
    private static final List<String> overridePushOutOfBlocksHookTypes = new LinkedList<>();
    private static final List<String> afterPushOutOfBlocksHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforePushOutOfBlocksHooks;
    private ClientPlayerBase[] overridePushOutOfBlocksHooks;
    private ClientPlayerBase[] afterPushOutOfBlocksHooks;
    public boolean isPushOutOfBlocksModded;
    private static final Map<String, String[]> allBaseBeforePushOutOfBlocksSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforePushOutOfBlocksInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverridePushOutOfBlocksSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverridePushOutOfBlocksInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterPushOutOfBlocksSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterPushOutOfBlocksInferiors = new Hashtable<>(0);
    private static final List<String> beforeRayTraceHookTypes = new LinkedList<>();
    private static final List<String> overrideRayTraceHookTypes = new LinkedList<>();
    private static final List<String> afterRayTraceHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeRayTraceHooks;
    private ClientPlayerBase[] overrideRayTraceHooks;
    private ClientPlayerBase[] afterRayTraceHooks;
    public boolean isRayTraceModded;
    private static final Map<String, String[]> allBaseBeforeRayTraceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeRayTraceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideRayTraceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideRayTraceInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterRayTraceSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterRayTraceInferiors = new Hashtable<>(0);
    private static final List<String> beforeReadEntityFromNBTHookTypes = new LinkedList<>();
    private static final List<String> overrideReadEntityFromNBTHookTypes = new LinkedList<>();
    private static final List<String> afterReadEntityFromNBTHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeReadEntityFromNBTHooks;
    private ClientPlayerBase[] overrideReadEntityFromNBTHooks;
    private ClientPlayerBase[] afterReadEntityFromNBTHooks;
    public boolean isReadEntityFromNBTModded;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTInferiors = new Hashtable<>(0);
    private static final List<String> beforeRespawnPlayerHookTypes = new LinkedList<>();
    private static final List<String> overrideRespawnPlayerHookTypes = new LinkedList<>();
    private static final List<String> afterRespawnPlayerHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeRespawnPlayerHooks;
    private ClientPlayerBase[] overrideRespawnPlayerHooks;
    private ClientPlayerBase[] afterRespawnPlayerHooks;
    public boolean isRespawnPlayerModded;
    private static final Map<String, String[]> allBaseBeforeRespawnPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeRespawnPlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideRespawnPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideRespawnPlayerInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterRespawnPlayerSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterRespawnPlayerInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetDeadHookTypes = new LinkedList<>();
    private static final List<String> overrideSetDeadHookTypes = new LinkedList<>();
    private static final List<String> afterSetDeadHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSetDeadHooks;
    private ClientPlayerBase[] overrideSetDeadHooks;
    private ClientPlayerBase[] afterSetDeadHooks;
    public boolean isSetDeadModded;
    private static final Map<String, String[]> allBaseBeforeSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetDeadInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetDeadInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetDeadSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetDeadInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetPlayerSPHealthHookTypes = new LinkedList<>();
    private static final List<String> overrideSetPlayerSPHealthHookTypes = new LinkedList<>();
    private static final List<String> afterSetPlayerSPHealthHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSetPlayerSPHealthHooks;
    private ClientPlayerBase[] overrideSetPlayerSPHealthHooks;
    private ClientPlayerBase[] afterSetPlayerSPHealthHooks;
    public boolean isSetPlayerSPHealthModded;
    private static final Map<String, String[]> allBaseBeforeSetPlayerSPHealthSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetPlayerSPHealthInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPlayerSPHealthSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPlayerSPHealthInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPlayerSPHealthSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPlayerSPHealthInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetPositionAndRotationHookTypes = new LinkedList<>();
    private static final List<String> overrideSetPositionAndRotationHookTypes = new LinkedList<>();
    private static final List<String> afterSetPositionAndRotationHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSetPositionAndRotationHooks;
    private ClientPlayerBase[] overrideSetPositionAndRotationHooks;
    private ClientPlayerBase[] afterSetPositionAndRotationHooks;
    public boolean isSetPositionAndRotationModded;
    private static final Map<String, String[]> allBaseBeforeSetPositionAndRotationSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetPositionAndRotationInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPositionAndRotationSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetPositionAndRotationInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPositionAndRotationSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetPositionAndRotationInferiors = new Hashtable<>(0);
    private static final List<String> beforeSetSneakingHookTypes = new LinkedList<>();
    private static final List<String> overrideSetSneakingHookTypes = new LinkedList<>();
    private static final List<String> afterSetSneakingHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSetSneakingHooks;
    private ClientPlayerBase[] overrideSetSneakingHooks;
    private ClientPlayerBase[] afterSetSneakingHooks;
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
    private ClientPlayerBase[] beforeSetSprintingHooks;
    private ClientPlayerBase[] overrideSetSprintingHooks;
    private ClientPlayerBase[] afterSetSprintingHooks;
    public boolean isSetSprintingModded;
    private static final Map<String, String[]> allBaseBeforeSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSetSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSetSprintingInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSprintingSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSetSprintingInferiors = new Hashtable<>(0);
    private static final List<String> beforeSleepInBedAtHookTypes = new LinkedList<>();
    private static final List<String> overrideSleepInBedAtHookTypes = new LinkedList<>();
    private static final List<String> afterSleepInBedAtHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSleepInBedAtHooks;
    private ClientPlayerBase[] overrideSleepInBedAtHooks;
    private ClientPlayerBase[] afterSleepInBedAtHooks;
    public boolean isSleepInBedAtModded;
    private static final Map<String, String[]> allBaseBeforeSleepInBedAtSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeSleepInBedAtInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSleepInBedAtSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideSleepInBedAtInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSleepInBedAtSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterSleepInBedAtInferiors = new Hashtable<>(0);
    private static final List<String> beforeSwingItemHookTypes = new LinkedList<>();
    private static final List<String> overrideSwingItemHookTypes = new LinkedList<>();
    private static final List<String> afterSwingItemHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeSwingItemHooks;
    private ClientPlayerBase[] overrideSwingItemHooks;
    private ClientPlayerBase[] afterSwingItemHooks;
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
    private ClientPlayerBase[] beforeUpdateEntityActionStateHooks;
    private ClientPlayerBase[] overrideUpdateEntityActionStateHooks;
    private ClientPlayerBase[] afterUpdateEntityActionStateHooks;
    public boolean isUpdateEntityActionStateModded;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateInferiors = new Hashtable<>(0);
    private static final List<String> beforeUpdateRiddenHookTypes = new LinkedList<>();
    private static final List<String> overrideUpdateRiddenHookTypes = new LinkedList<>();
    private static final List<String> afterUpdateRiddenHookTypes = new LinkedList<>();
    private ClientPlayerBase[] beforeUpdateRiddenHooks;
    private ClientPlayerBase[] overrideUpdateRiddenHooks;
    private ClientPlayerBase[] afterUpdateRiddenHooks;
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
    private ClientPlayerBase[] beforeWakeUpPlayerHooks;
    private ClientPlayerBase[] overrideWakeUpPlayerHooks;
    private ClientPlayerBase[] afterWakeUpPlayerHooks;
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
    private ClientPlayerBase[] beforeWriteEntityToNBTHooks;
    private ClientPlayerBase[] overrideWriteEntityToNBTHooks;
    private ClientPlayerBase[] afterWriteEntityToNBTHooks;
    public boolean isWriteEntityToNBTModded;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTInferiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTSuperiors = new Hashtable<>(0);
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTInferiors = new Hashtable<>(0);
    protected final IClientPlayerAPI player;
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
    private ClientPlayerBase[] beforeLocalConstructingHooks;
    private ClientPlayerBase[] afterLocalConstructingHooks;
    private final Map<ClientPlayerBase, String> baseObjectsToId = new Hashtable<>();
    private final Map<String, ClientPlayerBase> allBaseObjects = new Hashtable<>();
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
        register(id, baseClass, null);
    }

    public static void register(String id, Class<?> baseClass, ClientPlayerBaseSorting baseSorting) {
        try {
            register(baseClass, id, baseSorting);
        } catch (RuntimeException exception) {
            if (id != null) {
                log("Client Player: failed to register id '" + id + "'");
            } else {
                log("Client Player: failed to register ClientPlayerBase");
            }

            throw exception;
        }
    }

    private static void register(Class<?> baseClass, String id, ClientPlayerBaseSorting baseSorting) {
        if (!isCreated) {
            try {
                Method mandatory = EntityPlayerSP.class.getMethod("getClientPlayerBase", String.class);
                if (mandatory.getReturnType() != ClientPlayerBase.class) {
                    throw new NoSuchMethodException(ClientPlayerBase.class.getName() + " "
                            + EntityPlayerSP.class.getName() + ".getClientPlayerBase(" + String.class.getName() + ")");
                }
            } catch (NoSuchMethodException exception) {
                String[] errorMessageParts = new String[] {
                    "========================================",
                    "The API \"Client Player\" version " + PlayerAPIPlugin.Version + " of the mod \"Player API Core "
                            + PlayerAPIPlugin.Version + "\" can not be created!",
                    "----------------------------------------",
                    "Mandatory member method \"{0} getClientPlayerBase({3})\" not found in class \"{1}\".",
                    "There are three scenarios this can happen:",
                    "* Minecraft Forge is missing a Player API Core which Minecraft version matches its own.",
                    "  Download and install the latest Player API Core for the Minecraft version you were trying to run.",
                    "* The code of the class \"{2}\" of Player API Core has been modified beyond recognition by another Minecraft Forge coremod.",
                    "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.",
                    "* Player API Core has not been installed correctly.",
                    "  Deinstall Player API Core and install it again following the installation instructions in the readme file.",
                    "========================================"
                };
                String baseEntityPlayerSPClassName = ClientPlayerBase.class.getName();
                String targetClassName = EntityPlayerSP.class.getName();
                String targetClassFileName = targetClassName.replace(".", File.separator);
                String stringClassName = String.class.getName();

                for (int i = 0; i < errorMessageParts.length; ++i) {
                    errorMessageParts[i] = MessageFormat.format(
                            errorMessageParts[i],
                            baseEntityPlayerSPClassName,
                            targetClassName,
                            targetClassFileName,
                            stringClassName);
                }
                for (String errorMessagePart : errorMessageParts) {
                    logger.severe(errorMessagePart);
                }
                for (String errorMessagePart : errorMessageParts) {
                    System.err.println(errorMessagePart);
                }
                String errorMessage = "\n\n";
                for (String errorMessagePart : errorMessageParts) {
                    errorMessage = errorMessage + "\t" + errorMessagePart + "\n";
                }

                throw new RuntimeException(errorMessage, exception);
            }

            log("Client Player " + PlayerAPIPlugin.Version + " Created");
            isCreated = true;
        }

        if (id == null) {
            throw new NullPointerException("Argument 'id' can not be null");
        } else if (baseClass == null) {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        } else {
            Constructor<?> allreadyRegistered = allBaseConstructors.get(id);
            if (allreadyRegistered != null) {
                throw new IllegalArgumentException("The class '" + baseClass.getName()
                        + "' can not be registered with the id '" + id + "' because the class '"
                        + allreadyRegistered.getDeclaringClass().getName()
                        + "' has allready been registered with the same id");
            } else {
                Constructor<?> baseConstructor;
                try {
                    baseConstructor = baseClass.getDeclaredConstructor(Classes);
                } catch (Throwable t) {
                    try {
                        baseConstructor = baseClass.getDeclaredConstructor(Class);
                    } catch (Throwable s) {
                        throw new IllegalArgumentException(
                                "Can not find necessary constructor with one argument of type '"
                                        + ClientPlayerAPI.class.getName()
                                        + "' and eventually a second argument of type 'String' in the class '"
                                        + baseClass.getName() + "'",
                                t);
                    }
                }

                allBaseConstructors.put(id, baseConstructor);
                if (baseSorting != null) {
                    addSorting(
                            id,
                            allBaseBeforeLocalConstructingSuperiors,
                            baseSorting.getBeforeLocalConstructingSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeLocalConstructingInferiors,
                            baseSorting.getBeforeLocalConstructingInferiors());
                    addSorting(
                            id,
                            allBaseAfterLocalConstructingSuperiors,
                            baseSorting.getAfterLocalConstructingSuperiors());
                    addSorting(
                            id,
                            allBaseAfterLocalConstructingInferiors,
                            baseSorting.getAfterLocalConstructingInferiors());
                    addDynamicSorting(id, allBaseBeforeDynamicSuperiors, baseSorting.getDynamicBeforeSuperiors());
                    addDynamicSorting(id, allBaseBeforeDynamicInferiors, baseSorting.getDynamicBeforeInferiors());
                    addDynamicSorting(id, allBaseOverrideDynamicSuperiors, baseSorting.getDynamicOverrideSuperiors());
                    addDynamicSorting(id, allBaseOverrideDynamicInferiors, baseSorting.getDynamicOverrideInferiors());
                    addDynamicSorting(id, allBaseAfterDynamicSuperiors, baseSorting.getDynamicAfterSuperiors());
                    addDynamicSorting(id, allBaseAfterDynamicInferiors, baseSorting.getDynamicAfterInferiors());
                    addSorting(id, allBaseBeforeAddExhaustionSuperiors, baseSorting.getBeforeAddExhaustionSuperiors());
                    addSorting(id, allBaseBeforeAddExhaustionInferiors, baseSorting.getBeforeAddExhaustionInferiors());
                    addSorting(
                            id, allBaseOverrideAddExhaustionSuperiors, baseSorting.getOverrideAddExhaustionSuperiors());
                    addSorting(
                            id, allBaseOverrideAddExhaustionInferiors, baseSorting.getOverrideAddExhaustionInferiors());
                    addSorting(id, allBaseAfterAddExhaustionSuperiors, baseSorting.getAfterAddExhaustionSuperiors());
                    addSorting(id, allBaseAfterAddExhaustionInferiors, baseSorting.getAfterAddExhaustionInferiors());
                    addSorting(
                            id, allBaseBeforeAddMovementStatSuperiors, baseSorting.getBeforeAddMovementStatSuperiors());
                    addSorting(
                            id, allBaseBeforeAddMovementStatInferiors, baseSorting.getBeforeAddMovementStatInferiors());
                    addSorting(
                            id,
                            allBaseOverrideAddMovementStatSuperiors,
                            baseSorting.getOverrideAddMovementStatSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideAddMovementStatInferiors,
                            baseSorting.getOverrideAddMovementStatInferiors());
                    addSorting(
                            id, allBaseAfterAddMovementStatSuperiors, baseSorting.getAfterAddMovementStatSuperiors());
                    addSorting(
                            id, allBaseAfterAddMovementStatInferiors, baseSorting.getAfterAddMovementStatInferiors());
                    addSorting(id, allBaseBeforeAddStatSuperiors, baseSorting.getBeforeAddStatSuperiors());
                    addSorting(id, allBaseBeforeAddStatInferiors, baseSorting.getBeforeAddStatInferiors());
                    addSorting(id, allBaseOverrideAddStatSuperiors, baseSorting.getOverrideAddStatSuperiors());
                    addSorting(id, allBaseOverrideAddStatInferiors, baseSorting.getOverrideAddStatInferiors());
                    addSorting(id, allBaseAfterAddStatSuperiors, baseSorting.getAfterAddStatSuperiors());
                    addSorting(id, allBaseAfterAddStatInferiors, baseSorting.getAfterAddStatInferiors());
                    addSorting(
                            id,
                            allBaseBeforeAttackEntityFromSuperiors,
                            baseSorting.getBeforeAttackEntityFromSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeAttackEntityFromInferiors,
                            baseSorting.getBeforeAttackEntityFromInferiors());
                    addSorting(
                            id,
                            allBaseOverrideAttackEntityFromSuperiors,
                            baseSorting.getOverrideAttackEntityFromSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideAttackEntityFromInferiors,
                            baseSorting.getOverrideAttackEntityFromInferiors());
                    addSorting(
                            id, allBaseAfterAttackEntityFromSuperiors, baseSorting.getAfterAttackEntityFromSuperiors());
                    addSorting(
                            id, allBaseAfterAttackEntityFromInferiors, baseSorting.getAfterAttackEntityFromInferiors());
                    addSorting(
                            id,
                            allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors,
                            baseSorting.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeAttackTargetEntityWithCurrentItemInferiors,
                            baseSorting.getBeforeAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(
                            id,
                            allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors,
                            baseSorting.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideAttackTargetEntityWithCurrentItemInferiors,
                            baseSorting.getOverrideAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(
                            id,
                            allBaseAfterAttackTargetEntityWithCurrentItemSuperiors,
                            baseSorting.getAfterAttackTargetEntityWithCurrentItemSuperiors());
                    addSorting(
                            id,
                            allBaseAfterAttackTargetEntityWithCurrentItemInferiors,
                            baseSorting.getAfterAttackTargetEntityWithCurrentItemInferiors());
                    addSorting(
                            id,
                            allBaseBeforeCanBreatheUnderwaterSuperiors,
                            baseSorting.getBeforeCanBreatheUnderwaterSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeCanBreatheUnderwaterInferiors,
                            baseSorting.getBeforeCanBreatheUnderwaterInferiors());
                    addSorting(
                            id,
                            allBaseOverrideCanBreatheUnderwaterSuperiors,
                            baseSorting.getOverrideCanBreatheUnderwaterSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideCanBreatheUnderwaterInferiors,
                            baseSorting.getOverrideCanBreatheUnderwaterInferiors());
                    addSorting(
                            id,
                            allBaseAfterCanBreatheUnderwaterSuperiors,
                            baseSorting.getAfterCanBreatheUnderwaterSuperiors());
                    addSorting(
                            id,
                            allBaseAfterCanBreatheUnderwaterInferiors,
                            baseSorting.getAfterCanBreatheUnderwaterInferiors());
                    addSorting(
                            id, allBaseBeforeCanHarvestBlockSuperiors, baseSorting.getBeforeCanHarvestBlockSuperiors());
                    addSorting(
                            id, allBaseBeforeCanHarvestBlockInferiors, baseSorting.getBeforeCanHarvestBlockInferiors());
                    addSorting(
                            id,
                            allBaseOverrideCanHarvestBlockSuperiors,
                            baseSorting.getOverrideCanHarvestBlockSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideCanHarvestBlockInferiors,
                            baseSorting.getOverrideCanHarvestBlockInferiors());
                    addSorting(
                            id, allBaseAfterCanHarvestBlockSuperiors, baseSorting.getAfterCanHarvestBlockSuperiors());
                    addSorting(
                            id, allBaseAfterCanHarvestBlockInferiors, baseSorting.getAfterCanHarvestBlockInferiors());
                    addSorting(id, allBaseBeforeCanPlayerEditSuperiors, baseSorting.getBeforeCanPlayerEditSuperiors());
                    addSorting(id, allBaseBeforeCanPlayerEditInferiors, baseSorting.getBeforeCanPlayerEditInferiors());
                    addSorting(
                            id, allBaseOverrideCanPlayerEditSuperiors, baseSorting.getOverrideCanPlayerEditSuperiors());
                    addSorting(
                            id, allBaseOverrideCanPlayerEditInferiors, baseSorting.getOverrideCanPlayerEditInferiors());
                    addSorting(id, allBaseAfterCanPlayerEditSuperiors, baseSorting.getAfterCanPlayerEditSuperiors());
                    addSorting(id, allBaseAfterCanPlayerEditInferiors, baseSorting.getAfterCanPlayerEditInferiors());
                    addSorting(
                            id,
                            allBaseBeforeCanTriggerWalkingSuperiors,
                            baseSorting.getBeforeCanTriggerWalkingSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeCanTriggerWalkingInferiors,
                            baseSorting.getBeforeCanTriggerWalkingInferiors());
                    addSorting(
                            id,
                            allBaseOverrideCanTriggerWalkingSuperiors,
                            baseSorting.getOverrideCanTriggerWalkingSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideCanTriggerWalkingInferiors,
                            baseSorting.getOverrideCanTriggerWalkingInferiors());
                    addSorting(
                            id,
                            allBaseAfterCanTriggerWalkingSuperiors,
                            baseSorting.getAfterCanTriggerWalkingSuperiors());
                    addSorting(
                            id,
                            allBaseAfterCanTriggerWalkingInferiors,
                            baseSorting.getAfterCanTriggerWalkingInferiors());
                    addSorting(id, allBaseBeforeCloseScreenSuperiors, baseSorting.getBeforeCloseScreenSuperiors());
                    addSorting(id, allBaseBeforeCloseScreenInferiors, baseSorting.getBeforeCloseScreenInferiors());
                    addSorting(id, allBaseOverrideCloseScreenSuperiors, baseSorting.getOverrideCloseScreenSuperiors());
                    addSorting(id, allBaseOverrideCloseScreenInferiors, baseSorting.getOverrideCloseScreenInferiors());
                    addSorting(id, allBaseAfterCloseScreenSuperiors, baseSorting.getAfterCloseScreenSuperiors());
                    addSorting(id, allBaseAfterCloseScreenInferiors, baseSorting.getAfterCloseScreenInferiors());
                    addSorting(id, allBaseBeforeDamageEntitySuperiors, baseSorting.getBeforeDamageEntitySuperiors());
                    addSorting(id, allBaseBeforeDamageEntityInferiors, baseSorting.getBeforeDamageEntityInferiors());
                    addSorting(
                            id, allBaseOverrideDamageEntitySuperiors, baseSorting.getOverrideDamageEntitySuperiors());
                    addSorting(
                            id, allBaseOverrideDamageEntityInferiors, baseSorting.getOverrideDamageEntityInferiors());
                    addSorting(id, allBaseAfterDamageEntitySuperiors, baseSorting.getAfterDamageEntitySuperiors());
                    addSorting(id, allBaseAfterDamageEntityInferiors, baseSorting.getAfterDamageEntityInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIBrewingStandSuperiors,
                            baseSorting.getBeforeDisplayGUIBrewingStandSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIBrewingStandInferiors,
                            baseSorting.getBeforeDisplayGUIBrewingStandInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIBrewingStandSuperiors,
                            baseSorting.getOverrideDisplayGUIBrewingStandSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIBrewingStandInferiors,
                            baseSorting.getOverrideDisplayGUIBrewingStandInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIBrewingStandSuperiors,
                            baseSorting.getAfterDisplayGUIBrewingStandSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIBrewingStandInferiors,
                            baseSorting.getAfterDisplayGUIBrewingStandInferiors());
                    addSorting(
                            id, allBaseBeforeDisplayGUIChestSuperiors, baseSorting.getBeforeDisplayGUIChestSuperiors());
                    addSorting(
                            id, allBaseBeforeDisplayGUIChestInferiors, baseSorting.getBeforeDisplayGUIChestInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIChestSuperiors,
                            baseSorting.getOverrideDisplayGUIChestSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIChestInferiors,
                            baseSorting.getOverrideDisplayGUIChestInferiors());
                    addSorting(
                            id, allBaseAfterDisplayGUIChestSuperiors, baseSorting.getAfterDisplayGUIChestSuperiors());
                    addSorting(
                            id, allBaseAfterDisplayGUIChestInferiors, baseSorting.getAfterDisplayGUIChestInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIDispenserSuperiors,
                            baseSorting.getBeforeDisplayGUIDispenserSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIDispenserInferiors,
                            baseSorting.getBeforeDisplayGUIDispenserInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIDispenserSuperiors,
                            baseSorting.getOverrideDisplayGUIDispenserSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIDispenserInferiors,
                            baseSorting.getOverrideDisplayGUIDispenserInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIDispenserSuperiors,
                            baseSorting.getAfterDisplayGUIDispenserSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIDispenserInferiors,
                            baseSorting.getAfterDisplayGUIDispenserInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIEditSignSuperiors,
                            baseSorting.getBeforeDisplayGUIEditSignSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIEditSignInferiors,
                            baseSorting.getBeforeDisplayGUIEditSignInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIEditSignSuperiors,
                            baseSorting.getOverrideDisplayGUIEditSignSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIEditSignInferiors,
                            baseSorting.getOverrideDisplayGUIEditSignInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIEditSignSuperiors,
                            baseSorting.getAfterDisplayGUIEditSignSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIEditSignInferiors,
                            baseSorting.getAfterDisplayGUIEditSignInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIEnchantmentSuperiors,
                            baseSorting.getBeforeDisplayGUIEnchantmentSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIEnchantmentInferiors,
                            baseSorting.getBeforeDisplayGUIEnchantmentInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIEnchantmentSuperiors,
                            baseSorting.getOverrideDisplayGUIEnchantmentSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIEnchantmentInferiors,
                            baseSorting.getOverrideDisplayGUIEnchantmentInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIEnchantmentSuperiors,
                            baseSorting.getAfterDisplayGUIEnchantmentSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIEnchantmentInferiors,
                            baseSorting.getAfterDisplayGUIEnchantmentInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIFurnaceSuperiors,
                            baseSorting.getBeforeDisplayGUIFurnaceSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIFurnaceInferiors,
                            baseSorting.getBeforeDisplayGUIFurnaceInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIFurnaceSuperiors,
                            baseSorting.getOverrideDisplayGUIFurnaceSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIFurnaceInferiors,
                            baseSorting.getOverrideDisplayGUIFurnaceInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIFurnaceSuperiors,
                            baseSorting.getAfterDisplayGUIFurnaceSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIFurnaceInferiors,
                            baseSorting.getAfterDisplayGUIFurnaceInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIWorkbenchSuperiors,
                            baseSorting.getBeforeDisplayGUIWorkbenchSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDisplayGUIWorkbenchInferiors,
                            baseSorting.getBeforeDisplayGUIWorkbenchInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIWorkbenchSuperiors,
                            baseSorting.getOverrideDisplayGUIWorkbenchSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDisplayGUIWorkbenchInferiors,
                            baseSorting.getOverrideDisplayGUIWorkbenchInferiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIWorkbenchSuperiors,
                            baseSorting.getAfterDisplayGUIWorkbenchSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDisplayGUIWorkbenchInferiors,
                            baseSorting.getAfterDisplayGUIWorkbenchInferiors());
                    addSorting(id, allBaseBeforeDropOneItemSuperiors, baseSorting.getBeforeDropOneItemSuperiors());
                    addSorting(id, allBaseBeforeDropOneItemInferiors, baseSorting.getBeforeDropOneItemInferiors());
                    addSorting(id, allBaseOverrideDropOneItemSuperiors, baseSorting.getOverrideDropOneItemSuperiors());
                    addSorting(id, allBaseOverrideDropOneItemInferiors, baseSorting.getOverrideDropOneItemInferiors());
                    addSorting(id, allBaseAfterDropOneItemSuperiors, baseSorting.getAfterDropOneItemSuperiors());
                    addSorting(id, allBaseAfterDropOneItemInferiors, baseSorting.getAfterDropOneItemInferiors());
                    addSorting(
                            id, allBaseBeforeDropPlayerItemSuperiors, baseSorting.getBeforeDropPlayerItemSuperiors());
                    addSorting(
                            id, allBaseBeforeDropPlayerItemInferiors, baseSorting.getBeforeDropPlayerItemInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDropPlayerItemSuperiors,
                            baseSorting.getOverrideDropPlayerItemSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDropPlayerItemInferiors,
                            baseSorting.getOverrideDropPlayerItemInferiors());
                    addSorting(id, allBaseAfterDropPlayerItemSuperiors, baseSorting.getAfterDropPlayerItemSuperiors());
                    addSorting(id, allBaseAfterDropPlayerItemInferiors, baseSorting.getAfterDropPlayerItemInferiors());
                    addSorting(
                            id,
                            allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors,
                            baseSorting.getBeforeDropPlayerItemWithRandomChoiceSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeDropPlayerItemWithRandomChoiceInferiors,
                            baseSorting.getBeforeDropPlayerItemWithRandomChoiceInferiors());
                    addSorting(
                            id,
                            allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors,
                            baseSorting.getOverrideDropPlayerItemWithRandomChoiceSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideDropPlayerItemWithRandomChoiceInferiors,
                            baseSorting.getOverrideDropPlayerItemWithRandomChoiceInferiors());
                    addSorting(
                            id,
                            allBaseAfterDropPlayerItemWithRandomChoiceSuperiors,
                            baseSorting.getAfterDropPlayerItemWithRandomChoiceSuperiors());
                    addSorting(
                            id,
                            allBaseAfterDropPlayerItemWithRandomChoiceInferiors,
                            baseSorting.getAfterDropPlayerItemWithRandomChoiceInferiors());
                    addSorting(id, allBaseBeforeFallSuperiors, baseSorting.getBeforeFallSuperiors());
                    addSorting(id, allBaseBeforeFallInferiors, baseSorting.getBeforeFallInferiors());
                    addSorting(id, allBaseOverrideFallSuperiors, baseSorting.getOverrideFallSuperiors());
                    addSorting(id, allBaseOverrideFallInferiors, baseSorting.getOverrideFallInferiors());
                    addSorting(id, allBaseAfterFallSuperiors, baseSorting.getAfterFallSuperiors());
                    addSorting(id, allBaseAfterFallInferiors, baseSorting.getAfterFallInferiors());
                    addSorting(
                            id, allBaseBeforeGetAIMoveSpeedSuperiors, baseSorting.getBeforeGetAIMoveSpeedSuperiors());
                    addSorting(
                            id, allBaseBeforeGetAIMoveSpeedInferiors, baseSorting.getBeforeGetAIMoveSpeedInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetAIMoveSpeedSuperiors,
                            baseSorting.getOverrideGetAIMoveSpeedSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetAIMoveSpeedInferiors,
                            baseSorting.getOverrideGetAIMoveSpeedInferiors());
                    addSorting(id, allBaseAfterGetAIMoveSpeedSuperiors, baseSorting.getAfterGetAIMoveSpeedSuperiors());
                    addSorting(id, allBaseAfterGetAIMoveSpeedInferiors, baseSorting.getAfterGetAIMoveSpeedInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetBedOrientationInDegreesSuperiors,
                            baseSorting.getBeforeGetBedOrientationInDegreesSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetBedOrientationInDegreesInferiors,
                            baseSorting.getBeforeGetBedOrientationInDegreesInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetBedOrientationInDegreesSuperiors,
                            baseSorting.getOverrideGetBedOrientationInDegreesSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetBedOrientationInDegreesInferiors,
                            baseSorting.getOverrideGetBedOrientationInDegreesInferiors());
                    addSorting(
                            id,
                            allBaseAfterGetBedOrientationInDegreesSuperiors,
                            baseSorting.getAfterGetBedOrientationInDegreesSuperiors());
                    addSorting(
                            id,
                            allBaseAfterGetBedOrientationInDegreesInferiors,
                            baseSorting.getAfterGetBedOrientationInDegreesInferiors());
                    addSorting(id, allBaseBeforeGetBrightnessSuperiors, baseSorting.getBeforeGetBrightnessSuperiors());
                    addSorting(id, allBaseBeforeGetBrightnessInferiors, baseSorting.getBeforeGetBrightnessInferiors());
                    addSorting(
                            id, allBaseOverrideGetBrightnessSuperiors, baseSorting.getOverrideGetBrightnessSuperiors());
                    addSorting(
                            id, allBaseOverrideGetBrightnessInferiors, baseSorting.getOverrideGetBrightnessInferiors());
                    addSorting(id, allBaseAfterGetBrightnessSuperiors, baseSorting.getAfterGetBrightnessSuperiors());
                    addSorting(id, allBaseAfterGetBrightnessInferiors, baseSorting.getAfterGetBrightnessInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetBrightnessForRenderSuperiors,
                            baseSorting.getBeforeGetBrightnessForRenderSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetBrightnessForRenderInferiors,
                            baseSorting.getBeforeGetBrightnessForRenderInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetBrightnessForRenderSuperiors,
                            baseSorting.getOverrideGetBrightnessForRenderSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetBrightnessForRenderInferiors,
                            baseSorting.getOverrideGetBrightnessForRenderInferiors());
                    addSorting(
                            id,
                            allBaseAfterGetBrightnessForRenderSuperiors,
                            baseSorting.getAfterGetBrightnessForRenderSuperiors());
                    addSorting(
                            id,
                            allBaseAfterGetBrightnessForRenderInferiors,
                            baseSorting.getAfterGetBrightnessForRenderInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors,
                            baseSorting.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetCurrentPlayerStrVsBlockInferiors,
                            baseSorting.getBeforeGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors,
                            baseSorting.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetCurrentPlayerStrVsBlockInferiors,
                            baseSorting.getOverrideGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(
                            id,
                            allBaseAfterGetCurrentPlayerStrVsBlockSuperiors,
                            baseSorting.getAfterGetCurrentPlayerStrVsBlockSuperiors());
                    addSorting(
                            id,
                            allBaseAfterGetCurrentPlayerStrVsBlockInferiors,
                            baseSorting.getAfterGetCurrentPlayerStrVsBlockInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors,
                            baseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors,
                            baseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors,
                            baseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors,
                            baseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(
                            id,
                            allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors,
                            baseSorting.getAfterGetCurrentPlayerStrVsBlockForgeSuperiors());
                    addSorting(
                            id,
                            allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors,
                            baseSorting.getAfterGetCurrentPlayerStrVsBlockForgeInferiors());
                    addSorting(id, allBaseBeforeGetDistanceSqSuperiors, baseSorting.getBeforeGetDistanceSqSuperiors());
                    addSorting(id, allBaseBeforeGetDistanceSqInferiors, baseSorting.getBeforeGetDistanceSqInferiors());
                    addSorting(
                            id, allBaseOverrideGetDistanceSqSuperiors, baseSorting.getOverrideGetDistanceSqSuperiors());
                    addSorting(
                            id, allBaseOverrideGetDistanceSqInferiors, baseSorting.getOverrideGetDistanceSqInferiors());
                    addSorting(id, allBaseAfterGetDistanceSqSuperiors, baseSorting.getAfterGetDistanceSqSuperiors());
                    addSorting(id, allBaseAfterGetDistanceSqInferiors, baseSorting.getAfterGetDistanceSqInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetDistanceSqToEntitySuperiors,
                            baseSorting.getBeforeGetDistanceSqToEntitySuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetDistanceSqToEntityInferiors,
                            baseSorting.getBeforeGetDistanceSqToEntityInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetDistanceSqToEntitySuperiors,
                            baseSorting.getOverrideGetDistanceSqToEntitySuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetDistanceSqToEntityInferiors,
                            baseSorting.getOverrideGetDistanceSqToEntityInferiors());
                    addSorting(
                            id,
                            allBaseAfterGetDistanceSqToEntitySuperiors,
                            baseSorting.getAfterGetDistanceSqToEntitySuperiors());
                    addSorting(
                            id,
                            allBaseAfterGetDistanceSqToEntityInferiors,
                            baseSorting.getAfterGetDistanceSqToEntityInferiors());
                    addSorting(
                            id,
                            allBaseBeforeGetFOVMultiplierSuperiors,
                            baseSorting.getBeforeGetFOVMultiplierSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeGetFOVMultiplierInferiors,
                            baseSorting.getBeforeGetFOVMultiplierInferiors());
                    addSorting(
                            id,
                            allBaseOverrideGetFOVMultiplierSuperiors,
                            baseSorting.getOverrideGetFOVMultiplierSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideGetFOVMultiplierInferiors,
                            baseSorting.getOverrideGetFOVMultiplierInferiors());
                    addSorting(
                            id, allBaseAfterGetFOVMultiplierSuperiors, baseSorting.getAfterGetFOVMultiplierSuperiors());
                    addSorting(
                            id, allBaseAfterGetFOVMultiplierInferiors, baseSorting.getAfterGetFOVMultiplierInferiors());
                    addSorting(id, allBaseBeforeGetHurtSoundSuperiors, baseSorting.getBeforeGetHurtSoundSuperiors());
                    addSorting(id, allBaseBeforeGetHurtSoundInferiors, baseSorting.getBeforeGetHurtSoundInferiors());
                    addSorting(
                            id, allBaseOverrideGetHurtSoundSuperiors, baseSorting.getOverrideGetHurtSoundSuperiors());
                    addSorting(
                            id, allBaseOverrideGetHurtSoundInferiors, baseSorting.getOverrideGetHurtSoundInferiors());
                    addSorting(id, allBaseAfterGetHurtSoundSuperiors, baseSorting.getAfterGetHurtSoundSuperiors());
                    addSorting(id, allBaseAfterGetHurtSoundInferiors, baseSorting.getAfterGetHurtSoundInferiors());
                    addSorting(id, allBaseBeforeGetItemIconSuperiors, baseSorting.getBeforeGetItemIconSuperiors());
                    addSorting(id, allBaseBeforeGetItemIconInferiors, baseSorting.getBeforeGetItemIconInferiors());
                    addSorting(id, allBaseOverrideGetItemIconSuperiors, baseSorting.getOverrideGetItemIconSuperiors());
                    addSorting(id, allBaseOverrideGetItemIconInferiors, baseSorting.getOverrideGetItemIconInferiors());
                    addSorting(id, allBaseAfterGetItemIconSuperiors, baseSorting.getAfterGetItemIconSuperiors());
                    addSorting(id, allBaseAfterGetItemIconInferiors, baseSorting.getAfterGetItemIconInferiors());
                    addSorting(id, allBaseBeforeGetSleepTimerSuperiors, baseSorting.getBeforeGetSleepTimerSuperiors());
                    addSorting(id, allBaseBeforeGetSleepTimerInferiors, baseSorting.getBeforeGetSleepTimerInferiors());
                    addSorting(
                            id, allBaseOverrideGetSleepTimerSuperiors, baseSorting.getOverrideGetSleepTimerSuperiors());
                    addSorting(
                            id, allBaseOverrideGetSleepTimerInferiors, baseSorting.getOverrideGetSleepTimerInferiors());
                    addSorting(id, allBaseAfterGetSleepTimerSuperiors, baseSorting.getAfterGetSleepTimerSuperiors());
                    addSorting(id, allBaseAfterGetSleepTimerInferiors, baseSorting.getAfterGetSleepTimerInferiors());
                    addSorting(
                            id,
                            allBaseBeforeHandleLavaMovementSuperiors,
                            baseSorting.getBeforeHandleLavaMovementSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeHandleLavaMovementInferiors,
                            baseSorting.getBeforeHandleLavaMovementInferiors());
                    addSorting(
                            id,
                            allBaseOverrideHandleLavaMovementSuperiors,
                            baseSorting.getOverrideHandleLavaMovementSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideHandleLavaMovementInferiors,
                            baseSorting.getOverrideHandleLavaMovementInferiors());
                    addSorting(
                            id,
                            allBaseAfterHandleLavaMovementSuperiors,
                            baseSorting.getAfterHandleLavaMovementSuperiors());
                    addSorting(
                            id,
                            allBaseAfterHandleLavaMovementInferiors,
                            baseSorting.getAfterHandleLavaMovementInferiors());
                    addSorting(
                            id,
                            allBaseBeforeHandleWaterMovementSuperiors,
                            baseSorting.getBeforeHandleWaterMovementSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeHandleWaterMovementInferiors,
                            baseSorting.getBeforeHandleWaterMovementInferiors());
                    addSorting(
                            id,
                            allBaseOverrideHandleWaterMovementSuperiors,
                            baseSorting.getOverrideHandleWaterMovementSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideHandleWaterMovementInferiors,
                            baseSorting.getOverrideHandleWaterMovementInferiors());
                    addSorting(
                            id,
                            allBaseAfterHandleWaterMovementSuperiors,
                            baseSorting.getAfterHandleWaterMovementSuperiors());
                    addSorting(
                            id,
                            allBaseAfterHandleWaterMovementInferiors,
                            baseSorting.getAfterHandleWaterMovementInferiors());
                    addSorting(id, allBaseBeforeHealSuperiors, baseSorting.getBeforeHealSuperiors());
                    addSorting(id, allBaseBeforeHealInferiors, baseSorting.getBeforeHealInferiors());
                    addSorting(id, allBaseOverrideHealSuperiors, baseSorting.getOverrideHealSuperiors());
                    addSorting(id, allBaseOverrideHealInferiors, baseSorting.getOverrideHealInferiors());
                    addSorting(id, allBaseAfterHealSuperiors, baseSorting.getAfterHealSuperiors());
                    addSorting(id, allBaseAfterHealInferiors, baseSorting.getAfterHealInferiors());
                    addSorting(
                            id,
                            allBaseBeforeIsEntityInsideOpaqueBlockSuperiors,
                            baseSorting.getBeforeIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeIsEntityInsideOpaqueBlockInferiors,
                            baseSorting.getBeforeIsEntityInsideOpaqueBlockInferiors());
                    addSorting(
                            id,
                            allBaseOverrideIsEntityInsideOpaqueBlockSuperiors,
                            baseSorting.getOverrideIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideIsEntityInsideOpaqueBlockInferiors,
                            baseSorting.getOverrideIsEntityInsideOpaqueBlockInferiors());
                    addSorting(
                            id,
                            allBaseAfterIsEntityInsideOpaqueBlockSuperiors,
                            baseSorting.getAfterIsEntityInsideOpaqueBlockSuperiors());
                    addSorting(
                            id,
                            allBaseAfterIsEntityInsideOpaqueBlockInferiors,
                            baseSorting.getAfterIsEntityInsideOpaqueBlockInferiors());
                    addSorting(id, allBaseBeforeIsInWaterSuperiors, baseSorting.getBeforeIsInWaterSuperiors());
                    addSorting(id, allBaseBeforeIsInWaterInferiors, baseSorting.getBeforeIsInWaterInferiors());
                    addSorting(id, allBaseOverrideIsInWaterSuperiors, baseSorting.getOverrideIsInWaterSuperiors());
                    addSorting(id, allBaseOverrideIsInWaterInferiors, baseSorting.getOverrideIsInWaterInferiors());
                    addSorting(id, allBaseAfterIsInWaterSuperiors, baseSorting.getAfterIsInWaterSuperiors());
                    addSorting(id, allBaseAfterIsInWaterInferiors, baseSorting.getAfterIsInWaterInferiors());
                    addSorting(
                            id,
                            allBaseBeforeIsInsideOfMaterialSuperiors,
                            baseSorting.getBeforeIsInsideOfMaterialSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeIsInsideOfMaterialInferiors,
                            baseSorting.getBeforeIsInsideOfMaterialInferiors());
                    addSorting(
                            id,
                            allBaseOverrideIsInsideOfMaterialSuperiors,
                            baseSorting.getOverrideIsInsideOfMaterialSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideIsInsideOfMaterialInferiors,
                            baseSorting.getOverrideIsInsideOfMaterialInferiors());
                    addSorting(
                            id,
                            allBaseAfterIsInsideOfMaterialSuperiors,
                            baseSorting.getAfterIsInsideOfMaterialSuperiors());
                    addSorting(
                            id,
                            allBaseAfterIsInsideOfMaterialInferiors,
                            baseSorting.getAfterIsInsideOfMaterialInferiors());
                    addSorting(id, allBaseBeforeIsOnLadderSuperiors, baseSorting.getBeforeIsOnLadderSuperiors());
                    addSorting(id, allBaseBeforeIsOnLadderInferiors, baseSorting.getBeforeIsOnLadderInferiors());
                    addSorting(id, allBaseOverrideIsOnLadderSuperiors, baseSorting.getOverrideIsOnLadderSuperiors());
                    addSorting(id, allBaseOverrideIsOnLadderInferiors, baseSorting.getOverrideIsOnLadderInferiors());
                    addSorting(id, allBaseAfterIsOnLadderSuperiors, baseSorting.getAfterIsOnLadderSuperiors());
                    addSorting(id, allBaseAfterIsOnLadderInferiors, baseSorting.getAfterIsOnLadderInferiors());
                    addSorting(
                            id,
                            allBaseBeforeIsPlayerSleepingSuperiors,
                            baseSorting.getBeforeIsPlayerSleepingSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeIsPlayerSleepingInferiors,
                            baseSorting.getBeforeIsPlayerSleepingInferiors());
                    addSorting(
                            id,
                            allBaseOverrideIsPlayerSleepingSuperiors,
                            baseSorting.getOverrideIsPlayerSleepingSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideIsPlayerSleepingInferiors,
                            baseSorting.getOverrideIsPlayerSleepingInferiors());
                    addSorting(
                            id, allBaseAfterIsPlayerSleepingSuperiors, baseSorting.getAfterIsPlayerSleepingSuperiors());
                    addSorting(
                            id, allBaseAfterIsPlayerSleepingInferiors, baseSorting.getAfterIsPlayerSleepingInferiors());
                    addSorting(id, allBaseBeforeIsSneakingSuperiors, baseSorting.getBeforeIsSneakingSuperiors());
                    addSorting(id, allBaseBeforeIsSneakingInferiors, baseSorting.getBeforeIsSneakingInferiors());
                    addSorting(id, allBaseOverrideIsSneakingSuperiors, baseSorting.getOverrideIsSneakingSuperiors());
                    addSorting(id, allBaseOverrideIsSneakingInferiors, baseSorting.getOverrideIsSneakingInferiors());
                    addSorting(id, allBaseAfterIsSneakingSuperiors, baseSorting.getAfterIsSneakingSuperiors());
                    addSorting(id, allBaseAfterIsSneakingInferiors, baseSorting.getAfterIsSneakingInferiors());
                    addSorting(id, allBaseBeforeIsSprintingSuperiors, baseSorting.getBeforeIsSprintingSuperiors());
                    addSorting(id, allBaseBeforeIsSprintingInferiors, baseSorting.getBeforeIsSprintingInferiors());
                    addSorting(id, allBaseOverrideIsSprintingSuperiors, baseSorting.getOverrideIsSprintingSuperiors());
                    addSorting(id, allBaseOverrideIsSprintingInferiors, baseSorting.getOverrideIsSprintingInferiors());
                    addSorting(id, allBaseAfterIsSprintingSuperiors, baseSorting.getAfterIsSprintingSuperiors());
                    addSorting(id, allBaseAfterIsSprintingInferiors, baseSorting.getAfterIsSprintingInferiors());
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
                    addSorting(id, allBaseBeforeMoveEntitySuperiors, baseSorting.getBeforeMoveEntitySuperiors());
                    addSorting(id, allBaseBeforeMoveEntityInferiors, baseSorting.getBeforeMoveEntityInferiors());
                    addSorting(id, allBaseOverrideMoveEntitySuperiors, baseSorting.getOverrideMoveEntitySuperiors());
                    addSorting(id, allBaseOverrideMoveEntityInferiors, baseSorting.getOverrideMoveEntityInferiors());
                    addSorting(id, allBaseAfterMoveEntitySuperiors, baseSorting.getAfterMoveEntitySuperiors());
                    addSorting(id, allBaseAfterMoveEntityInferiors, baseSorting.getAfterMoveEntityInferiors());
                    addSorting(
                            id,
                            allBaseBeforeMoveEntityWithHeadingSuperiors,
                            baseSorting.getBeforeMoveEntityWithHeadingSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeMoveEntityWithHeadingInferiors,
                            baseSorting.getBeforeMoveEntityWithHeadingInferiors());
                    addSorting(
                            id,
                            allBaseOverrideMoveEntityWithHeadingSuperiors,
                            baseSorting.getOverrideMoveEntityWithHeadingSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideMoveEntityWithHeadingInferiors,
                            baseSorting.getOverrideMoveEntityWithHeadingInferiors());
                    addSorting(
                            id,
                            allBaseAfterMoveEntityWithHeadingSuperiors,
                            baseSorting.getAfterMoveEntityWithHeadingSuperiors());
                    addSorting(
                            id,
                            allBaseAfterMoveEntityWithHeadingInferiors,
                            baseSorting.getAfterMoveEntityWithHeadingInferiors());
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
                    addSorting(
                            id, allBaseBeforeOnLivingUpdateSuperiors, baseSorting.getBeforeOnLivingUpdateSuperiors());
                    addSorting(
                            id, allBaseBeforeOnLivingUpdateInferiors, baseSorting.getBeforeOnLivingUpdateInferiors());
                    addSorting(
                            id,
                            allBaseOverrideOnLivingUpdateSuperiors,
                            baseSorting.getOverrideOnLivingUpdateSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideOnLivingUpdateInferiors,
                            baseSorting.getOverrideOnLivingUpdateInferiors());
                    addSorting(id, allBaseAfterOnLivingUpdateSuperiors, baseSorting.getAfterOnLivingUpdateSuperiors());
                    addSorting(id, allBaseAfterOnLivingUpdateInferiors, baseSorting.getAfterOnLivingUpdateInferiors());
                    addSorting(id, allBaseBeforeOnKillEntitySuperiors, baseSorting.getBeforeOnKillEntitySuperiors());
                    addSorting(id, allBaseBeforeOnKillEntityInferiors, baseSorting.getBeforeOnKillEntityInferiors());
                    addSorting(
                            id, allBaseOverrideOnKillEntitySuperiors, baseSorting.getOverrideOnKillEntitySuperiors());
                    addSorting(
                            id, allBaseOverrideOnKillEntityInferiors, baseSorting.getOverrideOnKillEntityInferiors());
                    addSorting(id, allBaseAfterOnKillEntitySuperiors, baseSorting.getAfterOnKillEntitySuperiors());
                    addSorting(id, allBaseAfterOnKillEntityInferiors, baseSorting.getAfterOnKillEntityInferiors());
                    addSorting(
                            id,
                            allBaseBeforeOnStruckByLightningSuperiors,
                            baseSorting.getBeforeOnStruckByLightningSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeOnStruckByLightningInferiors,
                            baseSorting.getBeforeOnStruckByLightningInferiors());
                    addSorting(
                            id,
                            allBaseOverrideOnStruckByLightningSuperiors,
                            baseSorting.getOverrideOnStruckByLightningSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideOnStruckByLightningInferiors,
                            baseSorting.getOverrideOnStruckByLightningInferiors());
                    addSorting(
                            id,
                            allBaseAfterOnStruckByLightningSuperiors,
                            baseSorting.getAfterOnStruckByLightningSuperiors());
                    addSorting(
                            id,
                            allBaseAfterOnStruckByLightningInferiors,
                            baseSorting.getAfterOnStruckByLightningInferiors());
                    addSorting(id, allBaseBeforeOnUpdateSuperiors, baseSorting.getBeforeOnUpdateSuperiors());
                    addSorting(id, allBaseBeforeOnUpdateInferiors, baseSorting.getBeforeOnUpdateInferiors());
                    addSorting(id, allBaseOverrideOnUpdateSuperiors, baseSorting.getOverrideOnUpdateSuperiors());
                    addSorting(id, allBaseOverrideOnUpdateInferiors, baseSorting.getOverrideOnUpdateInferiors());
                    addSorting(id, allBaseAfterOnUpdateSuperiors, baseSorting.getAfterOnUpdateSuperiors());
                    addSorting(id, allBaseAfterOnUpdateInferiors, baseSorting.getAfterOnUpdateInferiors());
                    addSorting(id, allBaseBeforePlayStepSoundSuperiors, baseSorting.getBeforePlayStepSoundSuperiors());
                    addSorting(id, allBaseBeforePlayStepSoundInferiors, baseSorting.getBeforePlayStepSoundInferiors());
                    addSorting(
                            id, allBaseOverridePlayStepSoundSuperiors, baseSorting.getOverridePlayStepSoundSuperiors());
                    addSorting(
                            id, allBaseOverridePlayStepSoundInferiors, baseSorting.getOverridePlayStepSoundInferiors());
                    addSorting(id, allBaseAfterPlayStepSoundSuperiors, baseSorting.getAfterPlayStepSoundSuperiors());
                    addSorting(id, allBaseAfterPlayStepSoundInferiors, baseSorting.getAfterPlayStepSoundInferiors());
                    addSorting(
                            id, allBaseBeforePushOutOfBlocksSuperiors, baseSorting.getBeforePushOutOfBlocksSuperiors());
                    addSorting(
                            id, allBaseBeforePushOutOfBlocksInferiors, baseSorting.getBeforePushOutOfBlocksInferiors());
                    addSorting(
                            id,
                            allBaseOverridePushOutOfBlocksSuperiors,
                            baseSorting.getOverridePushOutOfBlocksSuperiors());
                    addSorting(
                            id,
                            allBaseOverridePushOutOfBlocksInferiors,
                            baseSorting.getOverridePushOutOfBlocksInferiors());
                    addSorting(
                            id, allBaseAfterPushOutOfBlocksSuperiors, baseSorting.getAfterPushOutOfBlocksSuperiors());
                    addSorting(
                            id, allBaseAfterPushOutOfBlocksInferiors, baseSorting.getAfterPushOutOfBlocksInferiors());
                    addSorting(id, allBaseBeforeRayTraceSuperiors, baseSorting.getBeforeRayTraceSuperiors());
                    addSorting(id, allBaseBeforeRayTraceInferiors, baseSorting.getBeforeRayTraceInferiors());
                    addSorting(id, allBaseOverrideRayTraceSuperiors, baseSorting.getOverrideRayTraceSuperiors());
                    addSorting(id, allBaseOverrideRayTraceInferiors, baseSorting.getOverrideRayTraceInferiors());
                    addSorting(id, allBaseAfterRayTraceSuperiors, baseSorting.getAfterRayTraceSuperiors());
                    addSorting(id, allBaseAfterRayTraceInferiors, baseSorting.getAfterRayTraceInferiors());
                    addSorting(
                            id,
                            allBaseBeforeReadEntityFromNBTSuperiors,
                            baseSorting.getBeforeReadEntityFromNBTSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeReadEntityFromNBTInferiors,
                            baseSorting.getBeforeReadEntityFromNBTInferiors());
                    addSorting(
                            id,
                            allBaseOverrideReadEntityFromNBTSuperiors,
                            baseSorting.getOverrideReadEntityFromNBTSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideReadEntityFromNBTInferiors,
                            baseSorting.getOverrideReadEntityFromNBTInferiors());
                    addSorting(
                            id,
                            allBaseAfterReadEntityFromNBTSuperiors,
                            baseSorting.getAfterReadEntityFromNBTSuperiors());
                    addSorting(
                            id,
                            allBaseAfterReadEntityFromNBTInferiors,
                            baseSorting.getAfterReadEntityFromNBTInferiors());
                    addSorting(id, allBaseBeforeRespawnPlayerSuperiors, baseSorting.getBeforeRespawnPlayerSuperiors());
                    addSorting(id, allBaseBeforeRespawnPlayerInferiors, baseSorting.getBeforeRespawnPlayerInferiors());
                    addSorting(
                            id, allBaseOverrideRespawnPlayerSuperiors, baseSorting.getOverrideRespawnPlayerSuperiors());
                    addSorting(
                            id, allBaseOverrideRespawnPlayerInferiors, baseSorting.getOverrideRespawnPlayerInferiors());
                    addSorting(id, allBaseAfterRespawnPlayerSuperiors, baseSorting.getAfterRespawnPlayerSuperiors());
                    addSorting(id, allBaseAfterRespawnPlayerInferiors, baseSorting.getAfterRespawnPlayerInferiors());
                    addSorting(id, allBaseBeforeSetDeadSuperiors, baseSorting.getBeforeSetDeadSuperiors());
                    addSorting(id, allBaseBeforeSetDeadInferiors, baseSorting.getBeforeSetDeadInferiors());
                    addSorting(id, allBaseOverrideSetDeadSuperiors, baseSorting.getOverrideSetDeadSuperiors());
                    addSorting(id, allBaseOverrideSetDeadInferiors, baseSorting.getOverrideSetDeadInferiors());
                    addSorting(id, allBaseAfterSetDeadSuperiors, baseSorting.getAfterSetDeadSuperiors());
                    addSorting(id, allBaseAfterSetDeadInferiors, baseSorting.getAfterSetDeadInferiors());
                    addSorting(
                            id,
                            allBaseBeforeSetPlayerSPHealthSuperiors,
                            baseSorting.getBeforeSetPlayerSPHealthSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeSetPlayerSPHealthInferiors,
                            baseSorting.getBeforeSetPlayerSPHealthInferiors());
                    addSorting(
                            id,
                            allBaseOverrideSetPlayerSPHealthSuperiors,
                            baseSorting.getOverrideSetPlayerSPHealthSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideSetPlayerSPHealthInferiors,
                            baseSorting.getOverrideSetPlayerSPHealthInferiors());
                    addSorting(
                            id,
                            allBaseAfterSetPlayerSPHealthSuperiors,
                            baseSorting.getAfterSetPlayerSPHealthSuperiors());
                    addSorting(
                            id,
                            allBaseAfterSetPlayerSPHealthInferiors,
                            baseSorting.getAfterSetPlayerSPHealthInferiors());
                    addSorting(
                            id,
                            allBaseBeforeSetPositionAndRotationSuperiors,
                            baseSorting.getBeforeSetPositionAndRotationSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeSetPositionAndRotationInferiors,
                            baseSorting.getBeforeSetPositionAndRotationInferiors());
                    addSorting(
                            id,
                            allBaseOverrideSetPositionAndRotationSuperiors,
                            baseSorting.getOverrideSetPositionAndRotationSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideSetPositionAndRotationInferiors,
                            baseSorting.getOverrideSetPositionAndRotationInferiors());
                    addSorting(
                            id,
                            allBaseAfterSetPositionAndRotationSuperiors,
                            baseSorting.getAfterSetPositionAndRotationSuperiors());
                    addSorting(
                            id,
                            allBaseAfterSetPositionAndRotationInferiors,
                            baseSorting.getAfterSetPositionAndRotationInferiors());
                    addSorting(id, allBaseBeforeSetSneakingSuperiors, baseSorting.getBeforeSetSneakingSuperiors());
                    addSorting(id, allBaseBeforeSetSneakingInferiors, baseSorting.getBeforeSetSneakingInferiors());
                    addSorting(id, allBaseOverrideSetSneakingSuperiors, baseSorting.getOverrideSetSneakingSuperiors());
                    addSorting(id, allBaseOverrideSetSneakingInferiors, baseSorting.getOverrideSetSneakingInferiors());
                    addSorting(id, allBaseAfterSetSneakingSuperiors, baseSorting.getAfterSetSneakingSuperiors());
                    addSorting(id, allBaseAfterSetSneakingInferiors, baseSorting.getAfterSetSneakingInferiors());
                    addSorting(id, allBaseBeforeSetSprintingSuperiors, baseSorting.getBeforeSetSprintingSuperiors());
                    addSorting(id, allBaseBeforeSetSprintingInferiors, baseSorting.getBeforeSetSprintingInferiors());
                    addSorting(
                            id, allBaseOverrideSetSprintingSuperiors, baseSorting.getOverrideSetSprintingSuperiors());
                    addSorting(
                            id, allBaseOverrideSetSprintingInferiors, baseSorting.getOverrideSetSprintingInferiors());
                    addSorting(id, allBaseAfterSetSprintingSuperiors, baseSorting.getAfterSetSprintingSuperiors());
                    addSorting(id, allBaseAfterSetSprintingInferiors, baseSorting.getAfterSetSprintingInferiors());
                    addSorting(id, allBaseBeforeSleepInBedAtSuperiors, baseSorting.getBeforeSleepInBedAtSuperiors());
                    addSorting(id, allBaseBeforeSleepInBedAtInferiors, baseSorting.getBeforeSleepInBedAtInferiors());
                    addSorting(
                            id, allBaseOverrideSleepInBedAtSuperiors, baseSorting.getOverrideSleepInBedAtSuperiors());
                    addSorting(
                            id, allBaseOverrideSleepInBedAtInferiors, baseSorting.getOverrideSleepInBedAtInferiors());
                    addSorting(id, allBaseAfterSleepInBedAtSuperiors, baseSorting.getAfterSleepInBedAtSuperiors());
                    addSorting(id, allBaseAfterSleepInBedAtInferiors, baseSorting.getAfterSleepInBedAtInferiors());
                    addSorting(id, allBaseBeforeSwingItemSuperiors, baseSorting.getBeforeSwingItemSuperiors());
                    addSorting(id, allBaseBeforeSwingItemInferiors, baseSorting.getBeforeSwingItemInferiors());
                    addSorting(id, allBaseOverrideSwingItemSuperiors, baseSorting.getOverrideSwingItemSuperiors());
                    addSorting(id, allBaseOverrideSwingItemInferiors, baseSorting.getOverrideSwingItemInferiors());
                    addSorting(id, allBaseAfterSwingItemSuperiors, baseSorting.getAfterSwingItemSuperiors());
                    addSorting(id, allBaseAfterSwingItemInferiors, baseSorting.getAfterSwingItemInferiors());
                    addSorting(
                            id,
                            allBaseBeforeUpdateEntityActionStateSuperiors,
                            baseSorting.getBeforeUpdateEntityActionStateSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeUpdateEntityActionStateInferiors,
                            baseSorting.getBeforeUpdateEntityActionStateInferiors());
                    addSorting(
                            id,
                            allBaseOverrideUpdateEntityActionStateSuperiors,
                            baseSorting.getOverrideUpdateEntityActionStateSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideUpdateEntityActionStateInferiors,
                            baseSorting.getOverrideUpdateEntityActionStateInferiors());
                    addSorting(
                            id,
                            allBaseAfterUpdateEntityActionStateSuperiors,
                            baseSorting.getAfterUpdateEntityActionStateSuperiors());
                    addSorting(
                            id,
                            allBaseAfterUpdateEntityActionStateInferiors,
                            baseSorting.getAfterUpdateEntityActionStateInferiors());
                    addSorting(id, allBaseBeforeUpdateRiddenSuperiors, baseSorting.getBeforeUpdateRiddenSuperiors());
                    addSorting(id, allBaseBeforeUpdateRiddenInferiors, baseSorting.getBeforeUpdateRiddenInferiors());
                    addSorting(
                            id, allBaseOverrideUpdateRiddenSuperiors, baseSorting.getOverrideUpdateRiddenSuperiors());
                    addSorting(
                            id, allBaseOverrideUpdateRiddenInferiors, baseSorting.getOverrideUpdateRiddenInferiors());
                    addSorting(id, allBaseAfterUpdateRiddenSuperiors, baseSorting.getAfterUpdateRiddenSuperiors());
                    addSorting(id, allBaseAfterUpdateRiddenInferiors, baseSorting.getAfterUpdateRiddenInferiors());
                    addSorting(id, allBaseBeforeWakeUpPlayerSuperiors, baseSorting.getBeforeWakeUpPlayerSuperiors());
                    addSorting(id, allBaseBeforeWakeUpPlayerInferiors, baseSorting.getBeforeWakeUpPlayerInferiors());
                    addSorting(
                            id, allBaseOverrideWakeUpPlayerSuperiors, baseSorting.getOverrideWakeUpPlayerSuperiors());
                    addSorting(
                            id, allBaseOverrideWakeUpPlayerInferiors, baseSorting.getOverrideWakeUpPlayerInferiors());
                    addSorting(id, allBaseAfterWakeUpPlayerSuperiors, baseSorting.getAfterWakeUpPlayerSuperiors());
                    addSorting(id, allBaseAfterWakeUpPlayerInferiors, baseSorting.getAfterWakeUpPlayerInferiors());
                    addSorting(
                            id,
                            allBaseBeforeWriteEntityToNBTSuperiors,
                            baseSorting.getBeforeWriteEntityToNBTSuperiors());
                    addSorting(
                            id,
                            allBaseBeforeWriteEntityToNBTInferiors,
                            baseSorting.getBeforeWriteEntityToNBTInferiors());
                    addSorting(
                            id,
                            allBaseOverrideWriteEntityToNBTSuperiors,
                            baseSorting.getOverrideWriteEntityToNBTSuperiors());
                    addSorting(
                            id,
                            allBaseOverrideWriteEntityToNBTInferiors,
                            baseSorting.getOverrideWriteEntityToNBTInferiors());
                    addSorting(
                            id, allBaseAfterWriteEntityToNBTSuperiors, baseSorting.getAfterWriteEntityToNBTSuperiors());
                    addSorting(
                            id, allBaseAfterWriteEntityToNBTInferiors, baseSorting.getAfterWriteEntityToNBTInferiors());
                }

                addMethod(
                        id,
                        baseClass,
                        beforeLocalConstructingHookTypes,
                        "beforeLocalConstructing",
                        Minecraft.class,
                        World.class,
                        Session.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        afterLocalConstructingHookTypes,
                        "afterLocalConstructing",
                        Minecraft.class,
                        World.class,
                        Session.class,
                        int.class);
                addMethod(id, baseClass, beforeAddExhaustionHookTypes, "beforeAddExhaustion", float.class);
                addMethod(id, baseClass, overrideAddExhaustionHookTypes, "addExhaustion", float.class);
                addMethod(id, baseClass, afterAddExhaustionHookTypes, "afterAddExhaustion", float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeAddMovementStatHookTypes,
                        "beforeAddMovementStat",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        overrideAddMovementStatHookTypes,
                        "addMovementStat",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        afterAddMovementStatHookTypes,
                        "afterAddMovementStat",
                        double.class,
                        double.class,
                        double.class);
                addMethod(id, baseClass, beforeAddStatHookTypes, "beforeAddStat", StatBase.class, int.class);
                addMethod(id, baseClass, overrideAddStatHookTypes, "addStat", StatBase.class, int.class);
                addMethod(id, baseClass, afterAddStatHookTypes, "afterAddStat", StatBase.class, int.class);
                addMethod(
                        id,
                        baseClass,
                        beforeAttackEntityFromHookTypes,
                        "beforeAttackEntityFrom",
                        DamageSource.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        overrideAttackEntityFromHookTypes,
                        "attackEntityFrom",
                        DamageSource.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        afterAttackEntityFromHookTypes,
                        "afterAttackEntityFrom",
                        DamageSource.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeAttackTargetEntityWithCurrentItemHookTypes,
                        "beforeAttackTargetEntityWithCurrentItem",
                        Entity.class);
                addMethod(
                        id,
                        baseClass,
                        overrideAttackTargetEntityWithCurrentItemHookTypes,
                        "attackTargetEntityWithCurrentItem",
                        Entity.class);
                addMethod(
                        id,
                        baseClass,
                        afterAttackTargetEntityWithCurrentItemHookTypes,
                        "afterAttackTargetEntityWithCurrentItem",
                        Entity.class);
                addMethod(id, baseClass, beforeCanBreatheUnderwaterHookTypes, "beforeCanBreatheUnderwater");
                addMethod(id, baseClass, overrideCanBreatheUnderwaterHookTypes, "canBreatheUnderwater");
                addMethod(id, baseClass, afterCanBreatheUnderwaterHookTypes, "afterCanBreatheUnderwater");
                addMethod(id, baseClass, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", Block.class);
                addMethod(id, baseClass, overrideCanHarvestBlockHookTypes, "canHarvestBlock", Block.class);
                addMethod(id, baseClass, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", Block.class);
                addMethod(
                        id,
                        baseClass,
                        beforeCanPlayerEditHookTypes,
                        "beforeCanPlayerEdit",
                        int.class,
                        int.class,
                        int.class,
                        int.class,
                        ItemStack.class);
                addMethod(
                        id,
                        baseClass,
                        overrideCanPlayerEditHookTypes,
                        "canPlayerEdit",
                        int.class,
                        int.class,
                        int.class,
                        int.class,
                        ItemStack.class);
                addMethod(
                        id,
                        baseClass,
                        afterCanPlayerEditHookTypes,
                        "afterCanPlayerEdit",
                        int.class,
                        int.class,
                        int.class,
                        int.class,
                        ItemStack.class);
                addMethod(id, baseClass, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking");
                addMethod(id, baseClass, overrideCanTriggerWalkingHookTypes, "canTriggerWalking");
                addMethod(id, baseClass, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking");
                addMethod(id, baseClass, beforeCloseScreenHookTypes, "beforeCloseScreen");
                addMethod(id, baseClass, overrideCloseScreenHookTypes, "closeScreen");
                addMethod(id, baseClass, afterCloseScreenHookTypes, "afterCloseScreen");
                addMethod(
                        id,
                        baseClass,
                        beforeDamageEntityHookTypes,
                        "beforeDamageEntity",
                        DamageSource.class,
                        float.class);
                addMethod(
                        id, baseClass, overrideDamageEntityHookTypes, "damageEntity", DamageSource.class, float.class);
                addMethod(
                        id,
                        baseClass,
                        afterDamageEntityHookTypes,
                        "afterDamageEntity",
                        DamageSource.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDisplayGUIBrewingStandHookTypes,
                        "beforeDisplayGUIBrewingStand",
                        TileEntityBrewingStand.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDisplayGUIBrewingStandHookTypes,
                        "displayGUIBrewingStand",
                        TileEntityBrewingStand.class);
                addMethod(
                        id,
                        baseClass,
                        afterDisplayGUIBrewingStandHookTypes,
                        "afterDisplayGUIBrewingStand",
                        TileEntityBrewingStand.class);
                addMethod(id, baseClass, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", IInventory.class);
                addMethod(id, baseClass, overrideDisplayGUIChestHookTypes, "displayGUIChest", IInventory.class);
                addMethod(id, baseClass, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", IInventory.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDisplayGUIDispenserHookTypes,
                        "beforeDisplayGUIDispenser",
                        TileEntityDispenser.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDisplayGUIDispenserHookTypes,
                        "displayGUIDispenser",
                        TileEntityDispenser.class);
                addMethod(
                        id,
                        baseClass,
                        afterDisplayGUIDispenserHookTypes,
                        "afterDisplayGUIDispenser",
                        TileEntityDispenser.class);
                addMethod(
                        id, baseClass, beforeDisplayGUIEditSignHookTypes, "beforeDisplayGUIEditSign", TileEntity.class);
                addMethod(id, baseClass, overrideDisplayGUIEditSignHookTypes, "displayGUIEditSign", TileEntity.class);
                addMethod(id, baseClass, afterDisplayGUIEditSignHookTypes, "afterDisplayGUIEditSign", TileEntity.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDisplayGUIEnchantmentHookTypes,
                        "beforeDisplayGUIEnchantment",
                        int.class,
                        int.class,
                        int.class,
                        String.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDisplayGUIEnchantmentHookTypes,
                        "displayGUIEnchantment",
                        int.class,
                        int.class,
                        int.class,
                        String.class);
                addMethod(
                        id,
                        baseClass,
                        afterDisplayGUIEnchantmentHookTypes,
                        "afterDisplayGUIEnchantment",
                        int.class,
                        int.class,
                        int.class,
                        String.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDisplayGUIFurnaceHookTypes,
                        "beforeDisplayGUIFurnace",
                        TileEntityFurnace.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDisplayGUIFurnaceHookTypes,
                        "displayGUIFurnace",
                        TileEntityFurnace.class);
                addMethod(
                        id,
                        baseClass,
                        afterDisplayGUIFurnaceHookTypes,
                        "afterDisplayGUIFurnace",
                        TileEntityFurnace.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDisplayGUIWorkbenchHookTypes,
                        "beforeDisplayGUIWorkbench",
                        int.class,
                        int.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDisplayGUIWorkbenchHookTypes,
                        "displayGUIWorkbench",
                        int.class,
                        int.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        afterDisplayGUIWorkbenchHookTypes,
                        "afterDisplayGUIWorkbench",
                        int.class,
                        int.class,
                        int.class);
                addMethod(id, baseClass, beforeDropOneItemHookTypes, "beforeDropOneItem", boolean.class);
                addMethod(id, baseClass, overrideDropOneItemHookTypes, "dropOneItem", boolean.class);
                addMethod(id, baseClass, afterDropOneItemHookTypes, "afterDropOneItem", boolean.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDropPlayerItemHookTypes,
                        "beforeDropPlayerItem",
                        ItemStack.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDropPlayerItemHookTypes,
                        "dropPlayerItem",
                        ItemStack.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        afterDropPlayerItemHookTypes,
                        "afterDropPlayerItem",
                        ItemStack.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        beforeDropPlayerItemWithRandomChoiceHookTypes,
                        "beforeDropPlayerItemWithRandomChoice",
                        ItemStack.class,
                        boolean.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        overrideDropPlayerItemWithRandomChoiceHookTypes,
                        "dropPlayerItemWithRandomChoice",
                        ItemStack.class,
                        boolean.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        afterDropPlayerItemWithRandomChoiceHookTypes,
                        "afterDropPlayerItemWithRandomChoice",
                        ItemStack.class,
                        boolean.class,
                        boolean.class);
                addMethod(id, baseClass, beforeFallHookTypes, "beforeFall", float.class);
                addMethod(id, baseClass, overrideFallHookTypes, "fall", float.class);
                addMethod(id, baseClass, afterFallHookTypes, "afterFall", float.class);
                addMethod(id, baseClass, beforeGetAIMoveSpeedHookTypes, "beforeGetAIMoveSpeed");
                addMethod(id, baseClass, overrideGetAIMoveSpeedHookTypes, "getAIMoveSpeed");
                addMethod(id, baseClass, afterGetAIMoveSpeedHookTypes, "afterGetAIMoveSpeed");
                addMethod(id, baseClass, beforeGetBedOrientationInDegreesHookTypes, "beforeGetBedOrientationInDegrees");
                addMethod(id, baseClass, overrideGetBedOrientationInDegreesHookTypes, "getBedOrientationInDegrees");
                addMethod(id, baseClass, afterGetBedOrientationInDegreesHookTypes, "afterGetBedOrientationInDegrees");
                addMethod(id, baseClass, beforeGetBrightnessHookTypes, "beforeGetBrightness", float.class);
                addMethod(id, baseClass, overrideGetBrightnessHookTypes, "getBrightness", float.class);
                addMethod(id, baseClass, afterGetBrightnessHookTypes, "afterGetBrightness", float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeGetBrightnessForRenderHookTypes,
                        "beforeGetBrightnessForRender",
                        float.class);
                addMethod(
                        id, baseClass, overrideGetBrightnessForRenderHookTypes, "getBrightnessForRender", float.class);
                addMethod(
                        id,
                        baseClass,
                        afterGetBrightnessForRenderHookTypes,
                        "afterGetBrightnessForRender",
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeGetCurrentPlayerStrVsBlockHookTypes,
                        "beforeGetCurrentPlayerStrVsBlock",
                        Block.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        overrideGetCurrentPlayerStrVsBlockHookTypes,
                        "getCurrentPlayerStrVsBlock",
                        Block.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        afterGetCurrentPlayerStrVsBlockHookTypes,
                        "afterGetCurrentPlayerStrVsBlock",
                        Block.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        beforeGetCurrentPlayerStrVsBlockForgeHookTypes,
                        "beforeGetCurrentPlayerStrVsBlockForge",
                        Block.class,
                        boolean.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        overrideGetCurrentPlayerStrVsBlockForgeHookTypes,
                        "getCurrentPlayerStrVsBlockForge",
                        Block.class,
                        boolean.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        afterGetCurrentPlayerStrVsBlockForgeHookTypes,
                        "afterGetCurrentPlayerStrVsBlockForge",
                        Block.class,
                        boolean.class,
                        int.class);
                addMethod(
                        id,
                        baseClass,
                        beforeGetDistanceSqHookTypes,
                        "beforeGetDistanceSq",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        overrideGetDistanceSqHookTypes,
                        "getDistanceSq",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        afterGetDistanceSqHookTypes,
                        "afterGetDistanceSq",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        beforeGetDistanceSqToEntityHookTypes,
                        "beforeGetDistanceSqToEntity",
                        Entity.class);
                addMethod(id, baseClass, overrideGetDistanceSqToEntityHookTypes, "getDistanceSqToEntity", Entity.class);
                addMethod(
                        id, baseClass, afterGetDistanceSqToEntityHookTypes, "afterGetDistanceSqToEntity", Entity.class);
                addMethod(id, baseClass, beforeGetFOVMultiplierHookTypes, "beforeGetFOVMultiplier");
                addMethod(id, baseClass, overrideGetFOVMultiplierHookTypes, "getFOVMultiplier");
                addMethod(id, baseClass, afterGetFOVMultiplierHookTypes, "afterGetFOVMultiplier");
                addMethod(id, baseClass, beforeGetHurtSoundHookTypes, "beforeGetHurtSound");
                addMethod(id, baseClass, overrideGetHurtSoundHookTypes, "getHurtSound");
                addMethod(id, baseClass, afterGetHurtSoundHookTypes, "afterGetHurtSound");
                addMethod(id, baseClass, beforeGetItemIconHookTypes, "beforeGetItemIcon", ItemStack.class, int.class);
                addMethod(id, baseClass, overrideGetItemIconHookTypes, "getItemIcon", ItemStack.class, int.class);
                addMethod(id, baseClass, afterGetItemIconHookTypes, "afterGetItemIcon", ItemStack.class, int.class);
                addMethod(id, baseClass, beforeGetSleepTimerHookTypes, "beforeGetSleepTimer");
                addMethod(id, baseClass, overrideGetSleepTimerHookTypes, "getSleepTimer");
                addMethod(id, baseClass, afterGetSleepTimerHookTypes, "afterGetSleepTimer");
                addMethod(id, baseClass, beforeHandleLavaMovementHookTypes, "beforeHandleLavaMovement");
                addMethod(id, baseClass, overrideHandleLavaMovementHookTypes, "handleLavaMovement");
                addMethod(id, baseClass, afterHandleLavaMovementHookTypes, "afterHandleLavaMovement");
                addMethod(id, baseClass, beforeHandleWaterMovementHookTypes, "beforeHandleWaterMovement");
                addMethod(id, baseClass, overrideHandleWaterMovementHookTypes, "handleWaterMovement");
                addMethod(id, baseClass, afterHandleWaterMovementHookTypes, "afterHandleWaterMovement");
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
                addMethod(id, baseClass, beforeIsSprintingHookTypes, "beforeIsSprinting");
                addMethod(id, baseClass, overrideIsSprintingHookTypes, "isSprinting");
                addMethod(id, baseClass, afterIsSprintingHookTypes, "afterIsSprinting");
                addMethod(id, baseClass, beforeJumpHookTypes, "beforeJump");
                addMethod(id, baseClass, overrideJumpHookTypes, "jump");
                addMethod(id, baseClass, afterJumpHookTypes, "afterJump");
                addMethod(
                        id,
                        baseClass,
                        beforeKnockBackHookTypes,
                        "beforeKnockBack",
                        Entity.class,
                        float.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        overrideKnockBackHookTypes,
                        "knockBack",
                        Entity.class,
                        float.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        afterKnockBackHookTypes,
                        "afterKnockBack",
                        Entity.class,
                        float.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        beforeMoveEntityHookTypes,
                        "beforeMoveEntity",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        overrideMoveEntityHookTypes,
                        "moveEntity",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        afterMoveEntityHookTypes,
                        "afterMoveEntity",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        beforeMoveEntityWithHeadingHookTypes,
                        "beforeMoveEntityWithHeading",
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        overrideMoveEntityWithHeadingHookTypes,
                        "moveEntityWithHeading",
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        afterMoveEntityWithHeadingHookTypes,
                        "afterMoveEntityWithHeading",
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeMoveFlyingHookTypes,
                        "beforeMoveFlying",
                        float.class,
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        overrideMoveFlyingHookTypes,
                        "moveFlying",
                        float.class,
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        afterMoveFlyingHookTypes,
                        "afterMoveFlying",
                        float.class,
                        float.class,
                        float.class);
                addMethod(id, baseClass, beforeOnDeathHookTypes, "beforeOnDeath", DamageSource.class);
                addMethod(id, baseClass, overrideOnDeathHookTypes, "onDeath", DamageSource.class);
                addMethod(id, baseClass, afterOnDeathHookTypes, "afterOnDeath", DamageSource.class);
                addMethod(id, baseClass, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate");
                addMethod(id, baseClass, overrideOnLivingUpdateHookTypes, "onLivingUpdate");
                addMethod(id, baseClass, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate");
                addMethod(id, baseClass, beforeOnKillEntityHookTypes, "beforeOnKillEntity", EntityLivingBase.class);
                addMethod(id, baseClass, overrideOnKillEntityHookTypes, "onKillEntity", EntityLivingBase.class);
                addMethod(id, baseClass, afterOnKillEntityHookTypes, "afterOnKillEntity", EntityLivingBase.class);
                addMethod(
                        id,
                        baseClass,
                        beforeOnStruckByLightningHookTypes,
                        "beforeOnStruckByLightning",
                        EntityLightningBolt.class);
                addMethod(
                        id,
                        baseClass,
                        overrideOnStruckByLightningHookTypes,
                        "onStruckByLightning",
                        EntityLightningBolt.class);
                addMethod(
                        id,
                        baseClass,
                        afterOnStruckByLightningHookTypes,
                        "afterOnStruckByLightning",
                        EntityLightningBolt.class);
                addMethod(id, baseClass, beforeOnUpdateHookTypes, "beforeOnUpdate");
                addMethod(id, baseClass, overrideOnUpdateHookTypes, "onUpdate");
                addMethod(id, baseClass, afterOnUpdateHookTypes, "afterOnUpdate");
                addMethod(
                        id,
                        baseClass,
                        beforePlayStepSoundHookTypes,
                        "beforePlayStepSound",
                        int.class,
                        int.class,
                        int.class,
                        Block.class);
                addMethod(
                        id,
                        baseClass,
                        overridePlayStepSoundHookTypes,
                        "playStepSound",
                        int.class,
                        int.class,
                        int.class,
                        Block.class);
                addMethod(
                        id,
                        baseClass,
                        afterPlayStepSoundHookTypes,
                        "afterPlayStepSound",
                        int.class,
                        int.class,
                        int.class,
                        Block.class);
                addMethod(
                        id,
                        baseClass,
                        beforePushOutOfBlocksHookTypes,
                        "beforePushOutOfBlocks",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        overridePushOutOfBlocksHookTypes,
                        "pushOutOfBlocks",
                        double.class,
                        double.class,
                        double.class);
                addMethod(
                        id,
                        baseClass,
                        afterPushOutOfBlocksHookTypes,
                        "afterPushOutOfBlocks",
                        double.class,
                        double.class,
                        double.class);
                addMethod(id, baseClass, beforeRayTraceHookTypes, "beforeRayTrace", double.class, float.class);
                addMethod(id, baseClass, overrideRayTraceHookTypes, "rayTrace", double.class, float.class);
                addMethod(id, baseClass, afterRayTraceHookTypes, "afterRayTrace", double.class, float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeReadEntityFromNBTHookTypes,
                        "beforeReadEntityFromNBT",
                        NBTTagCompound.class);
                addMethod(id, baseClass, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", NBTTagCompound.class);
                addMethod(
                        id, baseClass, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", NBTTagCompound.class);
                addMethod(id, baseClass, beforeRespawnPlayerHookTypes, "beforeRespawnPlayer");
                addMethod(id, baseClass, overrideRespawnPlayerHookTypes, "respawnPlayer");
                addMethod(id, baseClass, afterRespawnPlayerHookTypes, "afterRespawnPlayer");
                addMethod(id, baseClass, beforeSetDeadHookTypes, "beforeSetDead");
                addMethod(id, baseClass, overrideSetDeadHookTypes, "setDead");
                addMethod(id, baseClass, afterSetDeadHookTypes, "afterSetDead");
                addMethod(id, baseClass, beforeSetPlayerSPHealthHookTypes, "beforeSetPlayerSPHealth", float.class);
                addMethod(id, baseClass, overrideSetPlayerSPHealthHookTypes, "setPlayerSPHealth", float.class);
                addMethod(id, baseClass, afterSetPlayerSPHealthHookTypes, "afterSetPlayerSPHealth", float.class);
                addMethod(
                        id,
                        baseClass,
                        beforeSetPositionAndRotationHookTypes,
                        "beforeSetPositionAndRotation",
                        double.class,
                        double.class,
                        double.class,
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        overrideSetPositionAndRotationHookTypes,
                        "setPositionAndRotation",
                        double.class,
                        double.class,
                        double.class,
                        float.class,
                        float.class);
                addMethod(
                        id,
                        baseClass,
                        afterSetPositionAndRotationHookTypes,
                        "afterSetPositionAndRotation",
                        double.class,
                        double.class,
                        double.class,
                        float.class,
                        float.class);
                addMethod(id, baseClass, beforeSetSneakingHookTypes, "beforeSetSneaking", boolean.class);
                addMethod(id, baseClass, overrideSetSneakingHookTypes, "setSneaking", boolean.class);
                addMethod(id, baseClass, afterSetSneakingHookTypes, "afterSetSneaking", boolean.class);
                addMethod(id, baseClass, beforeSetSprintingHookTypes, "beforeSetSprinting", boolean.class);
                addMethod(id, baseClass, overrideSetSprintingHookTypes, "setSprinting", boolean.class);
                addMethod(id, baseClass, afterSetSprintingHookTypes, "afterSetSprinting", boolean.class);
                addMethod(
                        id,
                        baseClass,
                        beforeSleepInBedAtHookTypes,
                        "beforeSleepInBedAt",
                        int.class,
                        int.class,
                        int.class);
                addMethod(
                        id, baseClass, overrideSleepInBedAtHookTypes, "sleepInBedAt", int.class, int.class, int.class);
                addMethod(
                        id,
                        baseClass,
                        afterSleepInBedAtHookTypes,
                        "afterSleepInBedAt",
                        int.class,
                        int.class,
                        int.class);
                addMethod(id, baseClass, beforeSwingItemHookTypes, "beforeSwingItem");
                addMethod(id, baseClass, overrideSwingItemHookTypes, "swingItem");
                addMethod(id, baseClass, afterSwingItemHookTypes, "afterSwingItem");
                addMethod(id, baseClass, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState");
                addMethod(id, baseClass, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState");
                addMethod(id, baseClass, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState");
                addMethod(id, baseClass, beforeUpdateRiddenHookTypes, "beforeUpdateRidden");
                addMethod(id, baseClass, overrideUpdateRiddenHookTypes, "updateRidden");
                addMethod(id, baseClass, afterUpdateRiddenHookTypes, "afterUpdateRidden");
                addMethod(
                        id,
                        baseClass,
                        beforeWakeUpPlayerHookTypes,
                        "beforeWakeUpPlayer",
                        boolean.class,
                        boolean.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        overrideWakeUpPlayerHookTypes,
                        "wakeUpPlayer",
                        boolean.class,
                        boolean.class,
                        boolean.class);
                addMethod(
                        id,
                        baseClass,
                        afterWakeUpPlayerHookTypes,
                        "afterWakeUpPlayer",
                        boolean.class,
                        boolean.class,
                        boolean.class);
                addMethod(
                        id, baseClass, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", NBTTagCompound.class);
                addMethod(id, baseClass, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", NBTTagCompound.class);
                addMethod(id, baseClass, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", NBTTagCompound.class);

                addDynamicMethods(id, baseClass);

                addDynamicKeys(id, baseClass, beforeDynamicHookMethods, beforeDynamicHookTypes);
                addDynamicKeys(id, baseClass, overrideDynamicHookMethods, overrideDynamicHookTypes);
                addDynamicKeys(id, baseClass, afterDynamicHookMethods, afterDynamicHookTypes);

                initialize();

                for (IClientPlayerAPI instance : getAllInstancesList()) {
                    instance.getClientPlayerAPI().attachClientPlayerBase(id);
                }

                System.out.println("Client Player: registered " + id);
                logger.fine("Client Player: registered class '" + baseClass.getName() + "' with id '" + id + "'");
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
                for (IClientPlayerAPI instance : getAllInstancesList()) {
                    instance.getClientPlayerAPI().detachClientPlayerBase(id);
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
                allBaseBeforeAddMovementStatSuperiors.remove(id);
                allBaseBeforeAddMovementStatInferiors.remove(id);
                allBaseOverrideAddMovementStatSuperiors.remove(id);
                allBaseOverrideAddMovementStatInferiors.remove(id);
                allBaseAfterAddMovementStatSuperiors.remove(id);
                allBaseAfterAddMovementStatInferiors.remove(id);
                beforeAddMovementStatHookTypes.remove(id);
                overrideAddMovementStatHookTypes.remove(id);
                afterAddMovementStatHookTypes.remove(id);
                allBaseBeforeAddStatSuperiors.remove(id);
                allBaseBeforeAddStatInferiors.remove(id);
                allBaseOverrideAddStatSuperiors.remove(id);
                allBaseOverrideAddStatInferiors.remove(id);
                allBaseAfterAddStatSuperiors.remove(id);
                allBaseAfterAddStatInferiors.remove(id);
                beforeAddStatHookTypes.remove(id);
                overrideAddStatHookTypes.remove(id);
                afterAddStatHookTypes.remove(id);
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
                allBaseBeforeCloseScreenSuperiors.remove(id);
                allBaseBeforeCloseScreenInferiors.remove(id);
                allBaseOverrideCloseScreenSuperiors.remove(id);
                allBaseOverrideCloseScreenInferiors.remove(id);
                allBaseAfterCloseScreenSuperiors.remove(id);
                allBaseAfterCloseScreenInferiors.remove(id);
                beforeCloseScreenHookTypes.remove(id);
                overrideCloseScreenHookTypes.remove(id);
                afterCloseScreenHookTypes.remove(id);
                allBaseBeforeDamageEntitySuperiors.remove(id);
                allBaseBeforeDamageEntityInferiors.remove(id);
                allBaseOverrideDamageEntitySuperiors.remove(id);
                allBaseOverrideDamageEntityInferiors.remove(id);
                allBaseAfterDamageEntitySuperiors.remove(id);
                allBaseAfterDamageEntityInferiors.remove(id);
                beforeDamageEntityHookTypes.remove(id);
                overrideDamageEntityHookTypes.remove(id);
                afterDamageEntityHookTypes.remove(id);
                allBaseBeforeDisplayGUIBrewingStandSuperiors.remove(id);
                allBaseBeforeDisplayGUIBrewingStandInferiors.remove(id);
                allBaseOverrideDisplayGUIBrewingStandSuperiors.remove(id);
                allBaseOverrideDisplayGUIBrewingStandInferiors.remove(id);
                allBaseAfterDisplayGUIBrewingStandSuperiors.remove(id);
                allBaseAfterDisplayGUIBrewingStandInferiors.remove(id);
                beforeDisplayGUIBrewingStandHookTypes.remove(id);
                overrideDisplayGUIBrewingStandHookTypes.remove(id);
                afterDisplayGUIBrewingStandHookTypes.remove(id);
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
                allBaseBeforeDisplayGUIEditSignSuperiors.remove(id);
                allBaseBeforeDisplayGUIEditSignInferiors.remove(id);
                allBaseOverrideDisplayGUIEditSignSuperiors.remove(id);
                allBaseOverrideDisplayGUIEditSignInferiors.remove(id);
                allBaseAfterDisplayGUIEditSignSuperiors.remove(id);
                allBaseAfterDisplayGUIEditSignInferiors.remove(id);
                beforeDisplayGUIEditSignHookTypes.remove(id);
                overrideDisplayGUIEditSignHookTypes.remove(id);
                afterDisplayGUIEditSignHookTypes.remove(id);
                allBaseBeforeDisplayGUIEnchantmentSuperiors.remove(id);
                allBaseBeforeDisplayGUIEnchantmentInferiors.remove(id);
                allBaseOverrideDisplayGUIEnchantmentSuperiors.remove(id);
                allBaseOverrideDisplayGUIEnchantmentInferiors.remove(id);
                allBaseAfterDisplayGUIEnchantmentSuperiors.remove(id);
                allBaseAfterDisplayGUIEnchantmentInferiors.remove(id);
                beforeDisplayGUIEnchantmentHookTypes.remove(id);
                overrideDisplayGUIEnchantmentHookTypes.remove(id);
                afterDisplayGUIEnchantmentHookTypes.remove(id);
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
                allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors.remove(id);
                allBaseBeforeDropPlayerItemWithRandomChoiceInferiors.remove(id);
                allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors.remove(id);
                allBaseOverrideDropPlayerItemWithRandomChoiceInferiors.remove(id);
                allBaseAfterDropPlayerItemWithRandomChoiceSuperiors.remove(id);
                allBaseAfterDropPlayerItemWithRandomChoiceInferiors.remove(id);
                beforeDropPlayerItemWithRandomChoiceHookTypes.remove(id);
                overrideDropPlayerItemWithRandomChoiceHookTypes.remove(id);
                afterDropPlayerItemWithRandomChoiceHookTypes.remove(id);
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
                allBaseBeforeGetBedOrientationInDegreesSuperiors.remove(id);
                allBaseBeforeGetBedOrientationInDegreesInferiors.remove(id);
                allBaseOverrideGetBedOrientationInDegreesSuperiors.remove(id);
                allBaseOverrideGetBedOrientationInDegreesInferiors.remove(id);
                allBaseAfterGetBedOrientationInDegreesSuperiors.remove(id);
                allBaseAfterGetBedOrientationInDegreesInferiors.remove(id);
                beforeGetBedOrientationInDegreesHookTypes.remove(id);
                overrideGetBedOrientationInDegreesHookTypes.remove(id);
                afterGetBedOrientationInDegreesHookTypes.remove(id);
                allBaseBeforeGetBrightnessSuperiors.remove(id);
                allBaseBeforeGetBrightnessInferiors.remove(id);
                allBaseOverrideGetBrightnessSuperiors.remove(id);
                allBaseOverrideGetBrightnessInferiors.remove(id);
                allBaseAfterGetBrightnessSuperiors.remove(id);
                allBaseAfterGetBrightnessInferiors.remove(id);
                beforeGetBrightnessHookTypes.remove(id);
                overrideGetBrightnessHookTypes.remove(id);
                afterGetBrightnessHookTypes.remove(id);
                allBaseBeforeGetBrightnessForRenderSuperiors.remove(id);
                allBaseBeforeGetBrightnessForRenderInferiors.remove(id);
                allBaseOverrideGetBrightnessForRenderSuperiors.remove(id);
                allBaseOverrideGetBrightnessForRenderInferiors.remove(id);
                allBaseAfterGetBrightnessForRenderSuperiors.remove(id);
                allBaseAfterGetBrightnessForRenderInferiors.remove(id);
                beforeGetBrightnessForRenderHookTypes.remove(id);
                overrideGetBrightnessForRenderHookTypes.remove(id);
                afterGetBrightnessForRenderHookTypes.remove(id);
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
                allBaseBeforeGetDistanceSqToEntitySuperiors.remove(id);
                allBaseBeforeGetDistanceSqToEntityInferiors.remove(id);
                allBaseOverrideGetDistanceSqToEntitySuperiors.remove(id);
                allBaseOverrideGetDistanceSqToEntityInferiors.remove(id);
                allBaseAfterGetDistanceSqToEntitySuperiors.remove(id);
                allBaseAfterGetDistanceSqToEntityInferiors.remove(id);
                beforeGetDistanceSqToEntityHookTypes.remove(id);
                overrideGetDistanceSqToEntityHookTypes.remove(id);
                afterGetDistanceSqToEntityHookTypes.remove(id);
                allBaseBeforeGetFOVMultiplierSuperiors.remove(id);
                allBaseBeforeGetFOVMultiplierInferiors.remove(id);
                allBaseOverrideGetFOVMultiplierSuperiors.remove(id);
                allBaseOverrideGetFOVMultiplierInferiors.remove(id);
                allBaseAfterGetFOVMultiplierSuperiors.remove(id);
                allBaseAfterGetFOVMultiplierInferiors.remove(id);
                beforeGetFOVMultiplierHookTypes.remove(id);
                overrideGetFOVMultiplierHookTypes.remove(id);
                afterGetFOVMultiplierHookTypes.remove(id);
                allBaseBeforeGetHurtSoundSuperiors.remove(id);
                allBaseBeforeGetHurtSoundInferiors.remove(id);
                allBaseOverrideGetHurtSoundSuperiors.remove(id);
                allBaseOverrideGetHurtSoundInferiors.remove(id);
                allBaseAfterGetHurtSoundSuperiors.remove(id);
                allBaseAfterGetHurtSoundInferiors.remove(id);
                beforeGetHurtSoundHookTypes.remove(id);
                overrideGetHurtSoundHookTypes.remove(id);
                afterGetHurtSoundHookTypes.remove(id);
                allBaseBeforeGetItemIconSuperiors.remove(id);
                allBaseBeforeGetItemIconInferiors.remove(id);
                allBaseOverrideGetItemIconSuperiors.remove(id);
                allBaseOverrideGetItemIconInferiors.remove(id);
                allBaseAfterGetItemIconSuperiors.remove(id);
                allBaseAfterGetItemIconInferiors.remove(id);
                beforeGetItemIconHookTypes.remove(id);
                overrideGetItemIconHookTypes.remove(id);
                afterGetItemIconHookTypes.remove(id);
                allBaseBeforeGetSleepTimerSuperiors.remove(id);
                allBaseBeforeGetSleepTimerInferiors.remove(id);
                allBaseOverrideGetSleepTimerSuperiors.remove(id);
                allBaseOverrideGetSleepTimerInferiors.remove(id);
                allBaseAfterGetSleepTimerSuperiors.remove(id);
                allBaseAfterGetSleepTimerInferiors.remove(id);
                beforeGetSleepTimerHookTypes.remove(id);
                overrideGetSleepTimerHookTypes.remove(id);
                afterGetSleepTimerHookTypes.remove(id);
                allBaseBeforeHandleLavaMovementSuperiors.remove(id);
                allBaseBeforeHandleLavaMovementInferiors.remove(id);
                allBaseOverrideHandleLavaMovementSuperiors.remove(id);
                allBaseOverrideHandleLavaMovementInferiors.remove(id);
                allBaseAfterHandleLavaMovementSuperiors.remove(id);
                allBaseAfterHandleLavaMovementInferiors.remove(id);
                beforeHandleLavaMovementHookTypes.remove(id);
                overrideHandleLavaMovementHookTypes.remove(id);
                afterHandleLavaMovementHookTypes.remove(id);
                allBaseBeforeHandleWaterMovementSuperiors.remove(id);
                allBaseBeforeHandleWaterMovementInferiors.remove(id);
                allBaseOverrideHandleWaterMovementSuperiors.remove(id);
                allBaseOverrideHandleWaterMovementInferiors.remove(id);
                allBaseAfterHandleWaterMovementSuperiors.remove(id);
                allBaseAfterHandleWaterMovementInferiors.remove(id);
                beforeHandleWaterMovementHookTypes.remove(id);
                overrideHandleWaterMovementHookTypes.remove(id);
                afterHandleWaterMovementHookTypes.remove(id);
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
                allBaseBeforeIsSprintingSuperiors.remove(id);
                allBaseBeforeIsSprintingInferiors.remove(id);
                allBaseOverrideIsSprintingSuperiors.remove(id);
                allBaseOverrideIsSprintingInferiors.remove(id);
                allBaseAfterIsSprintingSuperiors.remove(id);
                allBaseAfterIsSprintingInferiors.remove(id);
                beforeIsSprintingHookTypes.remove(id);
                overrideIsSprintingHookTypes.remove(id);
                afterIsSprintingHookTypes.remove(id);
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
                allBaseBeforePlayStepSoundSuperiors.remove(id);
                allBaseBeforePlayStepSoundInferiors.remove(id);
                allBaseOverridePlayStepSoundSuperiors.remove(id);
                allBaseOverridePlayStepSoundInferiors.remove(id);
                allBaseAfterPlayStepSoundSuperiors.remove(id);
                allBaseAfterPlayStepSoundInferiors.remove(id);
                beforePlayStepSoundHookTypes.remove(id);
                overridePlayStepSoundHookTypes.remove(id);
                afterPlayStepSoundHookTypes.remove(id);
                allBaseBeforePushOutOfBlocksSuperiors.remove(id);
                allBaseBeforePushOutOfBlocksInferiors.remove(id);
                allBaseOverridePushOutOfBlocksSuperiors.remove(id);
                allBaseOverridePushOutOfBlocksInferiors.remove(id);
                allBaseAfterPushOutOfBlocksSuperiors.remove(id);
                allBaseAfterPushOutOfBlocksInferiors.remove(id);
                beforePushOutOfBlocksHookTypes.remove(id);
                overridePushOutOfBlocksHookTypes.remove(id);
                afterPushOutOfBlocksHookTypes.remove(id);
                allBaseBeforeRayTraceSuperiors.remove(id);
                allBaseBeforeRayTraceInferiors.remove(id);
                allBaseOverrideRayTraceSuperiors.remove(id);
                allBaseOverrideRayTraceInferiors.remove(id);
                allBaseAfterRayTraceSuperiors.remove(id);
                allBaseAfterRayTraceInferiors.remove(id);
                beforeRayTraceHookTypes.remove(id);
                overrideRayTraceHookTypes.remove(id);
                afterRayTraceHookTypes.remove(id);
                allBaseBeforeReadEntityFromNBTSuperiors.remove(id);
                allBaseBeforeReadEntityFromNBTInferiors.remove(id);
                allBaseOverrideReadEntityFromNBTSuperiors.remove(id);
                allBaseOverrideReadEntityFromNBTInferiors.remove(id);
                allBaseAfterReadEntityFromNBTSuperiors.remove(id);
                allBaseAfterReadEntityFromNBTInferiors.remove(id);
                beforeReadEntityFromNBTHookTypes.remove(id);
                overrideReadEntityFromNBTHookTypes.remove(id);
                afterReadEntityFromNBTHookTypes.remove(id);
                allBaseBeforeRespawnPlayerSuperiors.remove(id);
                allBaseBeforeRespawnPlayerInferiors.remove(id);
                allBaseOverrideRespawnPlayerSuperiors.remove(id);
                allBaseOverrideRespawnPlayerInferiors.remove(id);
                allBaseAfterRespawnPlayerSuperiors.remove(id);
                allBaseAfterRespawnPlayerInferiors.remove(id);
                beforeRespawnPlayerHookTypes.remove(id);
                overrideRespawnPlayerHookTypes.remove(id);
                afterRespawnPlayerHookTypes.remove(id);
                allBaseBeforeSetDeadSuperiors.remove(id);
                allBaseBeforeSetDeadInferiors.remove(id);
                allBaseOverrideSetDeadSuperiors.remove(id);
                allBaseOverrideSetDeadInferiors.remove(id);
                allBaseAfterSetDeadSuperiors.remove(id);
                allBaseAfterSetDeadInferiors.remove(id);
                beforeSetDeadHookTypes.remove(id);
                overrideSetDeadHookTypes.remove(id);
                afterSetDeadHookTypes.remove(id);
                allBaseBeforeSetPlayerSPHealthSuperiors.remove(id);
                allBaseBeforeSetPlayerSPHealthInferiors.remove(id);
                allBaseOverrideSetPlayerSPHealthSuperiors.remove(id);
                allBaseOverrideSetPlayerSPHealthInferiors.remove(id);
                allBaseAfterSetPlayerSPHealthSuperiors.remove(id);
                allBaseAfterSetPlayerSPHealthInferiors.remove(id);
                beforeSetPlayerSPHealthHookTypes.remove(id);
                overrideSetPlayerSPHealthHookTypes.remove(id);
                afterSetPlayerSPHealthHookTypes.remove(id);
                allBaseBeforeSetPositionAndRotationSuperiors.remove(id);
                allBaseBeforeSetPositionAndRotationInferiors.remove(id);
                allBaseOverrideSetPositionAndRotationSuperiors.remove(id);
                allBaseOverrideSetPositionAndRotationInferiors.remove(id);
                allBaseAfterSetPositionAndRotationSuperiors.remove(id);
                allBaseAfterSetPositionAndRotationInferiors.remove(id);
                beforeSetPositionAndRotationHookTypes.remove(id);
                overrideSetPositionAndRotationHookTypes.remove(id);
                afterSetPositionAndRotationHookTypes.remove(id);
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
                allBaseBeforeSleepInBedAtSuperiors.remove(id);
                allBaseBeforeSleepInBedAtInferiors.remove(id);
                allBaseOverrideSleepInBedAtSuperiors.remove(id);
                allBaseOverrideSleepInBedAtInferiors.remove(id);
                allBaseAfterSleepInBedAtSuperiors.remove(id);
                allBaseAfterSleepInBedAtInferiors.remove(id);
                beforeSleepInBedAtHookTypes.remove(id);
                overrideSleepInBedAtHookTypes.remove(id);
                afterSleepInBedAtHookTypes.remove(id);
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

                for (IClientPlayerAPI instance : getAllInstancesList()) {
                    instance.getClientPlayerAPI().updateClientPlayerBases();
                }

                Iterator<String> iterator = keysToVirtualIds.keySet().iterator();

                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (keysToVirtualIds.get(key).equals(id)) {
                        keysToVirtualIds.remove(key);
                    }
                }

                boolean otherFound = false;
                Class<?> type = constructor.getDeclaringClass();
                iterator = allBaseConstructors.keySet().iterator();

                while (iterator.hasNext()) {
                    String otherId = iterator.next();
                    Class<?> otherType = allBaseConstructors.get(otherId).getDeclaringClass();
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

                log("ClientPlayerAPI: unregistered id '" + id + "'");

                return true;
            }
        }
    }

    public static void removeDynamicHookTypes(String id, Map<String, List<String>> map) {

        for (String s : map.keySet()) {
            map.get(s).remove(id);
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

    private static void addDynamicSorting(
            String id, Map<String, Map<String, String[]>> map, Map<String, String[]> values) {
        if (values != null && values.size() > 0) {
            map.put(id, values);
        }
    }

    private static boolean addMethod(
            String id, Class<?> baseClass, List<String> list, String methodName, Class<?>... _parameterTypes) {
        try {
            Method method = baseClass.getMethod(methodName, _parameterTypes);
            boolean isOverridden = method.getDeclaringClass() != ClientPlayerBase.class;
            if (isOverridden) {
                list.add(id);
            }

            return isOverridden;
        } catch (Exception e) {
            throw new RuntimeException(
                    "Can not reflect method '" + methodName + "' of class '" + baseClass.getName() + "'", e);
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

                            boolean before = false;
                            boolean virtual = false;
                            boolean override = false;
                            boolean after = false;
                            if (name.substring(0, 7).equalsIgnoreCase("virtual")) {
                                virtual = true;
                                name = name.substring(7);
                            } else if (name.length() >= 8
                                    && name.substring(0, 8).equalsIgnoreCase("override")) {
                                name = name.substring(8);
                                override = true;
                            } else if (name.substring(0, 6).equalsIgnoreCase("before")) {
                                before = true;
                                name = name.substring(6);
                            } else if (name.substring(0, 5).equalsIgnoreCase("after")) {
                                after = true;
                                name = name.substring(5);
                            }

                            if (name.length() >= 1 && (before || virtual || override || after)) {
                                name = name.substring(0, 1).toLowerCase() + name.substring(1);
                            }

                            while (name.charAt(0) == '_') {
                                name = name.substring(1);
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

    private static void addDynamicKeys(
            String id,
            Class<?> baseClass,
            Map<Class<?>, Map<String, Method>> dynamicHookMethods,
            Map<String, List<String>> dynamicHookTypes) {
        Map<String, Method> methods = dynamicHookMethods.get(baseClass);
        if (methods != null && methods.size() != 0) {
            String key;
            for (Iterator<String> keys = methods.keySet().iterator();
                    keys.hasNext();
                    dynamicHookTypes.get(key).add(id)) {
                key = keys.next();
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

        if (methods.containsKey(key)) {
            throw new RuntimeException("method with key '" + key + "' allready exists");
        } else {
            methods.put(key, method);
            return methods;
        }
    }

    public static ClientPlayerAPI create(IClientPlayerAPI clientPlayer) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            initialize();
        }

        return new ClientPlayerAPI(clientPlayer);
    }

    private static void initialize() {
        sortBases(
                beforeLocalConstructingHookTypes,
                allBaseBeforeLocalConstructingSuperiors,
                allBaseBeforeLocalConstructingInferiors,
                "beforeLocalConstructing");
        sortBases(
                afterLocalConstructingHookTypes,
                allBaseAfterLocalConstructingSuperiors,
                allBaseAfterLocalConstructingInferiors,
                "afterLocalConstructing");

        for (String key : keys) {
            sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, key);
            sortDynamicBases(
                    overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, key);
            sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, key);
        }

        sortBases(
                beforeAddExhaustionHookTypes,
                allBaseBeforeAddExhaustionSuperiors,
                allBaseBeforeAddExhaustionInferiors,
                "beforeAddExhaustion");
        sortBases(
                overrideAddExhaustionHookTypes,
                allBaseOverrideAddExhaustionSuperiors,
                allBaseOverrideAddExhaustionInferiors,
                "overrideAddExhaustion");
        sortBases(
                afterAddExhaustionHookTypes,
                allBaseAfterAddExhaustionSuperiors,
                allBaseAfterAddExhaustionInferiors,
                "afterAddExhaustion");
        sortBases(
                beforeAddMovementStatHookTypes,
                allBaseBeforeAddMovementStatSuperiors,
                allBaseBeforeAddMovementStatInferiors,
                "beforeAddMovementStat");
        sortBases(
                overrideAddMovementStatHookTypes,
                allBaseOverrideAddMovementStatSuperiors,
                allBaseOverrideAddMovementStatInferiors,
                "overrideAddMovementStat");
        sortBases(
                afterAddMovementStatHookTypes,
                allBaseAfterAddMovementStatSuperiors,
                allBaseAfterAddMovementStatInferiors,
                "afterAddMovementStat");
        sortBases(
                beforeAddStatHookTypes, allBaseBeforeAddStatSuperiors, allBaseBeforeAddStatInferiors, "beforeAddStat");
        sortBases(
                overrideAddStatHookTypes,
                allBaseOverrideAddStatSuperiors,
                allBaseOverrideAddStatInferiors,
                "overrideAddStat");
        sortBases(afterAddStatHookTypes, allBaseAfterAddStatSuperiors, allBaseAfterAddStatInferiors, "afterAddStat");
        sortBases(
                beforeAttackEntityFromHookTypes,
                allBaseBeforeAttackEntityFromSuperiors,
                allBaseBeforeAttackEntityFromInferiors,
                "beforeAttackEntityFrom");
        sortBases(
                overrideAttackEntityFromHookTypes,
                allBaseOverrideAttackEntityFromSuperiors,
                allBaseOverrideAttackEntityFromInferiors,
                "overrideAttackEntityFrom");
        sortBases(
                afterAttackEntityFromHookTypes,
                allBaseAfterAttackEntityFromSuperiors,
                allBaseAfterAttackEntityFromInferiors,
                "afterAttackEntityFrom");
        sortBases(
                beforeAttackTargetEntityWithCurrentItemHookTypes,
                allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors,
                allBaseBeforeAttackTargetEntityWithCurrentItemInferiors,
                "beforeAttackTargetEntityWithCurrentItem");
        sortBases(
                overrideAttackTargetEntityWithCurrentItemHookTypes,
                allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors,
                allBaseOverrideAttackTargetEntityWithCurrentItemInferiors,
                "overrideAttackTargetEntityWithCurrentItem");
        sortBases(
                afterAttackTargetEntityWithCurrentItemHookTypes,
                allBaseAfterAttackTargetEntityWithCurrentItemSuperiors,
                allBaseAfterAttackTargetEntityWithCurrentItemInferiors,
                "afterAttackTargetEntityWithCurrentItem");
        sortBases(
                beforeCanBreatheUnderwaterHookTypes,
                allBaseBeforeCanBreatheUnderwaterSuperiors,
                allBaseBeforeCanBreatheUnderwaterInferiors,
                "beforeCanBreatheUnderwater");
        sortBases(
                overrideCanBreatheUnderwaterHookTypes,
                allBaseOverrideCanBreatheUnderwaterSuperiors,
                allBaseOverrideCanBreatheUnderwaterInferiors,
                "overrideCanBreatheUnderwater");
        sortBases(
                afterCanBreatheUnderwaterHookTypes,
                allBaseAfterCanBreatheUnderwaterSuperiors,
                allBaseAfterCanBreatheUnderwaterInferiors,
                "afterCanBreatheUnderwater");
        sortBases(
                beforeCanHarvestBlockHookTypes,
                allBaseBeforeCanHarvestBlockSuperiors,
                allBaseBeforeCanHarvestBlockInferiors,
                "beforeCanHarvestBlock");
        sortBases(
                overrideCanHarvestBlockHookTypes,
                allBaseOverrideCanHarvestBlockSuperiors,
                allBaseOverrideCanHarvestBlockInferiors,
                "overrideCanHarvestBlock");
        sortBases(
                afterCanHarvestBlockHookTypes,
                allBaseAfterCanHarvestBlockSuperiors,
                allBaseAfterCanHarvestBlockInferiors,
                "afterCanHarvestBlock");
        sortBases(
                beforeCanPlayerEditHookTypes,
                allBaseBeforeCanPlayerEditSuperiors,
                allBaseBeforeCanPlayerEditInferiors,
                "beforeCanPlayerEdit");
        sortBases(
                overrideCanPlayerEditHookTypes,
                allBaseOverrideCanPlayerEditSuperiors,
                allBaseOverrideCanPlayerEditInferiors,
                "overrideCanPlayerEdit");
        sortBases(
                afterCanPlayerEditHookTypes,
                allBaseAfterCanPlayerEditSuperiors,
                allBaseAfterCanPlayerEditInferiors,
                "afterCanPlayerEdit");
        sortBases(
                beforeCanTriggerWalkingHookTypes,
                allBaseBeforeCanTriggerWalkingSuperiors,
                allBaseBeforeCanTriggerWalkingInferiors,
                "beforeCanTriggerWalking");
        sortBases(
                overrideCanTriggerWalkingHookTypes,
                allBaseOverrideCanTriggerWalkingSuperiors,
                allBaseOverrideCanTriggerWalkingInferiors,
                "overrideCanTriggerWalking");
        sortBases(
                afterCanTriggerWalkingHookTypes,
                allBaseAfterCanTriggerWalkingSuperiors,
                allBaseAfterCanTriggerWalkingInferiors,
                "afterCanTriggerWalking");
        sortBases(
                beforeCloseScreenHookTypes,
                allBaseBeforeCloseScreenSuperiors,
                allBaseBeforeCloseScreenInferiors,
                "beforeCloseScreen");
        sortBases(
                overrideCloseScreenHookTypes,
                allBaseOverrideCloseScreenSuperiors,
                allBaseOverrideCloseScreenInferiors,
                "overrideCloseScreen");
        sortBases(
                afterCloseScreenHookTypes,
                allBaseAfterCloseScreenSuperiors,
                allBaseAfterCloseScreenInferiors,
                "afterCloseScreen");
        sortBases(
                beforeDamageEntityHookTypes,
                allBaseBeforeDamageEntitySuperiors,
                allBaseBeforeDamageEntityInferiors,
                "beforeDamageEntity");
        sortBases(
                overrideDamageEntityHookTypes,
                allBaseOverrideDamageEntitySuperiors,
                allBaseOverrideDamageEntityInferiors,
                "overrideDamageEntity");
        sortBases(
                afterDamageEntityHookTypes,
                allBaseAfterDamageEntitySuperiors,
                allBaseAfterDamageEntityInferiors,
                "afterDamageEntity");
        sortBases(
                beforeDisplayGUIBrewingStandHookTypes,
                allBaseBeforeDisplayGUIBrewingStandSuperiors,
                allBaseBeforeDisplayGUIBrewingStandInferiors,
                "beforeDisplayGUIBrewingStand");
        sortBases(
                overrideDisplayGUIBrewingStandHookTypes,
                allBaseOverrideDisplayGUIBrewingStandSuperiors,
                allBaseOverrideDisplayGUIBrewingStandInferiors,
                "overrideDisplayGUIBrewingStand");
        sortBases(
                afterDisplayGUIBrewingStandHookTypes,
                allBaseAfterDisplayGUIBrewingStandSuperiors,
                allBaseAfterDisplayGUIBrewingStandInferiors,
                "afterDisplayGUIBrewingStand");
        sortBases(
                beforeDisplayGUIChestHookTypes,
                allBaseBeforeDisplayGUIChestSuperiors,
                allBaseBeforeDisplayGUIChestInferiors,
                "beforeDisplayGUIChest");
        sortBases(
                overrideDisplayGUIChestHookTypes,
                allBaseOverrideDisplayGUIChestSuperiors,
                allBaseOverrideDisplayGUIChestInferiors,
                "overrideDisplayGUIChest");
        sortBases(
                afterDisplayGUIChestHookTypes,
                allBaseAfterDisplayGUIChestSuperiors,
                allBaseAfterDisplayGUIChestInferiors,
                "afterDisplayGUIChest");
        sortBases(
                beforeDisplayGUIDispenserHookTypes,
                allBaseBeforeDisplayGUIDispenserSuperiors,
                allBaseBeforeDisplayGUIDispenserInferiors,
                "beforeDisplayGUIDispenser");
        sortBases(
                overrideDisplayGUIDispenserHookTypes,
                allBaseOverrideDisplayGUIDispenserSuperiors,
                allBaseOverrideDisplayGUIDispenserInferiors,
                "overrideDisplayGUIDispenser");
        sortBases(
                afterDisplayGUIDispenserHookTypes,
                allBaseAfterDisplayGUIDispenserSuperiors,
                allBaseAfterDisplayGUIDispenserInferiors,
                "afterDisplayGUIDispenser");
        sortBases(
                beforeDisplayGUIEditSignHookTypes,
                allBaseBeforeDisplayGUIEditSignSuperiors,
                allBaseBeforeDisplayGUIEditSignInferiors,
                "beforeDisplayGUIEditSign");
        sortBases(
                overrideDisplayGUIEditSignHookTypes,
                allBaseOverrideDisplayGUIEditSignSuperiors,
                allBaseOverrideDisplayGUIEditSignInferiors,
                "overrideDisplayGUIEditSign");
        sortBases(
                afterDisplayGUIEditSignHookTypes,
                allBaseAfterDisplayGUIEditSignSuperiors,
                allBaseAfterDisplayGUIEditSignInferiors,
                "afterDisplayGUIEditSign");
        sortBases(
                beforeDisplayGUIEnchantmentHookTypes,
                allBaseBeforeDisplayGUIEnchantmentSuperiors,
                allBaseBeforeDisplayGUIEnchantmentInferiors,
                "beforeDisplayGUIEnchantment");
        sortBases(
                overrideDisplayGUIEnchantmentHookTypes,
                allBaseOverrideDisplayGUIEnchantmentSuperiors,
                allBaseOverrideDisplayGUIEnchantmentInferiors,
                "overrideDisplayGUIEnchantment");
        sortBases(
                afterDisplayGUIEnchantmentHookTypes,
                allBaseAfterDisplayGUIEnchantmentSuperiors,
                allBaseAfterDisplayGUIEnchantmentInferiors,
                "afterDisplayGUIEnchantment");
        sortBases(
                beforeDisplayGUIFurnaceHookTypes,
                allBaseBeforeDisplayGUIFurnaceSuperiors,
                allBaseBeforeDisplayGUIFurnaceInferiors,
                "beforeDisplayGUIFurnace");
        sortBases(
                overrideDisplayGUIFurnaceHookTypes,
                allBaseOverrideDisplayGUIFurnaceSuperiors,
                allBaseOverrideDisplayGUIFurnaceInferiors,
                "overrideDisplayGUIFurnace");
        sortBases(
                afterDisplayGUIFurnaceHookTypes,
                allBaseAfterDisplayGUIFurnaceSuperiors,
                allBaseAfterDisplayGUIFurnaceInferiors,
                "afterDisplayGUIFurnace");
        sortBases(
                beforeDisplayGUIWorkbenchHookTypes,
                allBaseBeforeDisplayGUIWorkbenchSuperiors,
                allBaseBeforeDisplayGUIWorkbenchInferiors,
                "beforeDisplayGUIWorkbench");
        sortBases(
                overrideDisplayGUIWorkbenchHookTypes,
                allBaseOverrideDisplayGUIWorkbenchSuperiors,
                allBaseOverrideDisplayGUIWorkbenchInferiors,
                "overrideDisplayGUIWorkbench");
        sortBases(
                afterDisplayGUIWorkbenchHookTypes,
                allBaseAfterDisplayGUIWorkbenchSuperiors,
                allBaseAfterDisplayGUIWorkbenchInferiors,
                "afterDisplayGUIWorkbench");
        sortBases(
                beforeDropOneItemHookTypes,
                allBaseBeforeDropOneItemSuperiors,
                allBaseBeforeDropOneItemInferiors,
                "beforeDropOneItem");
        sortBases(
                overrideDropOneItemHookTypes,
                allBaseOverrideDropOneItemSuperiors,
                allBaseOverrideDropOneItemInferiors,
                "overrideDropOneItem");
        sortBases(
                afterDropOneItemHookTypes,
                allBaseAfterDropOneItemSuperiors,
                allBaseAfterDropOneItemInferiors,
                "afterDropOneItem");
        sortBases(
                beforeDropPlayerItemHookTypes,
                allBaseBeforeDropPlayerItemSuperiors,
                allBaseBeforeDropPlayerItemInferiors,
                "beforeDropPlayerItem");
        sortBases(
                overrideDropPlayerItemHookTypes,
                allBaseOverrideDropPlayerItemSuperiors,
                allBaseOverrideDropPlayerItemInferiors,
                "overrideDropPlayerItem");
        sortBases(
                afterDropPlayerItemHookTypes,
                allBaseAfterDropPlayerItemSuperiors,
                allBaseAfterDropPlayerItemInferiors,
                "afterDropPlayerItem");
        sortBases(
                beforeDropPlayerItemWithRandomChoiceHookTypes,
                allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors,
                allBaseBeforeDropPlayerItemWithRandomChoiceInferiors,
                "beforeDropPlayerItemWithRandomChoice");
        sortBases(
                overrideDropPlayerItemWithRandomChoiceHookTypes,
                allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors,
                allBaseOverrideDropPlayerItemWithRandomChoiceInferiors,
                "overrideDropPlayerItemWithRandomChoice");
        sortBases(
                afterDropPlayerItemWithRandomChoiceHookTypes,
                allBaseAfterDropPlayerItemWithRandomChoiceSuperiors,
                allBaseAfterDropPlayerItemWithRandomChoiceInferiors,
                "afterDropPlayerItemWithRandomChoice");
        sortBases(beforeFallHookTypes, allBaseBeforeFallSuperiors, allBaseBeforeFallInferiors, "beforeFall");
        sortBases(overrideFallHookTypes, allBaseOverrideFallSuperiors, allBaseOverrideFallInferiors, "overrideFall");
        sortBases(afterFallHookTypes, allBaseAfterFallSuperiors, allBaseAfterFallInferiors, "afterFall");
        sortBases(
                beforeGetAIMoveSpeedHookTypes,
                allBaseBeforeGetAIMoveSpeedSuperiors,
                allBaseBeforeGetAIMoveSpeedInferiors,
                "beforeGetAIMoveSpeed");
        sortBases(
                overrideGetAIMoveSpeedHookTypes,
                allBaseOverrideGetAIMoveSpeedSuperiors,
                allBaseOverrideGetAIMoveSpeedInferiors,
                "overrideGetAIMoveSpeed");
        sortBases(
                afterGetAIMoveSpeedHookTypes,
                allBaseAfterGetAIMoveSpeedSuperiors,
                allBaseAfterGetAIMoveSpeedInferiors,
                "afterGetAIMoveSpeed");
        sortBases(
                beforeGetBedOrientationInDegreesHookTypes,
                allBaseBeforeGetBedOrientationInDegreesSuperiors,
                allBaseBeforeGetBedOrientationInDegreesInferiors,
                "beforeGetBedOrientationInDegrees");
        sortBases(
                overrideGetBedOrientationInDegreesHookTypes,
                allBaseOverrideGetBedOrientationInDegreesSuperiors,
                allBaseOverrideGetBedOrientationInDegreesInferiors,
                "overrideGetBedOrientationInDegrees");
        sortBases(
                afterGetBedOrientationInDegreesHookTypes,
                allBaseAfterGetBedOrientationInDegreesSuperiors,
                allBaseAfterGetBedOrientationInDegreesInferiors,
                "afterGetBedOrientationInDegrees");
        sortBases(
                beforeGetBrightnessHookTypes,
                allBaseBeforeGetBrightnessSuperiors,
                allBaseBeforeGetBrightnessInferiors,
                "beforeGetBrightness");
        sortBases(
                overrideGetBrightnessHookTypes,
                allBaseOverrideGetBrightnessSuperiors,
                allBaseOverrideGetBrightnessInferiors,
                "overrideGetBrightness");
        sortBases(
                afterGetBrightnessHookTypes,
                allBaseAfterGetBrightnessSuperiors,
                allBaseAfterGetBrightnessInferiors,
                "afterGetBrightness");
        sortBases(
                beforeGetBrightnessForRenderHookTypes,
                allBaseBeforeGetBrightnessForRenderSuperiors,
                allBaseBeforeGetBrightnessForRenderInferiors,
                "beforeGetBrightnessForRender");
        sortBases(
                overrideGetBrightnessForRenderHookTypes,
                allBaseOverrideGetBrightnessForRenderSuperiors,
                allBaseOverrideGetBrightnessForRenderInferiors,
                "overrideGetBrightnessForRender");
        sortBases(
                afterGetBrightnessForRenderHookTypes,
                allBaseAfterGetBrightnessForRenderSuperiors,
                allBaseAfterGetBrightnessForRenderInferiors,
                "afterGetBrightnessForRender");
        sortBases(
                beforeGetCurrentPlayerStrVsBlockHookTypes,
                allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors,
                allBaseBeforeGetCurrentPlayerStrVsBlockInferiors,
                "beforeGetCurrentPlayerStrVsBlock");
        sortBases(
                overrideGetCurrentPlayerStrVsBlockHookTypes,
                allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors,
                allBaseOverrideGetCurrentPlayerStrVsBlockInferiors,
                "overrideGetCurrentPlayerStrVsBlock");
        sortBases(
                afterGetCurrentPlayerStrVsBlockHookTypes,
                allBaseAfterGetCurrentPlayerStrVsBlockSuperiors,
                allBaseAfterGetCurrentPlayerStrVsBlockInferiors,
                "afterGetCurrentPlayerStrVsBlock");
        sortBases(
                beforeGetCurrentPlayerStrVsBlockForgeHookTypes,
                allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors,
                allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors,
                "beforeGetCurrentPlayerStrVsBlockForge");
        sortBases(
                overrideGetCurrentPlayerStrVsBlockForgeHookTypes,
                allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors,
                allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors,
                "overrideGetCurrentPlayerStrVsBlockForge");
        sortBases(
                afterGetCurrentPlayerStrVsBlockForgeHookTypes,
                allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors,
                allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors,
                "afterGetCurrentPlayerStrVsBlockForge");
        sortBases(
                beforeGetDistanceSqHookTypes,
                allBaseBeforeGetDistanceSqSuperiors,
                allBaseBeforeGetDistanceSqInferiors,
                "beforeGetDistanceSq");
        sortBases(
                overrideGetDistanceSqHookTypes,
                allBaseOverrideGetDistanceSqSuperiors,
                allBaseOverrideGetDistanceSqInferiors,
                "overrideGetDistanceSq");
        sortBases(
                afterGetDistanceSqHookTypes,
                allBaseAfterGetDistanceSqSuperiors,
                allBaseAfterGetDistanceSqInferiors,
                "afterGetDistanceSq");
        sortBases(
                beforeGetDistanceSqToEntityHookTypes,
                allBaseBeforeGetDistanceSqToEntitySuperiors,
                allBaseBeforeGetDistanceSqToEntityInferiors,
                "beforeGetDistanceSqToEntity");
        sortBases(
                overrideGetDistanceSqToEntityHookTypes,
                allBaseOverrideGetDistanceSqToEntitySuperiors,
                allBaseOverrideGetDistanceSqToEntityInferiors,
                "overrideGetDistanceSqToEntity");
        sortBases(
                afterGetDistanceSqToEntityHookTypes,
                allBaseAfterGetDistanceSqToEntitySuperiors,
                allBaseAfterGetDistanceSqToEntityInferiors,
                "afterGetDistanceSqToEntity");
        sortBases(
                beforeGetFOVMultiplierHookTypes,
                allBaseBeforeGetFOVMultiplierSuperiors,
                allBaseBeforeGetFOVMultiplierInferiors,
                "beforeGetFOVMultiplier");
        sortBases(
                overrideGetFOVMultiplierHookTypes,
                allBaseOverrideGetFOVMultiplierSuperiors,
                allBaseOverrideGetFOVMultiplierInferiors,
                "overrideGetFOVMultiplier");
        sortBases(
                afterGetFOVMultiplierHookTypes,
                allBaseAfterGetFOVMultiplierSuperiors,
                allBaseAfterGetFOVMultiplierInferiors,
                "afterGetFOVMultiplier");
        sortBases(
                beforeGetHurtSoundHookTypes,
                allBaseBeforeGetHurtSoundSuperiors,
                allBaseBeforeGetHurtSoundInferiors,
                "beforeGetHurtSound");
        sortBases(
                overrideGetHurtSoundHookTypes,
                allBaseOverrideGetHurtSoundSuperiors,
                allBaseOverrideGetHurtSoundInferiors,
                "overrideGetHurtSound");
        sortBases(
                afterGetHurtSoundHookTypes,
                allBaseAfterGetHurtSoundSuperiors,
                allBaseAfterGetHurtSoundInferiors,
                "afterGetHurtSound");
        sortBases(
                beforeGetItemIconHookTypes,
                allBaseBeforeGetItemIconSuperiors,
                allBaseBeforeGetItemIconInferiors,
                "beforeGetItemIcon");
        sortBases(
                overrideGetItemIconHookTypes,
                allBaseOverrideGetItemIconSuperiors,
                allBaseOverrideGetItemIconInferiors,
                "overrideGetItemIcon");
        sortBases(
                afterGetItemIconHookTypes,
                allBaseAfterGetItemIconSuperiors,
                allBaseAfterGetItemIconInferiors,
                "afterGetItemIcon");
        sortBases(
                beforeGetSleepTimerHookTypes,
                allBaseBeforeGetSleepTimerSuperiors,
                allBaseBeforeGetSleepTimerInferiors,
                "beforeGetSleepTimer");
        sortBases(
                overrideGetSleepTimerHookTypes,
                allBaseOverrideGetSleepTimerSuperiors,
                allBaseOverrideGetSleepTimerInferiors,
                "overrideGetSleepTimer");
        sortBases(
                afterGetSleepTimerHookTypes,
                allBaseAfterGetSleepTimerSuperiors,
                allBaseAfterGetSleepTimerInferiors,
                "afterGetSleepTimer");
        sortBases(
                beforeHandleLavaMovementHookTypes,
                allBaseBeforeHandleLavaMovementSuperiors,
                allBaseBeforeHandleLavaMovementInferiors,
                "beforeHandleLavaMovement");
        sortBases(
                overrideHandleLavaMovementHookTypes,
                allBaseOverrideHandleLavaMovementSuperiors,
                allBaseOverrideHandleLavaMovementInferiors,
                "overrideHandleLavaMovement");
        sortBases(
                afterHandleLavaMovementHookTypes,
                allBaseAfterHandleLavaMovementSuperiors,
                allBaseAfterHandleLavaMovementInferiors,
                "afterHandleLavaMovement");
        sortBases(
                beforeHandleWaterMovementHookTypes,
                allBaseBeforeHandleWaterMovementSuperiors,
                allBaseBeforeHandleWaterMovementInferiors,
                "beforeHandleWaterMovement");
        sortBases(
                overrideHandleWaterMovementHookTypes,
                allBaseOverrideHandleWaterMovementSuperiors,
                allBaseOverrideHandleWaterMovementInferiors,
                "overrideHandleWaterMovement");
        sortBases(
                afterHandleWaterMovementHookTypes,
                allBaseAfterHandleWaterMovementSuperiors,
                allBaseAfterHandleWaterMovementInferiors,
                "afterHandleWaterMovement");
        sortBases(beforeHealHookTypes, allBaseBeforeHealSuperiors, allBaseBeforeHealInferiors, "beforeHeal");
        sortBases(overrideHealHookTypes, allBaseOverrideHealSuperiors, allBaseOverrideHealInferiors, "overrideHeal");
        sortBases(afterHealHookTypes, allBaseAfterHealSuperiors, allBaseAfterHealInferiors, "afterHeal");
        sortBases(
                beforeIsEntityInsideOpaqueBlockHookTypes,
                allBaseBeforeIsEntityInsideOpaqueBlockSuperiors,
                allBaseBeforeIsEntityInsideOpaqueBlockInferiors,
                "beforeIsEntityInsideOpaqueBlock");
        sortBases(
                overrideIsEntityInsideOpaqueBlockHookTypes,
                allBaseOverrideIsEntityInsideOpaqueBlockSuperiors,
                allBaseOverrideIsEntityInsideOpaqueBlockInferiors,
                "overrideIsEntityInsideOpaqueBlock");
        sortBases(
                afterIsEntityInsideOpaqueBlockHookTypes,
                allBaseAfterIsEntityInsideOpaqueBlockSuperiors,
                allBaseAfterIsEntityInsideOpaqueBlockInferiors,
                "afterIsEntityInsideOpaqueBlock");
        sortBases(
                beforeIsInWaterHookTypes,
                allBaseBeforeIsInWaterSuperiors,
                allBaseBeforeIsInWaterInferiors,
                "beforeIsInWater");
        sortBases(
                overrideIsInWaterHookTypes,
                allBaseOverrideIsInWaterSuperiors,
                allBaseOverrideIsInWaterInferiors,
                "overrideIsInWater");
        sortBases(
                afterIsInWaterHookTypes,
                allBaseAfterIsInWaterSuperiors,
                allBaseAfterIsInWaterInferiors,
                "afterIsInWater");
        sortBases(
                beforeIsInsideOfMaterialHookTypes,
                allBaseBeforeIsInsideOfMaterialSuperiors,
                allBaseBeforeIsInsideOfMaterialInferiors,
                "beforeIsInsideOfMaterial");
        sortBases(
                overrideIsInsideOfMaterialHookTypes,
                allBaseOverrideIsInsideOfMaterialSuperiors,
                allBaseOverrideIsInsideOfMaterialInferiors,
                "overrideIsInsideOfMaterial");
        sortBases(
                afterIsInsideOfMaterialHookTypes,
                allBaseAfterIsInsideOfMaterialSuperiors,
                allBaseAfterIsInsideOfMaterialInferiors,
                "afterIsInsideOfMaterial");
        sortBases(
                beforeIsOnLadderHookTypes,
                allBaseBeforeIsOnLadderSuperiors,
                allBaseBeforeIsOnLadderInferiors,
                "beforeIsOnLadder");
        sortBases(
                overrideIsOnLadderHookTypes,
                allBaseOverrideIsOnLadderSuperiors,
                allBaseOverrideIsOnLadderInferiors,
                "overrideIsOnLadder");
        sortBases(
                afterIsOnLadderHookTypes,
                allBaseAfterIsOnLadderSuperiors,
                allBaseAfterIsOnLadderInferiors,
                "afterIsOnLadder");
        sortBases(
                beforeIsPlayerSleepingHookTypes,
                allBaseBeforeIsPlayerSleepingSuperiors,
                allBaseBeforeIsPlayerSleepingInferiors,
                "beforeIsPlayerSleeping");
        sortBases(
                overrideIsPlayerSleepingHookTypes,
                allBaseOverrideIsPlayerSleepingSuperiors,
                allBaseOverrideIsPlayerSleepingInferiors,
                "overrideIsPlayerSleeping");
        sortBases(
                afterIsPlayerSleepingHookTypes,
                allBaseAfterIsPlayerSleepingSuperiors,
                allBaseAfterIsPlayerSleepingInferiors,
                "afterIsPlayerSleeping");
        sortBases(
                beforeIsSneakingHookTypes,
                allBaseBeforeIsSneakingSuperiors,
                allBaseBeforeIsSneakingInferiors,
                "beforeIsSneaking");
        sortBases(
                overrideIsSneakingHookTypes,
                allBaseOverrideIsSneakingSuperiors,
                allBaseOverrideIsSneakingInferiors,
                "overrideIsSneaking");
        sortBases(
                afterIsSneakingHookTypes,
                allBaseAfterIsSneakingSuperiors,
                allBaseAfterIsSneakingInferiors,
                "afterIsSneaking");
        sortBases(
                beforeIsSprintingHookTypes,
                allBaseBeforeIsSprintingSuperiors,
                allBaseBeforeIsSprintingInferiors,
                "beforeIsSprinting");
        sortBases(
                overrideIsSprintingHookTypes,
                allBaseOverrideIsSprintingSuperiors,
                allBaseOverrideIsSprintingInferiors,
                "overrideIsSprinting");
        sortBases(
                afterIsSprintingHookTypes,
                allBaseAfterIsSprintingSuperiors,
                allBaseAfterIsSprintingInferiors,
                "afterIsSprinting");
        sortBases(beforeJumpHookTypes, allBaseBeforeJumpSuperiors, allBaseBeforeJumpInferiors, "beforeJump");
        sortBases(overrideJumpHookTypes, allBaseOverrideJumpSuperiors, allBaseOverrideJumpInferiors, "overrideJump");
        sortBases(afterJumpHookTypes, allBaseAfterJumpSuperiors, allBaseAfterJumpInferiors, "afterJump");
        sortBases(
                beforeKnockBackHookTypes,
                allBaseBeforeKnockBackSuperiors,
                allBaseBeforeKnockBackInferiors,
                "beforeKnockBack");
        sortBases(
                overrideKnockBackHookTypes,
                allBaseOverrideKnockBackSuperiors,
                allBaseOverrideKnockBackInferiors,
                "overrideKnockBack");
        sortBases(
                afterKnockBackHookTypes,
                allBaseAfterKnockBackSuperiors,
                allBaseAfterKnockBackInferiors,
                "afterKnockBack");
        sortBases(
                beforeMoveEntityHookTypes,
                allBaseBeforeMoveEntitySuperiors,
                allBaseBeforeMoveEntityInferiors,
                "beforeMoveEntity");
        sortBases(
                overrideMoveEntityHookTypes,
                allBaseOverrideMoveEntitySuperiors,
                allBaseOverrideMoveEntityInferiors,
                "overrideMoveEntity");
        sortBases(
                afterMoveEntityHookTypes,
                allBaseAfterMoveEntitySuperiors,
                allBaseAfterMoveEntityInferiors,
                "afterMoveEntity");
        sortBases(
                beforeMoveEntityWithHeadingHookTypes,
                allBaseBeforeMoveEntityWithHeadingSuperiors,
                allBaseBeforeMoveEntityWithHeadingInferiors,
                "beforeMoveEntityWithHeading");
        sortBases(
                overrideMoveEntityWithHeadingHookTypes,
                allBaseOverrideMoveEntityWithHeadingSuperiors,
                allBaseOverrideMoveEntityWithHeadingInferiors,
                "overrideMoveEntityWithHeading");
        sortBases(
                afterMoveEntityWithHeadingHookTypes,
                allBaseAfterMoveEntityWithHeadingSuperiors,
                allBaseAfterMoveEntityWithHeadingInferiors,
                "afterMoveEntityWithHeading");
        sortBases(
                beforeMoveFlyingHookTypes,
                allBaseBeforeMoveFlyingSuperiors,
                allBaseBeforeMoveFlyingInferiors,
                "beforeMoveFlying");
        sortBases(
                overrideMoveFlyingHookTypes,
                allBaseOverrideMoveFlyingSuperiors,
                allBaseOverrideMoveFlyingInferiors,
                "overrideMoveFlying");
        sortBases(
                afterMoveFlyingHookTypes,
                allBaseAfterMoveFlyingSuperiors,
                allBaseAfterMoveFlyingInferiors,
                "afterMoveFlying");
        sortBases(
                beforeOnDeathHookTypes, allBaseBeforeOnDeathSuperiors, allBaseBeforeOnDeathInferiors, "beforeOnDeath");
        sortBases(
                overrideOnDeathHookTypes,
                allBaseOverrideOnDeathSuperiors,
                allBaseOverrideOnDeathInferiors,
                "overrideOnDeath");
        sortBases(afterOnDeathHookTypes, allBaseAfterOnDeathSuperiors, allBaseAfterOnDeathInferiors, "afterOnDeath");
        sortBases(
                beforeOnLivingUpdateHookTypes,
                allBaseBeforeOnLivingUpdateSuperiors,
                allBaseBeforeOnLivingUpdateInferiors,
                "beforeOnLivingUpdate");
        sortBases(
                overrideOnLivingUpdateHookTypes,
                allBaseOverrideOnLivingUpdateSuperiors,
                allBaseOverrideOnLivingUpdateInferiors,
                "overrideOnLivingUpdate");
        sortBases(
                afterOnLivingUpdateHookTypes,
                allBaseAfterOnLivingUpdateSuperiors,
                allBaseAfterOnLivingUpdateInferiors,
                "afterOnLivingUpdate");
        sortBases(
                beforeOnKillEntityHookTypes,
                allBaseBeforeOnKillEntitySuperiors,
                allBaseBeforeOnKillEntityInferiors,
                "beforeOnKillEntity");
        sortBases(
                overrideOnKillEntityHookTypes,
                allBaseOverrideOnKillEntitySuperiors,
                allBaseOverrideOnKillEntityInferiors,
                "overrideOnKillEntity");
        sortBases(
                afterOnKillEntityHookTypes,
                allBaseAfterOnKillEntitySuperiors,
                allBaseAfterOnKillEntityInferiors,
                "afterOnKillEntity");
        sortBases(
                beforeOnStruckByLightningHookTypes,
                allBaseBeforeOnStruckByLightningSuperiors,
                allBaseBeforeOnStruckByLightningInferiors,
                "beforeOnStruckByLightning");
        sortBases(
                overrideOnStruckByLightningHookTypes,
                allBaseOverrideOnStruckByLightningSuperiors,
                allBaseOverrideOnStruckByLightningInferiors,
                "overrideOnStruckByLightning");
        sortBases(
                afterOnStruckByLightningHookTypes,
                allBaseAfterOnStruckByLightningSuperiors,
                allBaseAfterOnStruckByLightningInferiors,
                "afterOnStruckByLightning");
        sortBases(
                beforeOnUpdateHookTypes,
                allBaseBeforeOnUpdateSuperiors,
                allBaseBeforeOnUpdateInferiors,
                "beforeOnUpdate");
        sortBases(
                overrideOnUpdateHookTypes,
                allBaseOverrideOnUpdateSuperiors,
                allBaseOverrideOnUpdateInferiors,
                "overrideOnUpdate");
        sortBases(
                afterOnUpdateHookTypes, allBaseAfterOnUpdateSuperiors, allBaseAfterOnUpdateInferiors, "afterOnUpdate");
        sortBases(
                beforePlayStepSoundHookTypes,
                allBaseBeforePlayStepSoundSuperiors,
                allBaseBeforePlayStepSoundInferiors,
                "beforePlayStepSound");
        sortBases(
                overridePlayStepSoundHookTypes,
                allBaseOverridePlayStepSoundSuperiors,
                allBaseOverridePlayStepSoundInferiors,
                "overridePlayStepSound");
        sortBases(
                afterPlayStepSoundHookTypes,
                allBaseAfterPlayStepSoundSuperiors,
                allBaseAfterPlayStepSoundInferiors,
                "afterPlayStepSound");
        sortBases(
                beforePushOutOfBlocksHookTypes,
                allBaseBeforePushOutOfBlocksSuperiors,
                allBaseBeforePushOutOfBlocksInferiors,
                "beforePushOutOfBlocks");
        sortBases(
                overridePushOutOfBlocksHookTypes,
                allBaseOverridePushOutOfBlocksSuperiors,
                allBaseOverridePushOutOfBlocksInferiors,
                "overridePushOutOfBlocks");
        sortBases(
                afterPushOutOfBlocksHookTypes,
                allBaseAfterPushOutOfBlocksSuperiors,
                allBaseAfterPushOutOfBlocksInferiors,
                "afterPushOutOfBlocks");
        sortBases(
                beforeRayTraceHookTypes,
                allBaseBeforeRayTraceSuperiors,
                allBaseBeforeRayTraceInferiors,
                "beforeRayTrace");
        sortBases(
                overrideRayTraceHookTypes,
                allBaseOverrideRayTraceSuperiors,
                allBaseOverrideRayTraceInferiors,
                "overrideRayTrace");
        sortBases(
                afterRayTraceHookTypes, allBaseAfterRayTraceSuperiors, allBaseAfterRayTraceInferiors, "afterRayTrace");
        sortBases(
                beforeReadEntityFromNBTHookTypes,
                allBaseBeforeReadEntityFromNBTSuperiors,
                allBaseBeforeReadEntityFromNBTInferiors,
                "beforeReadEntityFromNBT");
        sortBases(
                overrideReadEntityFromNBTHookTypes,
                allBaseOverrideReadEntityFromNBTSuperiors,
                allBaseOverrideReadEntityFromNBTInferiors,
                "overrideReadEntityFromNBT");
        sortBases(
                afterReadEntityFromNBTHookTypes,
                allBaseAfterReadEntityFromNBTSuperiors,
                allBaseAfterReadEntityFromNBTInferiors,
                "afterReadEntityFromNBT");
        sortBases(
                beforeRespawnPlayerHookTypes,
                allBaseBeforeRespawnPlayerSuperiors,
                allBaseBeforeRespawnPlayerInferiors,
                "beforeRespawnPlayer");
        sortBases(
                overrideRespawnPlayerHookTypes,
                allBaseOverrideRespawnPlayerSuperiors,
                allBaseOverrideRespawnPlayerInferiors,
                "overrideRespawnPlayer");
        sortBases(
                afterRespawnPlayerHookTypes,
                allBaseAfterRespawnPlayerSuperiors,
                allBaseAfterRespawnPlayerInferiors,
                "afterRespawnPlayer");
        sortBases(
                beforeSetDeadHookTypes, allBaseBeforeSetDeadSuperiors, allBaseBeforeSetDeadInferiors, "beforeSetDead");
        sortBases(
                overrideSetDeadHookTypes,
                allBaseOverrideSetDeadSuperiors,
                allBaseOverrideSetDeadInferiors,
                "overrideSetDead");
        sortBases(afterSetDeadHookTypes, allBaseAfterSetDeadSuperiors, allBaseAfterSetDeadInferiors, "afterSetDead");
        sortBases(
                beforeSetPlayerSPHealthHookTypes,
                allBaseBeforeSetPlayerSPHealthSuperiors,
                allBaseBeforeSetPlayerSPHealthInferiors,
                "beforeSetPlayerSPHealth");
        sortBases(
                overrideSetPlayerSPHealthHookTypes,
                allBaseOverrideSetPlayerSPHealthSuperiors,
                allBaseOverrideSetPlayerSPHealthInferiors,
                "overrideSetPlayerSPHealth");
        sortBases(
                afterSetPlayerSPHealthHookTypes,
                allBaseAfterSetPlayerSPHealthSuperiors,
                allBaseAfterSetPlayerSPHealthInferiors,
                "afterSetPlayerSPHealth");
        sortBases(
                beforeSetPositionAndRotationHookTypes,
                allBaseBeforeSetPositionAndRotationSuperiors,
                allBaseBeforeSetPositionAndRotationInferiors,
                "beforeSetPositionAndRotation");
        sortBases(
                overrideSetPositionAndRotationHookTypes,
                allBaseOverrideSetPositionAndRotationSuperiors,
                allBaseOverrideSetPositionAndRotationInferiors,
                "overrideSetPositionAndRotation");
        sortBases(
                afterSetPositionAndRotationHookTypes,
                allBaseAfterSetPositionAndRotationSuperiors,
                allBaseAfterSetPositionAndRotationInferiors,
                "afterSetPositionAndRotation");
        sortBases(
                beforeSetSneakingHookTypes,
                allBaseBeforeSetSneakingSuperiors,
                allBaseBeforeSetSneakingInferiors,
                "beforeSetSneaking");
        sortBases(
                overrideSetSneakingHookTypes,
                allBaseOverrideSetSneakingSuperiors,
                allBaseOverrideSetSneakingInferiors,
                "overrideSetSneaking");
        sortBases(
                afterSetSneakingHookTypes,
                allBaseAfterSetSneakingSuperiors,
                allBaseAfterSetSneakingInferiors,
                "afterSetSneaking");
        sortBases(
                beforeSetSprintingHookTypes,
                allBaseBeforeSetSprintingSuperiors,
                allBaseBeforeSetSprintingInferiors,
                "beforeSetSprinting");
        sortBases(
                overrideSetSprintingHookTypes,
                allBaseOverrideSetSprintingSuperiors,
                allBaseOverrideSetSprintingInferiors,
                "overrideSetSprinting");
        sortBases(
                afterSetSprintingHookTypes,
                allBaseAfterSetSprintingSuperiors,
                allBaseAfterSetSprintingInferiors,
                "afterSetSprinting");
        sortBases(
                beforeSleepInBedAtHookTypes,
                allBaseBeforeSleepInBedAtSuperiors,
                allBaseBeforeSleepInBedAtInferiors,
                "beforeSleepInBedAt");
        sortBases(
                overrideSleepInBedAtHookTypes,
                allBaseOverrideSleepInBedAtSuperiors,
                allBaseOverrideSleepInBedAtInferiors,
                "overrideSleepInBedAt");
        sortBases(
                afterSleepInBedAtHookTypes,
                allBaseAfterSleepInBedAtSuperiors,
                allBaseAfterSleepInBedAtInferiors,
                "afterSleepInBedAt");
        sortBases(
                beforeSwingItemHookTypes,
                allBaseBeforeSwingItemSuperiors,
                allBaseBeforeSwingItemInferiors,
                "beforeSwingItem");
        sortBases(
                overrideSwingItemHookTypes,
                allBaseOverrideSwingItemSuperiors,
                allBaseOverrideSwingItemInferiors,
                "overrideSwingItem");
        sortBases(
                afterSwingItemHookTypes,
                allBaseAfterSwingItemSuperiors,
                allBaseAfterSwingItemInferiors,
                "afterSwingItem");
        sortBases(
                beforeUpdateEntityActionStateHookTypes,
                allBaseBeforeUpdateEntityActionStateSuperiors,
                allBaseBeforeUpdateEntityActionStateInferiors,
                "beforeUpdateEntityActionState");
        sortBases(
                overrideUpdateEntityActionStateHookTypes,
                allBaseOverrideUpdateEntityActionStateSuperiors,
                allBaseOverrideUpdateEntityActionStateInferiors,
                "overrideUpdateEntityActionState");
        sortBases(
                afterUpdateEntityActionStateHookTypes,
                allBaseAfterUpdateEntityActionStateSuperiors,
                allBaseAfterUpdateEntityActionStateInferiors,
                "afterUpdateEntityActionState");
        sortBases(
                beforeUpdateRiddenHookTypes,
                allBaseBeforeUpdateRiddenSuperiors,
                allBaseBeforeUpdateRiddenInferiors,
                "beforeUpdateRidden");
        sortBases(
                overrideUpdateRiddenHookTypes,
                allBaseOverrideUpdateRiddenSuperiors,
                allBaseOverrideUpdateRiddenInferiors,
                "overrideUpdateRidden");
        sortBases(
                afterUpdateRiddenHookTypes,
                allBaseAfterUpdateRiddenSuperiors,
                allBaseAfterUpdateRiddenInferiors,
                "afterUpdateRidden");
        sortBases(
                beforeWakeUpPlayerHookTypes,
                allBaseBeforeWakeUpPlayerSuperiors,
                allBaseBeforeWakeUpPlayerInferiors,
                "beforeWakeUpPlayer");
        sortBases(
                overrideWakeUpPlayerHookTypes,
                allBaseOverrideWakeUpPlayerSuperiors,
                allBaseOverrideWakeUpPlayerInferiors,
                "overrideWakeUpPlayer");
        sortBases(
                afterWakeUpPlayerHookTypes,
                allBaseAfterWakeUpPlayerSuperiors,
                allBaseAfterWakeUpPlayerInferiors,
                "afterWakeUpPlayer");
        sortBases(
                beforeWriteEntityToNBTHookTypes,
                allBaseBeforeWriteEntityToNBTSuperiors,
                allBaseBeforeWriteEntityToNBTInferiors,
                "beforeWriteEntityToNBT");
        sortBases(
                overrideWriteEntityToNBTHookTypes,
                allBaseOverrideWriteEntityToNBTSuperiors,
                allBaseOverrideWriteEntityToNBTInferiors,
                "overrideWriteEntityToNBT");
        sortBases(
                afterWriteEntityToNBTHookTypes,
                allBaseAfterWriteEntityToNBTSuperiors,
                allBaseAfterWriteEntityToNBTInferiors,
                "afterWriteEntityToNBT");
        initialized = true;
    }

    private static List<IClientPlayerAPI> getAllInstancesList() {
        ArrayList<IClientPlayerAPI> result = new ArrayList<>();

        Object player;
        try {
            Object minecraft = Minecraft.class.getMethod("func_71410_x").invoke(null);
            player = minecraft != null
                    ? Minecraft.class.getField("field_71439_g").get(minecraft)
                    : null;
        } catch (Exception obfuscatedException) {
            try {
                Object minecraft = Minecraft.class.getMethod("getMinecraft").invoke(null);
                player = minecraft != null
                        ? Minecraft.class.getField("thePlayer").get(minecraft)
                        : null;
            } catch (Exception var4) {
                throw new RuntimeException("Unable to aquire list of current server players.", obfuscatedException);
            }
        }

        if (player != null) {
            result.add((IClientPlayerAPI) player);
        }

        return result;
    }

    public static EntityPlayerSP[] getAllInstances() {
        List<IClientPlayerAPI> allInstances = getAllInstancesList();
        return allInstances.toArray(new EntityPlayerSP[allInstances.size()]);
    }

    public static void beforeLocalConstructing(
            IClientPlayerAPI clientPlayer,
            Minecraft paramMinecraft,
            World paramWorld,
            Session paramSession,
            int paramInt) {
        ClientPlayerAPI clientPlayerAPI = clientPlayer.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            clientPlayerAPI.load();
        }

        if (clientPlayerAPI != null) {
            clientPlayerAPI.beforeLocalConstructing(paramMinecraft, paramWorld, paramSession, paramInt);
        }
    }

    public static void afterLocalConstructing(
            IClientPlayerAPI clientPlayer,
            Minecraft paramMinecraft,
            World paramWorld,
            Session paramSession,
            int paramInt) {
        ClientPlayerAPI clientPlayerAPI = clientPlayer.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            clientPlayerAPI.afterLocalConstructing(paramMinecraft, paramWorld, paramSession, paramInt);
        }
    }

    public static ClientPlayerBase getClientPlayerBase(IClientPlayerAPI clientPlayer, String baseId) {
        ClientPlayerAPI clientPlayerAPI = clientPlayer.getClientPlayerAPI();
        return clientPlayerAPI != null ? clientPlayerAPI.getClientPlayerBase(baseId) : null;
    }

    public static Set<String> getClientPlayerBaseIds(IClientPlayerAPI clientPlayer) {
        ClientPlayerAPI clientPlayerAPI = clientPlayer.getClientPlayerAPI();
        Set<String> result = null;
        if (clientPlayerAPI != null) {
            result = clientPlayerAPI.getClientPlayerBaseIds();
        } else {
            result = Collections.emptySet();
        }

        return result;
    }

    public static Object dynamic(IClientPlayerAPI clientPlayer, String key, Object[] parameters) {
        ClientPlayerAPI clientPlayerAPI = clientPlayer.getClientPlayerAPI();
        return clientPlayerAPI != null ? clientPlayerAPI.dynamic(key, parameters) : null;
    }

    private static void sortBases(
            List<String> list,
            Map<String, String[]> allBaseSuperiors,
            Map<String, String[]> allBaseInferiors,
            String methodName) {
        new ClientPlayerBaseSorter(list, allBaseSuperiors, allBaseInferiors, methodName).Sort();
    }

    private static void sortDynamicBases(
            Map<String, List<String>> lists,
            Map<String, Map<String, String[]>> allBaseSuperiors,
            Map<String, Map<String, String[]>> allBaseInferiors,
            String key) {
        List<String> types = lists.get(key);
        if (types != null && types.size() > 1) {
            sortBases(
                    types,
                    getDynamicSorters(key, types, allBaseSuperiors),
                    getDynamicSorters(key, types, allBaseInferiors),
                    key);
        }
    }

    private static Map<String, String[]> getDynamicSorters(
            String key, List<String> toSort, Map<String, Map<String, String[]>> allBaseValues) {
        HashMap<String, String[]> superiors = null;

        for (String id : toSort) {
            Map<String, String[]> idSuperiors = allBaseValues.get(id);
            if (idSuperiors != null) {
                String[] keySuperiorIds = idSuperiors.get(key);
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

    private ClientPlayerAPI(IClientPlayerAPI player) {
        this.unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
        this.player = player;
    }

    private void load() {
        Iterator<String> iterator = allBaseConstructors.keySet().iterator();

        while (iterator.hasNext()) {
            String id = iterator.next();
            ClientPlayerBase toAttach = this.createClientPlayerBase(id);
            toAttach.beforeBaseAttach(false);
            this.allBaseObjects.put(id, toAttach);
            this.baseObjectsToId.put(toAttach, id);
        }

        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateClientPlayerBases();
        iterator = this.allBaseObjects.keySet().iterator();

        while (iterator.hasNext()) {
            this.allBaseObjects.get(iterator.next()).afterBaseAttach(false);
        }
    }

    private ClientPlayerBase createClientPlayerBase(String id) {
        Constructor<?> constructor = allBaseConstructors.get(id);

        try {
            ClientPlayerBase base;
            if (constructor.getParameterTypes().length == 1) {
                base = (ClientPlayerBase) constructor.newInstance(this);
            } else {
                base = (ClientPlayerBase) constructor.newInstance(this, id);
            }

            return base;
        } catch (Exception e) {
            throw new RuntimeException(
                    "Exception while creating a ClientPlayerBase of type '" + constructor.getDeclaringClass() + "'", e);
        }
    }

    private void updateClientPlayerBases() {
        this.beforeAddExhaustionHooks = this.create(beforeAddExhaustionHookTypes);
        this.overrideAddExhaustionHooks = this.create(overrideAddExhaustionHookTypes);
        this.afterAddExhaustionHooks = this.create(afterAddExhaustionHookTypes);
        this.isAddExhaustionModded = this.beforeAddExhaustionHooks != null
                || this.overrideAddExhaustionHooks != null
                || this.afterAddExhaustionHooks != null;
        this.beforeAddMovementStatHooks = this.create(beforeAddMovementStatHookTypes);
        this.overrideAddMovementStatHooks = this.create(overrideAddMovementStatHookTypes);
        this.afterAddMovementStatHooks = this.create(afterAddMovementStatHookTypes);
        this.isAddMovementStatModded = this.beforeAddMovementStatHooks != null
                || this.overrideAddMovementStatHooks != null
                || this.afterAddMovementStatHooks != null;
        this.beforeAddStatHooks = this.create(beforeAddStatHookTypes);
        this.overrideAddStatHooks = this.create(overrideAddStatHookTypes);
        this.afterAddStatHooks = this.create(afterAddStatHookTypes);
        this.isAddStatModded =
                this.beforeAddStatHooks != null || this.overrideAddStatHooks != null || this.afterAddStatHooks != null;
        this.beforeAttackEntityFromHooks = this.create(beforeAttackEntityFromHookTypes);
        this.overrideAttackEntityFromHooks = this.create(overrideAttackEntityFromHookTypes);
        this.afterAttackEntityFromHooks = this.create(afterAttackEntityFromHookTypes);
        this.isAttackEntityFromModded = this.beforeAttackEntityFromHooks != null
                || this.overrideAttackEntityFromHooks != null
                || this.afterAttackEntityFromHooks != null;
        this.beforeAttackTargetEntityWithCurrentItemHooks =
                this.create(beforeAttackTargetEntityWithCurrentItemHookTypes);
        this.overrideAttackTargetEntityWithCurrentItemHooks =
                this.create(overrideAttackTargetEntityWithCurrentItemHookTypes);
        this.afterAttackTargetEntityWithCurrentItemHooks = this.create(afterAttackTargetEntityWithCurrentItemHookTypes);
        this.isAttackTargetEntityWithCurrentItemModded = this.beforeAttackTargetEntityWithCurrentItemHooks != null
                || this.overrideAttackTargetEntityWithCurrentItemHooks != null
                || this.afterAttackTargetEntityWithCurrentItemHooks != null;
        this.beforeCanBreatheUnderwaterHooks = this.create(beforeCanBreatheUnderwaterHookTypes);
        this.overrideCanBreatheUnderwaterHooks = this.create(overrideCanBreatheUnderwaterHookTypes);
        this.afterCanBreatheUnderwaterHooks = this.create(afterCanBreatheUnderwaterHookTypes);
        this.isCanBreatheUnderwaterModded = this.beforeCanBreatheUnderwaterHooks != null
                || this.overrideCanBreatheUnderwaterHooks != null
                || this.afterCanBreatheUnderwaterHooks != null;
        this.beforeCanHarvestBlockHooks = this.create(beforeCanHarvestBlockHookTypes);
        this.overrideCanHarvestBlockHooks = this.create(overrideCanHarvestBlockHookTypes);
        this.afterCanHarvestBlockHooks = this.create(afterCanHarvestBlockHookTypes);
        this.isCanHarvestBlockModded = this.beforeCanHarvestBlockHooks != null
                || this.overrideCanHarvestBlockHooks != null
                || this.afterCanHarvestBlockHooks != null;
        this.beforeCanPlayerEditHooks = this.create(beforeCanPlayerEditHookTypes);
        this.overrideCanPlayerEditHooks = this.create(overrideCanPlayerEditHookTypes);
        this.afterCanPlayerEditHooks = this.create(afterCanPlayerEditHookTypes);
        this.isCanPlayerEditModded = this.beforeCanPlayerEditHooks != null
                || this.overrideCanPlayerEditHooks != null
                || this.afterCanPlayerEditHooks != null;
        this.beforeCanTriggerWalkingHooks = this.create(beforeCanTriggerWalkingHookTypes);
        this.overrideCanTriggerWalkingHooks = this.create(overrideCanTriggerWalkingHookTypes);
        this.afterCanTriggerWalkingHooks = this.create(afterCanTriggerWalkingHookTypes);
        this.isCanTriggerWalkingModded = this.beforeCanTriggerWalkingHooks != null
                || this.overrideCanTriggerWalkingHooks != null
                || this.afterCanTriggerWalkingHooks != null;
        this.beforeCloseScreenHooks = this.create(beforeCloseScreenHookTypes);
        this.overrideCloseScreenHooks = this.create(overrideCloseScreenHookTypes);
        this.afterCloseScreenHooks = this.create(afterCloseScreenHookTypes);
        this.isCloseScreenModded = this.beforeCloseScreenHooks != null
                || this.overrideCloseScreenHooks != null
                || this.afterCloseScreenHooks != null;
        this.beforeDamageEntityHooks = this.create(beforeDamageEntityHookTypes);
        this.overrideDamageEntityHooks = this.create(overrideDamageEntityHookTypes);
        this.afterDamageEntityHooks = this.create(afterDamageEntityHookTypes);
        this.isDamageEntityModded = this.beforeDamageEntityHooks != null
                || this.overrideDamageEntityHooks != null
                || this.afterDamageEntityHooks != null;
        this.beforeDisplayGUIBrewingStandHooks = this.create(beforeDisplayGUIBrewingStandHookTypes);
        this.overrideDisplayGUIBrewingStandHooks = this.create(overrideDisplayGUIBrewingStandHookTypes);
        this.afterDisplayGUIBrewingStandHooks = this.create(afterDisplayGUIBrewingStandHookTypes);
        this.isDisplayGUIBrewingStandModded = this.beforeDisplayGUIBrewingStandHooks != null
                || this.overrideDisplayGUIBrewingStandHooks != null
                || this.afterDisplayGUIBrewingStandHooks != null;
        this.beforeDisplayGUIChestHooks = this.create(beforeDisplayGUIChestHookTypes);
        this.overrideDisplayGUIChestHooks = this.create(overrideDisplayGUIChestHookTypes);
        this.afterDisplayGUIChestHooks = this.create(afterDisplayGUIChestHookTypes);
        this.isDisplayGUIChestModded = this.beforeDisplayGUIChestHooks != null
                || this.overrideDisplayGUIChestHooks != null
                || this.afterDisplayGUIChestHooks != null;
        this.beforeDisplayGUIDispenserHooks = this.create(beforeDisplayGUIDispenserHookTypes);
        this.overrideDisplayGUIDispenserHooks = this.create(overrideDisplayGUIDispenserHookTypes);
        this.afterDisplayGUIDispenserHooks = this.create(afterDisplayGUIDispenserHookTypes);
        this.isDisplayGUIDispenserModded = this.beforeDisplayGUIDispenserHooks != null
                || this.overrideDisplayGUIDispenserHooks != null
                || this.afterDisplayGUIDispenserHooks != null;
        this.beforeDisplayGUIEditSignHooks = this.create(beforeDisplayGUIEditSignHookTypes);
        this.overrideDisplayGUIEditSignHooks = this.create(overrideDisplayGUIEditSignHookTypes);
        this.afterDisplayGUIEditSignHooks = this.create(afterDisplayGUIEditSignHookTypes);
        this.isDisplayGUIEditSignModded = this.beforeDisplayGUIEditSignHooks != null
                || this.overrideDisplayGUIEditSignHooks != null
                || this.afterDisplayGUIEditSignHooks != null;
        this.beforeDisplayGUIEnchantmentHooks = this.create(beforeDisplayGUIEnchantmentHookTypes);
        this.overrideDisplayGUIEnchantmentHooks = this.create(overrideDisplayGUIEnchantmentHookTypes);
        this.afterDisplayGUIEnchantmentHooks = this.create(afterDisplayGUIEnchantmentHookTypes);
        this.isDisplayGUIEnchantmentModded = this.beforeDisplayGUIEnchantmentHooks != null
                || this.overrideDisplayGUIEnchantmentHooks != null
                || this.afterDisplayGUIEnchantmentHooks != null;
        this.beforeDisplayGUIFurnaceHooks = this.create(beforeDisplayGUIFurnaceHookTypes);
        this.overrideDisplayGUIFurnaceHooks = this.create(overrideDisplayGUIFurnaceHookTypes);
        this.afterDisplayGUIFurnaceHooks = this.create(afterDisplayGUIFurnaceHookTypes);
        this.isDisplayGUIFurnaceModded = this.beforeDisplayGUIFurnaceHooks != null
                || this.overrideDisplayGUIFurnaceHooks != null
                || this.afterDisplayGUIFurnaceHooks != null;
        this.beforeDisplayGUIWorkbenchHooks = this.create(beforeDisplayGUIWorkbenchHookTypes);
        this.overrideDisplayGUIWorkbenchHooks = this.create(overrideDisplayGUIWorkbenchHookTypes);
        this.afterDisplayGUIWorkbenchHooks = this.create(afterDisplayGUIWorkbenchHookTypes);
        this.isDisplayGUIWorkbenchModded = this.beforeDisplayGUIWorkbenchHooks != null
                || this.overrideDisplayGUIWorkbenchHooks != null
                || this.afterDisplayGUIWorkbenchHooks != null;
        this.beforeDropOneItemHooks = this.create(beforeDropOneItemHookTypes);
        this.overrideDropOneItemHooks = this.create(overrideDropOneItemHookTypes);
        this.afterDropOneItemHooks = this.create(afterDropOneItemHookTypes);
        this.isDropOneItemModded = this.beforeDropOneItemHooks != null
                || this.overrideDropOneItemHooks != null
                || this.afterDropOneItemHooks != null;
        this.beforeDropPlayerItemHooks = this.create(beforeDropPlayerItemHookTypes);
        this.overrideDropPlayerItemHooks = this.create(overrideDropPlayerItemHookTypes);
        this.afterDropPlayerItemHooks = this.create(afterDropPlayerItemHookTypes);
        this.isDropPlayerItemModded = this.beforeDropPlayerItemHooks != null
                || this.overrideDropPlayerItemHooks != null
                || this.afterDropPlayerItemHooks != null;
        this.beforeDropPlayerItemWithRandomChoiceHooks = this.create(beforeDropPlayerItemWithRandomChoiceHookTypes);
        this.overrideDropPlayerItemWithRandomChoiceHooks = this.create(overrideDropPlayerItemWithRandomChoiceHookTypes);
        this.afterDropPlayerItemWithRandomChoiceHooks = this.create(afterDropPlayerItemWithRandomChoiceHookTypes);
        this.isDropPlayerItemWithRandomChoiceModded = this.beforeDropPlayerItemWithRandomChoiceHooks != null
                || this.overrideDropPlayerItemWithRandomChoiceHooks != null
                || this.afterDropPlayerItemWithRandomChoiceHooks != null;
        this.beforeFallHooks = this.create(beforeFallHookTypes);
        this.overrideFallHooks = this.create(overrideFallHookTypes);
        this.afterFallHooks = this.create(afterFallHookTypes);
        this.isFallModded =
                this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null;
        this.beforeGetAIMoveSpeedHooks = this.create(beforeGetAIMoveSpeedHookTypes);
        this.overrideGetAIMoveSpeedHooks = this.create(overrideGetAIMoveSpeedHookTypes);
        this.afterGetAIMoveSpeedHooks = this.create(afterGetAIMoveSpeedHookTypes);
        this.isGetAIMoveSpeedModded = this.beforeGetAIMoveSpeedHooks != null
                || this.overrideGetAIMoveSpeedHooks != null
                || this.afterGetAIMoveSpeedHooks != null;
        this.beforeGetBedOrientationInDegreesHooks = this.create(beforeGetBedOrientationInDegreesHookTypes);
        this.overrideGetBedOrientationInDegreesHooks = this.create(overrideGetBedOrientationInDegreesHookTypes);
        this.afterGetBedOrientationInDegreesHooks = this.create(afterGetBedOrientationInDegreesHookTypes);
        this.isGetBedOrientationInDegreesModded = this.beforeGetBedOrientationInDegreesHooks != null
                || this.overrideGetBedOrientationInDegreesHooks != null
                || this.afterGetBedOrientationInDegreesHooks != null;
        this.beforeGetBrightnessHooks = this.create(beforeGetBrightnessHookTypes);
        this.overrideGetBrightnessHooks = this.create(overrideGetBrightnessHookTypes);
        this.afterGetBrightnessHooks = this.create(afterGetBrightnessHookTypes);
        this.isGetBrightnessModded = this.beforeGetBrightnessHooks != null
                || this.overrideGetBrightnessHooks != null
                || this.afterGetBrightnessHooks != null;
        this.beforeGetBrightnessForRenderHooks = this.create(beforeGetBrightnessForRenderHookTypes);
        this.overrideGetBrightnessForRenderHooks = this.create(overrideGetBrightnessForRenderHookTypes);
        this.afterGetBrightnessForRenderHooks = this.create(afterGetBrightnessForRenderHookTypes);
        this.isGetBrightnessForRenderModded = this.beforeGetBrightnessForRenderHooks != null
                || this.overrideGetBrightnessForRenderHooks != null
                || this.afterGetBrightnessForRenderHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockHooks = this.create(beforeGetCurrentPlayerStrVsBlockHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockHooks = this.create(overrideGetCurrentPlayerStrVsBlockHookTypes);
        this.afterGetCurrentPlayerStrVsBlockHooks = this.create(afterGetCurrentPlayerStrVsBlockHookTypes);
        this.isGetCurrentPlayerStrVsBlockModded = this.beforeGetCurrentPlayerStrVsBlockHooks != null
                || this.overrideGetCurrentPlayerStrVsBlockHooks != null
                || this.afterGetCurrentPlayerStrVsBlockHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockForgeHooks = this.create(beforeGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockForgeHooks =
                this.create(overrideGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.afterGetCurrentPlayerStrVsBlockForgeHooks = this.create(afterGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.isGetCurrentPlayerStrVsBlockForgeModded = this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null
                || this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null
                || this.afterGetCurrentPlayerStrVsBlockForgeHooks != null;
        this.beforeGetDistanceSqHooks = this.create(beforeGetDistanceSqHookTypes);
        this.overrideGetDistanceSqHooks = this.create(overrideGetDistanceSqHookTypes);
        this.afterGetDistanceSqHooks = this.create(afterGetDistanceSqHookTypes);
        this.isGetDistanceSqModded = this.beforeGetDistanceSqHooks != null
                || this.overrideGetDistanceSqHooks != null
                || this.afterGetDistanceSqHooks != null;
        this.beforeGetDistanceSqToEntityHooks = this.create(beforeGetDistanceSqToEntityHookTypes);
        this.overrideGetDistanceSqToEntityHooks = this.create(overrideGetDistanceSqToEntityHookTypes);
        this.afterGetDistanceSqToEntityHooks = this.create(afterGetDistanceSqToEntityHookTypes);
        this.isGetDistanceSqToEntityModded = this.beforeGetDistanceSqToEntityHooks != null
                || this.overrideGetDistanceSqToEntityHooks != null
                || this.afterGetDistanceSqToEntityHooks != null;
        this.beforeGetFOVMultiplierHooks = this.create(beforeGetFOVMultiplierHookTypes);
        this.overrideGetFOVMultiplierHooks = this.create(overrideGetFOVMultiplierHookTypes);
        this.afterGetFOVMultiplierHooks = this.create(afterGetFOVMultiplierHookTypes);
        this.isGetFOVMultiplierModded = this.beforeGetFOVMultiplierHooks != null
                || this.overrideGetFOVMultiplierHooks != null
                || this.afterGetFOVMultiplierHooks != null;
        this.beforeGetHurtSoundHooks = this.create(beforeGetHurtSoundHookTypes);
        this.overrideGetHurtSoundHooks = this.create(overrideGetHurtSoundHookTypes);
        this.afterGetHurtSoundHooks = this.create(afterGetHurtSoundHookTypes);
        this.isGetHurtSoundModded = this.beforeGetHurtSoundHooks != null
                || this.overrideGetHurtSoundHooks != null
                || this.afterGetHurtSoundHooks != null;
        this.beforeGetItemIconHooks = this.create(beforeGetItemIconHookTypes);
        this.overrideGetItemIconHooks = this.create(overrideGetItemIconHookTypes);
        this.afterGetItemIconHooks = this.create(afterGetItemIconHookTypes);
        this.isGetItemIconModded = this.beforeGetItemIconHooks != null
                || this.overrideGetItemIconHooks != null
                || this.afterGetItemIconHooks != null;
        this.beforeGetSleepTimerHooks = this.create(beforeGetSleepTimerHookTypes);
        this.overrideGetSleepTimerHooks = this.create(overrideGetSleepTimerHookTypes);
        this.afterGetSleepTimerHooks = this.create(afterGetSleepTimerHookTypes);
        this.isGetSleepTimerModded = this.beforeGetSleepTimerHooks != null
                || this.overrideGetSleepTimerHooks != null
                || this.afterGetSleepTimerHooks != null;
        this.beforeHandleLavaMovementHooks = this.create(beforeHandleLavaMovementHookTypes);
        this.overrideHandleLavaMovementHooks = this.create(overrideHandleLavaMovementHookTypes);
        this.afterHandleLavaMovementHooks = this.create(afterHandleLavaMovementHookTypes);
        this.isHandleLavaMovementModded = this.beforeHandleLavaMovementHooks != null
                || this.overrideHandleLavaMovementHooks != null
                || this.afterHandleLavaMovementHooks != null;
        this.beforeHandleWaterMovementHooks = this.create(beforeHandleWaterMovementHookTypes);
        this.overrideHandleWaterMovementHooks = this.create(overrideHandleWaterMovementHookTypes);
        this.afterHandleWaterMovementHooks = this.create(afterHandleWaterMovementHookTypes);
        this.isHandleWaterMovementModded = this.beforeHandleWaterMovementHooks != null
                || this.overrideHandleWaterMovementHooks != null
                || this.afterHandleWaterMovementHooks != null;
        this.beforeHealHooks = this.create(beforeHealHookTypes);
        this.overrideHealHooks = this.create(overrideHealHookTypes);
        this.afterHealHooks = this.create(afterHealHookTypes);
        this.isHealModded =
                this.beforeHealHooks != null || this.overrideHealHooks != null || this.afterHealHooks != null;
        this.beforeIsEntityInsideOpaqueBlockHooks = this.create(beforeIsEntityInsideOpaqueBlockHookTypes);
        this.overrideIsEntityInsideOpaqueBlockHooks = this.create(overrideIsEntityInsideOpaqueBlockHookTypes);
        this.afterIsEntityInsideOpaqueBlockHooks = this.create(afterIsEntityInsideOpaqueBlockHookTypes);
        this.isIsEntityInsideOpaqueBlockModded = this.beforeIsEntityInsideOpaqueBlockHooks != null
                || this.overrideIsEntityInsideOpaqueBlockHooks != null
                || this.afterIsEntityInsideOpaqueBlockHooks != null;
        this.beforeIsInWaterHooks = this.create(beforeIsInWaterHookTypes);
        this.overrideIsInWaterHooks = this.create(overrideIsInWaterHookTypes);
        this.afterIsInWaterHooks = this.create(afterIsInWaterHookTypes);
        this.isIsInWaterModded = this.beforeIsInWaterHooks != null
                || this.overrideIsInWaterHooks != null
                || this.afterIsInWaterHooks != null;
        this.beforeIsInsideOfMaterialHooks = this.create(beforeIsInsideOfMaterialHookTypes);
        this.overrideIsInsideOfMaterialHooks = this.create(overrideIsInsideOfMaterialHookTypes);
        this.afterIsInsideOfMaterialHooks = this.create(afterIsInsideOfMaterialHookTypes);
        this.isIsInsideOfMaterialModded = this.beforeIsInsideOfMaterialHooks != null
                || this.overrideIsInsideOfMaterialHooks != null
                || this.afterIsInsideOfMaterialHooks != null;
        this.beforeIsOnLadderHooks = this.create(beforeIsOnLadderHookTypes);
        this.overrideIsOnLadderHooks = this.create(overrideIsOnLadderHookTypes);
        this.afterIsOnLadderHooks = this.create(afterIsOnLadderHookTypes);
        this.isIsOnLadderModded = this.beforeIsOnLadderHooks != null
                || this.overrideIsOnLadderHooks != null
                || this.afterIsOnLadderHooks != null;
        this.beforeIsPlayerSleepingHooks = this.create(beforeIsPlayerSleepingHookTypes);
        this.overrideIsPlayerSleepingHooks = this.create(overrideIsPlayerSleepingHookTypes);
        this.afterIsPlayerSleepingHooks = this.create(afterIsPlayerSleepingHookTypes);
        this.isIsPlayerSleepingModded = this.beforeIsPlayerSleepingHooks != null
                || this.overrideIsPlayerSleepingHooks != null
                || this.afterIsPlayerSleepingHooks != null;
        this.beforeIsSneakingHooks = this.create(beforeIsSneakingHookTypes);
        this.overrideIsSneakingHooks = this.create(overrideIsSneakingHookTypes);
        this.afterIsSneakingHooks = this.create(afterIsSneakingHookTypes);
        this.isIsSneakingModded = this.beforeIsSneakingHooks != null
                || this.overrideIsSneakingHooks != null
                || this.afterIsSneakingHooks != null;
        this.beforeIsSprintingHooks = this.create(beforeIsSprintingHookTypes);
        this.overrideIsSprintingHooks = this.create(overrideIsSprintingHookTypes);
        this.afterIsSprintingHooks = this.create(afterIsSprintingHookTypes);
        this.isIsSprintingModded = this.beforeIsSprintingHooks != null
                || this.overrideIsSprintingHooks != null
                || this.afterIsSprintingHooks != null;
        this.beforeJumpHooks = this.create(beforeJumpHookTypes);
        this.overrideJumpHooks = this.create(overrideJumpHookTypes);
        this.afterJumpHooks = this.create(afterJumpHookTypes);
        this.isJumpModded =
                this.beforeJumpHooks != null || this.overrideJumpHooks != null || this.afterJumpHooks != null;
        this.beforeKnockBackHooks = this.create(beforeKnockBackHookTypes);
        this.overrideKnockBackHooks = this.create(overrideKnockBackHookTypes);
        this.afterKnockBackHooks = this.create(afterKnockBackHookTypes);
        this.isKnockBackModded = this.beforeKnockBackHooks != null
                || this.overrideKnockBackHooks != null
                || this.afterKnockBackHooks != null;
        this.beforeMoveEntityHooks = this.create(beforeMoveEntityHookTypes);
        this.overrideMoveEntityHooks = this.create(overrideMoveEntityHookTypes);
        this.afterMoveEntityHooks = this.create(afterMoveEntityHookTypes);
        this.isMoveEntityModded = this.beforeMoveEntityHooks != null
                || this.overrideMoveEntityHooks != null
                || this.afterMoveEntityHooks != null;
        this.beforeMoveEntityWithHeadingHooks = this.create(beforeMoveEntityWithHeadingHookTypes);
        this.overrideMoveEntityWithHeadingHooks = this.create(overrideMoveEntityWithHeadingHookTypes);
        this.afterMoveEntityWithHeadingHooks = this.create(afterMoveEntityWithHeadingHookTypes);
        this.isMoveEntityWithHeadingModded = this.beforeMoveEntityWithHeadingHooks != null
                || this.overrideMoveEntityWithHeadingHooks != null
                || this.afterMoveEntityWithHeadingHooks != null;
        this.beforeMoveFlyingHooks = this.create(beforeMoveFlyingHookTypes);
        this.overrideMoveFlyingHooks = this.create(overrideMoveFlyingHookTypes);
        this.afterMoveFlyingHooks = this.create(afterMoveFlyingHookTypes);
        this.isMoveFlyingModded = this.beforeMoveFlyingHooks != null
                || this.overrideMoveFlyingHooks != null
                || this.afterMoveFlyingHooks != null;
        this.beforeOnDeathHooks = this.create(beforeOnDeathHookTypes);
        this.overrideOnDeathHooks = this.create(overrideOnDeathHookTypes);
        this.afterOnDeathHooks = this.create(afterOnDeathHookTypes);
        this.isOnDeathModded =
                this.beforeOnDeathHooks != null || this.overrideOnDeathHooks != null || this.afterOnDeathHooks != null;
        this.beforeOnLivingUpdateHooks = this.create(beforeOnLivingUpdateHookTypes);
        this.overrideOnLivingUpdateHooks = this.create(overrideOnLivingUpdateHookTypes);
        this.afterOnLivingUpdateHooks = this.create(afterOnLivingUpdateHookTypes);
        this.isOnLivingUpdateModded = this.beforeOnLivingUpdateHooks != null
                || this.overrideOnLivingUpdateHooks != null
                || this.afterOnLivingUpdateHooks != null;
        this.beforeOnKillEntityHooks = this.create(beforeOnKillEntityHookTypes);
        this.overrideOnKillEntityHooks = this.create(overrideOnKillEntityHookTypes);
        this.afterOnKillEntityHooks = this.create(afterOnKillEntityHookTypes);
        this.isOnKillEntityModded = this.beforeOnKillEntityHooks != null
                || this.overrideOnKillEntityHooks != null
                || this.afterOnKillEntityHooks != null;
        this.beforeOnStruckByLightningHooks = this.create(beforeOnStruckByLightningHookTypes);
        this.overrideOnStruckByLightningHooks = this.create(overrideOnStruckByLightningHookTypes);
        this.afterOnStruckByLightningHooks = this.create(afterOnStruckByLightningHookTypes);
        this.isOnStruckByLightningModded = this.beforeOnStruckByLightningHooks != null
                || this.overrideOnStruckByLightningHooks != null
                || this.afterOnStruckByLightningHooks != null;
        this.beforeOnUpdateHooks = this.create(beforeOnUpdateHookTypes);
        this.overrideOnUpdateHooks = this.create(overrideOnUpdateHookTypes);
        this.afterOnUpdateHooks = this.create(afterOnUpdateHookTypes);
        this.isOnUpdateModded = this.beforeOnUpdateHooks != null
                || this.overrideOnUpdateHooks != null
                || this.afterOnUpdateHooks != null;
        this.beforePlayStepSoundHooks = this.create(beforePlayStepSoundHookTypes);
        this.overridePlayStepSoundHooks = this.create(overridePlayStepSoundHookTypes);
        this.afterPlayStepSoundHooks = this.create(afterPlayStepSoundHookTypes);
        this.isPlayStepSoundModded = this.beforePlayStepSoundHooks != null
                || this.overridePlayStepSoundHooks != null
                || this.afterPlayStepSoundHooks != null;
        this.beforePushOutOfBlocksHooks = this.create(beforePushOutOfBlocksHookTypes);
        this.overridePushOutOfBlocksHooks = this.create(overridePushOutOfBlocksHookTypes);
        this.afterPushOutOfBlocksHooks = this.create(afterPushOutOfBlocksHookTypes);
        this.isPushOutOfBlocksModded = this.beforePushOutOfBlocksHooks != null
                || this.overridePushOutOfBlocksHooks != null
                || this.afterPushOutOfBlocksHooks != null;
        this.beforeRayTraceHooks = this.create(beforeRayTraceHookTypes);
        this.overrideRayTraceHooks = this.create(overrideRayTraceHookTypes);
        this.afterRayTraceHooks = this.create(afterRayTraceHookTypes);
        this.isRayTraceModded = this.beforeRayTraceHooks != null
                || this.overrideRayTraceHooks != null
                || this.afterRayTraceHooks != null;
        this.beforeReadEntityFromNBTHooks = this.create(beforeReadEntityFromNBTHookTypes);
        this.overrideReadEntityFromNBTHooks = this.create(overrideReadEntityFromNBTHookTypes);
        this.afterReadEntityFromNBTHooks = this.create(afterReadEntityFromNBTHookTypes);
        this.isReadEntityFromNBTModded = this.beforeReadEntityFromNBTHooks != null
                || this.overrideReadEntityFromNBTHooks != null
                || this.afterReadEntityFromNBTHooks != null;
        this.beforeRespawnPlayerHooks = this.create(beforeRespawnPlayerHookTypes);
        this.overrideRespawnPlayerHooks = this.create(overrideRespawnPlayerHookTypes);
        this.afterRespawnPlayerHooks = this.create(afterRespawnPlayerHookTypes);
        this.isRespawnPlayerModded = this.beforeRespawnPlayerHooks != null
                || this.overrideRespawnPlayerHooks != null
                || this.afterRespawnPlayerHooks != null;
        this.beforeSetDeadHooks = this.create(beforeSetDeadHookTypes);
        this.overrideSetDeadHooks = this.create(overrideSetDeadHookTypes);
        this.afterSetDeadHooks = this.create(afterSetDeadHookTypes);
        this.isSetDeadModded =
                this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null;
        this.beforeSetPlayerSPHealthHooks = this.create(beforeSetPlayerSPHealthHookTypes);
        this.overrideSetPlayerSPHealthHooks = this.create(overrideSetPlayerSPHealthHookTypes);
        this.afterSetPlayerSPHealthHooks = this.create(afterSetPlayerSPHealthHookTypes);
        this.isSetPlayerSPHealthModded = this.beforeSetPlayerSPHealthHooks != null
                || this.overrideSetPlayerSPHealthHooks != null
                || this.afterSetPlayerSPHealthHooks != null;
        this.beforeSetPositionAndRotationHooks = this.create(beforeSetPositionAndRotationHookTypes);
        this.overrideSetPositionAndRotationHooks = this.create(overrideSetPositionAndRotationHookTypes);
        this.afterSetPositionAndRotationHooks = this.create(afterSetPositionAndRotationHookTypes);
        this.isSetPositionAndRotationModded = this.beforeSetPositionAndRotationHooks != null
                || this.overrideSetPositionAndRotationHooks != null
                || this.afterSetPositionAndRotationHooks != null;
        this.beforeSetSneakingHooks = this.create(beforeSetSneakingHookTypes);
        this.overrideSetSneakingHooks = this.create(overrideSetSneakingHookTypes);
        this.afterSetSneakingHooks = this.create(afterSetSneakingHookTypes);
        this.isSetSneakingModded = this.beforeSetSneakingHooks != null
                || this.overrideSetSneakingHooks != null
                || this.afterSetSneakingHooks != null;
        this.beforeSetSprintingHooks = this.create(beforeSetSprintingHookTypes);
        this.overrideSetSprintingHooks = this.create(overrideSetSprintingHookTypes);
        this.afterSetSprintingHooks = this.create(afterSetSprintingHookTypes);
        this.isSetSprintingModded = this.beforeSetSprintingHooks != null
                || this.overrideSetSprintingHooks != null
                || this.afterSetSprintingHooks != null;
        this.beforeSleepInBedAtHooks = this.create(beforeSleepInBedAtHookTypes);
        this.overrideSleepInBedAtHooks = this.create(overrideSleepInBedAtHookTypes);
        this.afterSleepInBedAtHooks = this.create(afterSleepInBedAtHookTypes);
        this.isSleepInBedAtModded = this.beforeSleepInBedAtHooks != null
                || this.overrideSleepInBedAtHooks != null
                || this.afterSleepInBedAtHooks != null;
        this.beforeSwingItemHooks = this.create(beforeSwingItemHookTypes);
        this.overrideSwingItemHooks = this.create(overrideSwingItemHookTypes);
        this.afterSwingItemHooks = this.create(afterSwingItemHookTypes);
        this.isSwingItemModded = this.beforeSwingItemHooks != null
                || this.overrideSwingItemHooks != null
                || this.afterSwingItemHooks != null;
        this.beforeUpdateEntityActionStateHooks = this.create(beforeUpdateEntityActionStateHookTypes);
        this.overrideUpdateEntityActionStateHooks = this.create(overrideUpdateEntityActionStateHookTypes);
        this.afterUpdateEntityActionStateHooks = this.create(afterUpdateEntityActionStateHookTypes);
        this.isUpdateEntityActionStateModded = this.beforeUpdateEntityActionStateHooks != null
                || this.overrideUpdateEntityActionStateHooks != null
                || this.afterUpdateEntityActionStateHooks != null;
        this.beforeUpdateRiddenHooks = this.create(beforeUpdateRiddenHookTypes);
        this.overrideUpdateRiddenHooks = this.create(overrideUpdateRiddenHookTypes);
        this.afterUpdateRiddenHooks = this.create(afterUpdateRiddenHookTypes);
        this.isUpdateRiddenModded = this.beforeUpdateRiddenHooks != null
                || this.overrideUpdateRiddenHooks != null
                || this.afterUpdateRiddenHooks != null;
        this.beforeWakeUpPlayerHooks = this.create(beforeWakeUpPlayerHookTypes);
        this.overrideWakeUpPlayerHooks = this.create(overrideWakeUpPlayerHookTypes);
        this.afterWakeUpPlayerHooks = this.create(afterWakeUpPlayerHookTypes);
        this.isWakeUpPlayerModded = this.beforeWakeUpPlayerHooks != null
                || this.overrideWakeUpPlayerHooks != null
                || this.afterWakeUpPlayerHooks != null;
        this.beforeWriteEntityToNBTHooks = this.create(beforeWriteEntityToNBTHookTypes);
        this.overrideWriteEntityToNBTHooks = this.create(overrideWriteEntityToNBTHookTypes);
        this.afterWriteEntityToNBTHooks = this.create(afterWriteEntityToNBTHookTypes);
        this.isWriteEntityToNBTModded = this.beforeWriteEntityToNBTHooks != null
                || this.overrideWriteEntityToNBTHooks != null
                || this.afterWriteEntityToNBTHooks != null;
    }

    private void attachClientPlayerBase(String id) {
        ClientPlayerBase toAttach = this.createClientPlayerBase(id);
        toAttach.beforeBaseAttach(true);
        this.allBaseObjects.put(id, toAttach);
        this.updateClientPlayerBases();
        toAttach.afterBaseAttach(true);
    }

    private void detachClientPlayerBase(String id) {
        ClientPlayerBase toDetach = this.allBaseObjects.get(id);
        toDetach.beforeBaseDetach(true);
        this.allBaseObjects.remove(id);
        toDetach.afterBaseDetach(true);
    }

    private ClientPlayerBase[] create(List<String> types) {
        if (types.isEmpty()) {
            return null;
        } else {
            ClientPlayerBase[] result = new ClientPlayerBase[types.size()];

            for (int i = 0; i < result.length; ++i) {
                result[i] = this.getClientPlayerBase(types.get(i));
            }

            return result;
        }
    }

    private void beforeLocalConstructing(
            Minecraft paramMinecraft, World paramWorld, Session paramSession, int paramInt) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing(
                        paramMinecraft, paramWorld, paramSession, paramInt);
            }
        }

        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(
            Minecraft paramMinecraft, World paramWorld, Session paramSession, int paramInt) {
        if (this.afterLocalConstructingHooks != null) {
            for (ClientPlayerBase afterLocalConstructingHook : this.afterLocalConstructingHooks) {
                afterLocalConstructingHook.afterLocalConstructing(paramMinecraft, paramWorld, paramSession, paramInt);
            }
        }

        this.afterLocalConstructingHooks = null;
    }

    public ClientPlayerBase getClientPlayerBase(String id) {
        return this.allBaseObjects.get(id);
    }

    public Set<String> getClientPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String key, Object[] parameters) {
        key = key.replace('.', '_').replace(' ', '_');
        this.executeAll(key, parameters, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object result = this.dynamicOverwritten(key, parameters, null);
        this.executeAll(key, parameters, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return result;
    }

    public Object dynamicOverwritten(String key, Object[] parameters, ClientPlayerBase overwriter) {
        List<String> overrideIds = overrideDynamicHookTypes.get(key);
        String id = null;
        if (overrideIds != null) {
            if (overwriter != null) {
                id = this.baseObjectsToId.get(overwriter);
                int index = overrideIds.indexOf(id);
                if (index > 0) {
                    id = overrideIds.get(index - 1);
                } else {
                    id = null;
                }
            } else if (overrideIds.size() > 0) {
                id = overrideIds.get(overrideIds.size() - 1);
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

        Map<String, Method> methods = methodMap.get(allBaseConstructors.get(id).getDeclaringClass());
        if (methods == null) {
            return null;
        } else {
            Method method = methods.get(key);
            return method == null ? null : this.execute(this.getClientPlayerBase(id), method, parameters);
        }
    }

    private void executeAll(
            String key,
            Object[] parameters,
            Map<String, List<String>> dynamicHookTypes,
            Map<Class<?>, Map<String, Method>> dynamicHookMethods,
            boolean reverse) {
        List<String> beforeIds = dynamicHookTypes.get(key);
        if (beforeIds != null) {
            int i = reverse ? beforeIds.size() - 1 : 0;

            while (true) {
                if (reverse) {
                    if (i < 0) {
                        break;
                    }
                } else if (i >= beforeIds.size()) {
                    break;
                }

                String id = beforeIds.get(i);
                ClientPlayerBase base = this.getClientPlayerBase(id);
                Class<?> type = base.getClass();
                Map<String, Method> methods = dynamicHookMethods.get(type);
                if (methods != null) {
                    Method method = methods.get(key);
                    if (method != null) {
                        this.execute(base, method, parameters);
                    }
                }

                i += reverse ? -1 : 1;
            }
        }
    }

    private Object execute(ClientPlayerBase base, Method method, Object[] parameters) {
        try {
            return method.invoke(base, parameters);
        } catch (Exception var5) {
            throw new RuntimeException("Exception while invoking dynamic method", var5);
        }
    }

    public static void addExhaustion(IClientPlayerAPI target, float paramFloat) {
        ClientPlayerAPI clientPlayerAPI = target.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isAddExhaustionModded) {
            clientPlayerAPI.addExhaustion(paramFloat);
        } else {
            target.localAddExhaustion(paramFloat);
        }
    }

    private void addExhaustion(float paramFloat) {
        int i;
        if (this.beforeAddExhaustionHooks != null) {
            for (i = this.beforeAddExhaustionHooks.length - 1; i >= 0; --i) {
                this.beforeAddExhaustionHooks[i].beforeAddExhaustion(paramFloat);
            }
        }

        if (this.overrideAddExhaustionHooks != null) {
            this.overrideAddExhaustionHooks[this.overrideAddExhaustionHooks.length - 1].addExhaustion(paramFloat);
        } else {
            this.player.localAddExhaustion(paramFloat);
        }

        if (this.afterAddExhaustionHooks != null) {
            for (i = 0; i < this.afterAddExhaustionHooks.length; ++i) {
                this.afterAddExhaustionHooks[i].afterAddExhaustion(paramFloat);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenAddExhaustion(ClientPlayerBase overWriter) {
        if (this.overrideAddExhaustionHooks != null) {
            for (int i = 0; i < this.overrideAddExhaustionHooks.length; ++i) {
                if (this.overrideAddExhaustionHooks[i] == overWriter) {
                    if (i == 0) {
                        return null;
                    }

                    return this.overrideAddExhaustionHooks[i - 1];
                }
            }
        }
        return overWriter;
    }

    public static void addMovementStat(IClientPlayerAPI var0, double var1, double var3, double var5) {
        ClientPlayerAPI var7 = var0.getClientPlayerAPI();
        if (var7 != null && var7.isAddMovementStatModded) {
            var7.addMovementStat(var1, var3, var5);
        } else {
            var0.localAddMovementStat(var1, var3, var5);
        }
    }

    private void addMovementStat(double var1, double var3, double var5) {
        int var7;
        if (this.beforeAddMovementStatHooks != null) {
            for (var7 = this.beforeAddMovementStatHooks.length - 1; var7 >= 0; --var7) {
                this.beforeAddMovementStatHooks[var7].beforeAddMovementStat(var1, var3, var5);
            }
        }

        if (this.overrideAddMovementStatHooks != null) {
            this.overrideAddMovementStatHooks[this.overrideAddMovementStatHooks.length - 1].addMovementStat(
                    var1, var3, var5);
        } else {
            this.player.localAddMovementStat(var1, var3, var5);
        }

        if (this.afterAddMovementStatHooks != null) {
            for (var7 = 0; var7 < this.afterAddMovementStatHooks.length; ++var7) {
                this.afterAddMovementStatHooks[var7].afterAddMovementStat(var1, var3, var5);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenAddMovementStat(ClientPlayerBase var1) {
        if (this.overrideAddMovementStatHooks != null) {
            for (int var2 = 0; var2 < this.overrideAddMovementStatHooks.length; ++var2) {
                if (this.overrideAddMovementStatHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddMovementStatHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void addStat(IClientPlayerAPI var0, StatBase var1, int var2) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
        if (var3 != null && var3.isAddStatModded) {
            var3.addStat(var1, var2);
        } else {
            var0.localAddStat(var1, var2);
        }
    }

    private void addStat(StatBase var1, int var2) {
        int var3;
        if (this.beforeAddStatHooks != null) {
            for (var3 = this.beforeAddStatHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAddStatHooks[var3].beforeAddStat(var1, var2);
            }
        }

        if (this.overrideAddStatHooks != null) {
            this.overrideAddStatHooks[this.overrideAddStatHooks.length - 1].addStat(var1, var2);
        } else {
            this.player.localAddStat(var1, var2);
        }

        if (this.afterAddStatHooks != null) {
            for (var3 = 0; var3 < this.afterAddStatHooks.length; ++var3) {
                this.afterAddStatHooks[var3].afterAddStat(var1, var2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenAddStat(ClientPlayerBase var1) {
        if (this.overrideAddStatHooks != null) {
            for (int var2 = 0; var2 < this.overrideAddStatHooks.length; ++var2) {
                if (this.overrideAddStatHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAddStatHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean attackEntityFrom(IClientPlayerAPI var0, DamageSource var1, float var2) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
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
            for (int var3 = this.beforeAttackEntityFromHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAttackEntityFromHooks[var3].beforeAttackEntityFrom(var1, var2);
            }
        }

        boolean var5;
        if (this.overrideAttackEntityFromHooks != null) {
            var5 = this.overrideAttackEntityFromHooks[this.overrideAttackEntityFromHooks.length - 1].attackEntityFrom(
                    var1, var2);
        } else {
            var5 = this.player.localAttackEntityFrom(var1, var2);
        }

        if (this.afterAttackEntityFromHooks != null) {
            for (ClientPlayerBase afterAttackEntityFromHook : this.afterAttackEntityFromHooks) {
                afterAttackEntityFromHook.afterAttackEntityFrom(var1, var2);
            }
        }

        return var5;
    }

    protected ClientPlayerBase GetOverwrittenAttackEntityFrom(ClientPlayerBase var1) {
        if (this.overrideAttackEntityFromHooks != null) {
            for (int var2 = 0; var2 < this.overrideAttackEntityFromHooks.length; ++var2) {
                if (this.overrideAttackEntityFromHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAttackEntityFromHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void attackTargetEntityWithCurrentItem(IClientPlayerAPI var0, Entity var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isAttackTargetEntityWithCurrentItemModded) {
            var2.attackTargetEntityWithCurrentItem(var1);
        } else {
            var0.localAttackTargetEntityWithCurrentItem(var1);
        }
    }

    private void attackTargetEntityWithCurrentItem(Entity var1) {
        int var2;
        if (this.beforeAttackTargetEntityWithCurrentItemHooks != null) {
            for (var2 = this.beforeAttackTargetEntityWithCurrentItemHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAttackTargetEntityWithCurrentItemHooks[var2].beforeAttackTargetEntityWithCurrentItem(var1);
            }
        }

        if (this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
            this
                    .overrideAttackTargetEntityWithCurrentItemHooks[
                    this.overrideAttackTargetEntityWithCurrentItemHooks.length - 1]
                    .attackTargetEntityWithCurrentItem(var1);
        } else {
            this.player.localAttackTargetEntityWithCurrentItem(var1);
        }

        if (this.afterAttackTargetEntityWithCurrentItemHooks != null) {
            for (var2 = 0; var2 < this.afterAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
                this.afterAttackTargetEntityWithCurrentItemHooks[var2].afterAttackTargetEntityWithCurrentItem(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(ClientPlayerBase var1) {
        if (this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
            for (int var2 = 0; var2 < this.overrideAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
                if (this.overrideAttackTargetEntityWithCurrentItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideAttackTargetEntityWithCurrentItemHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean canBreatheUnderwater(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeCanBreatheUnderwaterHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanBreatheUnderwaterHooks[var1].beforeCanBreatheUnderwater();
            }
        }

        boolean var3;
        if (this.overrideCanBreatheUnderwaterHooks != null) {
            var3 = this.overrideCanBreatheUnderwaterHooks[this.overrideCanBreatheUnderwaterHooks.length - 1]
                    .canBreatheUnderwater();
        } else {
            var3 = this.player.localCanBreatheUnderwater();
        }

        if (this.afterCanBreatheUnderwaterHooks != null) {
            for (ClientPlayerBase afterCanBreatheUnderwaterHook : this.afterCanBreatheUnderwaterHooks) {
                afterCanBreatheUnderwaterHook.afterCanBreatheUnderwater();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenCanBreatheUnderwater(ClientPlayerBase var1) {
        if (this.overrideCanBreatheUnderwaterHooks != null) {
            for (int var2 = 0; var2 < this.overrideCanBreatheUnderwaterHooks.length; ++var2) {
                if (this.overrideCanBreatheUnderwaterHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanBreatheUnderwaterHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean canHarvestBlock(IClientPlayerAPI var0, Block var1) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
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
            for (int var2 = this.beforeCanHarvestBlockHooks.length - 1; var2 >= 0; --var2) {
                this.beforeCanHarvestBlockHooks[var2].beforeCanHarvestBlock(var1);
            }
        }

        boolean var4;
        if (this.overrideCanHarvestBlockHooks != null) {
            var4 = this.overrideCanHarvestBlockHooks[this.overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(
                    var1);
        } else {
            var4 = this.player.localCanHarvestBlock(var1);
        }

        if (this.afterCanHarvestBlockHooks != null) {
            for (ClientPlayerBase afterCanHarvestBlockHook : this.afterCanHarvestBlockHooks) {
                afterCanHarvestBlockHook.afterCanHarvestBlock(var1);
            }
        }

        return var4;
    }

    protected ClientPlayerBase GetOverwrittenCanHarvestBlock(ClientPlayerBase var1) {
        if (this.overrideCanHarvestBlockHooks != null) {
            for (int var2 = 0; var2 < this.overrideCanHarvestBlockHooks.length; ++var2) {
                if (this.overrideCanHarvestBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanHarvestBlockHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean canPlayerEdit(IClientPlayerAPI var0, int var1, int var2, int var3, int var4, ItemStack var5) {
        ClientPlayerAPI var7 = var0.getClientPlayerAPI();
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
            for (int var6 = this.beforeCanPlayerEditHooks.length - 1; var6 >= 0; --var6) {
                this.beforeCanPlayerEditHooks[var6].beforeCanPlayerEdit(var1, var2, var3, var4, var5);
            }
        }

        boolean var8;
        if (this.overrideCanPlayerEditHooks != null) {
            var8 = this.overrideCanPlayerEditHooks[this.overrideCanPlayerEditHooks.length - 1].canPlayerEdit(
                    var1, var2, var3, var4, var5);
        } else {
            var8 = this.player.localCanPlayerEdit(var1, var2, var3, var4, var5);
        }

        if (this.afterCanPlayerEditHooks != null) {
            for (ClientPlayerBase afterCanPlayerEditHook : this.afterCanPlayerEditHooks) {
                afterCanPlayerEditHook.afterCanPlayerEdit(var1, var2, var3, var4, var5);
            }
        }

        return var8;
    }

    protected ClientPlayerBase GetOverwrittenCanPlayerEdit(ClientPlayerBase var1) {
        if (this.overrideCanPlayerEditHooks != null) {
            for (int var2 = 0; var2 < this.overrideCanPlayerEditHooks.length; ++var2) {
                if (this.overrideCanPlayerEditHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanPlayerEditHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean canTriggerWalking(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeCanTriggerWalkingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanTriggerWalkingHooks[var1].beforeCanTriggerWalking();
            }
        }

        boolean var3;
        if (this.overrideCanTriggerWalkingHooks != null) {
            var3 =
                    this.overrideCanTriggerWalkingHooks[this.overrideCanTriggerWalkingHooks.length - 1]
                            .canTriggerWalking();
        } else {
            var3 = this.player.localCanTriggerWalking();
        }

        if (this.afterCanTriggerWalkingHooks != null) {
            for (ClientPlayerBase afterCanTriggerWalkingHook : this.afterCanTriggerWalkingHooks) {
                afterCanTriggerWalkingHook.afterCanTriggerWalking();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenCanTriggerWalking(ClientPlayerBase var1) {
        if (this.overrideCanTriggerWalkingHooks != null) {
            for (int var2 = 0; var2 < this.overrideCanTriggerWalkingHooks.length; ++var2) {
                if (this.overrideCanTriggerWalkingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCanTriggerWalkingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void closeScreen(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isCloseScreenModded) {
            var1.closeScreen();
        } else {
            var0.localCloseScreen();
        }
    }

    private void closeScreen() {
        int var1;
        if (this.beforeCloseScreenHooks != null) {
            for (var1 = this.beforeCloseScreenHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCloseScreenHooks[var1].beforeCloseScreen();
            }
        }

        if (this.overrideCloseScreenHooks != null) {
            this.overrideCloseScreenHooks[this.overrideCloseScreenHooks.length - 1].closeScreen();
        } else {
            this.player.localCloseScreen();
        }

        if (this.afterCloseScreenHooks != null) {
            for (var1 = 0; var1 < this.afterCloseScreenHooks.length; ++var1) {
                this.afterCloseScreenHooks[var1].afterCloseScreen();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenCloseScreen(ClientPlayerBase var1) {
        if (this.overrideCloseScreenHooks != null) {
            for (int var2 = 0; var2 < this.overrideCloseScreenHooks.length; ++var2) {
                if (this.overrideCloseScreenHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideCloseScreenHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void damageEntity(IClientPlayerAPI var0, DamageSource var1, float var2) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
        if (var3 != null && var3.isDamageEntityModded) {
            var3.damageEntity(var1, var2);
        } else {
            var0.localDamageEntity(var1, var2);
        }
    }

    private void damageEntity(DamageSource var1, float var2) {
        int var3;
        if (this.beforeDamageEntityHooks != null) {
            for (var3 = this.beforeDamageEntityHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDamageEntityHooks[var3].beforeDamageEntity(var1, var2);
            }
        }

        if (this.overrideDamageEntityHooks != null) {
            this.overrideDamageEntityHooks[this.overrideDamageEntityHooks.length - 1].damageEntity(var1, var2);
        } else {
            this.player.localDamageEntity(var1, var2);
        }

        if (this.afterDamageEntityHooks != null) {
            for (var3 = 0; var3 < this.afterDamageEntityHooks.length; ++var3) {
                this.afterDamageEntityHooks[var3].afterDamageEntity(var1, var2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDamageEntity(ClientPlayerBase var1) {
        if (this.overrideDamageEntityHooks != null) {
            for (int var2 = 0; var2 < this.overrideDamageEntityHooks.length; ++var2) {
                if (this.overrideDamageEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDamageEntityHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIBrewingStand(IClientPlayerAPI var0, TileEntityBrewingStand var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isDisplayGUIBrewingStandModded) {
            var2.displayGUIBrewingStand(var1);
        } else {
            var0.localDisplayGUIBrewingStand(var1);
        }
    }

    private void displayGUIBrewingStand(TileEntityBrewingStand var1) {
        int var2;
        if (this.beforeDisplayGUIBrewingStandHooks != null) {
            for (var2 = this.beforeDisplayGUIBrewingStandHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIBrewingStandHooks[var2].beforeDisplayGUIBrewingStand(var1);
            }
        }

        if (this.overrideDisplayGUIBrewingStandHooks != null) {
            this.overrideDisplayGUIBrewingStandHooks[this.overrideDisplayGUIBrewingStandHooks.length - 1]
                    .displayGUIBrewingStand(var1);
        } else {
            this.player.localDisplayGUIBrewingStand(var1);
        }

        if (this.afterDisplayGUIBrewingStandHooks != null) {
            for (var2 = 0; var2 < this.afterDisplayGUIBrewingStandHooks.length; ++var2) {
                this.afterDisplayGUIBrewingStandHooks[var2].afterDisplayGUIBrewingStand(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIBrewingStand(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIBrewingStandHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIBrewingStandHooks.length; ++var2) {
                if (this.overrideDisplayGUIBrewingStandHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIBrewingStandHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIChest(IClientPlayerAPI var0, IInventory var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isDisplayGUIChestModded) {
            var2.displayGUIChest(var1);
        } else {
            var0.localDisplayGUIChest(var1);
        }
    }

    private void displayGUIChest(IInventory var1) {
        int var2;
        if (this.beforeDisplayGUIChestHooks != null) {
            for (var2 = this.beforeDisplayGUIChestHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIChestHooks[var2].beforeDisplayGUIChest(var1);
            }
        }

        if (this.overrideDisplayGUIChestHooks != null) {
            this.overrideDisplayGUIChestHooks[this.overrideDisplayGUIChestHooks.length - 1].displayGUIChest(var1);
        } else {
            this.player.localDisplayGUIChest(var1);
        }

        if (this.afterDisplayGUIChestHooks != null) {
            for (var2 = 0; var2 < this.afterDisplayGUIChestHooks.length; ++var2) {
                this.afterDisplayGUIChestHooks[var2].afterDisplayGUIChest(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIChest(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIChestHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIChestHooks.length; ++var2) {
                if (this.overrideDisplayGUIChestHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIChestHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIDispenser(IClientPlayerAPI var0, TileEntityDispenser var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isDisplayGUIDispenserModded) {
            var2.displayGUIDispenser(var1);
        } else {
            var0.localDisplayGUIDispenser(var1);
        }
    }

    private void displayGUIDispenser(TileEntityDispenser var1) {
        int var2;
        if (this.beforeDisplayGUIDispenserHooks != null) {
            for (var2 = this.beforeDisplayGUIDispenserHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIDispenserHooks[var2].beforeDisplayGUIDispenser(var1);
            }
        }

        if (this.overrideDisplayGUIDispenserHooks != null) {
            this.overrideDisplayGUIDispenserHooks[this.overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(
                    var1);
        } else {
            this.player.localDisplayGUIDispenser(var1);
        }

        if (this.afterDisplayGUIDispenserHooks != null) {
            for (var2 = 0; var2 < this.afterDisplayGUIDispenserHooks.length; ++var2) {
                this.afterDisplayGUIDispenserHooks[var2].afterDisplayGUIDispenser(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIDispenser(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIDispenserHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIDispenserHooks.length; ++var2) {
                if (this.overrideDisplayGUIDispenserHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIDispenserHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIEditSign(IClientPlayerAPI var0, TileEntity var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isDisplayGUIEditSignModded) {
            var2.displayGUIEditSign(var1);
        } else {
            var0.localDisplayGUIEditSign(var1);
        }
    }

    private void displayGUIEditSign(TileEntity var1) {
        int var2;
        if (this.beforeDisplayGUIEditSignHooks != null) {
            for (var2 = this.beforeDisplayGUIEditSignHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIEditSignHooks[var2].beforeDisplayGUIEditSign(var1);
            }
        }

        if (this.overrideDisplayGUIEditSignHooks != null) {
            this.overrideDisplayGUIEditSignHooks[this.overrideDisplayGUIEditSignHooks.length - 1].displayGUIEditSign(
                    var1);
        } else {
            this.player.localDisplayGUIEditSign(var1);
        }

        if (this.afterDisplayGUIEditSignHooks != null) {
            for (var2 = 0; var2 < this.afterDisplayGUIEditSignHooks.length; ++var2) {
                this.afterDisplayGUIEditSignHooks[var2].afterDisplayGUIEditSign(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIEditSign(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIEditSignHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIEditSignHooks.length; ++var2) {
                if (this.overrideDisplayGUIEditSignHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIEditSignHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIEnchantment(IClientPlayerAPI var0, int var1, int var2, int var3, String var4) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
        if (var5 != null && var5.isDisplayGUIEnchantmentModded) {
            var5.displayGUIEnchantment(var1, var2, var3, var4);
        } else {
            var0.localDisplayGUIEnchantment(var1, var2, var3, var4);
        }
    }

    private void displayGUIEnchantment(int var1, int var2, int var3, String var4) {
        int var5;
        if (this.beforeDisplayGUIEnchantmentHooks != null) {
            for (var5 = this.beforeDisplayGUIEnchantmentHooks.length - 1; var5 >= 0; --var5) {
                this.beforeDisplayGUIEnchantmentHooks[var5].beforeDisplayGUIEnchantment(var1, var2, var3, var4);
            }
        }

        if (this.overrideDisplayGUIEnchantmentHooks != null) {
            this.overrideDisplayGUIEnchantmentHooks[this.overrideDisplayGUIEnchantmentHooks.length - 1]
                    .displayGUIEnchantment(var1, var2, var3, var4);
        } else {
            this.player.localDisplayGUIEnchantment(var1, var2, var3, var4);
        }

        if (this.afterDisplayGUIEnchantmentHooks != null) {
            for (var5 = 0; var5 < this.afterDisplayGUIEnchantmentHooks.length; ++var5) {
                this.afterDisplayGUIEnchantmentHooks[var5].afterDisplayGUIEnchantment(var1, var2, var3, var4);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIEnchantment(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIEnchantmentHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIEnchantmentHooks.length; ++var2) {
                if (this.overrideDisplayGUIEnchantmentHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIEnchantmentHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIFurnace(IClientPlayerAPI var0, TileEntityFurnace var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isDisplayGUIFurnaceModded) {
            var2.displayGUIFurnace(var1);
        } else {
            var0.localDisplayGUIFurnace(var1);
        }
    }

    private void displayGUIFurnace(TileEntityFurnace var1) {
        int var2;
        if (this.beforeDisplayGUIFurnaceHooks != null) {
            for (var2 = this.beforeDisplayGUIFurnaceHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIFurnaceHooks[var2].beforeDisplayGUIFurnace(var1);
            }
        }

        if (this.overrideDisplayGUIFurnaceHooks != null) {
            this.overrideDisplayGUIFurnaceHooks[this.overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(var1);
        } else {
            this.player.localDisplayGUIFurnace(var1);
        }

        if (this.afterDisplayGUIFurnaceHooks != null) {
            for (var2 = 0; var2 < this.afterDisplayGUIFurnaceHooks.length; ++var2) {
                this.afterDisplayGUIFurnaceHooks[var2].afterDisplayGUIFurnace(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIFurnace(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIFurnaceHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIFurnaceHooks.length; ++var2) {
                if (this.overrideDisplayGUIFurnaceHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIFurnaceHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void displayGUIWorkbench(IClientPlayerAPI var0, int var1, int var2, int var3) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
        if (var4 != null && var4.isDisplayGUIWorkbenchModded) {
            var4.displayGUIWorkbench(var1, var2, var3);
        } else {
            var0.localDisplayGUIWorkbench(var1, var2, var3);
        }
    }

    private void displayGUIWorkbench(int var1, int var2, int var3) {
        int var4;
        if (this.beforeDisplayGUIWorkbenchHooks != null) {
            for (var4 = this.beforeDisplayGUIWorkbenchHooks.length - 1; var4 >= 0; --var4) {
                this.beforeDisplayGUIWorkbenchHooks[var4].beforeDisplayGUIWorkbench(var1, var2, var3);
            }
        }

        if (this.overrideDisplayGUIWorkbenchHooks != null) {
            this.overrideDisplayGUIWorkbenchHooks[this.overrideDisplayGUIWorkbenchHooks.length - 1].displayGUIWorkbench(
                    var1, var2, var3);
        } else {
            this.player.localDisplayGUIWorkbench(var1, var2, var3);
        }

        if (this.afterDisplayGUIWorkbenchHooks != null) {
            for (var4 = 0; var4 < this.afterDisplayGUIWorkbenchHooks.length; ++var4) {
                this.afterDisplayGUIWorkbenchHooks[var4].afterDisplayGUIWorkbench(var1, var2, var3);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIWorkbench(ClientPlayerBase var1) {
        if (this.overrideDisplayGUIWorkbenchHooks != null) {
            for (int var2 = 0; var2 < this.overrideDisplayGUIWorkbenchHooks.length; ++var2) {
                if (this.overrideDisplayGUIWorkbenchHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDisplayGUIWorkbenchHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static EntityItem dropOneItem(IClientPlayerAPI var0, boolean var1) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
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
            for (int var2 = this.beforeDropOneItemHooks.length - 1; var2 >= 0; --var2) {
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
            for (ClientPlayerBase afterDropOneItemHook : this.afterDropOneItemHooks) {
                afterDropOneItemHook.afterDropOneItem(var1);
            }
        }

        return var4;
    }

    protected ClientPlayerBase GetOverwrittenDropOneItem(ClientPlayerBase var1) {
        if (this.overrideDropOneItemHooks != null) {
            for (int var2 = 0; var2 < this.overrideDropOneItemHooks.length; ++var2) {
                if (this.overrideDropOneItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDropOneItemHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static EntityItem dropPlayerItem(IClientPlayerAPI var0, ItemStack var1, boolean var2) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
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
            for (int var3 = this.beforeDropPlayerItemHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDropPlayerItemHooks[var3].beforeDropPlayerItem(var1, var2);
            }
        }

        EntityItem var5;
        if (this.overrideDropPlayerItemHooks != null) {
            var5 = this.overrideDropPlayerItemHooks[this.overrideDropPlayerItemHooks.length - 1].dropPlayerItem(
                    var1, var2);
        } else {
            var5 = this.player.localDropPlayerItem(var1, var2);
        }

        if (this.afterDropPlayerItemHooks != null) {
            for (ClientPlayerBase afterDropPlayerItemHook : this.afterDropPlayerItemHooks) {
                afterDropPlayerItemHook.afterDropPlayerItem(var1, var2);
            }
        }

        return var5;
    }

    protected ClientPlayerBase GetOverwrittenDropPlayerItem(ClientPlayerBase var1) {
        if (this.overrideDropPlayerItemHooks != null) {
            for (int var2 = 0; var2 < this.overrideDropPlayerItemHooks.length; ++var2) {
                if (this.overrideDropPlayerItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDropPlayerItemHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static EntityItem dropPlayerItemWithRandomChoice(
            IClientPlayerAPI var0, ItemStack var1, boolean var2, boolean var3) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
        EntityItem var4;
        if (var5 != null && var5.isDropPlayerItemWithRandomChoiceModded) {
            var4 = var5.dropPlayerItemWithRandomChoice(var1, var2, var3);
        } else {
            var4 = var0.localDropPlayerItemWithRandomChoice(var1, var2, var3);
        }

        return var4;
    }

    private EntityItem dropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3) {
        if (this.beforeDropPlayerItemWithRandomChoiceHooks != null) {
            for (int var4 = this.beforeDropPlayerItemWithRandomChoiceHooks.length - 1; var4 >= 0; --var4) {
                this.beforeDropPlayerItemWithRandomChoiceHooks[var4].beforeDropPlayerItemWithRandomChoice(
                        var1, var2, var3);
            }
        }

        EntityItem var6;
        if (this.overrideDropPlayerItemWithRandomChoiceHooks != null) {
            var6 = this
                    .overrideDropPlayerItemWithRandomChoiceHooks[
                    this.overrideDropPlayerItemWithRandomChoiceHooks.length - 1]
                    .dropPlayerItemWithRandomChoice(var1, var2, var3);
        } else {
            var6 = this.player.localDropPlayerItemWithRandomChoice(var1, var2, var3);
        }

        if (this.afterDropPlayerItemWithRandomChoiceHooks != null) {
            for (ClientPlayerBase afterDropPlayerItemWithRandomChoiceHook :
                    this.afterDropPlayerItemWithRandomChoiceHooks) {
                afterDropPlayerItemWithRandomChoiceHook.afterDropPlayerItemWithRandomChoice(var1, var2, var3);
            }
        }

        return var6;
    }

    protected ClientPlayerBase GetOverwrittenDropPlayerItemWithRandomChoice(ClientPlayerBase var1) {
        if (this.overrideDropPlayerItemWithRandomChoiceHooks != null) {
            for (int var2 = 0; var2 < this.overrideDropPlayerItemWithRandomChoiceHooks.length; ++var2) {
                if (this.overrideDropPlayerItemWithRandomChoiceHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideDropPlayerItemWithRandomChoiceHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void fall(IClientPlayerAPI var0, float var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isFallModded) {
            var2.fall(var1);
        } else {
            var0.localFall(var1);
        }
    }

    private void fall(float var1) {
        int var2;
        if (this.beforeFallHooks != null) {
            for (var2 = this.beforeFallHooks.length - 1; var2 >= 0; --var2) {
                this.beforeFallHooks[var2].beforeFall(var1);
            }
        }

        if (this.overrideFallHooks != null) {
            this.overrideFallHooks[this.overrideFallHooks.length - 1].fall(var1);
        } else {
            this.player.localFall(var1);
        }

        if (this.afterFallHooks != null) {
            for (var2 = 0; var2 < this.afterFallHooks.length; ++var2) {
                this.afterFallHooks[var2].afterFall(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenFall(ClientPlayerBase var1) {
        if (this.overrideFallHooks != null) {
            for (int var2 = 0; var2 < this.overrideFallHooks.length; ++var2) {
                if (this.overrideFallHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideFallHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getAIMoveSpeed(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeGetAIMoveSpeedHooks.length - 1; var1 >= 0; --var1) {
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
            for (ClientPlayerBase afterGetAIMoveSpeedHook : this.afterGetAIMoveSpeedHooks) {
                afterGetAIMoveSpeedHook.afterGetAIMoveSpeed();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenGetAIMoveSpeed(ClientPlayerBase var1) {
        if (this.overrideGetAIMoveSpeedHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetAIMoveSpeedHooks.length; ++var2) {
                if (this.overrideGetAIMoveSpeedHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetAIMoveSpeedHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getBedOrientationInDegrees(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        float var1;
        if (var2 != null && var2.isGetBedOrientationInDegreesModded) {
            var1 = var2.getBedOrientationInDegrees();
        } else {
            var1 = var0.localGetBedOrientationInDegrees();
        }

        return var1;
    }

    private float getBedOrientationInDegrees() {
        if (this.beforeGetBedOrientationInDegreesHooks != null) {
            for (int var1 = this.beforeGetBedOrientationInDegreesHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetBedOrientationInDegreesHooks[var1].beforeGetBedOrientationInDegrees();
            }
        }

        float var3;
        if (this.overrideGetBedOrientationInDegreesHooks != null) {
            var3 = this.overrideGetBedOrientationInDegreesHooks[this.overrideGetBedOrientationInDegreesHooks.length - 1]
                    .getBedOrientationInDegrees();
        } else {
            var3 = this.player.localGetBedOrientationInDegrees();
        }

        if (this.afterGetBedOrientationInDegreesHooks != null) {
            for (ClientPlayerBase afterGetBedOrientationInDegreesHook : this.afterGetBedOrientationInDegreesHooks) {
                afterGetBedOrientationInDegreesHook.afterGetBedOrientationInDegrees();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenGetBedOrientationInDegrees(ClientPlayerBase var1) {
        if (this.overrideGetBedOrientationInDegreesHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetBedOrientationInDegreesHooks.length; ++var2) {
                if (this.overrideGetBedOrientationInDegreesHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetBedOrientationInDegreesHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getBrightness(IClientPlayerAPI var0, float var1) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
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
            for (int var2 = this.beforeGetBrightnessHooks.length - 1; var2 >= 0; --var2) {
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
            for (ClientPlayerBase afterGetBrightnessHook : this.afterGetBrightnessHooks) {
                afterGetBrightnessHook.afterGetBrightness(var1);
            }
        }

        return var4;
    }

    protected ClientPlayerBase GetOverwrittenGetBrightness(ClientPlayerBase var1) {
        if (this.overrideGetBrightnessHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetBrightnessHooks.length; ++var2) {
                if (this.overrideGetBrightnessHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetBrightnessHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static int getBrightnessForRender(IClientPlayerAPI var0, float var1) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
        int var2;
        if (var3 != null && var3.isGetBrightnessForRenderModded) {
            var2 = var3.getBrightnessForRender(var1);
        } else {
            var2 = var0.localGetBrightnessForRender(var1);
        }

        return var2;
    }

    private int getBrightnessForRender(float var1) {
        int var2;
        if (this.beforeGetBrightnessForRenderHooks != null) {
            for (var2 = this.beforeGetBrightnessForRenderHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetBrightnessForRenderHooks[var2].beforeGetBrightnessForRender(var1);
            }
        }

        if (this.overrideGetBrightnessForRenderHooks != null) {
            var2 = this.overrideGetBrightnessForRenderHooks[this.overrideGetBrightnessForRenderHooks.length - 1]
                    .getBrightnessForRender(var1);
        } else {
            var2 = this.player.localGetBrightnessForRender(var1);
        }

        if (this.afterGetBrightnessForRenderHooks != null) {
            for (ClientPlayerBase afterGetBrightnessForRenderHook : this.afterGetBrightnessForRenderHooks) {
                afterGetBrightnessForRenderHook.afterGetBrightnessForRender(var1);
            }
        }

        return var2;
    }

    protected ClientPlayerBase GetOverwrittenGetBrightnessForRender(ClientPlayerBase var1) {
        if (this.overrideGetBrightnessForRenderHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetBrightnessForRenderHooks.length; ++var2) {
                if (this.overrideGetBrightnessForRenderHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetBrightnessForRenderHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getCurrentPlayerStrVsBlock(IClientPlayerAPI var0, Block var1, boolean var2) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
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
            for (int var3 = this.beforeGetCurrentPlayerStrVsBlockHooks.length - 1; var3 >= 0; --var3) {
                this.beforeGetCurrentPlayerStrVsBlockHooks[var3].beforeGetCurrentPlayerStrVsBlock(var1, var2);
            }
        }

        float var5;
        if (this.overrideGetCurrentPlayerStrVsBlockHooks != null) {
            var5 = this.overrideGetCurrentPlayerStrVsBlockHooks[this.overrideGetCurrentPlayerStrVsBlockHooks.length - 1]
                    .getCurrentPlayerStrVsBlock(var1, var2);
        } else {
            var5 = this.player.localGetCurrentPlayerStrVsBlock(var1, var2);
        }

        if (this.afterGetCurrentPlayerStrVsBlockHooks != null) {
            for (ClientPlayerBase afterGetCurrentPlayerStrVsBlockHook : this.afterGetCurrentPlayerStrVsBlockHooks) {
                afterGetCurrentPlayerStrVsBlockHook.afterGetCurrentPlayerStrVsBlock(var1, var2);
            }
        }

        return var5;
    }

    protected ClientPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(ClientPlayerBase var1) {
        if (this.overrideGetCurrentPlayerStrVsBlockHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockHooks.length; ++var2) {
                if (this.overrideGetCurrentPlayerStrVsBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetCurrentPlayerStrVsBlockHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getCurrentPlayerStrVsBlockForge(IClientPlayerAPI var0, Block var1, boolean var2, int var3) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
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
            for (int var4 = this.beforeGetCurrentPlayerStrVsBlockForgeHooks.length - 1; var4 >= 0; --var4) {
                this.beforeGetCurrentPlayerStrVsBlockForgeHooks[var4].beforeGetCurrentPlayerStrVsBlockForge(
                        var1, var2, var3);
            }
        }

        float var6;
        if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null) {
            var6 = this
                    .overrideGetCurrentPlayerStrVsBlockForgeHooks[
                    this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length - 1]
                    .getCurrentPlayerStrVsBlockForge(var1, var2, var3);
        } else {
            var6 = this.player.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
        }

        if (this.afterGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for (ClientPlayerBase afterGetCurrentPlayerStrVsBlockForgeHook :
                    this.afterGetCurrentPlayerStrVsBlockForgeHooks) {
                afterGetCurrentPlayerStrVsBlockForgeHook.afterGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
            }
        }

        return var6;
    }

    protected ClientPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlockForge(ClientPlayerBase var1) {
        if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length; ++var2) {
                if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetCurrentPlayerStrVsBlockForgeHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static double getDistanceSq(IClientPlayerAPI var0, double var1, double var3, double var5) {
        ClientPlayerAPI var9 = var0.getClientPlayerAPI();
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
            for (int var7 = this.beforeGetDistanceSqHooks.length - 1; var7 >= 0; --var7) {
                this.beforeGetDistanceSqHooks[var7].beforeGetDistanceSq(var1, var3, var5);
            }
        }

        double var10;
        if (this.overrideGetDistanceSqHooks != null) {
            var10 = this.overrideGetDistanceSqHooks[this.overrideGetDistanceSqHooks.length - 1].getDistanceSq(
                    var1, var3, var5);
        } else {
            var10 = this.player.localGetDistanceSq(var1, var3, var5);
        }

        if (this.afterGetDistanceSqHooks != null) {
            for (ClientPlayerBase afterGetDistanceSqHook : this.afterGetDistanceSqHooks) {
                afterGetDistanceSqHook.afterGetDistanceSq(var1, var3, var5);
            }
        }

        return var10;
    }

    protected ClientPlayerBase GetOverwrittenGetDistanceSq(ClientPlayerBase var1) {
        if (this.overrideGetDistanceSqHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetDistanceSqHooks.length; ++var2) {
                if (this.overrideGetDistanceSqHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetDistanceSqHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static double getDistanceSqToEntity(IClientPlayerAPI var0, Entity var1) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
        double var2;
        if (var4 != null && var4.isGetDistanceSqToEntityModded) {
            var2 = var4.getDistanceSqToEntity(var1);
        } else {
            var2 = var0.localGetDistanceSqToEntity(var1);
        }

        return var2;
    }

    private double getDistanceSqToEntity(Entity var1) {
        if (this.beforeGetDistanceSqToEntityHooks != null) {
            for (int var2 = this.beforeGetDistanceSqToEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetDistanceSqToEntityHooks[var2].beforeGetDistanceSqToEntity(var1);
            }
        }

        double var5;
        if (this.overrideGetDistanceSqToEntityHooks != null) {
            var5 = this.overrideGetDistanceSqToEntityHooks[this.overrideGetDistanceSqToEntityHooks.length - 1]
                    .getDistanceSqToEntity(var1);
        } else {
            var5 = this.player.localGetDistanceSqToEntity(var1);
        }

        if (this.afterGetDistanceSqToEntityHooks != null) {
            for (ClientPlayerBase afterGetDistanceSqToEntityHook : this.afterGetDistanceSqToEntityHooks) {
                afterGetDistanceSqToEntityHook.afterGetDistanceSqToEntity(var1);
            }
        }

        return var5;
    }

    protected ClientPlayerBase GetOverwrittenGetDistanceSqToEntity(ClientPlayerBase var1) {
        if (this.overrideGetDistanceSqToEntityHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetDistanceSqToEntityHooks.length; ++var2) {
                if (this.overrideGetDistanceSqToEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetDistanceSqToEntityHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static float getFOVMultiplier(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        float var1;
        if (var2 != null && var2.isGetFOVMultiplierModded) {
            var1 = var2.getFOVMultiplier();
        } else {
            var1 = var0.localGetFOVMultiplier();
        }

        return var1;
    }

    private float getFOVMultiplier() {
        if (this.beforeGetFOVMultiplierHooks != null) {
            for (int var1 = this.beforeGetFOVMultiplierHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetFOVMultiplierHooks[var1].beforeGetFOVMultiplier();
            }
        }

        float var3;
        if (this.overrideGetFOVMultiplierHooks != null) {
            var3 = this.overrideGetFOVMultiplierHooks[this.overrideGetFOVMultiplierHooks.length - 1].getFOVMultiplier();
        } else {
            var3 = this.player.localGetFOVMultiplier();
        }

        if (this.afterGetFOVMultiplierHooks != null) {
            for (ClientPlayerBase afterGetFOVMultiplierHook : this.afterGetFOVMultiplierHooks) {
                afterGetFOVMultiplierHook.afterGetFOVMultiplier();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenGetFOVMultiplier(ClientPlayerBase var1) {
        if (this.overrideGetFOVMultiplierHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetFOVMultiplierHooks.length; ++var2) {
                if (this.overrideGetFOVMultiplierHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetFOVMultiplierHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static String getHurtSound(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        String var1;
        if (var2 != null && var2.isGetHurtSoundModded) {
            var1 = var2.getHurtSound();
        } else {
            var1 = var0.localGetHurtSound();
        }

        return var1;
    }

    private String getHurtSound() {
        if (this.beforeGetHurtSoundHooks != null) {
            for (int var1 = this.beforeGetHurtSoundHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetHurtSoundHooks[var1].beforeGetHurtSound();
            }
        }

        String var3;
        if (this.overrideGetHurtSoundHooks != null) {
            var3 = this.overrideGetHurtSoundHooks[this.overrideGetHurtSoundHooks.length - 1].getHurtSound();
        } else {
            var3 = this.player.localGetHurtSound();
        }

        if (this.afterGetHurtSoundHooks != null) {
            for (ClientPlayerBase afterGetHurtSoundHook : this.afterGetHurtSoundHooks) {
                afterGetHurtSoundHook.afterGetHurtSound();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenGetHurtSound(ClientPlayerBase var1) {
        if (this.overrideGetHurtSoundHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetHurtSoundHooks.length; ++var2) {
                if (this.overrideGetHurtSoundHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetHurtSoundHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static IIcon getItemIcon(IClientPlayerAPI var0, ItemStack var1, int var2) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
        IIcon var3;
        if (var4 != null && var4.isGetItemIconModded) {
            var3 = var4.getItemIcon(var1, var2);
        } else {
            var3 = var0.localGetItemIcon(var1, var2);
        }

        return var3;
    }

    private IIcon getItemIcon(ItemStack var1, int var2) {
        if (this.beforeGetItemIconHooks != null) {
            for (int var3 = this.beforeGetItemIconHooks.length - 1; var3 >= 0; --var3) {
                this.beforeGetItemIconHooks[var3].beforeGetItemIcon(var1, var2);
            }
        }

        IIcon var5;
        if (this.overrideGetItemIconHooks != null) {
            var5 = this.overrideGetItemIconHooks[this.overrideGetItemIconHooks.length - 1].getItemIcon(var1, var2);
        } else {
            var5 = this.player.localGetItemIcon(var1, var2);
        }

        if (this.afterGetItemIconHooks != null) {
            for (ClientPlayerBase afterGetItemIconHook : this.afterGetItemIconHooks) {
                afterGetItemIconHook.afterGetItemIcon(var1, var2);
            }
        }

        return var5;
    }

    protected ClientPlayerBase GetOverwrittenGetItemIcon(ClientPlayerBase var1) {
        if (this.overrideGetItemIconHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetItemIconHooks.length; ++var2) {
                if (this.overrideGetItemIconHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetItemIconHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static int getSleepTimer(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        int var1;
        if (var2 != null && var2.isGetSleepTimerModded) {
            var1 = var2.getSleepTimer();
        } else {
            var1 = var0.localGetSleepTimer();
        }

        return var1;
    }

    private int getSleepTimer() {
        int var1;
        if (this.beforeGetSleepTimerHooks != null) {
            for (var1 = this.beforeGetSleepTimerHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetSleepTimerHooks[var1].beforeGetSleepTimer();
            }
        }

        if (this.overrideGetSleepTimerHooks != null) {
            var1 = this.overrideGetSleepTimerHooks[this.overrideGetSleepTimerHooks.length - 1].getSleepTimer();
        } else {
            var1 = this.player.localGetSleepTimer();
        }

        if (this.afterGetSleepTimerHooks != null) {
            for (ClientPlayerBase afterGetSleepTimerHook : this.afterGetSleepTimerHooks) {
                afterGetSleepTimerHook.afterGetSleepTimer();
            }
        }

        return var1;
    }

    protected ClientPlayerBase GetOverwrittenGetSleepTimer(ClientPlayerBase var1) {
        if (this.overrideGetSleepTimerHooks != null) {
            for (int var2 = 0; var2 < this.overrideGetSleepTimerHooks.length; ++var2) {
                if (this.overrideGetSleepTimerHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideGetSleepTimerHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean handleLavaMovement(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isHandleLavaMovementModded) {
            var1 = var2.handleLavaMovement();
        } else {
            var1 = var0.localHandleLavaMovement();
        }

        return var1;
    }

    private boolean handleLavaMovement() {
        if (this.beforeHandleLavaMovementHooks != null) {
            for (int var1 = this.beforeHandleLavaMovementHooks.length - 1; var1 >= 0; --var1) {
                this.beforeHandleLavaMovementHooks[var1].beforeHandleLavaMovement();
            }
        }

        boolean var3;
        if (this.overrideHandleLavaMovementHooks != null) {
            var3 =
                    this.overrideHandleLavaMovementHooks[this.overrideHandleLavaMovementHooks.length - 1]
                            .handleLavaMovement();
        } else {
            var3 = this.player.localHandleLavaMovement();
        }

        if (this.afterHandleLavaMovementHooks != null) {
            for (ClientPlayerBase afterHandleLavaMovementHook : this.afterHandleLavaMovementHooks) {
                afterHandleLavaMovementHook.afterHandleLavaMovement();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenHandleLavaMovement(ClientPlayerBase var1) {
        if (this.overrideHandleLavaMovementHooks != null) {
            for (int var2 = 0; var2 < this.overrideHandleLavaMovementHooks.length; ++var2) {
                if (this.overrideHandleLavaMovementHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideHandleLavaMovementHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean handleWaterMovement(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isHandleWaterMovementModded) {
            var1 = var2.handleWaterMovement();
        } else {
            var1 = var0.localHandleWaterMovement();
        }

        return var1;
    }

    private boolean handleWaterMovement() {
        if (this.beforeHandleWaterMovementHooks != null) {
            for (int var1 = this.beforeHandleWaterMovementHooks.length - 1; var1 >= 0; --var1) {
                this.beforeHandleWaterMovementHooks[var1].beforeHandleWaterMovement();
            }
        }

        boolean var3;
        if (this.overrideHandleWaterMovementHooks != null) {
            var3 =
                    this.overrideHandleWaterMovementHooks[this.overrideHandleWaterMovementHooks.length - 1]
                            .handleWaterMovement();
        } else {
            var3 = this.player.localHandleWaterMovement();
        }

        if (this.afterHandleWaterMovementHooks != null) {
            for (ClientPlayerBase afterHandleWaterMovementHook : this.afterHandleWaterMovementHooks) {
                afterHandleWaterMovementHook.afterHandleWaterMovement();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenHandleWaterMovement(ClientPlayerBase var1) {
        if (this.overrideHandleWaterMovementHooks != null) {
            for (int var2 = 0; var2 < this.overrideHandleWaterMovementHooks.length; ++var2) {
                if (this.overrideHandleWaterMovementHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideHandleWaterMovementHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void heal(IClientPlayerAPI var0, float var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isHealModded) {
            var2.heal(var1);
        } else {
            var0.localHeal(var1);
        }
    }

    private void heal(float var1) {
        int var2;
        if (this.beforeHealHooks != null) {
            for (var2 = this.beforeHealHooks.length - 1; var2 >= 0; --var2) {
                this.beforeHealHooks[var2].beforeHeal(var1);
            }
        }

        if (this.overrideHealHooks != null) {
            this.overrideHealHooks[this.overrideHealHooks.length - 1].heal(var1);
        } else {
            this.player.localHeal(var1);
        }

        if (this.afterHealHooks != null) {
            for (var2 = 0; var2 < this.afterHealHooks.length; ++var2) {
                this.afterHealHooks[var2].afterHeal(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenHeal(ClientPlayerBase var1) {
        if (this.overrideHealHooks != null) {
            for (int var2 = 0; var2 < this.overrideHealHooks.length; ++var2) {
                if (this.overrideHealHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideHealHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isEntityInsideOpaqueBlock(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeIsEntityInsideOpaqueBlockHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsEntityInsideOpaqueBlockHooks[var1].beforeIsEntityInsideOpaqueBlock();
            }
        }

        boolean var3;
        if (this.overrideIsEntityInsideOpaqueBlockHooks != null) {
            var3 = this.overrideIsEntityInsideOpaqueBlockHooks[this.overrideIsEntityInsideOpaqueBlockHooks.length - 1]
                    .isEntityInsideOpaqueBlock();
        } else {
            var3 = this.player.localIsEntityInsideOpaqueBlock();
        }

        if (this.afterIsEntityInsideOpaqueBlockHooks != null) {
            for (ClientPlayerBase afterIsEntityInsideOpaqueBlockHook : this.afterIsEntityInsideOpaqueBlockHooks) {
                afterIsEntityInsideOpaqueBlockHook.afterIsEntityInsideOpaqueBlock();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(ClientPlayerBase var1) {
        if (this.overrideIsEntityInsideOpaqueBlockHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsEntityInsideOpaqueBlockHooks.length; ++var2) {
                if (this.overrideIsEntityInsideOpaqueBlockHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsEntityInsideOpaqueBlockHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isInWater(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeIsInWaterHooks.length - 1; var1 >= 0; --var1) {
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
            for (ClientPlayerBase afterIsInWaterHook : this.afterIsInWaterHooks) {
                afterIsInWaterHook.afterIsInWater();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsInWater(ClientPlayerBase var1) {
        if (this.overrideIsInWaterHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsInWaterHooks.length; ++var2) {
                if (this.overrideIsInWaterHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsInWaterHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isInsideOfMaterial(IClientPlayerAPI var0, Material var1) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
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
            for (int var2 = this.beforeIsInsideOfMaterialHooks.length - 1; var2 >= 0; --var2) {
                this.beforeIsInsideOfMaterialHooks[var2].beforeIsInsideOfMaterial(var1);
            }
        }

        boolean var4;
        if (this.overrideIsInsideOfMaterialHooks != null) {
            var4 =
                    this.overrideIsInsideOfMaterialHooks[this.overrideIsInsideOfMaterialHooks.length - 1]
                            .isInsideOfMaterial(var1);
        } else {
            var4 = this.player.localIsInsideOfMaterial(var1);
        }

        if (this.afterIsInsideOfMaterialHooks != null) {
            for (ClientPlayerBase afterIsInsideOfMaterialHook : this.afterIsInsideOfMaterialHooks) {
                afterIsInsideOfMaterialHook.afterIsInsideOfMaterial(var1);
            }
        }

        return var4;
    }

    protected ClientPlayerBase GetOverwrittenIsInsideOfMaterial(ClientPlayerBase var1) {
        if (this.overrideIsInsideOfMaterialHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsInsideOfMaterialHooks.length; ++var2) {
                if (this.overrideIsInsideOfMaterialHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsInsideOfMaterialHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isOnLadder(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeIsOnLadderHooks.length - 1; var1 >= 0; --var1) {
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
            for (ClientPlayerBase afterIsOnLadderHook : this.afterIsOnLadderHooks) {
                afterIsOnLadderHook.afterIsOnLadder();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsOnLadder(ClientPlayerBase var1) {
        if (this.overrideIsOnLadderHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsOnLadderHooks.length; ++var2) {
                if (this.overrideIsOnLadderHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsOnLadderHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isPlayerSleeping(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeIsPlayerSleepingHooks.length - 1; var1 >= 0; --var1) {
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
            for (ClientPlayerBase afterIsPlayerSleepingHook : this.afterIsPlayerSleepingHooks) {
                afterIsPlayerSleepingHook.afterIsPlayerSleeping();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsPlayerSleeping(ClientPlayerBase var1) {
        if (this.overrideIsPlayerSleepingHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsPlayerSleepingHooks.length; ++var2) {
                if (this.overrideIsPlayerSleepingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsPlayerSleepingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isSneaking(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
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
            for (int var1 = this.beforeIsSneakingHooks.length - 1; var1 >= 0; --var1) {
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
            for (ClientPlayerBase afterIsSneakingHook : this.afterIsSneakingHooks) {
                afterIsSneakingHook.afterIsSneaking();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsSneaking(ClientPlayerBase var1) {
        if (this.overrideIsSneakingHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsSneakingHooks.length; ++var2) {
                if (this.overrideIsSneakingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsSneakingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean isSprinting(IClientPlayerAPI var0) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        boolean var1;
        if (var2 != null && var2.isIsSprintingModded) {
            var1 = var2.isSprinting();
        } else {
            var1 = var0.localIsSprinting();
        }

        return var1;
    }

    private boolean isSprinting() {
        if (this.beforeIsSprintingHooks != null) {
            for (int var1 = this.beforeIsSprintingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsSprintingHooks[var1].beforeIsSprinting();
            }
        }

        boolean var3;
        if (this.overrideIsSprintingHooks != null) {
            var3 = this.overrideIsSprintingHooks[this.overrideIsSprintingHooks.length - 1].isSprinting();
        } else {
            var3 = this.player.localIsSprinting();
        }

        if (this.afterIsSprintingHooks != null) {
            for (ClientPlayerBase afterIsSprintingHook : this.afterIsSprintingHooks) {
                afterIsSprintingHook.afterIsSprinting();
            }
        }

        return var3;
    }

    protected ClientPlayerBase GetOverwrittenIsSprinting(ClientPlayerBase var1) {
        if (this.overrideIsSprintingHooks != null) {
            for (int var2 = 0; var2 < this.overrideIsSprintingHooks.length; ++var2) {
                if (this.overrideIsSprintingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideIsSprintingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void jump(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isJumpModded) {
            var1.jump();
        } else {
            var0.localJump();
        }
    }

    private void jump() {
        int var1;
        if (this.beforeJumpHooks != null) {
            for (var1 = this.beforeJumpHooks.length - 1; var1 >= 0; --var1) {
                this.beforeJumpHooks[var1].beforeJump();
            }
        }

        if (this.overrideJumpHooks != null) {
            this.overrideJumpHooks[this.overrideJumpHooks.length - 1].jump();
        } else {
            this.player.localJump();
        }

        if (this.afterJumpHooks != null) {
            for (var1 = 0; var1 < this.afterJumpHooks.length; ++var1) {
                this.afterJumpHooks[var1].afterJump();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenJump(ClientPlayerBase var1) {
        if (this.overrideJumpHooks != null) {
            for (int var2 = 0; var2 < this.overrideJumpHooks.length; ++var2) {
                if (this.overrideJumpHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideJumpHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void knockBack(IClientPlayerAPI var0, Entity var1, float var2, double var3, double var5) {
        ClientPlayerAPI var7 = var0.getClientPlayerAPI();
        if (var7 != null && var7.isKnockBackModded) {
            var7.knockBack(var1, var2, var3, var5);
        } else {
            var0.localKnockBack(var1, var2, var3, var5);
        }
    }

    private void knockBack(Entity var1, float var2, double var3, double var5) {
        int var7;
        if (this.beforeKnockBackHooks != null) {
            for (var7 = this.beforeKnockBackHooks.length - 1; var7 >= 0; --var7) {
                this.beforeKnockBackHooks[var7].beforeKnockBack(var1, var2, var3, var5);
            }
        }

        if (this.overrideKnockBackHooks != null) {
            this.overrideKnockBackHooks[this.overrideKnockBackHooks.length - 1].knockBack(var1, var2, var3, var5);
        } else {
            this.player.localKnockBack(var1, var2, var3, var5);
        }

        if (this.afterKnockBackHooks != null) {
            for (var7 = 0; var7 < this.afterKnockBackHooks.length; ++var7) {
                this.afterKnockBackHooks[var7].afterKnockBack(var1, var2, var3, var5);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenKnockBack(ClientPlayerBase var1) {
        if (this.overrideKnockBackHooks != null) {
            for (int var2 = 0; var2 < this.overrideKnockBackHooks.length; ++var2) {
                if (this.overrideKnockBackHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideKnockBackHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void moveEntity(IClientPlayerAPI var0, double var1, double var3, double var5) {
        ClientPlayerAPI var7 = var0.getClientPlayerAPI();
        if (var7 != null && var7.isMoveEntityModded) {
            var7.moveEntity(var1, var3, var5);
        } else {
            var0.localMoveEntity(var1, var3, var5);
        }
    }

    private void moveEntity(double var1, double var3, double var5) {
        int var7;
        if (this.beforeMoveEntityHooks != null) {
            for (var7 = this.beforeMoveEntityHooks.length - 1; var7 >= 0; --var7) {
                this.beforeMoveEntityHooks[var7].beforeMoveEntity(var1, var3, var5);
            }
        }

        if (this.overrideMoveEntityHooks != null) {
            this.overrideMoveEntityHooks[this.overrideMoveEntityHooks.length - 1].moveEntity(var1, var3, var5);
        } else {
            this.player.localMoveEntity(var1, var3, var5);
        }

        if (this.afterMoveEntityHooks != null) {
            for (var7 = 0; var7 < this.afterMoveEntityHooks.length; ++var7) {
                this.afterMoveEntityHooks[var7].afterMoveEntity(var1, var3, var5);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenMoveEntity(ClientPlayerBase var1) {
        if (this.overrideMoveEntityHooks != null) {
            for (int var2 = 0; var2 < this.overrideMoveEntityHooks.length; ++var2) {
                if (this.overrideMoveEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveEntityHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void moveEntityWithHeading(IClientPlayerAPI var0, float var1, float var2) {
        ClientPlayerAPI var3 = var0.getClientPlayerAPI();
        if (var3 != null && var3.isMoveEntityWithHeadingModded) {
            var3.moveEntityWithHeading(var1, var2);
        } else {
            var0.localMoveEntityWithHeading(var1, var2);
        }
    }

    private void moveEntityWithHeading(float var1, float var2) {
        int var3;
        if (this.beforeMoveEntityWithHeadingHooks != null) {
            for (var3 = this.beforeMoveEntityWithHeadingHooks.length - 1; var3 >= 0; --var3) {
                this.beforeMoveEntityWithHeadingHooks[var3].beforeMoveEntityWithHeading(var1, var2);
            }
        }

        if (this.overrideMoveEntityWithHeadingHooks != null) {
            this.overrideMoveEntityWithHeadingHooks[this.overrideMoveEntityWithHeadingHooks.length - 1]
                    .moveEntityWithHeading(var1, var2);
        } else {
            this.player.localMoveEntityWithHeading(var1, var2);
        }

        if (this.afterMoveEntityWithHeadingHooks != null) {
            for (var3 = 0; var3 < this.afterMoveEntityWithHeadingHooks.length; ++var3) {
                this.afterMoveEntityWithHeadingHooks[var3].afterMoveEntityWithHeading(var1, var2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenMoveEntityWithHeading(ClientPlayerBase var1) {
        if (this.overrideMoveEntityWithHeadingHooks != null) {
            for (int var2 = 0; var2 < this.overrideMoveEntityWithHeadingHooks.length; ++var2) {
                if (this.overrideMoveEntityWithHeadingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveEntityWithHeadingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void moveFlying(IClientPlayerAPI var0, float var1, float var2, float var3) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
        if (var4 != null && var4.isMoveFlyingModded) {
            var4.moveFlying(var1, var2, var3);
        } else {
            var0.localMoveFlying(var1, var2, var3);
        }
    }

    private void moveFlying(float var1, float var2, float var3) {
        int var4;
        if (this.beforeMoveFlyingHooks != null) {
            for (var4 = this.beforeMoveFlyingHooks.length - 1; var4 >= 0; --var4) {
                this.beforeMoveFlyingHooks[var4].beforeMoveFlying(var1, var2, var3);
            }
        }

        if (this.overrideMoveFlyingHooks != null) {
            this.overrideMoveFlyingHooks[this.overrideMoveFlyingHooks.length - 1].moveFlying(var1, var2, var3);
        } else {
            this.player.localMoveFlying(var1, var2, var3);
        }

        if (this.afterMoveFlyingHooks != null) {
            for (var4 = 0; var4 < this.afterMoveFlyingHooks.length; ++var4) {
                this.afterMoveFlyingHooks[var4].afterMoveFlying(var1, var2, var3);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenMoveFlying(ClientPlayerBase var1) {
        if (this.overrideMoveFlyingHooks != null) {
            for (int var2 = 0; var2 < this.overrideMoveFlyingHooks.length; ++var2) {
                if (this.overrideMoveFlyingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideMoveFlyingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void onDeath(IClientPlayerAPI var0, DamageSource var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isOnDeathModded) {
            var2.onDeath(var1);
        } else {
            var0.localOnDeath(var1);
        }
    }

    private void onDeath(DamageSource var1) {
        int var2;
        if (this.beforeOnDeathHooks != null) {
            for (var2 = this.beforeOnDeathHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnDeathHooks[var2].beforeOnDeath(var1);
            }
        }

        if (this.overrideOnDeathHooks != null) {
            this.overrideOnDeathHooks[this.overrideOnDeathHooks.length - 1].onDeath(var1);
        } else {
            this.player.localOnDeath(var1);
        }

        if (this.afterOnDeathHooks != null) {
            for (var2 = 0; var2 < this.afterOnDeathHooks.length; ++var2) {
                this.afterOnDeathHooks[var2].afterOnDeath(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenOnDeath(ClientPlayerBase var1) {
        if (this.overrideOnDeathHooks != null) {
            for (int var2 = 0; var2 < this.overrideOnDeathHooks.length; ++var2) {
                if (this.overrideOnDeathHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnDeathHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void onLivingUpdate(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isOnLivingUpdateModded) {
            var1.onLivingUpdate();
        } else {
            var0.localOnLivingUpdate();
        }
    }

    private void onLivingUpdate() {
        int var1;
        if (this.beforeOnLivingUpdateHooks != null) {
            for (var1 = this.beforeOnLivingUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnLivingUpdateHooks[var1].beforeOnLivingUpdate();
            }
        }

        if (this.overrideOnLivingUpdateHooks != null) {
            this.overrideOnLivingUpdateHooks[this.overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
        } else {
            this.player.localOnLivingUpdate();
        }

        if (this.afterOnLivingUpdateHooks != null) {
            for (var1 = 0; var1 < this.afterOnLivingUpdateHooks.length; ++var1) {
                this.afterOnLivingUpdateHooks[var1].afterOnLivingUpdate();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenOnLivingUpdate(ClientPlayerBase var1) {
        if (this.overrideOnLivingUpdateHooks != null) {
            for (int var2 = 0; var2 < this.overrideOnLivingUpdateHooks.length; ++var2) {
                if (this.overrideOnLivingUpdateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnLivingUpdateHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void onKillEntity(IClientPlayerAPI var0, EntityLivingBase var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isOnKillEntityModded) {
            var2.onKillEntity(var1);
        } else {
            var0.localOnKillEntity(var1);
        }
    }

    private void onKillEntity(EntityLivingBase var1) {
        int var2;
        if (this.beforeOnKillEntityHooks != null) {
            for (var2 = this.beforeOnKillEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnKillEntityHooks[var2].beforeOnKillEntity(var1);
            }
        }

        if (this.overrideOnKillEntityHooks != null) {
            this.overrideOnKillEntityHooks[this.overrideOnKillEntityHooks.length - 1].onKillEntity(var1);
        } else {
            this.player.localOnKillEntity(var1);
        }

        if (this.afterOnKillEntityHooks != null) {
            for (var2 = 0; var2 < this.afterOnKillEntityHooks.length; ++var2) {
                this.afterOnKillEntityHooks[var2].afterOnKillEntity(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenOnKillEntity(ClientPlayerBase var1) {
        if (this.overrideOnKillEntityHooks != null) {
            for (int var2 = 0; var2 < this.overrideOnKillEntityHooks.length; ++var2) {
                if (this.overrideOnKillEntityHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnKillEntityHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void onStruckByLightning(IClientPlayerAPI var0, EntityLightningBolt var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isOnStruckByLightningModded) {
            var2.onStruckByLightning(var1);
        } else {
            var0.localOnStruckByLightning(var1);
        }
    }

    private void onStruckByLightning(EntityLightningBolt var1) {
        int var2;
        if (this.beforeOnStruckByLightningHooks != null) {
            for (var2 = this.beforeOnStruckByLightningHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnStruckByLightningHooks[var2].beforeOnStruckByLightning(var1);
            }
        }

        if (this.overrideOnStruckByLightningHooks != null) {
            this.overrideOnStruckByLightningHooks[this.overrideOnStruckByLightningHooks.length - 1].onStruckByLightning(
                    var1);
        } else {
            this.player.localOnStruckByLightning(var1);
        }

        if (this.afterOnStruckByLightningHooks != null) {
            for (var2 = 0; var2 < this.afterOnStruckByLightningHooks.length; ++var2) {
                this.afterOnStruckByLightningHooks[var2].afterOnStruckByLightning(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenOnStruckByLightning(ClientPlayerBase var1) {
        if (this.overrideOnStruckByLightningHooks != null) {
            for (int var2 = 0; var2 < this.overrideOnStruckByLightningHooks.length; ++var2) {
                if (this.overrideOnStruckByLightningHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnStruckByLightningHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void onUpdate(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isOnUpdateModded) {
            var1.onUpdate();
        } else {
            var0.localOnUpdate();
        }
    }

    private void onUpdate() {
        int var1;
        if (this.beforeOnUpdateHooks != null) {
            for (var1 = this.beforeOnUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnUpdateHooks[var1].beforeOnUpdate();
            }
        }

        if (this.overrideOnUpdateHooks != null) {
            this.overrideOnUpdateHooks[this.overrideOnUpdateHooks.length - 1].onUpdate();
        } else {
            this.player.localOnUpdate();
        }

        if (this.afterOnUpdateHooks != null) {
            for (var1 = 0; var1 < this.afterOnUpdateHooks.length; ++var1) {
                this.afterOnUpdateHooks[var1].afterOnUpdate();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenOnUpdate(ClientPlayerBase var1) {
        if (this.overrideOnUpdateHooks != null) {
            for (int var2 = 0; var2 < this.overrideOnUpdateHooks.length; ++var2) {
                if (this.overrideOnUpdateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideOnUpdateHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void playStepSound(IClientPlayerAPI var0, int var1, int var2, int var3, Block var4) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
        if (var5 != null && var5.isPlayStepSoundModded) {
            var5.playStepSound(var1, var2, var3, var4);
        } else {
            var0.localPlayStepSound(var1, var2, var3, var4);
        }
    }

    private void playStepSound(int var1, int var2, int var3, Block var4) {
        int var5;
        if (this.beforePlayStepSoundHooks != null) {
            for (var5 = this.beforePlayStepSoundHooks.length - 1; var5 >= 0; --var5) {
                this.beforePlayStepSoundHooks[var5].beforePlayStepSound(var1, var2, var3, var4);
            }
        }

        if (this.overridePlayStepSoundHooks != null) {
            this.overridePlayStepSoundHooks[this.overridePlayStepSoundHooks.length - 1].playStepSound(
                    var1, var2, var3, var4);
        } else {
            this.player.localPlayStepSound(var1, var2, var3, var4);
        }

        if (this.afterPlayStepSoundHooks != null) {
            for (var5 = 0; var5 < this.afterPlayStepSoundHooks.length; ++var5) {
                this.afterPlayStepSoundHooks[var5].afterPlayStepSound(var1, var2, var3, var4);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenPlayStepSound(ClientPlayerBase var1) {
        if (this.overridePlayStepSoundHooks != null) {
            for (int var2 = 0; var2 < this.overridePlayStepSoundHooks.length; ++var2) {
                if (this.overridePlayStepSoundHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overridePlayStepSoundHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static boolean pushOutOfBlocks(IClientPlayerAPI var0, double var1, double var3, double var5) {
        ClientPlayerAPI var8 = var0.getClientPlayerAPI();
        boolean var7;
        if (var8 != null && var8.isPushOutOfBlocksModded) {
            var7 = var8.pushOutOfBlocks(var1, var3, var5);
        } else {
            var7 = var0.localPushOutOfBlocks(var1, var3, var5);
        }

        return var7;
    }

    private boolean pushOutOfBlocks(double var1, double var3, double var5) {
        if (this.beforePushOutOfBlocksHooks != null) {
            for (int var7 = this.beforePushOutOfBlocksHooks.length - 1; var7 >= 0; --var7) {
                this.beforePushOutOfBlocksHooks[var7].beforePushOutOfBlocks(var1, var3, var5);
            }
        }

        boolean var9;
        if (this.overridePushOutOfBlocksHooks != null) {
            var9 = this.overridePushOutOfBlocksHooks[this.overridePushOutOfBlocksHooks.length - 1].pushOutOfBlocks(
                    var1, var3, var5);
        } else {
            var9 = this.player.localPushOutOfBlocks(var1, var3, var5);
        }

        if (this.afterPushOutOfBlocksHooks != null) {
            for (ClientPlayerBase afterPushOutOfBlocksHook : this.afterPushOutOfBlocksHooks) {
                afterPushOutOfBlocksHook.afterPushOutOfBlocks(var1, var3, var5);
            }
        }

        return var9;
    }

    protected ClientPlayerBase GetOverwrittenPushOutOfBlocks(ClientPlayerBase var1) {
        if (this.overridePushOutOfBlocksHooks != null) {
            for (int var2 = 0; var2 < this.overridePushOutOfBlocksHooks.length; ++var2) {
                if (this.overridePushOutOfBlocksHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overridePushOutOfBlocksHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static MovingObjectPosition rayTrace(IClientPlayerAPI var0, double var1, float var3) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
        MovingObjectPosition var4;
        if (var5 != null && var5.isRayTraceModded) {
            var4 = var5.rayTrace(var1, var3);
        } else {
            var4 = var0.localRayTrace(var1, var3);
        }

        return var4;
    }

    private MovingObjectPosition rayTrace(double var1, float var3) {
        if (this.beforeRayTraceHooks != null) {
            for (int var4 = this.beforeRayTraceHooks.length - 1; var4 >= 0; --var4) {
                this.beforeRayTraceHooks[var4].beforeRayTrace(var1, var3);
            }
        }

        MovingObjectPosition var6;
        if (this.overrideRayTraceHooks != null) {
            var6 = this.overrideRayTraceHooks[this.overrideRayTraceHooks.length - 1].rayTrace(var1, var3);
        } else {
            var6 = this.player.localRayTrace(var1, var3);
        }

        if (this.afterRayTraceHooks != null) {
            for (ClientPlayerBase afterRayTraceHook : this.afterRayTraceHooks) {
                afterRayTraceHook.afterRayTrace(var1, var3);
            }
        }

        return var6;
    }

    protected ClientPlayerBase GetOverwrittenRayTrace(ClientPlayerBase var1) {
        if (this.overrideRayTraceHooks != null) {
            for (int var2 = 0; var2 < this.overrideRayTraceHooks.length; ++var2) {
                if (this.overrideRayTraceHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideRayTraceHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void readEntityFromNBT(IClientPlayerAPI var0, NBTTagCompound var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isReadEntityFromNBTModded) {
            var2.readEntityFromNBT(var1);
        } else {
            var0.localReadEntityFromNBT(var1);
        }
    }

    private void readEntityFromNBT(NBTTagCompound var1) {
        int var2;
        if (this.beforeReadEntityFromNBTHooks != null) {
            for (var2 = this.beforeReadEntityFromNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeReadEntityFromNBTHooks[var2].beforeReadEntityFromNBT(var1);
            }
        }

        if (this.overrideReadEntityFromNBTHooks != null) {
            this.overrideReadEntityFromNBTHooks[this.overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(var1);
        } else {
            this.player.localReadEntityFromNBT(var1);
        }

        if (this.afterReadEntityFromNBTHooks != null) {
            for (var2 = 0; var2 < this.afterReadEntityFromNBTHooks.length; ++var2) {
                this.afterReadEntityFromNBTHooks[var2].afterReadEntityFromNBT(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenReadEntityFromNBT(ClientPlayerBase var1) {
        if (this.overrideReadEntityFromNBTHooks != null) {
            for (int var2 = 0; var2 < this.overrideReadEntityFromNBTHooks.length; ++var2) {
                if (this.overrideReadEntityFromNBTHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideReadEntityFromNBTHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void respawnPlayer(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isRespawnPlayerModded) {
            var1.respawnPlayer();
        } else {
            var0.localRespawnPlayer();
        }
    }

    private void respawnPlayer() {
        int var1;
        if (this.beforeRespawnPlayerHooks != null) {
            for (var1 = this.beforeRespawnPlayerHooks.length - 1; var1 >= 0; --var1) {
                this.beforeRespawnPlayerHooks[var1].beforeRespawnPlayer();
            }
        }

        if (this.overrideRespawnPlayerHooks != null) {
            this.overrideRespawnPlayerHooks[this.overrideRespawnPlayerHooks.length - 1].respawnPlayer();
        } else {
            this.player.localRespawnPlayer();
        }

        if (this.afterRespawnPlayerHooks != null) {
            for (var1 = 0; var1 < this.afterRespawnPlayerHooks.length; ++var1) {
                this.afterRespawnPlayerHooks[var1].afterRespawnPlayer();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenRespawnPlayer(ClientPlayerBase var1) {
        if (this.overrideRespawnPlayerHooks != null) {
            for (int var2 = 0; var2 < this.overrideRespawnPlayerHooks.length; ++var2) {
                if (this.overrideRespawnPlayerHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideRespawnPlayerHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void setDead(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isSetDeadModded) {
            var1.setDead();
        } else {
            var0.localSetDead();
        }
    }

    private void setDead() {
        int var1;
        if (this.beforeSetDeadHooks != null) {
            for (var1 = this.beforeSetDeadHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSetDeadHooks[var1].beforeSetDead();
            }
        }

        if (this.overrideSetDeadHooks != null) {
            this.overrideSetDeadHooks[this.overrideSetDeadHooks.length - 1].setDead();
        } else {
            this.player.localSetDead();
        }

        if (this.afterSetDeadHooks != null) {
            for (var1 = 0; var1 < this.afterSetDeadHooks.length; ++var1) {
                this.afterSetDeadHooks[var1].afterSetDead();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetDead(ClientPlayerBase var1) {
        if (this.overrideSetDeadHooks != null) {
            for (int var2 = 0; var2 < this.overrideSetDeadHooks.length; ++var2) {
                if (this.overrideSetDeadHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetDeadHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void setPlayerSPHealth(IClientPlayerAPI var0, float var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isSetPlayerSPHealthModded) {
            var2.setPlayerSPHealth(var1);
        } else {
            var0.localSetPlayerSPHealth(var1);
        }
    }

    private void setPlayerSPHealth(float var1) {
        int var2;
        if (this.beforeSetPlayerSPHealthHooks != null) {
            for (var2 = this.beforeSetPlayerSPHealthHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetPlayerSPHealthHooks[var2].beforeSetPlayerSPHealth(var1);
            }
        }

        if (this.overrideSetPlayerSPHealthHooks != null) {
            this.overrideSetPlayerSPHealthHooks[this.overrideSetPlayerSPHealthHooks.length - 1].setPlayerSPHealth(var1);
        } else {
            this.player.localSetPlayerSPHealth(var1);
        }

        if (this.afterSetPlayerSPHealthHooks != null) {
            for (var2 = 0; var2 < this.afterSetPlayerSPHealthHooks.length; ++var2) {
                this.afterSetPlayerSPHealthHooks[var2].afterSetPlayerSPHealth(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetPlayerSPHealth(ClientPlayerBase var1) {
        if (this.overrideSetPlayerSPHealthHooks != null) {
            for (int var2 = 0; var2 < this.overrideSetPlayerSPHealthHooks.length; ++var2) {
                if (this.overrideSetPlayerSPHealthHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetPlayerSPHealthHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void setPositionAndRotation(
            IClientPlayerAPI var0, double var1, double var3, double var5, float var7, float var8) {
        ClientPlayerAPI var9 = var0.getClientPlayerAPI();
        if (var9 != null && var9.isSetPositionAndRotationModded) {
            var9.setPositionAndRotation(var1, var3, var5, var7, var8);
        } else {
            var0.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        }
    }

    private void setPositionAndRotation(double var1, double var3, double var5, float var7, float var8) {
        int var9;
        if (this.beforeSetPositionAndRotationHooks != null) {
            for (var9 = this.beforeSetPositionAndRotationHooks.length - 1; var9 >= 0; --var9) {
                this.beforeSetPositionAndRotationHooks[var9].beforeSetPositionAndRotation(var1, var3, var5, var7, var8);
            }
        }

        if (this.overrideSetPositionAndRotationHooks != null) {
            this.overrideSetPositionAndRotationHooks[this.overrideSetPositionAndRotationHooks.length - 1]
                    .setPositionAndRotation(var1, var3, var5, var7, var8);
        } else {
            this.player.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        }

        if (this.afterSetPositionAndRotationHooks != null) {
            for (var9 = 0; var9 < this.afterSetPositionAndRotationHooks.length; ++var9) {
                this.afterSetPositionAndRotationHooks[var9].afterSetPositionAndRotation(var1, var3, var5, var7, var8);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetPositionAndRotation(ClientPlayerBase var1) {
        if (this.overrideSetPositionAndRotationHooks != null) {
            for (int var2 = 0; var2 < this.overrideSetPositionAndRotationHooks.length; ++var2) {
                if (this.overrideSetPositionAndRotationHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetPositionAndRotationHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void setSneaking(IClientPlayerAPI var0, boolean var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isSetSneakingModded) {
            var2.setSneaking(var1);
        } else {
            var0.localSetSneaking(var1);
        }
    }

    private void setSneaking(boolean var1) {
        int var2;
        if (this.beforeSetSneakingHooks != null) {
            for (var2 = this.beforeSetSneakingHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetSneakingHooks[var2].beforeSetSneaking(var1);
            }
        }

        if (this.overrideSetSneakingHooks != null) {
            this.overrideSetSneakingHooks[this.overrideSetSneakingHooks.length - 1].setSneaking(var1);
        } else {
            this.player.localSetSneaking(var1);
        }

        if (this.afterSetSneakingHooks != null) {
            for (var2 = 0; var2 < this.afterSetSneakingHooks.length; ++var2) {
                this.afterSetSneakingHooks[var2].afterSetSneaking(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetSneaking(ClientPlayerBase var1) {
        if (this.overrideSetSneakingHooks != null) {
            for (int var2 = 0; var2 < this.overrideSetSneakingHooks.length; ++var2) {
                if (this.overrideSetSneakingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetSneakingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void setSprinting(IClientPlayerAPI var0, boolean var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isSetSprintingModded) {
            var2.setSprinting(var1);
        } else {
            var0.localSetSprinting(var1);
        }
    }

    private void setSprinting(boolean var1) {
        int var2;
        if (this.beforeSetSprintingHooks != null) {
            for (var2 = this.beforeSetSprintingHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetSprintingHooks[var2].beforeSetSprinting(var1);
            }
        }

        if (this.overrideSetSprintingHooks != null) {
            this.overrideSetSprintingHooks[this.overrideSetSprintingHooks.length - 1].setSprinting(var1);
        } else {
            this.player.localSetSprinting(var1);
        }

        if (this.afterSetSprintingHooks != null) {
            for (var2 = 0; var2 < this.afterSetSprintingHooks.length; ++var2) {
                this.afterSetSprintingHooks[var2].afterSetSprinting(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetSprinting(ClientPlayerBase var1) {
        if (this.overrideSetSprintingHooks != null) {
            for (int var2 = 0; var2 < this.overrideSetSprintingHooks.length; ++var2) {
                if (this.overrideSetSprintingHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSetSprintingHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static EnumStatus sleepInBedAt(IClientPlayerAPI var0, int var1, int var2, int var3) {
        ClientPlayerAPI var5 = var0.getClientPlayerAPI();
        EnumStatus var4;
        if (var5 != null && var5.isSleepInBedAtModded) {
            var4 = var5.sleepInBedAt(var1, var2, var3);
        } else {
            var4 = var0.localSleepInBedAt(var1, var2, var3);
        }

        return var4;
    }

    private EnumStatus sleepInBedAt(int var1, int var2, int var3) {
        if (this.beforeSleepInBedAtHooks != null) {
            for (int var4 = this.beforeSleepInBedAtHooks.length - 1; var4 >= 0; --var4) {
                this.beforeSleepInBedAtHooks[var4].beforeSleepInBedAt(var1, var2, var3);
            }
        }

        EnumStatus var6;
        if (this.overrideSleepInBedAtHooks != null) {
            var6 = this.overrideSleepInBedAtHooks[this.overrideSleepInBedAtHooks.length - 1].sleepInBedAt(
                    var1, var2, var3);
        } else {
            var6 = this.player.localSleepInBedAt(var1, var2, var3);
        }

        if (this.afterSleepInBedAtHooks != null) {
            for (ClientPlayerBase afterSleepInBedAtHook : this.afterSleepInBedAtHooks) {
                afterSleepInBedAtHook.afterSleepInBedAt(var1, var2, var3);
            }
        }

        return var6;
    }

    protected ClientPlayerBase GetOverwrittenSleepInBedAt(ClientPlayerBase var1) {
        if (this.overrideSleepInBedAtHooks != null) {
            for (int var2 = 0; var2 < this.overrideSleepInBedAtHooks.length; ++var2) {
                if (this.overrideSleepInBedAtHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSleepInBedAtHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void swingItem(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isSwingItemModded) {
            var1.swingItem();
        } else {
            var0.localSwingItem();
        }
    }

    private void swingItem() {
        int var1;
        if (this.beforeSwingItemHooks != null) {
            for (var1 = this.beforeSwingItemHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSwingItemHooks[var1].beforeSwingItem();
            }
        }

        if (this.overrideSwingItemHooks != null) {
            this.overrideSwingItemHooks[this.overrideSwingItemHooks.length - 1].swingItem();
        } else {
            this.player.localSwingItem();
        }

        if (this.afterSwingItemHooks != null) {
            for (var1 = 0; var1 < this.afterSwingItemHooks.length; ++var1) {
                this.afterSwingItemHooks[var1].afterSwingItem();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSwingItem(ClientPlayerBase var1) {
        if (this.overrideSwingItemHooks != null) {
            for (int var2 = 0; var2 < this.overrideSwingItemHooks.length; ++var2) {
                if (this.overrideSwingItemHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideSwingItemHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void updateEntityActionState(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isUpdateEntityActionStateModded) {
            var1.updateEntityActionState();
        } else {
            var0.localUpdateEntityActionState();
        }
    }

    private void updateEntityActionState() {
        int var1;
        if (this.beforeUpdateEntityActionStateHooks != null) {
            for (var1 = this.beforeUpdateEntityActionStateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdateEntityActionStateHooks[var1].beforeUpdateEntityActionState();
            }
        }

        if (this.overrideUpdateEntityActionStateHooks != null) {
            this.overrideUpdateEntityActionStateHooks[this.overrideUpdateEntityActionStateHooks.length - 1]
                    .updateEntityActionState();
        } else {
            this.player.localUpdateEntityActionState();
        }

        if (this.afterUpdateEntityActionStateHooks != null) {
            for (var1 = 0; var1 < this.afterUpdateEntityActionStateHooks.length; ++var1) {
                this.afterUpdateEntityActionStateHooks[var1].afterUpdateEntityActionState();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenUpdateEntityActionState(ClientPlayerBase var1) {
        if (this.overrideUpdateEntityActionStateHooks != null) {
            for (int var2 = 0; var2 < this.overrideUpdateEntityActionStateHooks.length; ++var2) {
                if (this.overrideUpdateEntityActionStateHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideUpdateEntityActionStateHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void updateRidden(IClientPlayerAPI var0) {
        ClientPlayerAPI var1 = var0.getClientPlayerAPI();
        if (var1 != null && var1.isUpdateRiddenModded) {
            var1.updateRidden();
        } else {
            var0.localUpdateRidden();
        }
    }

    private void updateRidden() {
        int var1;
        if (this.beforeUpdateRiddenHooks != null) {
            for (var1 = this.beforeUpdateRiddenHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdateRiddenHooks[var1].beforeUpdateRidden();
            }
        }

        if (this.overrideUpdateRiddenHooks != null) {
            this.overrideUpdateRiddenHooks[this.overrideUpdateRiddenHooks.length - 1].updateRidden();
        } else {
            this.player.localUpdateRidden();
        }

        if (this.afterUpdateRiddenHooks != null) {
            for (var1 = 0; var1 < this.afterUpdateRiddenHooks.length; ++var1) {
                this.afterUpdateRiddenHooks[var1].afterUpdateRidden();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenUpdateRidden(ClientPlayerBase var1) {
        if (this.overrideUpdateRiddenHooks != null) {
            for (int var2 = 0; var2 < this.overrideUpdateRiddenHooks.length; ++var2) {
                if (this.overrideUpdateRiddenHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideUpdateRiddenHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void wakeUpPlayer(IClientPlayerAPI var0, boolean var1, boolean var2, boolean var3) {
        ClientPlayerAPI var4 = var0.getClientPlayerAPI();
        if (var4 != null && var4.isWakeUpPlayerModded) {
            var4.wakeUpPlayer(var1, var2, var3);
        } else {
            var0.localWakeUpPlayer(var1, var2, var3);
        }
    }

    private void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
        int var4;
        if (this.beforeWakeUpPlayerHooks != null) {
            for (var4 = this.beforeWakeUpPlayerHooks.length - 1; var4 >= 0; --var4) {
                this.beforeWakeUpPlayerHooks[var4].beforeWakeUpPlayer(var1, var2, var3);
            }
        }

        if (this.overrideWakeUpPlayerHooks != null) {
            this.overrideWakeUpPlayerHooks[this.overrideWakeUpPlayerHooks.length - 1].wakeUpPlayer(var1, var2, var3);
        } else {
            this.player.localWakeUpPlayer(var1, var2, var3);
        }

        if (this.afterWakeUpPlayerHooks != null) {
            for (var4 = 0; var4 < this.afterWakeUpPlayerHooks.length; ++var4) {
                this.afterWakeUpPlayerHooks[var4].afterWakeUpPlayer(var1, var2, var3);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenWakeUpPlayer(ClientPlayerBase var1) {
        if (this.overrideWakeUpPlayerHooks != null) {
            for (int var2 = 0; var2 < this.overrideWakeUpPlayerHooks.length; ++var2) {
                if (this.overrideWakeUpPlayerHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideWakeUpPlayerHooks[var2 - 1];
                }
            }
        }
        return var1;
    }

    public static void writeEntityToNBT(IClientPlayerAPI var0, NBTTagCompound var1) {
        ClientPlayerAPI var2 = var0.getClientPlayerAPI();
        if (var2 != null && var2.isWriteEntityToNBTModded) {
            var2.writeEntityToNBT(var1);
        } else {
            var0.localWriteEntityToNBT(var1);
        }
    }

    private void writeEntityToNBT(NBTTagCompound var1) {
        int var2;
        if (this.beforeWriteEntityToNBTHooks != null) {
            for (var2 = this.beforeWriteEntityToNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeWriteEntityToNBTHooks[var2].beforeWriteEntityToNBT(var1);
            }
        }

        if (this.overrideWriteEntityToNBTHooks != null) {
            this.overrideWriteEntityToNBTHooks[this.overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(var1);
        } else {
            this.player.localWriteEntityToNBT(var1);
        }

        if (this.afterWriteEntityToNBTHooks != null) {
            for (var2 = 0; var2 < this.afterWriteEntityToNBTHooks.length; ++var2) {
                this.afterWriteEntityToNBTHooks[var2].afterWriteEntityToNBT(var1);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenWriteEntityToNBT(ClientPlayerBase var1) {
        if (this.overrideWriteEntityToNBTHooks != null) {
            for (int var2 = 0; var2 < this.overrideWriteEntityToNBTHooks.length; ++var2) {
                if (this.overrideWriteEntityToNBTHooks[var2] == var1) {
                    if (var2 == 0) {
                        return null;
                    }

                    return this.overrideWriteEntityToNBTHooks[var2 - 1];
                }
            }
        }
        return var1;
    }
}
