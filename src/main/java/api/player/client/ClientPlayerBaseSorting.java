package api.player.client;

import java.util.HashMap;
import java.util.Map;

public final class ClientPlayerBaseSorting {

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
    private String[] beforeAddMovementStatSuperiors = null;
    private String[] beforeAddMovementStatInferiors = null;
    private String[] overrideAddMovementStatSuperiors = null;
    private String[] overrideAddMovementStatInferiors = null;
    private String[] afterAddMovementStatSuperiors = null;
    private String[] afterAddMovementStatInferiors = null;
    private String[] beforeAddStatSuperiors = null;
    private String[] beforeAddStatInferiors = null;
    private String[] overrideAddStatSuperiors = null;
    private String[] overrideAddStatInferiors = null;
    private String[] afterAddStatSuperiors = null;
    private String[] afterAddStatInferiors = null;
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
    private String[] beforeCloseScreenSuperiors = null;
    private String[] beforeCloseScreenInferiors = null;
    private String[] overrideCloseScreenSuperiors = null;
    private String[] overrideCloseScreenInferiors = null;
    private String[] afterCloseScreenSuperiors = null;
    private String[] afterCloseScreenInferiors = null;
    private String[] beforeDamageEntitySuperiors = null;
    private String[] beforeDamageEntityInferiors = null;
    private String[] overrideDamageEntitySuperiors = null;
    private String[] overrideDamageEntityInferiors = null;
    private String[] afterDamageEntitySuperiors = null;
    private String[] afterDamageEntityInferiors = null;
    private String[] beforeDisplayGUIBrewingStandSuperiors = null;
    private String[] beforeDisplayGUIBrewingStandInferiors = null;
    private String[] overrideDisplayGUIBrewingStandSuperiors = null;
    private String[] overrideDisplayGUIBrewingStandInferiors = null;
    private String[] afterDisplayGUIBrewingStandSuperiors = null;
    private String[] afterDisplayGUIBrewingStandInferiors = null;
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
    private String[] beforeDisplayGUIEditSignSuperiors = null;
    private String[] beforeDisplayGUIEditSignInferiors = null;
    private String[] overrideDisplayGUIEditSignSuperiors = null;
    private String[] overrideDisplayGUIEditSignInferiors = null;
    private String[] afterDisplayGUIEditSignSuperiors = null;
    private String[] afterDisplayGUIEditSignInferiors = null;
    private String[] beforeDisplayGUIEnchantmentSuperiors = null;
    private String[] beforeDisplayGUIEnchantmentInferiors = null;
    private String[] overrideDisplayGUIEnchantmentSuperiors = null;
    private String[] overrideDisplayGUIEnchantmentInferiors = null;
    private String[] afterDisplayGUIEnchantmentSuperiors = null;
    private String[] afterDisplayGUIEnchantmentInferiors = null;
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
    private String[] beforeDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] beforeDropPlayerItemWithRandomChoiceInferiors = null;
    private String[] overrideDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] overrideDropPlayerItemWithRandomChoiceInferiors = null;
    private String[] afterDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] afterDropPlayerItemWithRandomChoiceInferiors = null;
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
    private String[] beforeGetBedOrientationInDegreesSuperiors = null;
    private String[] beforeGetBedOrientationInDegreesInferiors = null;
    private String[] overrideGetBedOrientationInDegreesSuperiors = null;
    private String[] overrideGetBedOrientationInDegreesInferiors = null;
    private String[] afterGetBedOrientationInDegreesSuperiors = null;
    private String[] afterGetBedOrientationInDegreesInferiors = null;
    private String[] beforeGetBrightnessSuperiors = null;
    private String[] beforeGetBrightnessInferiors = null;
    private String[] overrideGetBrightnessSuperiors = null;
    private String[] overrideGetBrightnessInferiors = null;
    private String[] afterGetBrightnessSuperiors = null;
    private String[] afterGetBrightnessInferiors = null;
    private String[] beforeGetBrightnessForRenderSuperiors = null;
    private String[] beforeGetBrightnessForRenderInferiors = null;
    private String[] overrideGetBrightnessForRenderSuperiors = null;
    private String[] overrideGetBrightnessForRenderInferiors = null;
    private String[] afterGetBrightnessForRenderSuperiors = null;
    private String[] afterGetBrightnessForRenderInferiors = null;
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
    private String[] beforeGetDistanceSqToEntitySuperiors = null;
    private String[] beforeGetDistanceSqToEntityInferiors = null;
    private String[] overrideGetDistanceSqToEntitySuperiors = null;
    private String[] overrideGetDistanceSqToEntityInferiors = null;
    private String[] afterGetDistanceSqToEntitySuperiors = null;
    private String[] afterGetDistanceSqToEntityInferiors = null;
    private String[] beforeGetFOVMultiplierSuperiors = null;
    private String[] beforeGetFOVMultiplierInferiors = null;
    private String[] overrideGetFOVMultiplierSuperiors = null;
    private String[] overrideGetFOVMultiplierInferiors = null;
    private String[] afterGetFOVMultiplierSuperiors = null;
    private String[] afterGetFOVMultiplierInferiors = null;
    private String[] beforeGetHurtSoundSuperiors = null;
    private String[] beforeGetHurtSoundInferiors = null;
    private String[] overrideGetHurtSoundSuperiors = null;
    private String[] overrideGetHurtSoundInferiors = null;
    private String[] afterGetHurtSoundSuperiors = null;
    private String[] afterGetHurtSoundInferiors = null;
    private String[] beforeGetItemIconSuperiors = null;
    private String[] beforeGetItemIconInferiors = null;
    private String[] overrideGetItemIconSuperiors = null;
    private String[] overrideGetItemIconInferiors = null;
    private String[] afterGetItemIconSuperiors = null;
    private String[] afterGetItemIconInferiors = null;
    private String[] beforeGetSleepTimerSuperiors = null;
    private String[] beforeGetSleepTimerInferiors = null;
    private String[] overrideGetSleepTimerSuperiors = null;
    private String[] overrideGetSleepTimerInferiors = null;
    private String[] afterGetSleepTimerSuperiors = null;
    private String[] afterGetSleepTimerInferiors = null;
    private String[] beforeHandleLavaMovementSuperiors = null;
    private String[] beforeHandleLavaMovementInferiors = null;
    private String[] overrideHandleLavaMovementSuperiors = null;
    private String[] overrideHandleLavaMovementInferiors = null;
    private String[] afterHandleLavaMovementSuperiors = null;
    private String[] afterHandleLavaMovementInferiors = null;
    private String[] beforeHandleWaterMovementSuperiors = null;
    private String[] beforeHandleWaterMovementInferiors = null;
    private String[] overrideHandleWaterMovementSuperiors = null;
    private String[] overrideHandleWaterMovementInferiors = null;
    private String[] afterHandleWaterMovementSuperiors = null;
    private String[] afterHandleWaterMovementInferiors = null;
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
    private String[] beforeIsSprintingSuperiors = null;
    private String[] beforeIsSprintingInferiors = null;
    private String[] overrideIsSprintingSuperiors = null;
    private String[] overrideIsSprintingInferiors = null;
    private String[] afterIsSprintingSuperiors = null;
    private String[] afterIsSprintingInferiors = null;
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
    private String[] beforePlayStepSoundSuperiors = null;
    private String[] beforePlayStepSoundInferiors = null;
    private String[] overridePlayStepSoundSuperiors = null;
    private String[] overridePlayStepSoundInferiors = null;
    private String[] afterPlayStepSoundSuperiors = null;
    private String[] afterPlayStepSoundInferiors = null;
    private String[] beforePushOutOfBlocksSuperiors = null;
    private String[] beforePushOutOfBlocksInferiors = null;
    private String[] overridePushOutOfBlocksSuperiors = null;
    private String[] overridePushOutOfBlocksInferiors = null;
    private String[] afterPushOutOfBlocksSuperiors = null;
    private String[] afterPushOutOfBlocksInferiors = null;
    private String[] beforeRayTraceSuperiors = null;
    private String[] beforeRayTraceInferiors = null;
    private String[] overrideRayTraceSuperiors = null;
    private String[] overrideRayTraceInferiors = null;
    private String[] afterRayTraceSuperiors = null;
    private String[] afterRayTraceInferiors = null;
    private String[] beforeReadEntityFromNBTSuperiors = null;
    private String[] beforeReadEntityFromNBTInferiors = null;
    private String[] overrideReadEntityFromNBTSuperiors = null;
    private String[] overrideReadEntityFromNBTInferiors = null;
    private String[] afterReadEntityFromNBTSuperiors = null;
    private String[] afterReadEntityFromNBTInferiors = null;
    private String[] beforeRespawnPlayerSuperiors = null;
    private String[] beforeRespawnPlayerInferiors = null;
    private String[] overrideRespawnPlayerSuperiors = null;
    private String[] overrideRespawnPlayerInferiors = null;
    private String[] afterRespawnPlayerSuperiors = null;
    private String[] afterRespawnPlayerInferiors = null;
    private String[] beforeSetDeadSuperiors = null;
    private String[] beforeSetDeadInferiors = null;
    private String[] overrideSetDeadSuperiors = null;
    private String[] overrideSetDeadInferiors = null;
    private String[] afterSetDeadSuperiors = null;
    private String[] afterSetDeadInferiors = null;
    private String[] beforeSetPlayerSPHealthSuperiors = null;
    private String[] beforeSetPlayerSPHealthInferiors = null;
    private String[] overrideSetPlayerSPHealthSuperiors = null;
    private String[] overrideSetPlayerSPHealthInferiors = null;
    private String[] afterSetPlayerSPHealthSuperiors = null;
    private String[] afterSetPlayerSPHealthInferiors = null;
    private String[] beforeSetPositionAndRotationSuperiors = null;
    private String[] beforeSetPositionAndRotationInferiors = null;
    private String[] overrideSetPositionAndRotationSuperiors = null;
    private String[] overrideSetPositionAndRotationInferiors = null;
    private String[] afterSetPositionAndRotationSuperiors = null;
    private String[] afterSetPositionAndRotationInferiors = null;
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
    private String[] beforeSleepInBedAtSuperiors = null;
    private String[] beforeSleepInBedAtInferiors = null;
    private String[] overrideSleepInBedAtSuperiors = null;
    private String[] overrideSleepInBedAtInferiors = null;
    private String[] afterSleepInBedAtSuperiors = null;
    private String[] afterSleepInBedAtInferiors = null;
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

    public void setDynamicBeforeSuperiors(String value, String[] var2) {
        this.dynamicBeforeSuperiors = this.setDynamic(value, var2, this.dynamicBeforeSuperiors);
    }

    public void setDynamicBeforeInferiors(String value, String[] var2) {
        this.dynamicBeforeInferiors = this.setDynamic(value, var2, this.dynamicBeforeInferiors);
    }

    public void setDynamicOverrideSuperiors(String value, String[] var2) {
        this.dynamicOverrideSuperiors = this.setDynamic(value, var2, this.dynamicOverrideSuperiors);
    }

    public void setDynamicOverrideInferiors(String value, String[] var2) {
        this.dynamicOverrideInferiors = this.setDynamic(value, var2, this.dynamicOverrideInferiors);
    }

    public void setDynamicAfterSuperiors(String value, String[] var2) {
        this.dynamicAfterSuperiors = this.setDynamic(value, var2, this.dynamicAfterSuperiors);
    }

    public void setDynamicAfterInferiors(String value, String[] var2) {
        this.dynamicAfterInferiors = this.setDynamic(value, var2, this.dynamicAfterInferiors);
    }

    private Map<String, String[]> setDynamic(String value, String[] var2, Map<String, String[]> var3) {
        if (value == null) {
            throw new IllegalArgumentException("Parameter 'name' may not be null");
        } else if (var2 == null) {
            if (var3 != null) {
                ((Map<String, String[]>)var3).remove(value);
            }

            return var3;
        } else {
            if (var3 == null) {
                var3 = new HashMap<>();
            }

            ((Map<String, String[]>)var3).put(value, var2);
            return var3;
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

    public String[] getBeforeAddStatSuperiors() {
        return this.beforeAddStatSuperiors;
    }

    public String[] getBeforeAddStatInferiors() {
        return this.beforeAddStatInferiors;
    }

    public String[] getOverrideAddStatSuperiors() {
        return this.overrideAddStatSuperiors;
    }

    public String[] getOverrideAddStatInferiors() {
        return this.overrideAddStatInferiors;
    }

    public String[] getAfterAddStatSuperiors() {
        return this.afterAddStatSuperiors;
    }

    public String[] getAfterAddStatInferiors() {
        return this.afterAddStatInferiors;
    }

    public void setBeforeAddStatSuperiors(String[] value) {
        this.beforeAddStatSuperiors = value;
    }

    public void setBeforeAddStatInferiors(String[] value) {
        this.beforeAddStatInferiors = value;
    }

    public void setOverrideAddStatSuperiors(String[] value) {
        this.overrideAddStatSuperiors = value;
    }

    public void setOverrideAddStatInferiors(String[] value) {
        this.overrideAddStatInferiors = value;
    }

    public void setAfterAddStatSuperiors(String[] value) {
        this.afterAddStatSuperiors = value;
    }

    public void setAfterAddStatInferiors(String[] value) {
        this.afterAddStatInferiors = value;
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

    public String[] getBeforeCloseScreenSuperiors() {
        return this.beforeCloseScreenSuperiors;
    }

    public String[] getBeforeCloseScreenInferiors() {
        return this.beforeCloseScreenInferiors;
    }

    public String[] getOverrideCloseScreenSuperiors() {
        return this.overrideCloseScreenSuperiors;
    }

    public String[] getOverrideCloseScreenInferiors() {
        return this.overrideCloseScreenInferiors;
    }

    public String[] getAfterCloseScreenSuperiors() {
        return this.afterCloseScreenSuperiors;
    }

    public String[] getAfterCloseScreenInferiors() {
        return this.afterCloseScreenInferiors;
    }

    public void setBeforeCloseScreenSuperiors(String[] value) {
        this.beforeCloseScreenSuperiors = value;
    }

    public void setBeforeCloseScreenInferiors(String[] value) {
        this.beforeCloseScreenInferiors = value;
    }

    public void setOverrideCloseScreenSuperiors(String[] value) {
        this.overrideCloseScreenSuperiors = value;
    }

    public void setOverrideCloseScreenInferiors(String[] value) {
        this.overrideCloseScreenInferiors = value;
    }

    public void setAfterCloseScreenSuperiors(String[] value) {
        this.afterCloseScreenSuperiors = value;
    }

    public void setAfterCloseScreenInferiors(String[] value) {
        this.afterCloseScreenInferiors = value;
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

    public String[] getBeforeDisplayGUIBrewingStandSuperiors() {
        return this.beforeDisplayGUIBrewingStandSuperiors;
    }

    public String[] getBeforeDisplayGUIBrewingStandInferiors() {
        return this.beforeDisplayGUIBrewingStandInferiors;
    }

    public String[] getOverrideDisplayGUIBrewingStandSuperiors() {
        return this.overrideDisplayGUIBrewingStandSuperiors;
    }

    public String[] getOverrideDisplayGUIBrewingStandInferiors() {
        return this.overrideDisplayGUIBrewingStandInferiors;
    }

    public String[] getAfterDisplayGUIBrewingStandSuperiors() {
        return this.afterDisplayGUIBrewingStandSuperiors;
    }

    public String[] getAfterDisplayGUIBrewingStandInferiors() {
        return this.afterDisplayGUIBrewingStandInferiors;
    }

    public void setBeforeDisplayGUIBrewingStandSuperiors(String[] value) {
        this.beforeDisplayGUIBrewingStandSuperiors = value;
    }

    public void setBeforeDisplayGUIBrewingStandInferiors(String[] value) {
        this.beforeDisplayGUIBrewingStandInferiors = value;
    }

    public void setOverrideDisplayGUIBrewingStandSuperiors(String[] value) {
        this.overrideDisplayGUIBrewingStandSuperiors = value;
    }

    public void setOverrideDisplayGUIBrewingStandInferiors(String[] value) {
        this.overrideDisplayGUIBrewingStandInferiors = value;
    }

    public void setAfterDisplayGUIBrewingStandSuperiors(String[] value) {
        this.afterDisplayGUIBrewingStandSuperiors = value;
    }

    public void setAfterDisplayGUIBrewingStandInferiors(String[] value) {
        this.afterDisplayGUIBrewingStandInferiors = value;
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

    public String[] getBeforeDisplayGUIEditSignSuperiors() {
        return this.beforeDisplayGUIEditSignSuperiors;
    }

    public String[] getBeforeDisplayGUIEditSignInferiors() {
        return this.beforeDisplayGUIEditSignInferiors;
    }

    public String[] getOverrideDisplayGUIEditSignSuperiors() {
        return this.overrideDisplayGUIEditSignSuperiors;
    }

    public String[] getOverrideDisplayGUIEditSignInferiors() {
        return this.overrideDisplayGUIEditSignInferiors;
    }

    public String[] getAfterDisplayGUIEditSignSuperiors() {
        return this.afterDisplayGUIEditSignSuperiors;
    }

    public String[] getAfterDisplayGUIEditSignInferiors() {
        return this.afterDisplayGUIEditSignInferiors;
    }

    public void setBeforeDisplayGUIEditSignSuperiors(String[] value) {
        this.beforeDisplayGUIEditSignSuperiors = value;
    }

    public void setBeforeDisplayGUIEditSignInferiors(String[] value) {
        this.beforeDisplayGUIEditSignInferiors = value;
    }

    public void setOverrideDisplayGUIEditSignSuperiors(String[] value) {
        this.overrideDisplayGUIEditSignSuperiors = value;
    }

    public void setOverrideDisplayGUIEditSignInferiors(String[] value) {
        this.overrideDisplayGUIEditSignInferiors = value;
    }

    public void setAfterDisplayGUIEditSignSuperiors(String[] value) {
        this.afterDisplayGUIEditSignSuperiors = value;
    }

    public void setAfterDisplayGUIEditSignInferiors(String[] value) {
        this.afterDisplayGUIEditSignInferiors = value;
    }

    public String[] getBeforeDisplayGUIEnchantmentSuperiors() {
        return this.beforeDisplayGUIEnchantmentSuperiors;
    }

    public String[] getBeforeDisplayGUIEnchantmentInferiors() {
        return this.beforeDisplayGUIEnchantmentInferiors;
    }

    public String[] getOverrideDisplayGUIEnchantmentSuperiors() {
        return this.overrideDisplayGUIEnchantmentSuperiors;
    }

    public String[] getOverrideDisplayGUIEnchantmentInferiors() {
        return this.overrideDisplayGUIEnchantmentInferiors;
    }

    public String[] getAfterDisplayGUIEnchantmentSuperiors() {
        return this.afterDisplayGUIEnchantmentSuperiors;
    }

    public String[] getAfterDisplayGUIEnchantmentInferiors() {
        return this.afterDisplayGUIEnchantmentInferiors;
    }

    public void setBeforeDisplayGUIEnchantmentSuperiors(String[] value) {
        this.beforeDisplayGUIEnchantmentSuperiors = value;
    }

    public void setBeforeDisplayGUIEnchantmentInferiors(String[] value) {
        this.beforeDisplayGUIEnchantmentInferiors = value;
    }

    public void setOverrideDisplayGUIEnchantmentSuperiors(String[] value) {
        this.overrideDisplayGUIEnchantmentSuperiors = value;
    }

    public void setOverrideDisplayGUIEnchantmentInferiors(String[] value) {
        this.overrideDisplayGUIEnchantmentInferiors = value;
    }

    public void setAfterDisplayGUIEnchantmentSuperiors(String[] value) {
        this.afterDisplayGUIEnchantmentSuperiors = value;
    }

    public void setAfterDisplayGUIEnchantmentInferiors(String[] value) {
        this.afterDisplayGUIEnchantmentInferiors = value;
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

    public String[] getBeforeDropPlayerItemWithRandomChoiceSuperiors() {
        return this.beforeDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getBeforeDropPlayerItemWithRandomChoiceInferiors() {
        return this.beforeDropPlayerItemWithRandomChoiceInferiors;
    }

    public String[] getOverrideDropPlayerItemWithRandomChoiceSuperiors() {
        return this.overrideDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getOverrideDropPlayerItemWithRandomChoiceInferiors() {
        return this.overrideDropPlayerItemWithRandomChoiceInferiors;
    }

    public String[] getAfterDropPlayerItemWithRandomChoiceSuperiors() {
        return this.afterDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getAfterDropPlayerItemWithRandomChoiceInferiors() {
        return this.afterDropPlayerItemWithRandomChoiceInferiors;
    }

    public void setBeforeDropPlayerItemWithRandomChoiceSuperiors(String[] value) {
        this.beforeDropPlayerItemWithRandomChoiceSuperiors = value;
    }

    public void setBeforeDropPlayerItemWithRandomChoiceInferiors(String[] value) {
        this.beforeDropPlayerItemWithRandomChoiceInferiors = value;
    }

    public void setOverrideDropPlayerItemWithRandomChoiceSuperiors(String[] value) {
        this.overrideDropPlayerItemWithRandomChoiceSuperiors = value;
    }

    public void setOverrideDropPlayerItemWithRandomChoiceInferiors(String[] value) {
        this.overrideDropPlayerItemWithRandomChoiceInferiors = value;
    }

    public void setAfterDropPlayerItemWithRandomChoiceSuperiors(String[] value) {
        this.afterDropPlayerItemWithRandomChoiceSuperiors = value;
    }

    public void setAfterDropPlayerItemWithRandomChoiceInferiors(String[] value) {
        this.afterDropPlayerItemWithRandomChoiceInferiors = value;
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

    public String[] getBeforeGetBedOrientationInDegreesSuperiors() {
        return this.beforeGetBedOrientationInDegreesSuperiors;
    }

    public String[] getBeforeGetBedOrientationInDegreesInferiors() {
        return this.beforeGetBedOrientationInDegreesInferiors;
    }

    public String[] getOverrideGetBedOrientationInDegreesSuperiors() {
        return this.overrideGetBedOrientationInDegreesSuperiors;
    }

    public String[] getOverrideGetBedOrientationInDegreesInferiors() {
        return this.overrideGetBedOrientationInDegreesInferiors;
    }

    public String[] getAfterGetBedOrientationInDegreesSuperiors() {
        return this.afterGetBedOrientationInDegreesSuperiors;
    }

    public String[] getAfterGetBedOrientationInDegreesInferiors() {
        return this.afterGetBedOrientationInDegreesInferiors;
    }

    public void setBeforeGetBedOrientationInDegreesSuperiors(String[] value) {
        this.beforeGetBedOrientationInDegreesSuperiors = value;
    }

    public void setBeforeGetBedOrientationInDegreesInferiors(String[] value) {
        this.beforeGetBedOrientationInDegreesInferiors = value;
    }

    public void setOverrideGetBedOrientationInDegreesSuperiors(String[] value) {
        this.overrideGetBedOrientationInDegreesSuperiors = value;
    }

    public void setOverrideGetBedOrientationInDegreesInferiors(String[] value) {
        this.overrideGetBedOrientationInDegreesInferiors = value;
    }

    public void setAfterGetBedOrientationInDegreesSuperiors(String[] value) {
        this.afterGetBedOrientationInDegreesSuperiors = value;
    }

    public void setAfterGetBedOrientationInDegreesInferiors(String[] value) {
        this.afterGetBedOrientationInDegreesInferiors = value;
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

    public String[] getBeforeGetBrightnessForRenderSuperiors() {
        return this.beforeGetBrightnessForRenderSuperiors;
    }

    public String[] getBeforeGetBrightnessForRenderInferiors() {
        return this.beforeGetBrightnessForRenderInferiors;
    }

    public String[] getOverrideGetBrightnessForRenderSuperiors() {
        return this.overrideGetBrightnessForRenderSuperiors;
    }

    public String[] getOverrideGetBrightnessForRenderInferiors() {
        return this.overrideGetBrightnessForRenderInferiors;
    }

    public String[] getAfterGetBrightnessForRenderSuperiors() {
        return this.afterGetBrightnessForRenderSuperiors;
    }

    public String[] getAfterGetBrightnessForRenderInferiors() {
        return this.afterGetBrightnessForRenderInferiors;
    }

    public void setBeforeGetBrightnessForRenderSuperiors(String[] value) {
        this.beforeGetBrightnessForRenderSuperiors = value;
    }

    public void setBeforeGetBrightnessForRenderInferiors(String[] value) {
        this.beforeGetBrightnessForRenderInferiors = value;
    }

    public void setOverrideGetBrightnessForRenderSuperiors(String[] value) {
        this.overrideGetBrightnessForRenderSuperiors = value;
    }

    public void setOverrideGetBrightnessForRenderInferiors(String[] value) {
        this.overrideGetBrightnessForRenderInferiors = value;
    }

    public void setAfterGetBrightnessForRenderSuperiors(String[] value) {
        this.afterGetBrightnessForRenderSuperiors = value;
    }

    public void setAfterGetBrightnessForRenderInferiors(String[] value) {
        this.afterGetBrightnessForRenderInferiors = value;
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

    public String[] getBeforeGetDistanceSqToEntitySuperiors() {
        return this.beforeGetDistanceSqToEntitySuperiors;
    }

    public String[] getBeforeGetDistanceSqToEntityInferiors() {
        return this.beforeGetDistanceSqToEntityInferiors;
    }

    public String[] getOverrideGetDistanceSqToEntitySuperiors() {
        return this.overrideGetDistanceSqToEntitySuperiors;
    }

    public String[] getOverrideGetDistanceSqToEntityInferiors() {
        return this.overrideGetDistanceSqToEntityInferiors;
    }

    public String[] getAfterGetDistanceSqToEntitySuperiors() {
        return this.afterGetDistanceSqToEntitySuperiors;
    }

    public String[] getAfterGetDistanceSqToEntityInferiors() {
        return this.afterGetDistanceSqToEntityInferiors;
    }

    public void setBeforeGetDistanceSqToEntitySuperiors(String[] value) {
        this.beforeGetDistanceSqToEntitySuperiors = value;
    }

    public void setBeforeGetDistanceSqToEntityInferiors(String[] value) {
        this.beforeGetDistanceSqToEntityInferiors = value;
    }

    public void setOverrideGetDistanceSqToEntitySuperiors(String[] value) {
        this.overrideGetDistanceSqToEntitySuperiors = value;
    }

    public void setOverrideGetDistanceSqToEntityInferiors(String[] value) {
        this.overrideGetDistanceSqToEntityInferiors = value;
    }

    public void setAfterGetDistanceSqToEntitySuperiors(String[] value) {
        this.afterGetDistanceSqToEntitySuperiors = value;
    }

    public void setAfterGetDistanceSqToEntityInferiors(String[] value) {
        this.afterGetDistanceSqToEntityInferiors = value;
    }

    public String[] getBeforeGetFOVMultiplierSuperiors() {
        return this.beforeGetFOVMultiplierSuperiors;
    }

    public String[] getBeforeGetFOVMultiplierInferiors() {
        return this.beforeGetFOVMultiplierInferiors;
    }

    public String[] getOverrideGetFOVMultiplierSuperiors() {
        return this.overrideGetFOVMultiplierSuperiors;
    }

    public String[] getOverrideGetFOVMultiplierInferiors() {
        return this.overrideGetFOVMultiplierInferiors;
    }

    public String[] getAfterGetFOVMultiplierSuperiors() {
        return this.afterGetFOVMultiplierSuperiors;
    }

    public String[] getAfterGetFOVMultiplierInferiors() {
        return this.afterGetFOVMultiplierInferiors;
    }

    public void setBeforeGetFOVMultiplierSuperiors(String[] value) {
        this.beforeGetFOVMultiplierSuperiors = value;
    }

    public void setBeforeGetFOVMultiplierInferiors(String[] value) {
        this.beforeGetFOVMultiplierInferiors = value;
    }

    public void setOverrideGetFOVMultiplierSuperiors(String[] value) {
        this.overrideGetFOVMultiplierSuperiors = value;
    }

    public void setOverrideGetFOVMultiplierInferiors(String[] value) {
        this.overrideGetFOVMultiplierInferiors = value;
    }

    public void setAfterGetFOVMultiplierSuperiors(String[] value) {
        this.afterGetFOVMultiplierSuperiors = value;
    }

    public void setAfterGetFOVMultiplierInferiors(String[] value) {
        this.afterGetFOVMultiplierInferiors = value;
    }

    public String[] getBeforeGetHurtSoundSuperiors() {
        return this.beforeGetHurtSoundSuperiors;
    }

    public String[] getBeforeGetHurtSoundInferiors() {
        return this.beforeGetHurtSoundInferiors;
    }

    public String[] getOverrideGetHurtSoundSuperiors() {
        return this.overrideGetHurtSoundSuperiors;
    }

    public String[] getOverrideGetHurtSoundInferiors() {
        return this.overrideGetHurtSoundInferiors;
    }

    public String[] getAfterGetHurtSoundSuperiors() {
        return this.afterGetHurtSoundSuperiors;
    }

    public String[] getAfterGetHurtSoundInferiors() {
        return this.afterGetHurtSoundInferiors;
    }

    public void setBeforeGetHurtSoundSuperiors(String[] value) {
        this.beforeGetHurtSoundSuperiors = value;
    }

    public void setBeforeGetHurtSoundInferiors(String[] value) {
        this.beforeGetHurtSoundInferiors = value;
    }

    public void setOverrideGetHurtSoundSuperiors(String[] value) {
        this.overrideGetHurtSoundSuperiors = value;
    }

    public void setOverrideGetHurtSoundInferiors(String[] value) {
        this.overrideGetHurtSoundInferiors = value;
    }

    public void setAfterGetHurtSoundSuperiors(String[] value) {
        this.afterGetHurtSoundSuperiors = value;
    }

    public void setAfterGetHurtSoundInferiors(String[] value) {
        this.afterGetHurtSoundInferiors = value;
    }

    public String[] getBeforeGetItemIconSuperiors() {
        return this.beforeGetItemIconSuperiors;
    }

    public String[] getBeforeGetItemIconInferiors() {
        return this.beforeGetItemIconInferiors;
    }

    public String[] getOverrideGetItemIconSuperiors() {
        return this.overrideGetItemIconSuperiors;
    }

    public String[] getOverrideGetItemIconInferiors() {
        return this.overrideGetItemIconInferiors;
    }

    public String[] getAfterGetItemIconSuperiors() {
        return this.afterGetItemIconSuperiors;
    }

    public String[] getAfterGetItemIconInferiors() {
        return this.afterGetItemIconInferiors;
    }

    public void setBeforeGetItemIconSuperiors(String[] value) {
        this.beforeGetItemIconSuperiors = value;
    }

    public void setBeforeGetItemIconInferiors(String[] value) {
        this.beforeGetItemIconInferiors = value;
    }

    public void setOverrideGetItemIconSuperiors(String[] value) {
        this.overrideGetItemIconSuperiors = value;
    }

    public void setOverrideGetItemIconInferiors(String[] value) {
        this.overrideGetItemIconInferiors = value;
    }

    public void setAfterGetItemIconSuperiors(String[] value) {
        this.afterGetItemIconSuperiors = value;
    }

    public void setAfterGetItemIconInferiors(String[] value) {
        this.afterGetItemIconInferiors = value;
    }

    public String[] getBeforeGetSleepTimerSuperiors() {
        return this.beforeGetSleepTimerSuperiors;
    }

    public String[] getBeforeGetSleepTimerInferiors() {
        return this.beforeGetSleepTimerInferiors;
    }

    public String[] getOverrideGetSleepTimerSuperiors() {
        return this.overrideGetSleepTimerSuperiors;
    }

    public String[] getOverrideGetSleepTimerInferiors() {
        return this.overrideGetSleepTimerInferiors;
    }

    public String[] getAfterGetSleepTimerSuperiors() {
        return this.afterGetSleepTimerSuperiors;
    }

    public String[] getAfterGetSleepTimerInferiors() {
        return this.afterGetSleepTimerInferiors;
    }

    public void setBeforeGetSleepTimerSuperiors(String[] value) {
        this.beforeGetSleepTimerSuperiors = value;
    }

    public void setBeforeGetSleepTimerInferiors(String[] value) {
        this.beforeGetSleepTimerInferiors = value;
    }

    public void setOverrideGetSleepTimerSuperiors(String[] value) {
        this.overrideGetSleepTimerSuperiors = value;
    }

    public void setOverrideGetSleepTimerInferiors(String[] value) {
        this.overrideGetSleepTimerInferiors = value;
    }

    public void setAfterGetSleepTimerSuperiors(String[] value) {
        this.afterGetSleepTimerSuperiors = value;
    }

    public void setAfterGetSleepTimerInferiors(String[] value) {
        this.afterGetSleepTimerInferiors = value;
    }

    public String[] getBeforeHandleLavaMovementSuperiors() {
        return this.beforeHandleLavaMovementSuperiors;
    }

    public String[] getBeforeHandleLavaMovementInferiors() {
        return this.beforeHandleLavaMovementInferiors;
    }

    public String[] getOverrideHandleLavaMovementSuperiors() {
        return this.overrideHandleLavaMovementSuperiors;
    }

    public String[] getOverrideHandleLavaMovementInferiors() {
        return this.overrideHandleLavaMovementInferiors;
    }

    public String[] getAfterHandleLavaMovementSuperiors() {
        return this.afterHandleLavaMovementSuperiors;
    }

    public String[] getAfterHandleLavaMovementInferiors() {
        return this.afterHandleLavaMovementInferiors;
    }

    public void setBeforeHandleLavaMovementSuperiors(String[] value) {
        this.beforeHandleLavaMovementSuperiors = value;
    }

    public void setBeforeHandleLavaMovementInferiors(String[] value) {
        this.beforeHandleLavaMovementInferiors = value;
    }

    public void setOverrideHandleLavaMovementSuperiors(String[] value) {
        this.overrideHandleLavaMovementSuperiors = value;
    }

    public void setOverrideHandleLavaMovementInferiors(String[] value) {
        this.overrideHandleLavaMovementInferiors = value;
    }

    public void setAfterHandleLavaMovementSuperiors(String[] value) {
        this.afterHandleLavaMovementSuperiors = value;
    }

    public void setAfterHandleLavaMovementInferiors(String[] value) {
        this.afterHandleLavaMovementInferiors = value;
    }

    public String[] getBeforeHandleWaterMovementSuperiors() {
        return this.beforeHandleWaterMovementSuperiors;
    }

    public String[] getBeforeHandleWaterMovementInferiors() {
        return this.beforeHandleWaterMovementInferiors;
    }

    public String[] getOverrideHandleWaterMovementSuperiors() {
        return this.overrideHandleWaterMovementSuperiors;
    }

    public String[] getOverrideHandleWaterMovementInferiors() {
        return this.overrideHandleWaterMovementInferiors;
    }

    public String[] getAfterHandleWaterMovementSuperiors() {
        return this.afterHandleWaterMovementSuperiors;
    }

    public String[] getAfterHandleWaterMovementInferiors() {
        return this.afterHandleWaterMovementInferiors;
    }

    public void setBeforeHandleWaterMovementSuperiors(String[] value) {
        this.beforeHandleWaterMovementSuperiors = value;
    }

    public void setBeforeHandleWaterMovementInferiors(String[] value) {
        this.beforeHandleWaterMovementInferiors = value;
    }

    public void setOverrideHandleWaterMovementSuperiors(String[] value) {
        this.overrideHandleWaterMovementSuperiors = value;
    }

    public void setOverrideHandleWaterMovementInferiors(String[] value) {
        this.overrideHandleWaterMovementInferiors = value;
    }

    public void setAfterHandleWaterMovementSuperiors(String[] value) {
        this.afterHandleWaterMovementSuperiors = value;
    }

    public void setAfterHandleWaterMovementInferiors(String[] value) {
        this.afterHandleWaterMovementInferiors = value;
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

    public String[] getBeforeIsSprintingSuperiors() {
        return this.beforeIsSprintingSuperiors;
    }

    public String[] getBeforeIsSprintingInferiors() {
        return this.beforeIsSprintingInferiors;
    }

    public String[] getOverrideIsSprintingSuperiors() {
        return this.overrideIsSprintingSuperiors;
    }

    public String[] getOverrideIsSprintingInferiors() {
        return this.overrideIsSprintingInferiors;
    }

    public String[] getAfterIsSprintingSuperiors() {
        return this.afterIsSprintingSuperiors;
    }

    public String[] getAfterIsSprintingInferiors() {
        return this.afterIsSprintingInferiors;
    }

    public void setBeforeIsSprintingSuperiors(String[] value) {
        this.beforeIsSprintingSuperiors = value;
    }

    public void setBeforeIsSprintingInferiors(String[] value) {
        this.beforeIsSprintingInferiors = value;
    }

    public void setOverrideIsSprintingSuperiors(String[] value) {
        this.overrideIsSprintingSuperiors = value;
    }

    public void setOverrideIsSprintingInferiors(String[] value) {
        this.overrideIsSprintingInferiors = value;
    }

    public void setAfterIsSprintingSuperiors(String[] value) {
        this.afterIsSprintingSuperiors = value;
    }

    public void setAfterIsSprintingInferiors(String[] value) {
        this.afterIsSprintingInferiors = value;
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

    public String[] getBeforePlayStepSoundSuperiors() {
        return this.beforePlayStepSoundSuperiors;
    }

    public String[] getBeforePlayStepSoundInferiors() {
        return this.beforePlayStepSoundInferiors;
    }

    public String[] getOverridePlayStepSoundSuperiors() {
        return this.overridePlayStepSoundSuperiors;
    }

    public String[] getOverridePlayStepSoundInferiors() {
        return this.overridePlayStepSoundInferiors;
    }

    public String[] getAfterPlayStepSoundSuperiors() {
        return this.afterPlayStepSoundSuperiors;
    }

    public String[] getAfterPlayStepSoundInferiors() {
        return this.afterPlayStepSoundInferiors;
    }

    public void setBeforePlayStepSoundSuperiors(String[] value) {
        this.beforePlayStepSoundSuperiors = value;
    }

    public void setBeforePlayStepSoundInferiors(String[] value) {
        this.beforePlayStepSoundInferiors = value;
    }

    public void setOverridePlayStepSoundSuperiors(String[] value) {
        this.overridePlayStepSoundSuperiors = value;
    }

    public void setOverridePlayStepSoundInferiors(String[] value) {
        this.overridePlayStepSoundInferiors = value;
    }

    public void setAfterPlayStepSoundSuperiors(String[] value) {
        this.afterPlayStepSoundSuperiors = value;
    }

    public void setAfterPlayStepSoundInferiors(String[] value) {
        this.afterPlayStepSoundInferiors = value;
    }

    public String[] getBeforePushOutOfBlocksSuperiors() {
        return this.beforePushOutOfBlocksSuperiors;
    }

    public String[] getBeforePushOutOfBlocksInferiors() {
        return this.beforePushOutOfBlocksInferiors;
    }

    public String[] getOverridePushOutOfBlocksSuperiors() {
        return this.overridePushOutOfBlocksSuperiors;
    }

    public String[] getOverridePushOutOfBlocksInferiors() {
        return this.overridePushOutOfBlocksInferiors;
    }

    public String[] getAfterPushOutOfBlocksSuperiors() {
        return this.afterPushOutOfBlocksSuperiors;
    }

    public String[] getAfterPushOutOfBlocksInferiors() {
        return this.afterPushOutOfBlocksInferiors;
    }

    public void setBeforePushOutOfBlocksSuperiors(String[] value) {
        this.beforePushOutOfBlocksSuperiors = value;
    }

    public void setBeforePushOutOfBlocksInferiors(String[] value) {
        this.beforePushOutOfBlocksInferiors = value;
    }

    public void setOverridePushOutOfBlocksSuperiors(String[] value) {
        this.overridePushOutOfBlocksSuperiors = value;
    }

    public void setOverridePushOutOfBlocksInferiors(String[] value) {
        this.overridePushOutOfBlocksInferiors = value;
    }

    public void setAfterPushOutOfBlocksSuperiors(String[] value) {
        this.afterPushOutOfBlocksSuperiors = value;
    }

    public void setAfterPushOutOfBlocksInferiors(String[] value) {
        this.afterPushOutOfBlocksInferiors = value;
    }

    public String[] getBeforeRayTraceSuperiors() {
        return this.beforeRayTraceSuperiors;
    }

    public String[] getBeforeRayTraceInferiors() {
        return this.beforeRayTraceInferiors;
    }

    public String[] getOverrideRayTraceSuperiors() {
        return this.overrideRayTraceSuperiors;
    }

    public String[] getOverrideRayTraceInferiors() {
        return this.overrideRayTraceInferiors;
    }

    public String[] getAfterRayTraceSuperiors() {
        return this.afterRayTraceSuperiors;
    }

    public String[] getAfterRayTraceInferiors() {
        return this.afterRayTraceInferiors;
    }

    public void setBeforeRayTraceSuperiors(String[] value) {
        this.beforeRayTraceSuperiors = value;
    }

    public void setBeforeRayTraceInferiors(String[] value) {
        this.beforeRayTraceInferiors = value;
    }

    public void setOverrideRayTraceSuperiors(String[] value) {
        this.overrideRayTraceSuperiors = value;
    }

    public void setOverrideRayTraceInferiors(String[] value) {
        this.overrideRayTraceInferiors = value;
    }

    public void setAfterRayTraceSuperiors(String[] value) {
        this.afterRayTraceSuperiors = value;
    }

    public void setAfterRayTraceInferiors(String[] value) {
        this.afterRayTraceInferiors = value;
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

    public String[] getBeforeRespawnPlayerSuperiors() {
        return this.beforeRespawnPlayerSuperiors;
    }

    public String[] getBeforeRespawnPlayerInferiors() {
        return this.beforeRespawnPlayerInferiors;
    }

    public String[] getOverrideRespawnPlayerSuperiors() {
        return this.overrideRespawnPlayerSuperiors;
    }

    public String[] getOverrideRespawnPlayerInferiors() {
        return this.overrideRespawnPlayerInferiors;
    }

    public String[] getAfterRespawnPlayerSuperiors() {
        return this.afterRespawnPlayerSuperiors;
    }

    public String[] getAfterRespawnPlayerInferiors() {
        return this.afterRespawnPlayerInferiors;
    }

    public void setBeforeRespawnPlayerSuperiors(String[] value) {
        this.beforeRespawnPlayerSuperiors = value;
    }

    public void setBeforeRespawnPlayerInferiors(String[] value) {
        this.beforeRespawnPlayerInferiors = value;
    }

    public void setOverrideRespawnPlayerSuperiors(String[] value) {
        this.overrideRespawnPlayerSuperiors = value;
    }

    public void setOverrideRespawnPlayerInferiors(String[] value) {
        this.overrideRespawnPlayerInferiors = value;
    }

    public void setAfterRespawnPlayerSuperiors(String[] value) {
        this.afterRespawnPlayerSuperiors = value;
    }

    public void setAfterRespawnPlayerInferiors(String[] value) {
        this.afterRespawnPlayerInferiors = value;
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

    public String[] getBeforeSetPlayerSPHealthSuperiors() {
        return this.beforeSetPlayerSPHealthSuperiors;
    }

    public String[] getBeforeSetPlayerSPHealthInferiors() {
        return this.beforeSetPlayerSPHealthInferiors;
    }

    public String[] getOverrideSetPlayerSPHealthSuperiors() {
        return this.overrideSetPlayerSPHealthSuperiors;
    }

    public String[] getOverrideSetPlayerSPHealthInferiors() {
        return this.overrideSetPlayerSPHealthInferiors;
    }

    public String[] getAfterSetPlayerSPHealthSuperiors() {
        return this.afterSetPlayerSPHealthSuperiors;
    }

    public String[] getAfterSetPlayerSPHealthInferiors() {
        return this.afterSetPlayerSPHealthInferiors;
    }

    public void setBeforeSetPlayerSPHealthSuperiors(String[] value) {
        this.beforeSetPlayerSPHealthSuperiors = value;
    }

    public void setBeforeSetPlayerSPHealthInferiors(String[] value) {
        this.beforeSetPlayerSPHealthInferiors = value;
    }

    public void setOverrideSetPlayerSPHealthSuperiors(String[] value) {
        this.overrideSetPlayerSPHealthSuperiors = value;
    }

    public void setOverrideSetPlayerSPHealthInferiors(String[] value) {
        this.overrideSetPlayerSPHealthInferiors = value;
    }

    public void setAfterSetPlayerSPHealthSuperiors(String[] value) {
        this.afterSetPlayerSPHealthSuperiors = value;
    }

    public void setAfterSetPlayerSPHealthInferiors(String[] value) {
        this.afterSetPlayerSPHealthInferiors = value;
    }

    public String[] getBeforeSetPositionAndRotationSuperiors() {
        return this.beforeSetPositionAndRotationSuperiors;
    }

    public String[] getBeforeSetPositionAndRotationInferiors() {
        return this.beforeSetPositionAndRotationInferiors;
    }

    public String[] getOverrideSetPositionAndRotationSuperiors() {
        return this.overrideSetPositionAndRotationSuperiors;
    }

    public String[] getOverrideSetPositionAndRotationInferiors() {
        return this.overrideSetPositionAndRotationInferiors;
    }

    public String[] getAfterSetPositionAndRotationSuperiors() {
        return this.afterSetPositionAndRotationSuperiors;
    }

    public String[] getAfterSetPositionAndRotationInferiors() {
        return this.afterSetPositionAndRotationInferiors;
    }

    public void setBeforeSetPositionAndRotationSuperiors(String[] value) {
        this.beforeSetPositionAndRotationSuperiors = value;
    }

    public void setBeforeSetPositionAndRotationInferiors(String[] value) {
        this.beforeSetPositionAndRotationInferiors = value;
    }

    public void setOverrideSetPositionAndRotationSuperiors(String[] value) {
        this.overrideSetPositionAndRotationSuperiors = value;
    }

    public void setOverrideSetPositionAndRotationInferiors(String[] value) {
        this.overrideSetPositionAndRotationInferiors = value;
    }

    public void setAfterSetPositionAndRotationSuperiors(String[] value) {
        this.afterSetPositionAndRotationSuperiors = value;
    }

    public void setAfterSetPositionAndRotationInferiors(String[] value) {
        this.afterSetPositionAndRotationInferiors = value;
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

    public String[] getBeforeSleepInBedAtSuperiors() {
        return this.beforeSleepInBedAtSuperiors;
    }

    public String[] getBeforeSleepInBedAtInferiors() {
        return this.beforeSleepInBedAtInferiors;
    }

    public String[] getOverrideSleepInBedAtSuperiors() {
        return this.overrideSleepInBedAtSuperiors;
    }

    public String[] getOverrideSleepInBedAtInferiors() {
        return this.overrideSleepInBedAtInferiors;
    }

    public String[] getAfterSleepInBedAtSuperiors() {
        return this.afterSleepInBedAtSuperiors;
    }

    public String[] getAfterSleepInBedAtInferiors() {
        return this.afterSleepInBedAtInferiors;
    }

    public void setBeforeSleepInBedAtSuperiors(String[] value) {
        this.beforeSleepInBedAtSuperiors = value;
    }

    public void setBeforeSleepInBedAtInferiors(String[] value) {
        this.beforeSleepInBedAtInferiors = value;
    }

    public void setOverrideSleepInBedAtSuperiors(String[] value) {
        this.overrideSleepInBedAtSuperiors = value;
    }

    public void setOverrideSleepInBedAtInferiors(String[] value) {
        this.overrideSleepInBedAtInferiors = value;
    }

    public void setAfterSleepInBedAtSuperiors(String[] value) {
        this.afterSleepInBedAtSuperiors = value;
    }

    public void setAfterSleepInBedAtInferiors(String[] value) {
        this.afterSleepInBedAtInferiors = value;
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
