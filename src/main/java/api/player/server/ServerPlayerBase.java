package api.player.server;

import com.mojang.authlib.GameProfile;
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

public abstract class ServerPlayerBase {
    protected final EntityPlayerMP player;
    protected final IServerPlayer playerAPI;
    private final ServerPlayerAPI internalServerPlayerAPI;

    public ServerPlayerBase(ServerPlayerAPI playerAPI) {
        this.internalServerPlayerAPI = playerAPI;
        this.playerAPI = playerAPI.player;
        this.player = playerAPI.player.getEntityPlayerMP();
    }

    public void beforeBaseAttach(boolean onTheFly) {
    }

    public void afterBaseAttach(boolean onTheFly) {
    }

    public void beforeLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
    }

    public void afterLocalConstructing(MinecraftServer var1, WorldServer var2, GameProfile var3, ItemInWorldManager var4) {
    }

    public void beforeBaseDetach(boolean onTheFly) {
    }

    public void afterBaseDetach(boolean onTheFly) {
    }

    public Object dynamic(String key, Object[] parameters) {
        return this.internalServerPlayerAPI.dynamicOverwritten(key, parameters, this);
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeAddExhaustion(float var1) {
    }

    public void addExhaustion(float var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenAddExhaustion(this);
        if (var2 == null) {
            this.playerAPI.localAddExhaustion(var1);
        } else if (var2 != this) {
            var2.addExhaustion(var1);
        }

    }

    public void afterAddExhaustion(float var1) {
    }

    public void beforeAddExperience(int var1) {
    }

    public void addExperience(int var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenAddExperience(this);
        if (var2 == null) {
            this.playerAPI.localAddExperience(var1);
        } else if (var2 != this) {
            var2.addExperience(var1);
        }

    }

    public void afterAddExperience(int var1) {
    }

    public void beforeAddExperienceLevel(int var1) {
    }

    public void addExperienceLevel(int var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenAddExperienceLevel(this);
        if (var2 == null) {
            this.playerAPI.localAddExperienceLevel(var1);
        } else if (var2 != this) {
            var2.addExperienceLevel(var1);
        }

    }

    public void afterAddExperienceLevel(int var1) {
    }

    public void beforeAddMovementStat(double var1, double var3, double var5) {
    }

    public void addMovementStat(double var1, double var3, double var5) {
        ServerPlayerBase var7 = this.internalServerPlayerAPI.GetOverwrittenAddMovementStat(this);
        if (var7 == null) {
            this.playerAPI.localAddMovementStat(var1, var3, var5);
        } else if (var7 != this) {
            var7.addMovementStat(var1, var3, var5);
        }

    }

    public void afterAddMovementStat(double var1, double var3, double var5) {
    }

    public void beforeAttackEntityFrom(DamageSource var1, float var2) {
    }

    public boolean attackEntityFrom(DamageSource var1, float var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenAttackEntityFrom(this);
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

    public void afterAttackEntityFrom(DamageSource var1, float var2) {
    }

    public void beforeAttackTargetEntityWithCurrentItem(Entity var1) {
    }

    public void attackTargetEntityWithCurrentItem(Entity var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if (var2 == null) {
            this.playerAPI.localAttackTargetEntityWithCurrentItem(var1);
        } else if (var2 != this) {
            var2.attackTargetEntityWithCurrentItem(var1);
        }

    }

    public void afterAttackTargetEntityWithCurrentItem(Entity var1) {
    }

    public void beforeCanBreatheUnderwater() {
    }

    public boolean canBreatheUnderwater() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenCanBreatheUnderwater(this);
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

    public void afterCanBreatheUnderwater() {
    }

    public void beforeCanHarvestBlock(Block var1) {
    }

    public boolean canHarvestBlock(Block var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenCanHarvestBlock(this);
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

    public void afterCanHarvestBlock(Block var1) {
    }

    public void beforeCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
    }

    public boolean canPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
        ServerPlayerBase var6 = this.internalServerPlayerAPI.GetOverwrittenCanPlayerEdit(this);
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

    public void afterCanPlayerEdit(int var1, int var2, int var3, int var4, ItemStack var5) {
    }

    public void beforeCanTriggerWalking() {
    }

    public boolean canTriggerWalking() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenCanTriggerWalking(this);
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

    public void afterCanTriggerWalking() {
    }

    public void beforeClonePlayer(EntityPlayer var1, boolean var2) {
    }

    public void clonePlayer(EntityPlayer var1, boolean var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenClonePlayer(this);
        if (var3 == null) {
            this.playerAPI.localClonePlayer(var1, var2);
        } else if (var3 != this) {
            var3.clonePlayer(var1, var2);
        }

    }

    public void afterClonePlayer(EntityPlayer var1, boolean var2) {
    }

    public void beforeDamageEntity(DamageSource var1, float var2) {
    }

    public void damageEntity(DamageSource var1, float var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenDamageEntity(this);
        if (var3 == null) {
            this.playerAPI.localDamageEntity(var1, var2);
        } else if (var3 != this) {
            var3.damageEntity(var1, var2);
        }

    }

    public void afterDamageEntity(DamageSource var1, float var2) {
    }

    public void beforeDisplayGUIChest(IInventory var1) {
    }

    public void displayGUIChest(IInventory var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIChest(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIChest(var1);
        } else if (var2 != this) {
            var2.displayGUIChest(var1);
        }

    }

    public void afterDisplayGUIChest(IInventory var1) {
    }

    public void beforeDisplayGUIDispenser(TileEntityDispenser var1) {
    }

    public void displayGUIDispenser(TileEntityDispenser var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIDispenser(var1);
        } else if (var2 != this) {
            var2.displayGUIDispenser(var1);
        }

    }

    public void afterDisplayGUIDispenser(TileEntityDispenser var1) {
    }

    public void beforeDisplayGUIFurnace(TileEntityFurnace var1) {
    }

    public void displayGUIFurnace(TileEntityFurnace var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (var2 == null) {
            this.playerAPI.localDisplayGUIFurnace(var1);
        } else if (var2 != this) {
            var2.displayGUIFurnace(var1);
        }

    }

    public void afterDisplayGUIFurnace(TileEntityFurnace var1) {
    }

    public void beforeDisplayGUIWorkbench(int var1, int var2, int var3) {
    }

    public void displayGUIWorkbench(int var1, int var2, int var3) {
        ServerPlayerBase var4 = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIWorkbench(this);
        if (var4 == null) {
            this.playerAPI.localDisplayGUIWorkbench(var1, var2, var3);
        } else if (var4 != this) {
            var4.displayGUIWorkbench(var1, var2, var3);
        }

    }

    public void afterDisplayGUIWorkbench(int var1, int var2, int var3) {
    }

    public void beforeDropOneItem(boolean var1) {
    }

    public EntityItem dropOneItem(boolean var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenDropOneItem(this);
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

    public void afterDropOneItem(boolean var1) {
    }

    public void beforeDropPlayerItem(ItemStack var1, boolean var2) {
    }

    public EntityItem dropPlayerItem(ItemStack var1, boolean var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenDropPlayerItem(this);
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

    public void afterDropPlayerItem(ItemStack var1, boolean var2) {
    }

    public void beforeFall(float var1) {
    }

    public void fall(float var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenFall(this);
        if (var2 == null) {
            this.playerAPI.localFall(var1);
        } else if (var2 != this) {
            var2.fall(var1);
        }

    }

    public void afterFall(float var1) {
    }

    public void beforeGetAIMoveSpeed() {
    }

    public float getAIMoveSpeed() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenGetAIMoveSpeed(this);
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

    public void afterGetAIMoveSpeed() {
    }

    public void beforeGetCurrentPlayerStrVsBlock(Block var1, boolean var2) {
    }

    public float getCurrentPlayerStrVsBlock(Block var1, boolean var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
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

    public void afterGetCurrentPlayerStrVsBlock(Block var1, boolean var2) {
    }

    public void beforeGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
    }

    public float getCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
        ServerPlayerBase var4 = this.internalServerPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlockForge(this);
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

    public void afterGetCurrentPlayerStrVsBlockForge(Block var1, boolean var2, int var3) {
    }

    public void beforeGetDistanceSq(double var1, double var3, double var5) {
    }

    public double getDistanceSq(double var1, double var3, double var5) {
        ServerPlayerBase var7 = this.internalServerPlayerAPI.GetOverwrittenGetDistanceSq(this);
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

    public void afterGetDistanceSq(double var1, double var3, double var5) {
    }

    public void beforeGetBrightness(float var1) {
    }

    public float getBrightness(float var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenGetBrightness(this);
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

    public void afterGetBrightness(float var1) {
    }

    public void beforeGetEyeHeight() {
    }

    public float getEyeHeight() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenGetEyeHeight(this);
        float var2;
        if (var1 == null) {
            var2 = this.playerAPI.localGetEyeHeight();
        } else if (var1 != this) {
            var2 = var1.getEyeHeight();
        } else {
            var2 = 0.0F;
        }

        return var2;
    }

    public void afterGetEyeHeight() {
    }

    public void beforeHeal(float var1) {
    }

    public void heal(float var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenHeal(this);
        if (var2 == null) {
            this.playerAPI.localHeal(var1);
        } else if (var2 != this) {
            var2.heal(var1);
        }

    }

    public void afterHeal(float var1) {
    }

    public void beforeIsEntityInsideOpaqueBlock() {
    }

    public boolean isEntityInsideOpaqueBlock() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
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

    public void afterIsEntityInsideOpaqueBlock() {
    }

    public void beforeIsInWater() {
    }

    public boolean isInWater() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenIsInWater(this);
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

    public void afterIsInWater() {
    }

    public void beforeIsInsideOfMaterial(Material var1) {
    }

    public boolean isInsideOfMaterial(Material var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenIsInsideOfMaterial(this);
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

    public void afterIsInsideOfMaterial(Material var1) {
    }

    public void beforeIsOnLadder() {
    }

    public boolean isOnLadder() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenIsOnLadder(this);
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

    public void afterIsOnLadder() {
    }

    public void beforeIsPlayerSleeping() {
    }

    public boolean isPlayerSleeping() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenIsPlayerSleeping(this);
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

    public void afterIsPlayerSleeping() {
    }

    public void beforeIsSneaking() {
    }

    public boolean isSneaking() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenIsSneaking(this);
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

    public void afterIsSneaking() {
    }

    public void beforeJump() {
    }

    public void jump() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenJump(this);
        if (var1 == null) {
            this.playerAPI.localJump();
        } else if (var1 != this) {
            var1.jump();
        }

    }

    public void afterJump() {
    }

    public void beforeKnockBack(Entity var1, float var2, double var3, double var5) {
    }

    public void knockBack(Entity var1, float var2, double var3, double var5) {
        ServerPlayerBase var7 = this.internalServerPlayerAPI.GetOverwrittenKnockBack(this);
        if (var7 == null) {
            this.playerAPI.localKnockBack(var1, var2, var3, var5);
        } else if (var7 != this) {
            var7.knockBack(var1, var2, var3, var5);
        }

    }

    public void afterKnockBack(Entity var1, float var2, double var3, double var5) {
    }

    public void beforeMountEntity(Entity var1) {
    }

    public void mountEntity(Entity var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenMountEntity(this);
        if (var2 == null) {
            this.playerAPI.localMountEntity(var1);
        } else if (var2 != this) {
            var2.mountEntity(var1);
        }

    }

    public void afterMountEntity(Entity var1) {
    }

    public void beforeMoveEntity(double var1, double var3, double var5) {
    }

    public void moveEntity(double var1, double var3, double var5) {
        ServerPlayerBase var7 = this.internalServerPlayerAPI.GetOverwrittenMoveEntity(this);
        if (var7 == null) {
            this.playerAPI.localMoveEntity(var1, var3, var5);
        } else if (var7 != this) {
            var7.moveEntity(var1, var3, var5);
        }

    }

    public void afterMoveEntity(double var1, double var3, double var5) {
    }

    public void beforeMoveEntityWithHeading(float var1, float var2) {
    }

    public void moveEntityWithHeading(float var1, float var2) {
        ServerPlayerBase var3 = this.internalServerPlayerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if (var3 == null) {
            this.playerAPI.localMoveEntityWithHeading(var1, var2);
        } else if (var3 != this) {
            var3.moveEntityWithHeading(var1, var2);
        }

    }

    public void afterMoveEntityWithHeading(float var1, float var2) {
    }

    public void beforeMoveFlying(float var1, float var2, float var3) {
    }

    public void moveFlying(float var1, float var2, float var3) {
        ServerPlayerBase var4 = this.internalServerPlayerAPI.GetOverwrittenMoveFlying(this);
        if (var4 == null) {
            this.playerAPI.localMoveFlying(var1, var2, var3);
        } else if (var4 != this) {
            var4.moveFlying(var1, var2, var3);
        }

    }

    public void afterMoveFlying(float var1, float var2, float var3) {
    }

    public void beforeOnDeath(DamageSource var1) {
    }

    public void onDeath(DamageSource var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenOnDeath(this);
        if (var2 == null) {
            this.playerAPI.localOnDeath(var1);
        } else if (var2 != this) {
            var2.onDeath(var1);
        }

    }

    public void afterOnDeath(DamageSource var1) {
    }

    public void beforeOnLivingUpdate() {
    }

    public void onLivingUpdate() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenOnLivingUpdate(this);
        if (var1 == null) {
            this.playerAPI.localOnLivingUpdate();
        } else if (var1 != this) {
            var1.onLivingUpdate();
        }

    }

    public void afterOnLivingUpdate() {
    }

    public void beforeOnKillEntity(EntityLivingBase var1) {
    }

    public void onKillEntity(EntityLivingBase var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenOnKillEntity(this);
        if (var2 == null) {
            this.playerAPI.localOnKillEntity(var1);
        } else if (var2 != this) {
            var2.onKillEntity(var1);
        }

    }

    public void afterOnKillEntity(EntityLivingBase var1) {
    }

    public void beforeOnStruckByLightning(EntityLightningBolt var1) {
    }

    public void onStruckByLightning(EntityLightningBolt var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenOnStruckByLightning(this);
        if (var2 == null) {
            this.playerAPI.localOnStruckByLightning(var1);
        } else if (var2 != this) {
            var2.onStruckByLightning(var1);
        }

    }

    public void afterOnStruckByLightning(EntityLightningBolt var1) {
    }

    public void beforeOnUpdate() {
    }

    public void onUpdate() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenOnUpdate(this);
        if (var1 == null) {
            this.playerAPI.localOnUpdate();
        } else if (var1 != this) {
            var1.onUpdate();
        }

    }

    public void afterOnUpdate() {
    }

    public void beforeOnUpdateEntity() {
    }

    public void onUpdateEntity() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenOnUpdateEntity(this);
        if (var1 == null) {
            this.playerAPI.localOnUpdateEntity();
        } else if (var1 != this) {
            var1.onUpdateEntity();
        }

    }

    public void afterOnUpdateEntity() {
    }

    public void beforeReadEntityFromNBT(NBTTagCompound var1) {
    }

    public void readEntityFromNBT(NBTTagCompound var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (var2 == null) {
            this.playerAPI.localReadEntityFromNBT(var1);
        } else if (var2 != this) {
            var2.readEntityFromNBT(var1);
        }

    }

    public void afterReadEntityFromNBT(NBTTagCompound var1) {
    }

    public void beforeSetDead() {
    }

    public void setDead() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenSetDead(this);
        if (var1 == null) {
            this.playerAPI.localSetDead();
        } else if (var1 != this) {
            var1.setDead();
        }

    }

    public void afterSetDead() {
    }

    public void beforeSetEntityActionState(float var1, float var2, boolean var3, boolean var4) {
    }

    public void setEntityActionState(float var1, float var2, boolean var3, boolean var4) {
        ServerPlayerBase var5 = this.internalServerPlayerAPI.GetOverwrittenSetEntityActionState(this);
        if (var5 == null) {
            this.playerAPI.localSetEntityActionState(var1, var2, var3, var4);
        } else if (var5 != this) {
            var5.setEntityActionState(var1, var2, var3, var4);
        }

    }

    public void afterSetEntityActionState(float var1, float var2, boolean var3, boolean var4) {
    }

    public void beforeSetPosition(double var1, double var3, double var5) {
    }

    public void setPosition(double var1, double var3, double var5) {
        ServerPlayerBase var7 = this.internalServerPlayerAPI.GetOverwrittenSetPosition(this);
        if (var7 == null) {
            this.playerAPI.localSetPosition(var1, var3, var5);
        } else if (var7 != this) {
            var7.setPosition(var1, var3, var5);
        }

    }

    public void afterSetPosition(double var1, double var3, double var5) {
    }

    public void beforeSetSneaking(boolean var1) {
    }

    public void setSneaking(boolean var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenSetSneaking(this);
        if (var2 == null) {
            this.playerAPI.localSetSneaking(var1);
        } else if (var2 != this) {
            var2.setSneaking(var1);
        }

    }

    public void afterSetSneaking(boolean var1) {
    }

    public void beforeSetSprinting(boolean var1) {
    }

    public void setSprinting(boolean var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenSetSprinting(this);
        if (var2 == null) {
            this.playerAPI.localSetSprinting(var1);
        } else if (var2 != this) {
            var2.setSprinting(var1);
        }

    }

    public void afterSetSprinting(boolean var1) {
    }

    public void beforeSwingItem() {
    }

    public void swingItem() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenSwingItem(this);
        if (var1 == null) {
            this.playerAPI.localSwingItem();
        } else if (var1 != this) {
            var1.swingItem();
        }

    }

    public void afterSwingItem() {
    }

    public void beforeUpdateEntityActionState() {
    }

    public void updateEntityActionState() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenUpdateEntityActionState(this);
        if (var1 == null) {
            this.playerAPI.localUpdateEntityActionState();
        } else if (var1 != this) {
            var1.updateEntityActionState();
        }

    }

    public void afterUpdateEntityActionState() {
    }

    public void beforeUpdatePotionEffects() {
    }

    public void updatePotionEffects() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenUpdatePotionEffects(this);
        if (var1 == null) {
            this.playerAPI.localUpdatePotionEffects();
        } else if (var1 != this) {
            var1.updatePotionEffects();
        }

    }

    public void afterUpdatePotionEffects() {
    }

    public void beforeUpdateRidden() {
    }

    public void updateRidden() {
        ServerPlayerBase var1 = this.internalServerPlayerAPI.GetOverwrittenUpdateRidden(this);
        if (var1 == null) {
            this.playerAPI.localUpdateRidden();
        } else if (var1 != this) {
            var1.updateRidden();
        }

    }

    public void afterUpdateRidden() {
    }

    public void beforeWakeUpPlayer(boolean var1, boolean var2, boolean var3) {
    }

    public void wakeUpPlayer(boolean var1, boolean var2, boolean var3) {
        ServerPlayerBase var4 = this.internalServerPlayerAPI.GetOverwrittenWakeUpPlayer(this);
        if (var4 == null) {
            this.playerAPI.localWakeUpPlayer(var1, var2, var3);
        } else if (var4 != this) {
            var4.wakeUpPlayer(var1, var2, var3);
        }

    }

    public void afterWakeUpPlayer(boolean var1, boolean var2, boolean var3) {
    }

    public void beforeWriteEntityToNBT(NBTTagCompound var1) {
    }

    public void writeEntityToNBT(NBTTagCompound var1) {
        ServerPlayerBase var2 = this.internalServerPlayerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (var2 == null) {
            this.playerAPI.localWriteEntityToNBT(var1);
        } else if (var2 != this) {
            var2.writeEntityToNBT(var1);
        }

    }

    public void afterWriteEntityToNBT(NBTTagCompound var1) {
    }
}
