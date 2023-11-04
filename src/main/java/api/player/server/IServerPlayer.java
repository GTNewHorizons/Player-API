// ==================================================================
// This file is part of Player API.
//
// Player API is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// Player API is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License and the GNU General Public License along with Player API.
// If not, see <http://www.gnu.org/licenses/>.
// ==================================================================

package api.player.server;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ItemInWorldManager;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

public interface IServerPlayer {

    ServerPlayerBase getServerPlayerBase(String baseId);

    Set<String> getServerPlayerBaseIds();

    Object dynamic(String key, Object[] parameters);

    void realAddExhaustion(float paramFloat);

    void superAddExhaustion(float paramFloat);

    void localAddExhaustion(float paramFloat);

    void realAddExperience(int paramInt);

    void superAddExperience(int paramInt);

    void localAddExperience(int paramInt);

    void realAddExperienceLevel(int paramInt);

    void superAddExperienceLevel(int paramInt);

    void localAddExperienceLevel(int paramInt);

    void realAddMovementStat(double paramDouble1, double paramDouble2, double paramDouble3);

    void superAddMovementStat(double paramDouble1, double paramDouble2, double paramDouble3);

    void localAddMovementStat(double paramDouble1, double paramDouble2, double paramDouble3);

    boolean realAttackEntityFrom(DamageSource paramDamageSource, float paramFloat);

    boolean superAttackEntityFrom(DamageSource paramDamageSource, float paramFloat);

    boolean localAttackEntityFrom(DamageSource paramDamageSource, float paramFloat);

    void realAttackTargetEntityWithCurrentItem(Entity paramEntity);

    void superAttackTargetEntityWithCurrentItem(Entity paramEntity);

    void localAttackTargetEntityWithCurrentItem(Entity paramEntity);

    boolean realCanBreatheUnderwater();

    boolean superCanBreatheUnderwater();

    boolean localCanBreatheUnderwater();

    boolean realCanHarvestBlock(Block paramBlock);

    boolean superCanHarvestBlock(Block paramBlock);

    boolean localCanHarvestBlock(Block paramBlock);

