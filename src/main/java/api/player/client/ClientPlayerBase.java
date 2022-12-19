package api.player.client;

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

public abstract class ClientPlayerBase {

    protected final EntityPlayerSP player;
    protected final IClientPlayer playerAPI;
    private final ClientPlayerAPI internalClientPlayerAPI;

    public ClientPlayerBase(ClientPlayerAPI playerAPI) {
        this.internalClientPlayerAPI = playerAPI;
        this.playerAPI = playerAPI.player;
        this.player = playerAPI.player.getEntityPlayerSP();
    }

    public void beforeBaseAttach(boolean onTheFly) {}

    public void afterBaseAttach(boolean onTheFly) {}

    public void beforeLocalConstructing(Minecraft var1, World var2, Session var3, int var4) {}

    public void afterLocalConstructing(Minecraft var1, World var2, Session var3, int var4) {}

    public void beforeBaseDetach(boolean onTheFly) {}

    public void afterBaseDetach(boolean onTheFly) {}

    public Object dynamic(String key, Object[] parameters) {
        return this.internalClientPlayerAPI.dynamicOverwritten(key, parameters, this);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeAddExhaustion(float var1) {}

    public void addExhaustion(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenAddExhaustion(this);
        if (var2 == null) {
            this.playerAPI.localAddExhaustion(var1);
        } else if (var2 != this) {
            var2.addExhaustion(var1);
        }
    }

    public void afterAddExhaustion(float var1) {}

    public void beforeAddMovementStat(double var1, double var3, double var5) {}

    public void addMovementStat(double var1, double var3, double var5) {
        ClientPlayerBase var7 = this.internalClientPlayerAPI.GetOverwrittenAddMovementStat(this);
        if (var7 == null) {
            this.playerAPI.localAddMovementStat(var1, var3, var5);
        } else if (var7 != this) {
            var7.addMovementStat(var1, var3, var5);
        }
    }

    public void afterAddMovementStat(double var1, double var3, double var5) {}

    public void beforeAddStat(StatBase var1, int var2) {}

    public void addStat(StatBase var1, int var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenAddStat(this);
        if (var3 == null) {
            this.playerAPI.localAddStat(var1, var2);
        } else if (var3 != this) {
            var3.addStat(var1, var2);
        }
    }

    public void afterAddStat(StatBase var1, int var2) {}

    public void beforeAttackEntityFrom(DamageSource var1, float var2) {}

    public boolean attackEntityFrom(DamageSource var1, float var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean var4;
        if (var3 == null) {
            var4 = this.playerAPI.localAttackEntityFrom(var1, var2);
        } else if (var3 != this) {
            var4 = var3.attackEntityFrom(var1, var2);
        } else {
            var4 = false;
        }

        return var4;
    }

    public void afterAttackEntityFrom(DamageSource var1, float var2) {}

    public void beforeAttackTargetEntityWithCurrentItem(Entity var1) {}

    public void attackTargetEntityWithCurrentItem(Entity var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if (var2 == null) {
            this.playerAPI.localAttackTargetEntityWithCurrentItem(var1);
        } else if (var2 != this) {
            var2.attackTargetEntityWithCurrentItem(var1);
        }
    }

    public void afterAttackTargetEntityWithCurrentItem(Entity var1) {}

    public void beforeCanBreatheUnderwater() {}

    public boolean canBreatheUnderwater() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenCanBreatheUnderwater(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localCanBreatheUnderwater();
        } else if (var1 != this) {
            var2 = var1.canBreatheUnderwater();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterCanBreatheUnderwater() {}

    public void beforeCanHarvestBlock(Block var1) {}

    public boolean canHarvestBlock(Block var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean var3;
        if (var2 == null) {
            var3 = this.playerAPI.localCanHarvestBlock(var1);
        } else if (var2 != this) {
            var3 = var2.canHarvestBlock(var1);
        } else {
            var3 = false;
        }

        return var3;
    }

    public void afterCanHarvestBlock(Block var1) {}

    public void beforeCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {}

    public boolean canPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
        ClientPlayerBase var6 = this.internalClientPlayerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean var7;
        if (var6 == null) {
            var7 = this.playerAPI.localCanPlayerEdit(var1, var2, var3, var4, var5);
        } else if (var6 != this) {
            var7 = var6.canPlayerEdit(var1, var2, var3, var4, var5);
        } else {
            var7 = false;
        }

        return var7;
    }

    public void afterCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {}

    public void beforeCanTriggerWalking() {}

    public boolean canTriggerWalking() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localCanTriggerWalking();
        } else if (var1 != this) {
            var2 = var1.canTriggerWalking();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterCanTriggerWalking() {}

    public void beforeCloseScreen() {}

    public void closeScreen() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenCloseScreen(this);
        if (var1 == null) {
            this.playerAPI.localCloseScreen();
        } else if (var1 != this) {
            var1.closeScreen();
        }
    }

