package api.player.client;

import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Entity.EnumEntitySize;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.EnumStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IIcon;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public interface IClientPlayer {
    ClientPlayerBase getClientPlayerBase(String baseId);

    Set<String> getClientPlayerBaseIds();

    Object dynamic(String key, Object[] parameters);

    void realAddExhaustion(float var1);

    void superAddExhaustion(float var1);

    void localAddExhaustion(float var1);

    void realAddMovementStat(double var1, double var3, double var5);

    void superAddMovementStat(double var1, double var3, double var5);

    void localAddMovementStat(double var1, double var3, double var5);

    void realAddStat(StatBase var1, int var2);

    void superAddStat(StatBase var1, int var2);

    void localAddStat(StatBase var1, int var2);

    boolean realAttackEntityFrom(DamageSource var1, float var2);

    boolean superAttackEntityFrom(DamageSource var1, float var2);

    boolean localAttackEntityFrom(DamageSource var1, float var2);

    void realAttackTargetEntityWithCurrentItem(Entity var1);

    void superAttackTargetEntityWithCurrentItem(Entity var1);

    void localAttackTargetEntityWithCurrentItem(Entity var1);

    boolean realCanBreatheUnderwater();

    boolean superCanBreatheUnderwater();

    boolean localCanBreatheUnderwater();

    boolean realCanHarvestBlock(Block var1);

    boolean superCanHarvestBlock(Block var1);

    boolean localCanHarvestBlock(Block var1);

    boolean realCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5);

    boolean superCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5);

    boolean localCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5);

    boolean realCanTriggerWalking();

    boolean superCanTriggerWalking();

    boolean localCanTriggerWalking();

    void realCloseScreen();

    void superCloseScreen();

    void localCloseScreen();

    void realDamageEntity(DamageSource var1, float var2);

    void superDamageEntity(DamageSource var1, float var2);

    void localDamageEntity(DamageSource var1, float var2);

    void realDisplayGUIBrewingStand(TileEntityBrewingStand var1);

    void superDisplayGUIBrewingStand(TileEntityBrewingStand var1);

    void localDisplayGUIBrewingStand(TileEntityBrewingStand var1);

    void realDisplayGUIChest(IInventory var1);

    void superDisplayGUIChest(IInventory var1);

    void localDisplayGUIChest(IInventory var1);

    void realDisplayGUIDispenser(TileEntityDispenser var1);

    void superDisplayGUIDispenser(TileEntityDispenser var1);

    void localDisplayGUIDispenser(TileEntityDispenser var1);

    void realDisplayGUIEditSign(TileEntity var1);

    void superDisplayGUIEditSign(TileEntity var1);

    void localDisplayGUIEditSign(TileEntity var1);

    void realDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    void superDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    void localDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    void realDisplayGUIFurnace(TileEntityFurnace var1);

    void superDisplayGUIFurnace(TileEntityFurnace var1);

    void localDisplayGUIFurnace(TileEntityFurnace var1);

    void realDisplayGUIWorkbench(int var1, int var2, int var3);

    void superDisplayGUIWorkbench(int var1, int var2, int var3);

    void localDisplayGUIWorkbench(int var1, int var2, int var3);

    EntityItem realDropOneItem(boolean var1);

    EntityItem superDropOneItem(boolean var1);

    EntityItem localDropOneItem(boolean var1);

    EntityItem realDropPlayerItem(ItemStack var1, boolean var2);

    EntityItem superDropPlayerItem(ItemStack var1, boolean var2);

    EntityItem localDropPlayerItem(ItemStack var1, boolean var2);

    EntityItem realDropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3);

    EntityItem superDropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3);

    EntityItem localDropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3);

    void realFall(float var1);

    void superFall(float var1);

    void localFall(float var1);

    float realGetAIMoveSpeed();

    float superGetAIMoveSpeed();

    float localGetAIMoveSpeed();

    float realGetBedOrientationInDegrees();

    float superGetBedOrientationInDegrees();

    float localGetBedOrientationInDegrees();

    float realGetBrightness(float var1);

    float superGetBrightness(float var1);

    float localGetBrightness(float var1);

    int realGetBrightnessForRender(float var1);

    int superGetBrightnessForRender(float var1);

    int localGetBrightnessForRender(float var1);

    float realGetCurrentPlayerStrVsBlock(Block var1, boolean var2);

    float superGetCurrentPlayerStrVsBlock(Block var1, boolean var2);

    float localGetCurrentPlayerStrVsBlock(Block var1, boolean var2);

    float realGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3);

    float superGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3);

    float localGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3);

    double realGetDistanceSq(double var1, double var3, double var5);

    double superGetDistanceSq(double var1, double var3, double var5);

    double localGetDistanceSq(double var1, double var3, double var5);

    double realGetDistanceSqToEntity(Entity var1);

    double superGetDistanceSqToEntity(Entity var1);

    double localGetDistanceSqToEntity(Entity var1);

    float realGetFOVMultiplier();

    float localGetFOVMultiplier();

    String realGetHurtSound();

    String superGetHurtSound();

    String localGetHurtSound();

    IIcon realGetItemIcon(ItemStack var1, int var2);

    IIcon superGetItemIcon(ItemStack var1, int var2);

    IIcon localGetItemIcon(ItemStack var1, int var2);

    int realGetSleepTimer();

    int superGetSleepTimer();

    int localGetSleepTimer();

    boolean realHandleLavaMovement();

    boolean superHandleLavaMovement();

    boolean localHandleLavaMovement();

    boolean realHandleWaterMovement();

    boolean superHandleWaterMovement();

    boolean localHandleWaterMovement();

    void realHeal(float var1);

    void superHeal(float var1);

    void localHeal(float var1);

    boolean realIsEntityInsideOpaqueBlock();

    boolean superIsEntityInsideOpaqueBlock();

    boolean localIsEntityInsideOpaqueBlock();

    boolean realIsInWater();

    boolean superIsInWater();

    boolean localIsInWater();

    boolean realIsInsideOfMaterial(Material var1);

    boolean superIsInsideOfMaterial(Material var1);

    boolean localIsInsideOfMaterial(Material var1);

    boolean realIsOnLadder();

    boolean superIsOnLadder();

    boolean localIsOnLadder();

    boolean realIsPlayerSleeping();

    boolean superIsPlayerSleeping();

    boolean localIsPlayerSleeping();

    boolean realIsSneaking();

    boolean superIsSneaking();

    boolean localIsSneaking();

    boolean realIsSprinting();

    boolean superIsSprinting();

    boolean localIsSprinting();

    void realJump();

    void superJump();

    void localJump();

    void realKnockBack(Entity var1, float var2, double var3, double var5);

    void superKnockBack(Entity var1, float var2, double var3, double var5);

    void localKnockBack(Entity var1, float var2, double var3, double var5);

    void realMoveEntity(double var1, double var3, double var5);

    void superMoveEntity(double var1, double var3, double var5);

    void localMoveEntity(double var1, double var3, double var5);

    void realMoveEntityWithHeading(float var1, float var2);

    void superMoveEntityWithHeading(float var1, float var2);

    void localMoveEntityWithHeading(float var1, float var2);

    void realMoveFlying(float var1, float var2, float var3);

    void superMoveFlying(float var1, float var2, float var3);

    void localMoveFlying(float var1, float var2, float var3);

    void realOnDeath(DamageSource var1);

    void superOnDeath(DamageSource var1);

    void localOnDeath(DamageSource var1);

    void realOnLivingUpdate();

    void superOnLivingUpdate();

    void localOnLivingUpdate();

    void realOnKillEntity(EntityLivingBase var1);

    void superOnKillEntity(EntityLivingBase var1);

    void localOnKillEntity(EntityLivingBase var1);

    void realOnStruckByLightning(EntityLightningBolt var1);

    void superOnStruckByLightning(EntityLightningBolt var1);

    void localOnStruckByLightning(EntityLightningBolt var1);

    void realOnUpdate();

    void superOnUpdate();

    void localOnUpdate();

    void realPlayStepSound(int var1, int var2, int var3, Block var4);

    void superPlayStepSound(int var1, int var2, int var3, Block var4);

    void localPlayStepSound(int var1, int var2, int var3, Block var4);

    boolean realPushOutOfBlocks(double var1, double var3, double var5);

    boolean superPushOutOfBlocks(double var1, double var3, double var5);

    boolean localPushOutOfBlocks(double var1, double var3, double var5);

    MovingObjectPosition realRayTrace(double var1, float var3);

    MovingObjectPosition superRayTrace(double var1, float var3);

    MovingObjectPosition localRayTrace(double var1, float var3);

    void realReadEntityFromNBT(NBTTagCompound var1);

    void superReadEntityFromNBT(NBTTagCompound var1);

    void localReadEntityFromNBT(NBTTagCompound var1);

    void realRespawnPlayer();

    void superRespawnPlayer();

    void localRespawnPlayer();

    void realSetDead();

    void superSetDead();

    void localSetDead();

    void realSetPlayerSPHealth(float var1);

    void localSetPlayerSPHealth(float var1);

    void realSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    void superSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    void localSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    void realSetSneaking(boolean var1);

    void superSetSneaking(boolean var1);

    void localSetSneaking(boolean var1);

    void realSetSprinting(boolean var1);

    void superSetSprinting(boolean var1);

    void localSetSprinting(boolean var1);

    EnumStatus realSleepInBedAt(int var1, int var2, int var3);

    EnumStatus superSleepInBedAt(int var1, int var2, int var3);

    EnumStatus localSleepInBedAt(int var1, int var2, int var3);

    void realSwingItem();

    void superSwingItem();

    void localSwingItem();

    void realUpdateEntityActionState();

    void superUpdateEntityActionState();

    void localUpdateEntityActionState();

    void realUpdateRidden();

    void superUpdateRidden();

    void localUpdateRidden();

    void realWakeUpPlayer(boolean var1, boolean var2, boolean var3);

    void superWakeUpPlayer(boolean var1, boolean var2, boolean var3);

    void localWakeUpPlayer(boolean var1, boolean var2, boolean var3);

    void realWriteEntityToNBT(NBTTagCompound var1);

    void superWriteEntityToNBT(NBTTagCompound var1);

    void localWriteEntityToNBT(NBTTagCompound var1);

    boolean getAddedToChunkField();

    void setAddedToChunkField(boolean var1);

    int getArrowHitTimerField();

    void setArrowHitTimerField(int var1);

    int getAttackTimeField();

    void setAttackTimeField(int var1);

    float getAttackedAtYawField();

    void setAttackedAtYawField(float var1);

    EntityPlayer getAttackingPlayerField();

    void setAttackingPlayerField(EntityPlayer var1);

    AxisAlignedBB getBoundingBoxField();

    float getCameraPitchField();

    void setCameraPitchField(float var1);

    float getCameraYawField();

    void setCameraYawField(float var1);

    PlayerCapabilities getCapabilitiesField();

    void setCapabilitiesField(PlayerCapabilities var1);

    int getChunkCoordXField();

    void setChunkCoordXField(int var1);

    int getChunkCoordYField();

    void setChunkCoordYField(int var1);

    int getChunkCoordZField();

    void setChunkCoordZField(int var1);

    DataWatcher getDataWatcherField();

    void setDataWatcherField(DataWatcher var1);

    boolean getDeadField();

    void setDeadField(boolean var1);

    int getDeathTimeField();

    void setDeathTimeField(int var1);

    int getDimensionField();

    void setDimensionField(int var1);

    float getDistanceWalkedModifiedField();

    void setDistanceWalkedModifiedField(float var1);

    float getDistanceWalkedOnStepModifiedField();

    void setDistanceWalkedOnStepModifiedField(float var1);

    int getEntityAgeField();

    void setEntityAgeField(int var1);

    float getEntityCollisionReductionField();

    void setEntityCollisionReductionField(float var1);

    UUID getEntityUniqueIDField();

    void setEntityUniqueIDField(UUID var1);

    float getExperienceField();

    void setExperienceField(float var1);

    int getExperienceLevelField();

    void setExperienceLevelField(int var1);

    int getExperienceTotalField();

    void setExperienceTotalField(int var1);

    float getFallDistanceField();

    void setFallDistanceField(float var1);

    float getField_110154_aXField();

    void setField_110154_aXField(float var1);

    boolean getField_70135_KField();

    void setField_70135_KField(boolean var1);

    float getField_70741_aBField();

    void setField_70741_aBField(float var1);

    float getField_70763_axField();

    void setField_70763_axField(float var1);

    float getField_70764_awField();

    void setField_70764_awField(float var1);

    float getField_70768_auField();

    void setField_70768_auField(float var1);

    float getField_70769_aoField();

    void setField_70769_aoField(float var1);

    float getField_70770_apField();

    void setField_70770_apField(float var1);

    float getField_71079_bUField();

    void setField_71079_bUField(float var1);

    float getField_71082_cxField();

    void setField_71082_cxField(float var1);

    double getField_71085_bRField();

    void setField_71085_bRField(double var1);

    float getField_71089_bVField();

    void setField_71089_bVField(float var1);

    double getField_71091_bMField();

    void setField_71091_bMField(double var1);

    double getField_71094_bPField();

    void setField_71094_bPField(double var1);

    double getField_71095_bQField();

    void setField_71095_bQField(double var1);

    double getField_71096_bNField();

    void setField_71096_bNField(double var1);

    double getField_71097_bOField();

    void setField_71097_bOField(double var1);

    MouseFilter getField_71160_ciField();

    void setField_71160_ciField(MouseFilter var1);

    MouseFilter getField_71161_cjField();

    void setField_71161_cjField(MouseFilter var1);

    MouseFilter getField_71162_chField();

    void setField_71162_chField(MouseFilter var1);

    int getFireResistanceField();

    void setFireResistanceField(int var1);

    EntityFishHook getFishEntityField();

    void setFishEntityField(EntityFishHook var1);

    int getFlyToggleTimerField();

    void setFlyToggleTimerField(int var1);

    FoodStats getFoodStatsField();

    void setFoodStatsField(FoodStats var1);

    boolean getForceSpawnField();

    void setForceSpawnField(boolean var1);

    float getHeightField();

    void setHeightField(float var1);

    float getHorseJumpPowerField();

    void setHorseJumpPowerField(float var1);

    int getHorseJumpPowerCounterField();

    void setHorseJumpPowerCounterField(int var1);

    int getHurtResistantTimeField();

    void setHurtResistantTimeField(int var1);

    int getHurtTimeField();

    void setHurtTimeField(int var1);

    boolean getIgnoreFrustumCheckField();

    void setIgnoreFrustumCheckField(boolean var1);

    boolean getInPortalField();

    void setInPortalField(boolean var1);

    boolean getInWaterField();

    void setInWaterField(boolean var1);

    InventoryPlayer getInventoryField();

    void setInventoryField(InventoryPlayer var1);

    Container getInventoryContainerField();

    void setInventoryContainerField(Container var1);

    boolean getIsAirBorneField();

    void setIsAirBorneField(boolean var1);

    boolean getIsCollidedField();

    void setIsCollidedField(boolean var1);

    boolean getIsCollidedHorizontallyField();

    void setIsCollidedHorizontallyField(boolean var1);

    boolean getIsCollidedVerticallyField();

    void setIsCollidedVerticallyField(boolean var1);

    boolean getIsDeadField();

    void setIsDeadField(boolean var1);

    boolean getIsImmuneToFireField();

    void setIsImmuneToFireField(boolean var1);

    boolean getIsInWebField();

    void setIsInWebField(boolean var1);

    boolean getIsJumpingField();

    void setIsJumpingField(boolean var1);

    boolean getIsSwingInProgressField();

    void setIsSwingInProgressField(boolean var1);

    float getJumpMovementFactorField();

    void setJumpMovementFactorField(float var1);

    float getLastDamageField();

    void setLastDamageField(float var1);

    double getLastTickPosXField();

    void setLastTickPosXField(double var1);

    double getLastTickPosYField();

    void setLastTickPosYField(double var1);

    double getLastTickPosZField();

    void setLastTickPosZField(double var1);

    float getLimbSwingField();

    void setLimbSwingField(float var1);

    float getLimbSwingAmountField();

    void setLimbSwingAmountField(float var1);

    int getMaxHurtResistantTimeField();

    void setMaxHurtResistantTimeField(int var1);

    int getMaxHurtTimeField();

    void setMaxHurtTimeField(int var1);

    Minecraft getMcField();

    void setMcField(Minecraft var1);

    double getMotionXField();

    void setMotionXField(double var1);

    double getMotionYField();

    void setMotionYField(double var1);

    double getMotionZField();

    void setMotionZField(double var1);

    float getMoveForwardField();

    void setMoveForwardField(float var1);

    float getMoveStrafingField();

    void setMoveStrafingField(float var1);

    MovementInput getMovementInputField();

    void setMovementInputField(MovementInput var1);

    EnumEntitySize getMyEntitySizeField();

    void setMyEntitySizeField(EnumEntitySize var1);

    int getNewPosRotationIncrementsField();

    void setNewPosRotationIncrementsField(int var1);

    double getNewPosXField();

    void setNewPosXField(double var1);

    double getNewPosYField();

    void setNewPosYField(double var1);

    double getNewPosZField();

    void setNewPosZField(double var1);

    double getNewRotationPitchField();

    void setNewRotationPitchField(double var1);

    double getNewRotationYawField();

    void setNewRotationYawField(double var1);

    boolean getNoClipField();

    void setNoClipField(boolean var1);

    boolean getOnGroundField();

    void setOnGroundField(boolean var1);

    Container getOpenContainerField();

    void setOpenContainerField(Container var1);

    ChunkCoordinates getPlayerLocationField();

    void setPlayerLocationField(ChunkCoordinates var1);

    int getPortalCounterField();

    void setPortalCounterField(int var1);

    double getPosXField();

    void setPosXField(double var1);

    double getPosYField();

    void setPosYField(double var1);

    double getPosZField();

    void setPosZField(double var1);

    float getPrevCameraPitchField();

    void setPrevCameraPitchField(float var1);

    float getPrevCameraYawField();

    void setPrevCameraYawField(float var1);

    float getPrevDistanceWalkedModifiedField();

    void setPrevDistanceWalkedModifiedField(float var1);

    float getPrevHealthField();

    void setPrevHealthField(float var1);

    float getPrevLimbSwingAmountField();

    void setPrevLimbSwingAmountField(float var1);

    double getPrevPosXField();

    void setPrevPosXField(double var1);

    double getPrevPosYField();

    void setPrevPosYField(double var1);

    double getPrevPosZField();

    void setPrevPosZField(double var1);

    float getPrevRenderArmPitchField();

    void setPrevRenderArmPitchField(float var1);

    float getPrevRenderArmYawField();

    void setPrevRenderArmYawField(float var1);

    float getPrevRenderYawOffsetField();

    void setPrevRenderYawOffsetField(float var1);

    float getPrevRotationPitchField();

    void setPrevRotationPitchField(float var1);

    float getPrevRotationYawField();

    void setPrevRotationYawField(float var1);

    float getPrevRotationYawHeadField();

    void setPrevRotationYawHeadField(float var1);

    float getPrevSwingProgressField();

    void setPrevSwingProgressField(float var1);

    float getPrevTimeInPortalField();

    void setPrevTimeInPortalField(float var1);

    boolean getPreventEntitySpawningField();

    void setPreventEntitySpawningField(boolean var1);

    Random getRandField();

    void setRandField(Random var1);

    float getRandomYawVelocityField();

    void setRandomYawVelocityField(float var1);

    int getRecentlyHitField();

    void setRecentlyHitField(int var1);

    float getRenderArmPitchField();

    void setRenderArmPitchField(float var1);

    float getRenderArmYawField();

    void setRenderArmYawField(float var1);

    double getRenderDistanceWeightField();

    void setRenderDistanceWeightField(double var1);

    float getRenderYawOffsetField();

    void setRenderYawOffsetField(float var1);

    Entity getRiddenByEntityField();

    void setRiddenByEntityField(Entity var1);

    Entity getRidingEntityField();

    void setRidingEntityField(Entity var1);

    float getRotationPitchField();

    void setRotationPitchField(float var1);

    float getRotationYawField();

    void setRotationYawField(float var1);

    float getRotationYawHeadField();

    void setRotationYawHeadField(float var1);

    int getScoreValueField();

    void setScoreValueField(int var1);

    int getServerPosXField();

    void setServerPosXField(int var1);

    int getServerPosYField();

    void setServerPosYField(int var1);

    int getServerPosZField();

    void setServerPosZField(int var1);

    boolean getSleepingField();

    void setSleepingField(boolean var1);

    float getSpeedInAirField();

    void setSpeedInAirField(float var1);

    float getSpeedOnGroundField();

    void setSpeedOnGroundField(float var1);

    int getSprintToggleTimerField();

    void setSprintToggleTimerField(int var1);

    int getSprintingTicksLeftField();

    void setSprintingTicksLeftField(int var1);

    float getStepHeightField();

    void setStepHeightField(float var1);

    float getSwingProgressField();

    void setSwingProgressField(float var1);

    int getSwingProgressIntField();

    void setSwingProgressIntField(int var1);

    int getTeleportDirectionField();

    void setTeleportDirectionField(int var1);

    int getTicksExistedField();

    void setTicksExistedField(int var1);

    float getTimeInPortalField();

    void setTimeInPortalField(float var1);

    int getTimeUntilPortalField();

    void setTimeUntilPortalField(int var1);

    boolean getVelocityChangedField();

    void setVelocityChangedField(boolean var1);

    float getWidthField();

    void setWidthField(float var1);

    World getWorldObjField();

    void setWorldObjField(World var1);

    int getXpCooldownField();

    void setXpCooldownField(int var1);

    float getYOffsetField();

    void setYOffsetField(float var1);

    float getYSizeField();

    void setYSizeField(float var1);
}