    boolean realCanPlayerEdit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ItemStack paramItemStack);

    boolean superCanPlayerEdit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ItemStack paramItemStack);

    boolean localCanPlayerEdit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ItemStack paramItemStack);

    boolean realCanTriggerWalking();

    boolean superCanTriggerWalking();

    boolean localCanTriggerWalking();

    void realClonePlayer(EntityPlayer paramEntityPlayer, boolean paramBoolean);

    void superClonePlayer(EntityPlayer paramEntityPlayer, boolean paramBoolean);

    void localClonePlayer(EntityPlayer paramEntityPlayer, boolean paramBoolean);

    void realDamageEntity(DamageSource paramDamageSource, float paramFloat);

    void superDamageEntity(DamageSource paramDamageSource, float paramFloat);

    void localDamageEntity(DamageSource paramDamageSource, float paramFloat);

    void realDisplayGUIChest(IInventory paramIInventory);

    void superDisplayGUIChest(IInventory paramIInventory);

    void localDisplayGUIChest(IInventory paramIInventory);

    void realDisplayGUIDispenser(TileEntityDispenser paramTileEntityDispenser);

    void superDisplayGUIDispenser(TileEntityDispenser paramTileEntityDispenser);

    void localDisplayGUIDispenser(TileEntityDispenser paramTileEntityDispenser);

    void realDisplayGUIFurnace(TileEntityFurnace paramTileEntityFurnace);

    void superDisplayGUIFurnace(TileEntityFurnace paramTileEntityFurnace);

    void localDisplayGUIFurnace(TileEntityFurnace paramTileEntityFurnace);

    void realDisplayGUIWorkbench(int paramInt1, int paramInt2, int paramInt3);

    void superDisplayGUIWorkbench(int paramInt1, int paramInt2, int paramInt3);

    void localDisplayGUIWorkbench(int paramInt1, int paramInt2, int paramInt3);

    EntityItem realDropOneItem(boolean paramBoolean);

    EntityItem superDropOneItem(boolean paramBoolean);

    EntityItem localDropOneItem(boolean paramBoolean);

    EntityItem realDropPlayerItem(ItemStack paramItemStack, boolean paramBoolean);

    EntityItem superDropPlayerItem(ItemStack paramItemStack, boolean paramBoolean);

    EntityItem localDropPlayerItem(ItemStack paramItemStack, boolean paramBoolean);

    void realFall(float paramFloat);

    void superFall(float paramFloat);

    void localFall(float paramFloat);

    float realGetAIMoveSpeed();

    float superGetAIMoveSpeed();

    float localGetAIMoveSpeed();

    float realGetCurrentPlayerStrVsBlock(Block paramBlock, boolean paramBoolean);

    float superGetCurrentPlayerStrVsBlock(Block paramBlock, boolean paramBoolean);

    float localGetCurrentPlayerStrVsBlock(Block paramBlock, boolean paramBoolean);

    float realGetCurrentPlayerStrVsBlockForge(Block paramBlock, boolean paramBoolean, int paramInt);

    float superGetCurrentPlayerStrVsBlockForge(Block paramBlock, boolean paramBoolean, int paramInt);

    float localGetCurrentPlayerStrVsBlockForge(Block paramBlock, boolean paramBoolean, int paramInt);

    double realGetDistanceSq(double paramDouble1, double paramDouble2, double paramDouble3);

    double superGetDistanceSq(double paramDouble1, double paramDouble2, double paramDouble3);

    double localGetDistanceSq(double paramDouble1, double paramDouble2, double paramDouble3);

    float realGetBrightness(float paramFloat);

    float superGetBrightness(float paramFloat);

    float localGetBrightness(float paramFloat);

    float realGetEyeHeight();

    float superGetEyeHeight();

    float localGetEyeHeight();

    void realHeal(float paramFloat);

    void superHeal(float paramFloat);

    void localHeal(float paramFloat);

    boolean realIsEntityInsideOpaqueBlock();

    boolean superIsEntityInsideOpaqueBlock();

    boolean localIsEntityInsideOpaqueBlock();

    boolean realIsInWater();

    boolean superIsInWater();

    boolean localIsInWater();

    boolean realIsInsideOfMaterial(Material paramMaterial);

    boolean superIsInsideOfMaterial(Material paramMaterial);

    boolean localIsInsideOfMaterial(Material paramMaterial);

    boolean realIsOnLadder();

    boolean superIsOnLadder();

    boolean localIsOnLadder();

    boolean realIsPlayerSleeping();

    boolean superIsPlayerSleeping();

    boolean localIsPlayerSleeping();

    boolean realIsSneaking();

    boolean superIsSneaking();

    boolean localIsSneaking();

    void realJump();

    void superJump();

    void localJump();

    void realKnockBack(Entity paramEntity, float paramFloat, double paramDouble1, double paramDouble2);

    void superKnockBack(Entity paramEntity, float paramFloat, double paramDouble1, double paramDouble2);

    void localKnockBack(Entity paramEntity, float paramFloat, double paramDouble1, double paramDouble2);

    void realMountEntity(Entity paramEntity);

    void superMountEntity(Entity paramEntity);

    void localMountEntity(Entity paramEntity);

    void realMoveEntity(double paramDouble1, double paramDouble2, double paramDouble3);

    void superMoveEntity(double paramDouble1, double paramDouble2, double paramDouble3);

    void localMoveEntity(double paramDouble1, double paramDouble2, double paramDouble3);

    void realMoveEntityWithHeading(float paramFloat1, float paramFloat2);

    void superMoveEntityWithHeading(float paramFloat1, float paramFloat2);

    void localMoveEntityWithHeading(float paramFloat1, float paramFloat2);

    void realMoveFlying(float paramFloat1, float paramFloat2, float paramFloat3);

    void superMoveFlying(float paramFloat1, float paramFloat2, float paramFloat3);

    void localMoveFlying(float paramFloat1, float paramFloat2, float paramFloat3);

    void realOnDeath(DamageSource paramDamageSource);

    void superOnDeath(DamageSource paramDamageSource);

    void localOnDeath(DamageSource paramDamageSource);

    void realOnLivingUpdate();

    void superOnLivingUpdate();

    void localOnLivingUpdate();

    void realOnKillEntity(EntityLivingBase paramEntityLivingBase);

    void superOnKillEntity(EntityLivingBase paramEntityLivingBase);

    void localOnKillEntity(EntityLivingBase paramEntityLivingBase);

    void realOnStruckByLightning(EntityLightningBolt paramEntityLightningBolt);

    void superOnStruckByLightning(EntityLightningBolt paramEntityLightningBolt);

    void localOnStruckByLightning(EntityLightningBolt paramEntityLightningBolt);

    void realOnUpdate();

    void superOnUpdate();

    void localOnUpdate();

    void realOnUpdateEntity();

    void localOnUpdateEntity();

    void realReadEntityFromNBT(NBTTagCompound paramNBTTagCompound);

    void superReadEntityFromNBT(NBTTagCompound paramNBTTagCompound);

    void localReadEntityFromNBT(NBTTagCompound paramNBTTagCompound);

    void realSetDead();

    void superSetDead();

    void localSetDead();

    void realSetEntityActionState(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);

    void localSetEntityActionState(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);

    void realSetPosition(double paramDouble1, double paramDouble2, double paramDouble3);

    void superSetPosition(double paramDouble1, double paramDouble2, double paramDouble3);

    void localSetPosition(double paramDouble1, double paramDouble2, double paramDouble3);

    void realSetSneaking(boolean paramBoolean);

    void superSetSneaking(boolean paramBoolean);

    void localSetSneaking(boolean paramBoolean);

    void realSetSprinting(boolean paramBoolean);

    void superSetSprinting(boolean paramBoolean);

    void localSetSprinting(boolean paramBoolean);

    void realSwingItem();

    void superSwingItem();

    void localSwingItem();

    void realUpdateEntityActionState();

    void superUpdateEntityActionState();

    void localUpdateEntityActionState();

    void realUpdatePotionEffects();

    void superUpdatePotionEffects();

    void localUpdatePotionEffects();

    void realUpdateRidden();

    void superUpdateRidden();

    void localUpdateRidden();

    void realWakeUpPlayer(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

    void superWakeUpPlayer(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

    void localWakeUpPlayer(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

    void realWriteEntityToNBT(NBTTagCompound paramNBTTagCompound);

    void superWriteEntityToNBT(NBTTagCompound paramNBTTagCompound);

    void localWriteEntityToNBT(NBTTagCompound paramNBTTagCompound);

    boolean getAddedToChunkField();

    void setAddedToChunkField(boolean addedToChunk);

    int getArrowHitTimerField();

    void setArrowHitTimerField(int arrowHitTimer);

    int getAttackTimeField();

    void setAttackTimeField(int attackTime);

    float getAttackedAtYawField();

    void setAttackedAtYawField(float attackedAtYaw);

    EntityPlayer getAttackingPlayerField();

    void setAttackingPlayerField(EntityPlayer attackingPlayer);

    AxisAlignedBB getBoundingBoxField();

    float getCameraPitchField();

    void setCameraPitchField(float cameraPitch);

    float getCameraYawField();

    void setCameraYawField(float cameraYaw);

    PlayerCapabilities getCapabilitiesField();

    void setCapabilitiesField(PlayerCapabilities capabilities);

    boolean getChatColoursField();

    void setChatColoursField(boolean chatColours);

    EntityPlayer.EnumChatVisibility getChatVisibilityField();

    void setChatVisibilityField(EntityPlayer.EnumChatVisibility chatVisibility);

    int getChunkCoordXField();

    void setChunkCoordXField(int chunkCoordX);

    int getChunkCoordYField();

    void setChunkCoordYField(int chunkCoordY);

    int getChunkCoordZField();

    void setChunkCoordZField(int chunkCoordZ);

    int getCurrentWindowIdField();

    void setCurrentWindowIdField(int currentWindowId);

    DataWatcher getDataWatcherField();

    void setDataWatcherField(DataWatcher dataWatcher);

    boolean getDeadField();

    void setDeadField(boolean dead);

    int getDeathTimeField();

    void setDeathTimeField(int deathTime);

    java.util.List<?> getDestroyedItemsNetCacheField();

    int getDimensionField();

    void setDimensionField(int dimension);

    float getDistanceWalkedModifiedField();

    void setDistanceWalkedModifiedField(float distanceWalkedModified);

    float getDistanceWalkedOnStepModifiedField();

    void setDistanceWalkedOnStepModifiedField(float distanceWalkedOnStepModified);

    int getEntityAgeField();

    void setEntityAgeField(int entityAge);

    float getEntityCollisionReductionField();

    void setEntityCollisionReductionField(float entityCollisionReduction);

    java.util.UUID getEntityUniqueIDField();

    void setEntityUniqueIDField(java.util.UUID entityUniqueID);

    float getExperienceField();

    void setExperienceField(float experience);

    int getExperienceLevelField();

    void setExperienceLevelField(int experienceLevel);

    int getExperienceTotalField();

    void setExperienceTotalField(int experienceTotal);

    float getFallDistanceField();

    void setFallDistanceField(float fallDistance);

    float getField_110154_aXField();

    void setField_110154_aXField(float field_110154_aX);

    float getField_130068_bOField();

    void setField_130068_bOField(float field_130068_bO);

    long getField_143005_bXField();

    void setField_143005_bXField(long field_143005_bX);

    int getField_147101_bUField();

    void setField_147101_bUField(int field_147101_bU);

    StatisticsFile getField_147103_bOField();

    boolean getField_70135_KField();

    void setField_70135_KField(boolean field_70135_K);

    float getField_70741_aBField();

    void setField_70741_aBField(float field_70741_aB);

    float getField_70763_axField();

    void setField_70763_axField(float field_70763_ax);

    float getField_70764_awField();

    void setField_70764_awField(float field_70764_aw);

    float getField_70768_auField();

    void setField_70768_auField(float field_70768_au);

    float getField_70769_aoField();

    void setField_70769_aoField(float field_70769_ao);

    float getField_70770_apField();

    void setField_70770_apField(float field_70770_ap);

    float getField_71079_bUField();

    void setField_71079_bUField(float field_71079_bU);

    float getField_71082_cxField();

    void setField_71082_cxField(float field_71082_cx);

    double getField_71085_bRField();

    void setField_71085_bRField(double field_71085_bR);

    float getField_71089_bVField();

    void setField_71089_bVField(float field_71089_bV);

    double getField_71091_bMField();

    void setField_71091_bMField(double field_71091_bM);

    double getField_71094_bPField();

    void setField_71094_bPField(double field_71094_bP);

    double getField_71095_bQField();

    void setField_71095_bQField(double field_71095_bQ);

    double getField_71096_bNField();

    void setField_71096_bNField(double field_71096_bN);

    double getField_71097_bOField();

    void setField_71097_bOField(double field_71097_bO);

    int getFireResistanceField();

    void setFireResistanceField(int fireResistance);

    EntityFishHook getFishEntityField();

    void setFishEntityField(EntityFishHook fishEntity);

    int getFlyToggleTimerField();

    void setFlyToggleTimerField(int flyToggleTimer);

    FoodStats getFoodStatsField();

    void setFoodStatsField(FoodStats foodStats);

    boolean getForceSpawnField();

    void setForceSpawnField(boolean forceSpawn);

    float getHeightField();

    void setHeightField(float height);

    int getHurtResistantTimeField();

    void setHurtResistantTimeField(int hurtResistantTime);

    int getHurtTimeField();

    void setHurtTimeField(int hurtTime);

    boolean getIgnoreFrustumCheckField();

    void setIgnoreFrustumCheckField(boolean ignoreFrustumCheck);

    boolean getInPortalField();

    void setInPortalField(boolean inPortal);

    boolean getInWaterField();

    void setInWaterField(boolean inWater);

    InventoryPlayer getInventoryField();

    void setInventoryField(InventoryPlayer inventory);

    Container getInventoryContainerField();

    void setInventoryContainerField(Container inventoryContainer);

    boolean getIsAirBorneField();

    void setIsAirBorneField(boolean isAirBorne);

    boolean getIsChangingQuantityOnlyField();

    void setIsChangingQuantityOnlyField(boolean isChangingQuantityOnly);

    boolean getIsCollidedField();

    void setIsCollidedField(boolean isCollided);

    boolean getIsCollidedHorizontallyField();

    void setIsCollidedHorizontallyField(boolean isCollidedHorizontally);

    boolean getIsCollidedVerticallyField();

    void setIsCollidedVerticallyField(boolean isCollidedVertically);

    boolean getIsDeadField();

    void setIsDeadField(boolean isDead);

    boolean getIsImmuneToFireField();

    void setIsImmuneToFireField(boolean isImmuneToFire);

    boolean getIsInWebField();

    void setIsInWebField(boolean isInWeb);

    boolean getIsJumpingField();

    void setIsJumpingField(boolean isJumping);

    boolean getIsSwingInProgressField();

    void setIsSwingInProgressField(boolean isSwingInProgress);

    float getJumpMovementFactorField();

    void setJumpMovementFactorField(float jumpMovementFactor);

    float getLastDamageField();

    void setLastDamageField(float lastDamage);

    int getLastExperienceField();

    void setLastExperienceField(int lastExperience);

    int getLastFoodLevelField();

    void setLastFoodLevelField(int lastFoodLevel);

    float getLastHealthField();

    void setLastHealthField(float lastHealth);

    double getLastTickPosXField();

    void setLastTickPosXField(double lastTickPosX);

    double getLastTickPosYField();

    void setLastTickPosYField(double lastTickPosY);

    double getLastTickPosZField();

    void setLastTickPosZField(double lastTickPosZ);

    float getLimbSwingField();

    void setLimbSwingField(float limbSwing);

    float getLimbSwingAmountField();

    void setLimbSwingAmountField(float limbSwingAmount);

    java.util.List<?> getLoadedChunksField();

    org.apache.logging.log4j.Logger getLoggerField();

    double getManagedPosXField();

    void setManagedPosXField(double managedPosX);

    double getManagedPosZField();

    void setManagedPosZField(double managedPosZ);

    int getMaxHurtResistantTimeField();

    void setMaxHurtResistantTimeField(int maxHurtResistantTime);

    int getMaxHurtTimeField();

    void setMaxHurtTimeField(int maxHurtTime);

    MinecraftServer getMcServerField();

    double getMotionXField();

    void setMotionXField(double motionX);

    double getMotionYField();

    void setMotionYField(double motionY);

    double getMotionZField();

    void setMotionZField(double motionZ);

    float getMoveForwardField();

    void setMoveForwardField(float moveForward);

    float getMoveStrafingField();

    void setMoveStrafingField(float moveStrafing);

    Entity.EnumEntitySize getMyEntitySizeField();

    void setMyEntitySizeField(Entity.EnumEntitySize myEntitySize);

    int getNewPosRotationIncrementsField();

    void setNewPosRotationIncrementsField(int newPosRotationIncrements);

    double getNewPosXField();

    void setNewPosXField(double newPosX);

    double getNewPosYField();

    void setNewPosYField(double newPosY);

    double getNewPosZField();

    void setNewPosZField(double newPosZ);

    double getNewRotationPitchField();

    void setNewRotationPitchField(double newRotationPitch);

    double getNewRotationYawField();

    void setNewRotationYawField(double newRotationYaw);

    boolean getNoClipField();

    void setNoClipField(boolean noClip);

    boolean getOnGroundField();

    void setOnGroundField(boolean onGround);

    Container getOpenContainerField();

    void setOpenContainerField(Container openContainer);

    int getPingField();

    void setPingField(int ping);

    boolean getPlayerConqueredTheEndField();

    void setPlayerConqueredTheEndField(boolean playerConqueredTheEnd);

    ChunkCoordinates getPlayerLocationField();

    void setPlayerLocationField(ChunkCoordinates playerLocation);

    NetHandlerPlayServer getPlayerNetServerHandlerField();

    void setPlayerNetServerHandlerField(NetHandlerPlayServer playerNetServerHandler);

    int getPortalCounterField();

    void setPortalCounterField(int portalCounter);

    double getPosXField();

    void setPosXField(double posX);

    double getPosYField();

    void setPosYField(double posY);

    double getPosZField();

    void setPosZField(double posZ);

    float getPrevCameraPitchField();

    void setPrevCameraPitchField(float prevCameraPitch);

    float getPrevCameraYawField();

    void setPrevCameraYawField(float prevCameraYaw);

    float getPrevDistanceWalkedModifiedField();

    void setPrevDistanceWalkedModifiedField(float prevDistanceWalkedModified);

    float getPrevHealthField();

    void setPrevHealthField(float prevHealth);

    float getPrevLimbSwingAmountField();

    void setPrevLimbSwingAmountField(float prevLimbSwingAmount);

    double getPrevPosXField();

    void setPrevPosXField(double prevPosX);

    double getPrevPosYField();

    void setPrevPosYField(double prevPosY);

    double getPrevPosZField();

    void setPrevPosZField(double prevPosZ);

    float getPrevRenderYawOffsetField();

    void setPrevRenderYawOffsetField(float prevRenderYawOffset);

    float getPrevRotationPitchField();

    void setPrevRotationPitchField(float prevRotationPitch);

    float getPrevRotationYawField();

    void setPrevRotationYawField(float prevRotationYaw);

    float getPrevRotationYawHeadField();

    void setPrevRotationYawHeadField(float prevRotationYawHead);

    float getPrevSwingProgressField();

    void setPrevSwingProgressField(float prevSwingProgress);

    boolean getPreventEntitySpawningField();

    void setPreventEntitySpawningField(boolean preventEntitySpawning);

    java.util.Random getRandField();

    void setRandField(java.util.Random rand);

    float getRandomYawVelocityField();

    void setRandomYawVelocityField(float randomYawVelocity);

    int getRecentlyHitField();

    void setRecentlyHitField(int recentlyHit);

    double getRenderDistanceWeightField();

    void setRenderDistanceWeightField(double renderDistanceWeight);

    float getRenderYawOffsetField();

    void setRenderYawOffsetField(float renderYawOffset);

    Entity getRiddenByEntityField();

    void setRiddenByEntityField(Entity riddenByEntity);

    Entity getRidingEntityField();

    void setRidingEntityField(Entity ridingEntity);

    float getRotationPitchField();

    void setRotationPitchField(float rotationPitch);

    float getRotationYawField();

    void setRotationYawField(float rotationYaw);

    float getRotationYawHeadField();

    void setRotationYawHeadField(float rotationYawHead);

    int getScoreValueField();

    void setScoreValueField(int scoreValue);

    int getServerPosXField();

    void setServerPosXField(int serverPosX);

    int getServerPosYField();

    void setServerPosYField(int serverPosY);

    int getServerPosZField();

    void setServerPosZField(int serverPosZ);

    boolean getSleepingField();

    void setSleepingField(boolean sleeping);

    float getSpeedInAirField();

    void setSpeedInAirField(float speedInAir);

    float getSpeedOnGroundField();

    void setSpeedOnGroundField(float speedOnGround);

    float getStepHeightField();

    void setStepHeightField(float stepHeight);

    float getSwingProgressField();

    void setSwingProgressField(float swingProgress);

    int getSwingProgressIntField();

    void setSwingProgressIntField(int swingProgressInt);

    int getTeleportDirectionField();

    void setTeleportDirectionField(int teleportDirection);

    ItemInWorldManager getTheItemInWorldManagerField();

    int getTicksExistedField();

    void setTicksExistedField(int ticksExisted);

    int getTimeUntilPortalField();

    void setTimeUntilPortalField(int timeUntilPortal);

    String getTranslatorField();

    void setTranslatorField(String translator);

    boolean getVelocityChangedField();

    void setVelocityChangedField(boolean velocityChanged);

    boolean getWasHungryField();

    void setWasHungryField(boolean wasHungry);

    float getWidthField();

    void setWidthField(float width);

    World getWorldObjField();

    void setWorldObjField(World worldObj);

    int getXpCooldownField();

    void setXpCooldownField(int xpCooldown);

    float getYOffsetField();

    void setYOffsetField(float yOffset);

    float getYSizeField();

    void setYSizeField(float ySize);
}