    public void afterCloseScreen() {}

    public void beforeDamageEntity(DamageSource var1, float var2) {}

    public void damageEntity(DamageSource var1, float var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenDamageEntity(this);
        if (var3 == null) {
            this.playerAPI.localDamageEntity(var1, var2);
        } else if (var3 != this) {
            var3.damageEntity(var1, var2);
        }
    }

    public void afterDamageEntity(DamageSource var1, float var2) {}

    public void beforeDisplayGUIBrewingStand(TileEntityBrewingStand var1) {}

    public void displayGUIBrewingStand(TileEntityBrewingStand var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIBrewingStand(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIBrewingStand(var1);
        } else if (var2 != this) {
            var2.displayGUIBrewingStand(var1);
        }
    }

    public void afterDisplayGUIBrewingStand(TileEntityBrewingStand var1) {}

    public void beforeDisplayGUIChest(IInventory var1) {}

    public void displayGUIChest(IInventory var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIChest(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIChest(var1);
        } else if (var2 != this) {
            var2.displayGUIChest(var1);
        }
    }

    public void afterDisplayGUIChest(IInventory var1) {}

    public void beforeDisplayGUIDispenser(TileEntityDispenser var1) {}

    public void displayGUIDispenser(TileEntityDispenser var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIDispenser(var1);
        } else if (var2 != this) {
            var2.displayGUIDispenser(var1);
        }
    }

    public void afterDisplayGUIDispenser(TileEntityDispenser var1) {}

    public void beforeDisplayGUIEditSign(TileEntity var1) {}

    public void displayGUIEditSign(TileEntity var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIEditSign(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIEditSign(var1);
        } else if (var2 != this) {
            var2.displayGUIEditSign(var1);
        }
    }

    public void afterDisplayGUIEditSign(TileEntity var1) {}

    public void beforeDisplayGUIEnchantment(int var1, int var2, int var3, String var4) {}

    public void displayGUIEnchantment(int var1, int var2, int var3, String var4) {
        ClientPlayerBase var5 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIEnchantment(this);
        if (var5 == null) {
            this.playerAPI.localDisplayGUIEnchantment(var1, var2, var3, var4);
        } else if (var5 != this) {
            var5.displayGUIEnchantment(var1, var2, var3, var4);
        }
    }

    public void afterDisplayGUIEnchantment(int var1, int var2, int var3, String var4) {}

    public void beforeDisplayGUIFurnace(TileEntityFurnace var1) {}

    public void displayGUIFurnace(TileEntityFurnace var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIFurnace(var1);
        } else if (var2 != this) {
            var2.displayGUIFurnace(var1);
        }
    }

    public void afterDisplayGUIFurnace(TileEntityFurnace var1) {}

    public void beforeDisplayGUIWorkbench(int var1, int var2, int var3) {}

    public void displayGUIWorkbench(int var1, int var2, int var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIWorkbench(this);
        if (var4 == null) {
            this.playerAPI.localDisplayGUIWorkbench(var1, var2, var3);
        } else if (var4 != this) {
            var4.displayGUIWorkbench(var1, var2, var3);
        }
    }

    public void afterDisplayGUIWorkbench(int var1, int var2, int var3) {}

    public void beforeDropOneItem(boolean var1) {}

    public EntityItem dropOneItem(boolean var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenDropOneItem(this);
        EntityItem var3;
        if (var2 == null) {
            var3 = this.playerAPI.localDropOneItem(var1);
        } else if (var2 != this) {
            var3 = var2.dropOneItem(var1);
        } else {
            var3 = null;
        }

        return var3;
    }

    public void afterDropOneItem(boolean var1) {}

    public void beforeDropPlayerItem(ItemStack var1, boolean var2) {}

    public EntityItem dropPlayerItem(ItemStack var1, boolean var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem var4;
        if (var3 == null) {
            var4 = this.playerAPI.localDropPlayerItem(var1, var2);
        } else if (var3 != this) {
            var4 = var3.dropPlayerItem(var1, var2);
        } else {
            var4 = null;
        }

        return var4;
    }

    public void afterDropPlayerItem(ItemStack var1, boolean var2) {}

    public void beforeDropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3) {}

    public EntityItem dropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItemWithRandomChoice(this);
        EntityItem var5;
        if (var4 == null) {
            var5 = this.playerAPI.localDropPlayerItemWithRandomChoice(var1, var2, var3);
        } else if (var4 != this) {
            var5 = var4.dropPlayerItemWithRandomChoice(var1, var2, var3);
        } else {
            var5 = null;
        }

        return var5;
    }

    public void afterDropPlayerItemWithRandomChoice(ItemStack var1, boolean var2, boolean var3) {}

    public void beforeFall(float var1) {}

    public void fall(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenFall(this);
        if (var2 == null) {
            this.playerAPI.localFall(var1);
        } else if (var2 != this) {
            var2.fall(var1);
        }
    }

    public void afterFall(float var1) {}

    public void beforeGetAIMoveSpeed() {}

    public float getAIMoveSpeed() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenGetAIMoveSpeed(this);
        float var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetAIMoveSpeed();
        } else if (var1 != this) {
            var2 = var1.getAIMoveSpeed();
        } else {
            var2 = 0.0F;
        }

        return var2;
    }

    public void afterGetAIMoveSpeed() {}

    public void beforeGetBedOrientationInDegrees() {}

    public float getBedOrientationInDegrees() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenGetBedOrientationInDegrees(this);
        float var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetBedOrientationInDegrees();
        } else if (var1 != this) {
            var2 = var1.getBedOrientationInDegrees();
        } else {
            var2 = 0.0F;
        }

        return var2;
    }

    public void afterGetBedOrientationInDegrees() {}

    public void beforeGetBrightness(float var1) {}

    public float getBrightness(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenGetBrightness(this);
        float var3;
        if (var2 == null) {
            var3 = this.playerAPI.localGetBrightness(var1);
        } else if (var2 != this) {
            var3 = var2.getBrightness(var1);
        } else {
            var3 = 0.0F;
        }

        return var3;
    }

    public void afterGetBrightness(float var1) {}

    public void beforeGetBrightnessForRender(float var1) {}

    public int getBrightnessForRender(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenGetBrightnessForRender(this);
        int var3;
        if (var2 == null) {
            var3 = this.playerAPI.localGetBrightnessForRender(var1);
        } else if (var2 != this) {
            var3 = var2.getBrightnessForRender(var1);
        } else {
            var3 = 0;
        }

        return var3;
    }

    public void afterGetBrightnessForRender(float var1) {}

    public void beforeGetCurrentPlayerStrVsBlock(Block var1, boolean var2) {}

    public float getCurrentPlayerStrVsBlock(Block var1, boolean var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float var4;
        if (var3 == null) {
            var4 = this.playerAPI.localGetCurrentPlayerStrVsBlock(var1, var2);
        } else if (var3 != this) {
            var4 = var3.getCurrentPlayerStrVsBlock(var1, var2);
        } else {
            var4 = 0.0F;
        }

        return var4;
    }

    public void afterGetCurrentPlayerStrVsBlock(Block var1, boolean var2) {}

    public void beforeGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {}

    public float getCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlockForge(this);
        float var5;
        if (var4 == null) {
            var5 = this.playerAPI.localGetCurrentPlayerStrVsBlockForge(var1, var2, var3);
        } else if (var4 != this) {
            var5 = var4.getCurrentPlayerStrVsBlockForge(var1, var2, var3);
        } else {
            var5 = 0.0F;
        }

        return var5;
    }

    public void afterGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {}

    public void beforeGetDistanceSq(double var1, double var3, double var5) {}

    public double getDistanceSq(double var1, double var3, double var5) {
        ClientPlayerBase var7 = this.internalClientPlayerAPI.GetOverwrittenGetDistanceSq(this);
        double var8;
        if (var7 == null) {
            var8 = this.playerAPI.localGetDistanceSq(var1, var3, var5);
        } else if (var7 != this) {
            var8 = var7.getDistanceSq(var1, var3, var5);
        } else {
            var8 = 0.0D;
        }

        return var8;
    }

    public void afterGetDistanceSq(double var1, double var3, double var5) {}

    public void beforeGetDistanceSqToEntity(Entity var1) {}

    public double getDistanceSqToEntity(Entity var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenGetDistanceSqToEntity(this);
        double var3;
        if (var2 == null) {
            var3 = this.playerAPI.localGetDistanceSqToEntity(var1);
        } else if (var2 != this) {
            var3 = var2.getDistanceSqToEntity(var1);
        } else {
            var3 = 0.0D;
        }

        return var3;
    }

    public void afterGetDistanceSqToEntity(Entity var1) {}

    public void beforeGetFOVMultiplier() {}

    public float getFOVMultiplier() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenGetFOVMultiplier(this);
        float var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetFOVMultiplier();
        } else if (var1 != this) {
            var2 = var1.getFOVMultiplier();
        } else {
            var2 = 0.0F;
        }

        return var2;
    }

    public void afterGetFOVMultiplier() {}

    public void beforeGetHurtSound() {}

    public String getHurtSound() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenGetHurtSound(this);
        String var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetHurtSound();
        } else if (var1 != this) {
            var2 = var1.getHurtSound();
        } else {
            var2 = null;
        }

        return var2;
    }

    public void afterGetHurtSound() {}

    public void beforeGetItemIcon(ItemStack var1, int var2) {}

    public IIcon getItemIcon(ItemStack var1, int var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenGetItemIcon(this);
        IIcon var4;
        if (var3 == null) {
            var4 = this.playerAPI.localGetItemIcon(var1, var2);
        } else if (var3 != this) {
            var4 = var3.getItemIcon(var1, var2);
        } else {
            var4 = null;
        }

        return var4;
    }

    public void afterGetItemIcon(ItemStack var1, int var2) {}

    public void beforeGetSleepTimer() {}

    public int getSleepTimer() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenGetSleepTimer(this);
        int var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetSleepTimer();
        } else if (var1 != this) {
            var2 = var1.getSleepTimer();
        } else {
            var2 = 0;
        }

        return var2;
    }

    public void afterGetSleepTimer() {}

    public void beforeHandleLavaMovement() {}

    public boolean handleLavaMovement() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenHandleLavaMovement(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localHandleLavaMovement();
        } else if (var1 != this) {
            var2 = var1.handleLavaMovement();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterHandleLavaMovement() {}

    public void beforeHandleWaterMovement() {}

    public boolean handleWaterMovement() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenHandleWaterMovement(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localHandleWaterMovement();
        } else if (var1 != this) {
            var2 = var1.handleWaterMovement();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterHandleWaterMovement() {}

    public void beforeHeal(float var1) {}

    public void heal(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenHeal(this);
        if (var2 == null) {
            this.playerAPI.localHeal(var1);
        } else if (var2 != this) {
            var2.heal(var1);
        }
    }

    public void afterHeal(float var1) {}

    public void beforeIsEntityInsideOpaqueBlock() {}

    public boolean isEntityInsideOpaqueBlock() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsEntityInsideOpaqueBlock();
        } else if (var1 != this) {
            var2 = var1.isEntityInsideOpaqueBlock();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsEntityInsideOpaqueBlock() {}

    public void beforeIsInWater() {}

    public boolean isInWater() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsInWater(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsInWater();
        } else if (var1 != this) {
            var2 = var1.isInWater();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsInWater() {}

    public void beforeIsInsideOfMaterial(Material var1) {}

    public boolean isInsideOfMaterial(Material var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean var3;
        if (var2 == null) {
            var3 = this.playerAPI.localIsInsideOfMaterial(var1);
        } else if (var2 != this) {
            var3 = var2.isInsideOfMaterial(var1);
        } else {
            var3 = false;
        }

        return var3;
    }

    public void afterIsInsideOfMaterial(Material var1) {}

    public void beforeIsOnLadder() {}

    public boolean isOnLadder() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsOnLadder(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsOnLadder();
        } else if (var1 != this) {
            var2 = var1.isOnLadder();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsOnLadder() {}

    public void beforeIsPlayerSleeping() {}

    public boolean isPlayerSleeping() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsPlayerSleeping(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsPlayerSleeping();
        } else if (var1 != this) {
            var2 = var1.isPlayerSleeping();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsPlayerSleeping() {}

    public void beforeIsSneaking() {}

    public boolean isSneaking() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsSneaking(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsSneaking();
        } else if (var1 != this) {
            var2 = var1.isSneaking();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsSneaking() {}

    public void beforeIsSprinting() {}

    public boolean isSprinting() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenIsSprinting(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.playerAPI.localIsSprinting();
        } else if (var1 != this) {
            var2 = var1.isSprinting();
        } else {
            var2 = false;
        }

        return var2;
    }

    public void afterIsSprinting() {}

    public void beforeJump() {}

    public void jump() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenJump(this);
        if (var1 == null) {
            this.playerAPI.localJump();
        } else if (var1 != this) {
            var1.jump();
        }
    }

    public void afterJump() {}

    public void beforeKnockBack(Entity var1, float var2, double var3, double var5) {}

    public void knockBack(Entity var1, float var2, double var3, double var5) {
        ClientPlayerBase var7 = this.internalClientPlayerAPI.GetOverwrittenKnockBack(this);
        if (var7 == null) {
            this.playerAPI.localKnockBack(var1, var2, var3, var5);
        } else if (var7 != this) {
            var7.knockBack(var1, var2, var3, var5);
        }
    }

    public void afterKnockBack(Entity var1, float var2, double var3, double var5) {}

    public void beforeMoveEntity(double var1, double var3, double var5) {}

    public void moveEntity(double var1, double var3, double var5) {
        ClientPlayerBase var7 = this.internalClientPlayerAPI.GetOverwrittenMoveEntity(this);
        if (var7 == null) {
            this.playerAPI.localMoveEntity(var1, var3, var5);
        } else if (var7 != this) {
            var7.moveEntity(var1, var3, var5);
        }
    }

    public void afterMoveEntity(double var1, double var3, double var5) {}

    public void beforeMoveEntityWithHeading(float var1, float var2) {}

    public void moveEntityWithHeading(float var1, float var2) {
        ClientPlayerBase var3 = this.internalClientPlayerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if (var3 == null) {
            this.playerAPI.localMoveEntityWithHeading(var1, var2);
        } else if (var3 != this) {
            var3.moveEntityWithHeading(var1, var2);
        }
    }

    public void afterMoveEntityWithHeading(float var1, float var2) {}

    public void beforeMoveFlying(float var1, float var2, float var3) {}

    public void moveFlying(float var1, float var2, float var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenMoveFlying(this);
        if (var4 == null) {
            this.playerAPI.localMoveFlying(var1, var2, var3);
        } else if (var4 != this) {
            var4.moveFlying(var1, var2, var3);
        }
    }

    public void afterMoveFlying(float var1, float var2, float var3) {}

    public void beforeOnDeath(DamageSource var1) {}

    public void onDeath(DamageSource var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenOnDeath(this);
        if (var2 == null) {
            this.playerAPI.localOnDeath(var1);
        } else if (var2 != this) {
            var2.onDeath(var1);
        }
    }

    public void afterOnDeath(DamageSource var1) {}

    public void beforeOnLivingUpdate() {}

    public void onLivingUpdate() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenOnLivingUpdate(this);
        if (var1 == null) {
            this.playerAPI.localOnLivingUpdate();
        } else if (var1 != this) {
            var1.onLivingUpdate();
        }
    }

    public void afterOnLivingUpdate() {}

    public void beforeOnKillEntity(EntityLivingBase var1) {}

    public void onKillEntity(EntityLivingBase var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenOnKillEntity(this);
        if (var2 == null) {
            this.playerAPI.localOnKillEntity(var1);
        } else if (var2 != this) {
            var2.onKillEntity(var1);
        }
    }

    public void afterOnKillEntity(EntityLivingBase var1) {}

    public void beforeOnStruckByLightning(EntityLightningBolt var1) {}

    public void onStruckByLightning(EntityLightningBolt var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenOnStruckByLightning(this);
        if (var2 == null) {
            this.playerAPI.localOnStruckByLightning(var1);
        } else if (var2 != this) {
            var2.onStruckByLightning(var1);
        }
    }

    public void afterOnStruckByLightning(EntityLightningBolt var1) {}

    public void beforeOnUpdate() {}

    public void onUpdate() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenOnUpdate(this);
        if (var1 == null) {
            this.playerAPI.localOnUpdate();
        } else if (var1 != this) {
            var1.onUpdate();
        }
    }

    public void afterOnUpdate() {}

    public void beforePlayStepSound(int var1, int var2, int var3, Block var4) {}

    public void playStepSound(int var1, int var2, int var3, Block var4) {
        ClientPlayerBase var5 = this.internalClientPlayerAPI.GetOverwrittenPlayStepSound(this);
        if (var5 == null) {
            this.playerAPI.localPlayStepSound(var1, var2, var3, var4);
        } else if (var5 != this) {
            var5.playStepSound(var1, var2, var3, var4);
        }
    }

    public void afterPlayStepSound(int var1, int var2, int var3, Block var4) {}

    public void beforePushOutOfBlocks(double var1, double var3, double var5) {}

    public boolean pushOutOfBlocks(double var1, double var3, double var5) {
        ClientPlayerBase var7 = this.internalClientPlayerAPI.GetOverwrittenPushOutOfBlocks(this);
        boolean var8;
        if (var7 == null) {
            var8 = this.playerAPI.localPushOutOfBlocks(var1, var3, var5);
        } else if (var7 != this) {
            var8 = var7.pushOutOfBlocks(var1, var3, var5);
        } else {
            var8 = false;
        }

        return var8;
    }

    public void afterPushOutOfBlocks(double var1, double var3, double var5) {}

    public void beforeRayTrace(double var1, float var3) {}

    public MovingObjectPosition rayTrace(double var1, float var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenRayTrace(this);
        MovingObjectPosition var5;
        if (var4 == null) {
            var5 = this.playerAPI.localRayTrace(var1, var3);
        } else if (var4 != this) {
            var5 = var4.rayTrace(var1, var3);
        } else {
            var5 = null;
        }

        return var5;
    }

    public void afterRayTrace(double var1, float var3) {}

    public void beforeReadEntityFromNBT(NBTTagCompound var1) {}

    public void readEntityFromNBT(NBTTagCompound var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (var2 == null) {
            this.playerAPI.localReadEntityFromNBT(var1);
        } else if (var2 != this) {
            var2.readEntityFromNBT(var1);
        }
    }

    public void afterReadEntityFromNBT(NBTTagCompound var1) {}

    public void beforeRespawnPlayer() {}

    public void respawnPlayer() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenRespawnPlayer(this);
        if (var1 == null) {
            this.playerAPI.localRespawnPlayer();
        } else if (var1 != this) {
            var1.respawnPlayer();
        }
    }

    public void afterRespawnPlayer() {}

    public void beforeSetDead() {}

    public void setDead() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenSetDead(this);
        if (var1 == null) {
            this.playerAPI.localSetDead();
        } else if (var1 != this) {
            var1.setDead();
        }
    }

    public void afterSetDead() {}

    public void beforeSetPlayerSPHealth(float var1) {}

    public void setPlayerSPHealth(float var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenSetPlayerSPHealth(this);
        if (var2 == null) {
            this.playerAPI.localSetPlayerSPHealth(var1);
        } else if (var2 != this) {
            var2.setPlayerSPHealth(var1);
        }
    }

    public void afterSetPlayerSPHealth(float var1) {}

    public void beforeSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8) {}

    public void setPositionAndRotation(double var1, double var3, double var5, float var7, float var8) {
        ClientPlayerBase var9 = this.internalClientPlayerAPI.GetOverwrittenSetPositionAndRotation(this);
        if (var9 == null) {
            this.playerAPI.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        } else if (var9 != this) {
            var9.setPositionAndRotation(var1, var3, var5, var7, var8);
        }
    }

    public void afterSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8) {}

    public void beforeSetSneaking(boolean var1) {}

    public void setSneaking(boolean var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenSetSneaking(this);
        if (var2 == null) {
            this.playerAPI.localSetSneaking(var1);
        } else if (var2 != this) {
            var2.setSneaking(var1);
        }
    }

    public void afterSetSneaking(boolean var1) {}

    public void beforeSetSprinting(boolean var1) {}

    public void setSprinting(boolean var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenSetSprinting(this);
        if (var2 == null) {
            this.playerAPI.localSetSprinting(var1);
        } else if (var2 != this) {
            var2.setSprinting(var1);
        }
    }

    public void afterSetSprinting(boolean var1) {}

    public void beforeSleepInBedAt(int var1, int var2, int var3) {}

    public EnumStatus sleepInBedAt(int var1, int var2, int var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenSleepInBedAt(this);
        EnumStatus var5;
        if (var4 == null) {
            var5 = this.playerAPI.localSleepInBedAt(var1, var2, var3);
        } else if (var4 != this) {
            var5 = var4.sleepInBedAt(var1, var2, var3);
        } else {
            var5 = null;
        }

        return var5;
    }

    public void afterSleepInBedAt(int var1, int var2, int var3) {}

    public void beforeSwingItem() {}

    public void swingItem() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenSwingItem(this);
        if (var1 == null) {
            this.playerAPI.localSwingItem();
        } else if (var1 != this) {
            var1.swingItem();
        }
    }

    public void afterSwingItem() {}

    public void beforeUpdateEntityActionState() {}

    public void updateEntityActionState() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenUpdateEntityActionState(this);
        if (var1 == null) {
            this.playerAPI.localUpdateEntityActionState();
        } else if (var1 != this) {
            var1.updateEntityActionState();
        }
    }

    public void afterUpdateEntityActionState() {}

    public void beforeUpdateRidden() {}

    public void updateRidden() {
        ClientPlayerBase var1 = this.internalClientPlayerAPI.GetOverwrittenUpdateRidden(this);
        if (var1 == null) {
            this.playerAPI.localUpdateRidden();
        } else if (var1 != this) {
            var1.updateRidden();
        }
    }

    public void afterUpdateRidden() {}

    public void beforeWakeUpPlayer(boolean var1, boolean var2, boolean var3) {}

    public void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
        ClientPlayerBase var4 = this.internalClientPlayerAPI.GetOverwrittenWakeUpPlayer(this);
        if (var4 == null) {
            this.playerAPI.localWakeUpPlayer(var1, var2, var3);
        } else if (var4 != this) {
            var4.wakeUpPlayer(var1, var2, var3);
        }
    }

    public void afterWakeUpPlayer(boolean var1, boolean var2, boolean var3) {}

    public void beforeWriteEntityToNBT(NBTTagCompound var1) {}

    public void writeEntityToNBT(NBTTagCompound var1) {
        ClientPlayerBase var2 = this.internalClientPlayerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (var2 == null) {
            this.playerAPI.localWriteEntityToNBT(var1);
        } else if (var2 != this) {
            var2.writeEntityToNBT(var1);
        }
    }

    public void afterWriteEntityToNBT(NBTTagCompound var1) {}
}
