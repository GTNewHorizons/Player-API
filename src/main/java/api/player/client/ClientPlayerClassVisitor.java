package api.player.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public final class ClientPlayerClassVisitor extends ClassVisitor {

    public static final String targetClassName = "net.minecraft.client.entity.EntityPlayerSP";
    private boolean hadLocalAddExhaustion;
    private boolean hadLocalAddMovementStat;
    private boolean hadLocalAddStat;
    private boolean hadLocalAttackEntityFrom;
    private boolean hadLocalAttackTargetEntityWithCurrentItem;
    private boolean hadLocalCanBreatheUnderwater;
    private boolean hadLocalCanHarvestBlock;
    private boolean hadLocalCanPlayerEdit;
    private boolean hadLocalCanTriggerWalking;
    private boolean hadLocalCloseScreen;
    private boolean hadLocalDamageEntity;
    private boolean hadLocalDisplayGUIBrewingStand;
    private boolean hadLocalDisplayGUIChest;
    private boolean hadLocalDisplayGUIDispenser;
    private boolean hadLocalDisplayGUIEditSign;
    private boolean hadLocalDisplayGUIEnchantment;
    private boolean hadLocalDisplayGUIFurnace;
    private boolean hadLocalDisplayGUIWorkbench;
    private boolean hadLocalDropOneItem;
    private boolean hadLocalDropPlayerItem;
    private boolean hadLocalDropPlayerItemWithRandomChoice;
    private boolean hadLocalFall;
    private boolean hadLocalGetAIMoveSpeed;
    private boolean hadLocalGetBedOrientationInDegrees;
    private boolean hadLocalGetBrightness;
    private boolean hadLocalGetBrightnessForRender;
    private boolean hadLocalGetCurrentPlayerStrVsBlock;
    private boolean hadLocalGetCurrentPlayerStrVsBlockForge;
    private boolean hadLocalGetDistanceSq;
    private boolean hadLocalGetDistanceSqToEntity;
    private boolean hadLocalGetFOVMultiplier;
    private boolean hadLocalGetHurtSound;
    private boolean hadLocalGetItemIcon;
    private boolean hadLocalGetSleepTimer;
    private boolean hadLocalHandleLavaMovement;
    private boolean hadLocalHandleWaterMovement;
    private boolean hadLocalHeal;
    private boolean hadLocalIsEntityInsideOpaqueBlock;
    private boolean hadLocalIsInWater;
    private boolean hadLocalIsInsideOfMaterial;
    private boolean hadLocalIsOnLadder;
    private boolean hadLocalIsPlayerSleeping;
    private boolean hadLocalIsSneaking;
    private boolean hadLocalIsSprinting;
    private boolean hadLocalJump;
    private boolean hadLocalKnockBack;
    private boolean hadLocalMoveEntity;
    private boolean hadLocalMoveEntityWithHeading;
    private boolean hadLocalMoveFlying;
    private boolean hadLocalOnDeath;
    private boolean hadLocalOnLivingUpdate;
    private boolean hadLocalOnKillEntity;
    private boolean hadLocalOnStruckByLightning;
    private boolean hadLocalOnUpdate;
    private boolean hadLocalPlayStepSound;
    private boolean hadLocalPushOutOfBlocks;
    private boolean hadLocalRayTrace;
    private boolean hadLocalReadEntityFromNBT;
    private boolean hadLocalRespawnPlayer;
    private boolean hadLocalSetDead;
    private boolean hadLocalSetPlayerSPHealth;
    private boolean hadLocalSetPositionAndRotation;
    private boolean hadLocalSetSneaking;
    private boolean hadLocalSetSprinting;
    private boolean hadLocalSleepInBedAt;
    private boolean hadLocalSwingItem;
    private boolean hadLocalUpdateEntityActionState;
    private boolean hadLocalUpdateRidden;
    private boolean hadLocalWakeUpPlayer;
    private boolean hadLocalWriteEntityToNBT;
    private final boolean isObfuscated;

    public static byte[] transform(byte[] bytes, boolean isObfuscated) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ClassReader cr = new ClassReader(in);
            ClassWriter vw = new ClassWriter(1);
            ClientPlayerClassVisitor p = new ClientPlayerClassVisitor(vw, isObfuscated);
            cr.accept(p, 0);
            byte[] result = vw.toByteArray();
            in.close();
            return result;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public ClientPlayerClassVisitor(ClassVisitor classVisitor, boolean isObfuscated) {
        super(262144, classVisitor);
        this.isObfuscated = isObfuscated;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        String[] newInterfaces = new String[interfaces.length + 1];

        for (int i = 0; i < interfaces.length; ++i) {
            newInterfaces[i] = interfaces[i];
        }

        newInterfaces[interfaces.length] = "api/player/client/IClientPlayerAPI";
        super.visit(version, access, name, signature, superName, newInterfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals("<init>")) {
            return new ClientPlayerConstructorVisitor(
                    super.visitMethod(access, name, desc, signature, exceptions), this.isObfuscated);
        } else if (name.equals(this.isObfuscated ? "a" : "addExhaustion") && desc.equals("(F)V")) {
            this.hadLocalAddExhaustion = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAddExhaustion", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "k" : "addMovementStat") && desc.equals("(DDD)V")) {
            this.hadLocalAddMovementStat = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAddMovementStat", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "addStat")
                && desc.equals(this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V")) {
            this.hadLocalAddStat = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAddStat", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "attackEntityFrom")
                && desc.equals(this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z")) {
            this.hadLocalAttackEntityFrom = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAttackEntityFrom", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "r" : "attackEntityPlayerSPEntityWithCurrentItem")
                && desc.equals(this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V")) {
            this.hadLocalAttackTargetEntityWithCurrentItem = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localAttackTargetEntityWithCurrentItem",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "aE" : "canBreatheUnderwater") && desc.equals("()Z")) {
            this.hadLocalCanBreatheUnderwater = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanBreatheUnderwater", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "canHarvestBlock")
                && desc.equals(this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z")) {
            this.hadLocalCanHarvestBlock = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanHarvestBlock", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "canPlayerEdit")
                && desc.equals(this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z")) {
            this.hadLocalCanPlayerEdit = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanPlayerEdit", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "g_" : "canTriggerWalking") && desc.equals("()Z")) {
            this.hadLocalCanTriggerWalking = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanTriggerWalking", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "k" : "closeScreen") && desc.equals("()V")) {
            this.hadLocalCloseScreen = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCloseScreen", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "d" : "damageEntity")
                && desc.equals(this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V")) {
            this.hadLocalDamageEntity = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDamageEntity", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_146098_a")
                && desc.equals(
                        this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V")) {
            this.hadLocalDisplayGUIBrewingStand = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIBrewingStand", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "displayGUIChest")
                && desc.equals(this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V")) {
            this.hadLocalDisplayGUIChest = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIChest", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_146102_a")
                && desc.equals(this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V")) {
            this.hadLocalDisplayGUIDispenser = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIDispenser", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_146100_a")
                && desc.equals(this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V")) {
            this.hadLocalDisplayGUIEditSign = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIEditSign", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "displayGUIEnchantment")
                && desc.equals("(IIILjava/lang/String;)V")) {
            this.hadLocalDisplayGUIEnchantment = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIEnchantment", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_146101_a")
                && desc.equals(this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V")) {
            this.hadLocalDisplayGUIFurnace = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIFurnace", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "b" : "displayGUIWorkbench") && desc.equals("(III)V")) {
            this.hadLocalDisplayGUIWorkbench = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIWorkbench", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "dropOneItem")
                && desc.equals(this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;")) {
            this.hadLocalDropOneItem = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDropOneItem", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "dropPlayerItemWithRandomChoice")
                && desc.equals(
                        this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")) {
            this.hadLocalDropPlayerItem = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDropPlayerItem", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_146097_a")
                && desc.equals(
                        this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")) {
            this.hadLocalDropPlayerItemWithRandomChoice = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDropPlayerItemWithRandomChoice",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "b" : "fall") && desc.equals("(F)V")) {
            this.hadLocalFall = true;
            return super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localFall", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bl" : "getAIMoveSpeed") && desc.equals("()F")) {
            this.hadLocalGetAIMoveSpeed = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetAIMoveSpeed", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bK" : "getBedOrientationInDegrees") && desc.equals("()F")) {
            this.hadLocalGetBedOrientationInDegrees = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetBedOrientationInDegrees",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "d" : "getBrightness") && desc.equals("(F)F")) {
            this.hadLocalGetBrightness = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetBrightness", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "c" : "getBrightnessForRender") && desc.equals("(F)I")) {
            this.hadLocalGetBrightnessForRender = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetBrightnessForRender", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "getCurrentPlayerStrVsBlock")
                && desc.equals(this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F")) {
            this.hadLocalGetCurrentPlayerStrVsBlock = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetCurrentPlayerStrVsBlock",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals("getBreakSpeed")
                && desc.equals(this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F")) {
            this.hadLocalGetCurrentPlayerStrVsBlockForge = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetCurrentPlayerStrVsBlockForge",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "e" : "getDistanceSq") && desc.equals("(DDD)D")) {
            this.hadLocalGetDistanceSq = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetDistanceSq", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "f" : "getDistanceSqToEntity")
                && desc.equals(this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D")) {
            this.hadLocalGetDistanceSqToEntity = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetDistanceSqToEntity", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "t" : "getFOVMultiplier") && desc.equals("()F")) {
            this.hadLocalGetFOVMultiplier = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetFOVMultiplier", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "aT" : "getHurtSound") && desc.equals("()Ljava/lang/String;")) {
            this.hadLocalGetHurtSound = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetHurtSound", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "b" : "getItemIcon")
                && desc.equals(
                        this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")) {
            this.hadLocalGetItemIcon = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetItemIcon", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bM" : "getSleepTimer") && desc.equals("()I")) {
            this.hadLocalGetSleepTimer = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetSleepTimer", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "P" : "handleLavaMovement") && desc.equals("()Z")) {
            this.hadLocalHandleLavaMovement = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHandleLavaMovement", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "N" : "handleWaterMovement") && desc.equals("()Z")) {
            this.hadLocalHandleWaterMovement = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHandleWaterMovement", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "f" : "heal") && desc.equals("(F)V")) {
            this.hadLocalHeal = true;
            return super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHeal", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "aa" : "isEntityInsideOpaqueBlock") && desc.equals("()Z")) {
            this.hadLocalIsEntityInsideOpaqueBlock = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localIsEntityInsideOpaqueBlock",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "M" : "isInWater") && desc.equals("()Z")) {
            this.hadLocalIsInWater = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsInWater", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "isInsideOfMaterial")
                && desc.equals(this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z")) {
            this.hadLocalIsInsideOfMaterial = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsInsideOfMaterial", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "h_" : "isOnLadder") && desc.equals("()Z")) {
            this.hadLocalIsOnLadder = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsOnLadder", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bm" : "isPlayerSleeping") && desc.equals("()Z")) {
            this.hadLocalIsPlayerSleeping = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsPlayerSleeping", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "an" : "isSneaking") && desc.equals("()Z")) {
            this.hadLocalIsSneaking = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsSneaking", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "ao" : "isSprinting") && desc.equals("()Z")) {
            this.hadLocalIsSprinting = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsSprinting", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bj" : "jump") && desc.equals("()V")) {
            this.hadLocalJump = true;
            return super.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localJump", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "knockBack")
                && desc.equals(this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V")) {
            this.hadLocalKnockBack = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localKnockBack", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "d" : "moveEntity") && desc.equals("(DDD)V")) {
            this.hadLocalMoveEntity = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveEntity", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "e" : "moveEntityWithHeading") && desc.equals("(FF)V")) {
            this.hadLocalMoveEntityWithHeading = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveEntityWithHeading", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "moveFlying") && desc.equals("(FFF)V")) {
            this.hadLocalMoveFlying = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveFlying", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "onDeath")
                && desc.equals(this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V")) {
            this.hadLocalOnDeath = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnDeath", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "e" : "onLivingUpdate") && desc.equals("()V")) {
            this.hadLocalOnLivingUpdate = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnLivingUpdate", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "onKillEntity")
                && desc.equals(this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V")) {
            this.hadLocalOnKillEntity = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnKillEntity", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "onStruckByLightning")
                && desc.equals(
                        this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V")) {
            this.hadLocalOnStruckByLightning = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnStruckByLightning", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "h" : "onUpdate") && desc.equals("()V")) {
            this.hadLocalOnUpdate = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnUpdate", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "func_145780_a")
                && desc.equals(this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V")) {
            this.hadLocalPlayStepSound = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localPlayStepSound", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "j" : "func_145771_j") && desc.equals("(DDD)Z")) {
            this.hadLocalPushOutOfBlocks = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localPushOutOfBlocks", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "rayTrace")
                && desc.equals(this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;")) {
            this.hadLocalRayTrace = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localRayTrace", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "readEntityFromNBT")
                && desc.equals(this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V")) {
            this.hadLocalReadEntityFromNBT = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localReadEntityFromNBT", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bH" : "respawnPlayer") && desc.equals("()V")) {
            this.hadLocalRespawnPlayer = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localRespawnPlayer", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "B" : "setDead") && desc.equals("()V")) {
            this.hadLocalSetDead = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetDead", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "n" : "setPlayerSPHealth") && desc.equals("(F)V")) {
            this.hadLocalSetPlayerSPHealth = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetPlayerSPHealth", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "setPositionAndRotation") && desc.equals("(DDDFF)V")) {
            this.hadLocalSetPositionAndRotation = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetPositionAndRotation", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "b" : "setSneaking") && desc.equals("(Z)V")) {
            this.hadLocalSetSneaking = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetSneaking", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "c" : "setSprinting") && desc.equals("(Z)V")) {
            this.hadLocalSetSprinting = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetSprinting", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "sleepInBedAt")
                && desc.equals(
                        this.isObfuscated
                                ? "(III)Lza;"
                                : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")) {
            this.hadLocalSleepInBedAt = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSleepInBedAt", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "ba" : "swingItem") && desc.equals("()V")) {
            this.hadLocalSwingItem = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSwingItem", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "bq" : "updateEntityActionState") && desc.equals("()V")) {
            this.hadLocalUpdateEntityActionState = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localUpdateEntityActionState",
                    desc,
                    signature,
                    exceptions);
        } else if (name.equals(this.isObfuscated ? "ab" : "updateRidden") && desc.equals("()V")) {
            this.hadLocalUpdateRidden = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localUpdateRidden", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "a" : "wakeUpPlayer") && desc.equals("(ZZZ)V")) {
            this.hadLocalWakeUpPlayer = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localWakeUpPlayer", desc, signature, exceptions);
        } else if (name.equals(this.isObfuscated ? "b" : "writeEntityToNBT")
                && desc.equals(this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V")) {
            this.hadLocalWriteEntityToNBT = true;
            return super.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localWriteEntityToNBT", desc, signature, exceptions);
        } else {
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }

    @Override
    public void visitEnd() {
        MethodVisitor mv =
                this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "a" : "addExhaustion", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "addExhaustion",
                "(Lapi/player/client/IClientPlayerAPI;F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realAddExhaustion", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "addExhaustion",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superAddExhaustion", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "addExhaustion",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalAddExhaustion) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAddExhaustion", "(F)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "addExhaustion",
                    "(F)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "k" : "addMovementStat", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "addMovementStat",
                "(Lapi/player/client/IClientPlayerAPI;DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realAddMovementStat", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "k" : "addMovementStat",
                "(DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superAddMovementStat", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "k" : "addMovementStat",
                "(DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalAddMovementStat) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localAddMovementStat", "(DDD)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "k" : "addMovementStat",
                    "(DDD)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "addStat",
                "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "addStat",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lph;I" : "Lnet/minecraft/stats/StatBase;I") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realAddStat",
                "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "addStat",
                "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superAddStat",
                "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "addStat",
                "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalAddStat) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localAddStat",
                    "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "addStat",
                    "" + (this.isObfuscated ? "(Lph;I)V" : "(Lnet/minecraft/stats/StatBase;I)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "attackEntityFrom",
                "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "attackEntityFrom",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lro;F" : "Lnet/minecraft/util/DamageSource;F") + ")Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realAttackEntityFrom",
                "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "attackEntityFrom",
                "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superAttackEntityFrom",
                "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "attackEntityFrom",
                "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalAttackEntityFrom) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localAttackEntityFrom",
                    "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "attackEntityFrom",
                    "" + (this.isObfuscated ? "(Lro;F)Z" : "(Lnet/minecraft/util/DamageSource;F)Z") + "");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "r" : "attackEntityPlayerSPEntityWithCurrentItem",
                "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "attackTargetEntityWithCurrentItem",
                "(Lapi/player/client/IClientPlayerAPI;" + (this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;")
                        + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realAttackTargetEntityWithCurrentItem",
                "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "r" : "attackEntityPlayerSPEntityWithCurrentItem",
                "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superAttackTargetEntityWithCurrentItem",
                "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "r" : "attackEntityPlayerSPEntityWithCurrentItem",
                "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalAttackTargetEntityWithCurrentItem) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localAttackTargetEntityWithCurrentItem",
                    "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "r" : "attackEntityPlayerSPEntityWithCurrentItem",
                    "" + (this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "aE" : "canBreatheUnderwater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "canBreatheUnderwater",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realCanBreatheUnderwater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aE" : "canBreatheUnderwater",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superCanBreatheUnderwater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "aE" : "canBreatheUnderwater",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalCanBreatheUnderwater) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanBreatheUnderwater", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "aE" : "canBreatheUnderwater",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "canHarvestBlock",
                "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "canHarvestBlock",
                "(Lapi/player/client/IClientPlayerAPI;" + (this.isObfuscated ? "Laji;" : "Lnet/minecraft/block/Block;")
                        + ")Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realCanHarvestBlock",
                "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "canHarvestBlock",
                "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superCanHarvestBlock",
                "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "canHarvestBlock",
                "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalCanHarvestBlock) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localCanHarvestBlock",
                    "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "canHarvestBlock",
                    "" + (this.isObfuscated ? "(Laji;)Z" : "(Lnet/minecraft/block/Block;)Z") + "");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "canPlayerEdit",
                "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ILOAD, 4);
        mv.visitVarInsn(Opcodes.ALOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "canPlayerEdit",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "IIIILadd;" : "IIIILnet/minecraft/item/ItemStack;") + ")Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realCanPlayerEdit",
                "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ILOAD, 4);
        mv.visitVarInsn(Opcodes.ALOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "canPlayerEdit",
                "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superCanPlayerEdit",
                "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ILOAD, 4);
        mv.visitVarInsn(Opcodes.ALOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "canPlayerEdit",
                "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalCanPlayerEdit) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localCanPlayerEdit",
                    "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 4);
            mv.visitVarInsn(Opcodes.ALOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "canPlayerEdit",
                    "" + (this.isObfuscated ? "(IIIILadd;)Z" : "(IIIILnet/minecraft/item/ItemStack;)Z") + "");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "g_" : "canTriggerWalking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "canTriggerWalking",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realCanTriggerWalking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "g_" : "canTriggerWalking",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superCanTriggerWalking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "g_" : "canTriggerWalking",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalCanTriggerWalking) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCanTriggerWalking", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "g_" : "canTriggerWalking",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "k" : "closeScreen", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "closeScreen",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realCloseScreen", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "k" : "closeScreen",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superCloseScreen", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "k" : "closeScreen",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalCloseScreen) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localCloseScreen", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "k" : "closeScreen",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "d" : "damageEntity",
                "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "damageEntity",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lro;F" : "Lnet/minecraft/util/DamageSource;F") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDamageEntity",
                "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "d" : "damageEntity",
                "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDamageEntity",
                "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "d" : "damageEntity",
                "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDamageEntity) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDamageEntity",
                    "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "d" : "damageEntity",
                    "" + (this.isObfuscated ? "(Lro;F)V" : "(Lnet/minecraft/util/DamageSource;F)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_146098_a",
                "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIBrewingStand",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Laov;" : "Lnet/minecraft/tileentity/TileEntityBrewingStand;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIBrewingStand",
                "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_146098_a",
                "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIBrewingStand",
                "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_146098_a",
                "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIBrewingStand) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIBrewingStand",
                    "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_146098_a",
                    "" + (this.isObfuscated ? "(Laov;)V" : "(Lnet/minecraft/tileentity/TileEntityBrewingStand;)V")
                            + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "displayGUIChest",
                "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIChest",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lrb;" : "Lnet/minecraft/inventory/IInventory;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIChest",
                "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "displayGUIChest",
                "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIChest",
                "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "displayGUIChest",
                "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIChest) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIChest",
                    "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "displayGUIChest",
                    "" + (this.isObfuscated ? "(Lrb;)V" : "(Lnet/minecraft/inventory/IInventory;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_146102_a",
                "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIDispenser",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lapb;" : "Lnet/minecraft/tileentity/TileEntityDispenser;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIDispenser",
                "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_146102_a",
                "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIDispenser",
                "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_146102_a",
                "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIDispenser) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIDispenser",
                    "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_146102_a",
                    "" + (this.isObfuscated ? "(Lapb;)V" : "(Lnet/minecraft/tileentity/TileEntityDispenser;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_146100_a",
                "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIEditSign",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Laor;" : "Lnet/minecraft/tileentity/TileEntity;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIEditSign",
                "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_146100_a",
                "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIEditSign",
                "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_146100_a",
                "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIEditSign) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIEditSign",
                    "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_146100_a",
                    "" + (this.isObfuscated ? "(Laor;)V" : "(Lnet/minecraft/tileentity/TileEntity;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "displayGUIEnchantment",
                "(IIILjava/lang/String;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIEnchantment",
                "(Lapi/player/client/IClientPlayerAPI;IIILjava/lang/String;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIEnchantment",
                "(IIILjava/lang/String;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "displayGUIEnchantment",
                "(IIILjava/lang/String;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIEnchantment",
                "(IIILjava/lang/String;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "displayGUIEnchantment",
                "(IIILjava/lang/String;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIEnchantment) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIEnchantment",
                    "(IIILjava/lang/String;)V",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ALOAD, 4);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "displayGUIEnchantment",
                    "(IIILjava/lang/String;)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_146101_a",
                "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIFurnace",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lapg;" : "Lnet/minecraft/tileentity/TileEntityFurnace;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDisplayGUIFurnace",
                "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_146101_a",
                "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDisplayGUIFurnace",
                "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_146101_a",
                "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIFurnace) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDisplayGUIFurnace",
                    "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_146101_a",
                    "" + (this.isObfuscated ? "(Lapg;)V" : "(Lnet/minecraft/tileentity/TileEntityFurnace;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "b" : "displayGUIWorkbench", "(III)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "displayGUIWorkbench",
                "(Lapi/player/client/IClientPlayerAPI;III)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realDisplayGUIWorkbench", "(III)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "b" : "displayGUIWorkbench",
                "(III)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superDisplayGUIWorkbench", "(III)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "b" : "displayGUIWorkbench",
                "(III)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDisplayGUIWorkbench) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localDisplayGUIWorkbench", "(III)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "b" : "displayGUIWorkbench",
                    "(III)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "dropOneItem",
                "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "dropOneItem",
                "(Lapi/player/client/IClientPlayerAPI;Z)"
                        + (this.isObfuscated ? "Lxk;" : "Lnet/minecraft/entity/item/EntityItem;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDropOneItem",
                "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "dropOneItem",
                "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDropOneItem",
                "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "dropOneItem",
                "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDropOneItem) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDropOneItem",
                    "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "dropOneItem",
                    "" + (this.isObfuscated ? "(Z)Lxk;" : "(Z)Lnet/minecraft/entity/item/EntityItem;") + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "dropPlayerItemWithRandomChoice",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "dropPlayerItem",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Ladd;Z" : "Lnet/minecraft/item/ItemStack;Z") + ")"
                        + (this.isObfuscated ? "Lxk;" : "Lnet/minecraft/entity/item/EntityItem;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDropPlayerItem",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "dropPlayerItemWithRandomChoice",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDropPlayerItem",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "dropPlayerItemWithRandomChoice",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;Z)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDropPlayerItem) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDropPlayerItem",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;Z)Lxk;"
                                    : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                            + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "dropPlayerItemWithRandomChoice",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;Z)Lxk;"
                                    : "(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/item/EntityItem;")
                            + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_146097_a",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "dropPlayerItemWithRandomChoice",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Ladd;ZZ" : "Lnet/minecraft/item/ItemStack;ZZ") + ")"
                        + (this.isObfuscated ? "Lxk;" : "Lnet/minecraft/entity/item/EntityItem;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realDropPlayerItemWithRandomChoice",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_146097_a",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superDropPlayerItemWithRandomChoice",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_146097_a",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;ZZ)Lxk;"
                                : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalDropPlayerItemWithRandomChoice) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localDropPlayerItemWithRandomChoice",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;ZZ)Lxk;"
                                    : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                            + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_146097_a",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;ZZ)Lxk;"
                                    : "(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/item/EntityItem;")
                            + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "b" : "fall", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "fall",
                "(Lapi/player/client/IClientPlayerAPI;F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realFall", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "b" : "fall",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superFall", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "b" : "fall",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalFall) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localFall", "(F)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "b" : "fall",
                    "(F)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "bl" : "getAIMoveSpeed", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getAIMoveSpeed",
                "(Lapi/player/client/IClientPlayerAPI;)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetAIMoveSpeed", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bl" : "getAIMoveSpeed",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetAIMoveSpeed", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bl" : "getAIMoveSpeed",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetAIMoveSpeed) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetAIMoveSpeed", "()F", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bl" : "getAIMoveSpeed",
                    "()F");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "bK" : "getBedOrientationInDegrees", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getBedOrientationInDegrees",
                "(Lapi/player/client/IClientPlayerAPI;)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetBedOrientationInDegrees", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bK" : "getBedOrientationInDegrees",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetBedOrientationInDegrees", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bK" : "getBedOrientationInDegrees",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetBedOrientationInDegrees) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetBedOrientationInDegrees", "()F", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bK" : "getBedOrientationInDegrees",
                    "()F");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "d" : "getBrightness", "(F)F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getBrightness",
                "(Lapi/player/client/IClientPlayerAPI;F)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetBrightness", "(F)F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "d" : "getBrightness",
                "(F)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetBrightness", "(F)F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "d" : "getBrightness",
                "(F)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetBrightness) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetBrightness", "(F)F", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "d" : "getBrightness",
                    "(F)F");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "c" : "getBrightnessForRender", "(F)I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getBrightnessForRender",
                "(Lapi/player/client/IClientPlayerAPI;F)I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetBrightnessForRender", "(F)I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "c" : "getBrightnessForRender",
                "(F)I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetBrightnessForRender", "(F)I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "c" : "getBrightnessForRender",
                "(F)I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetBrightnessForRender) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetBrightnessForRender", "(F)I", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "c" : "getBrightnessForRender",
                    "(F)I");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "getCurrentPlayerStrVsBlock",
                "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getCurrentPlayerStrVsBlock",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Laji;Z" : "Lnet/minecraft/block/Block;Z") + ")F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realGetCurrentPlayerStrVsBlock",
                "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "getCurrentPlayerStrVsBlock",
                "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superGetCurrentPlayerStrVsBlock",
                "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "getCurrentPlayerStrVsBlock",
                "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetCurrentPlayerStrVsBlock) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetCurrentPlayerStrVsBlock",
                    "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "getCurrentPlayerStrVsBlock",
                    "" + (this.isObfuscated ? "(Laji;Z)F" : "(Lnet/minecraft/block/Block;Z)F") + "");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                "getBreakSpeed",
                "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getCurrentPlayerStrVsBlockForge",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Laji;ZI" : "Lnet/minecraft/block/Block;ZI") + ")F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realGetCurrentPlayerStrVsBlockForge",
                "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                "getBreakSpeed",
                "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superGetCurrentPlayerStrVsBlockForge",
                "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                "getBreakSpeed",
                "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetCurrentPlayerStrVsBlockForge) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetCurrentPlayerStrVsBlockForge",
                    "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    "getBreakSpeed",
                    "" + (this.isObfuscated ? "(Laji;ZI)F" : "(Lnet/minecraft/block/Block;ZI)F") + "");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "e" : "getDistanceSq", "(DDD)D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getDistanceSq",
                "(Lapi/player/client/IClientPlayerAPI;DDD)D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetDistanceSq", "(DDD)D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "e" : "getDistanceSq",
                "(DDD)D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetDistanceSq", "(DDD)D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "e" : "getDistanceSq",
                "(DDD)D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetDistanceSq) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetDistanceSq", "(DDD)D", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "e" : "getDistanceSq",
                    "(DDD)D");
            mv.visitInsn(Opcodes.DRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "f" : "getDistanceSqToEntity",
                "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getDistanceSqToEntity",
                "(Lapi/player/client/IClientPlayerAPI;" + (this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;")
                        + ")D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realGetDistanceSqToEntity",
                "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "f" : "getDistanceSqToEntity",
                "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superGetDistanceSqToEntity",
                "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "f" : "getDistanceSqToEntity",
                "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetDistanceSqToEntity) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetDistanceSqToEntity",
                    "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "f" : "getDistanceSqToEntity",
                    "" + (this.isObfuscated ? "(Lsa;)D" : "(Lnet/minecraft/entity/Entity;)D") + "");
            mv.visitInsn(Opcodes.DRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "t" : "getFOVMultiplier", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getFOVMultiplier",
                "(Lapi/player/client/IClientPlayerAPI;)F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetFOVMultiplier", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "t" : "getFOVMultiplier",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetFOVMultiplier", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "t" : "getFOVMultiplier",
                "()F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetFOVMultiplier) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetFOVMultiplier", "()F", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "t" : "getFOVMultiplier",
                    "()F");
            mv.visitInsn(Opcodes.FRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "aT" : "getHurtSound", "()Ljava/lang/String;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getHurtSound",
                "(Lapi/player/client/IClientPlayerAPI;)Ljava/lang/String;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetHurtSound", "()Ljava/lang/String;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aT" : "getHurtSound",
                "()Ljava/lang/String;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetHurtSound", "()Ljava/lang/String;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "aT" : "getHurtSound",
                "()Ljava/lang/String;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetHurtSound) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetHurtSound", "()Ljava/lang/String;", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "aT" : "getHurtSound",
                    "()Ljava/lang/String;");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "b" : "getItemIcon",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getItemIcon",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Ladd;I" : "Lnet/minecraft/item/ItemStack;I") + ")"
                        + (this.isObfuscated ? "Lrf;" : "Lnet/minecraft/util/IIcon;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realGetItemIcon",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "b" : "getItemIcon",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superGetItemIcon",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "b" : "getItemIcon",
                ""
                        + (this.isObfuscated
                                ? "(Ladd;I)Lrf;"
                                : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetItemIcon) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localGetItemIcon",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;I)Lrf;"
                                    : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                            + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "b" : "getItemIcon",
                    ""
                            + (this.isObfuscated
                                    ? "(Ladd;I)Lrf;"
                                    : "(Lnet/minecraft/item/ItemStack;I)Lnet/minecraft/util/IIcon;")
                            + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "bM" : "getSleepTimer", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getSleepTimer",
                "(Lapi/player/client/IClientPlayerAPI;)I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realGetSleepTimer", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bM" : "getSleepTimer",
                "()I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superGetSleepTimer", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bM" : "getSleepTimer",
                "()I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalGetSleepTimer) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localGetSleepTimer", "()I", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bM" : "getSleepTimer",
                    "()I");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "P" : "handleLavaMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "handleLavaMovement",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realHandleLavaMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "P" : "handleLavaMovement",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superHandleLavaMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "P" : "handleLavaMovement",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalHandleLavaMovement) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHandleLavaMovement", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "P" : "handleLavaMovement",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "N" : "handleWaterMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "handleWaterMovement",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realHandleWaterMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "N" : "handleWaterMovement",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superHandleWaterMovement", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "N" : "handleWaterMovement",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalHandleWaterMovement) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHandleWaterMovement", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "N" : "handleWaterMovement",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "f" : "heal", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "heal",
                "(Lapi/player/client/IClientPlayerAPI;F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realHeal", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "f" : "heal",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superHeal", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "f" : "heal",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalHeal) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localHeal", "(F)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "f" : "heal",
                    "(F)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "aa" : "isEntityInsideOpaqueBlock", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isEntityInsideOpaqueBlock",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsEntityInsideOpaqueBlock", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aa" : "isEntityInsideOpaqueBlock",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsEntityInsideOpaqueBlock", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "aa" : "isEntityInsideOpaqueBlock",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsEntityInsideOpaqueBlock) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsEntityInsideOpaqueBlock", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "aa" : "isEntityInsideOpaqueBlock",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "M" : "isInWater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isInWater",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsInWater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "M" : "isInWater",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsInWater", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "M" : "isInWater",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsInWater) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsInWater", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "M" : "isInWater",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "isInsideOfMaterial",
                "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isInsideOfMaterial",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lawt;" : "Lnet/minecraft/block/material/Material;") + ")Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realIsInsideOfMaterial",
                "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "isInsideOfMaterial",
                "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superIsInsideOfMaterial",
                "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "isInsideOfMaterial",
                "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsInsideOfMaterial) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localIsInsideOfMaterial",
                    "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "isInsideOfMaterial",
                    "" + (this.isObfuscated ? "(Lawt;)Z" : "(Lnet/minecraft/block/material/Material;)Z") + "");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "h_" : "isOnLadder", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isOnLadder",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsOnLadder", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "h_" : "isOnLadder",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsOnLadder", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "h_" : "isOnLadder",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsOnLadder) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsOnLadder", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "h_" : "isOnLadder",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "bm" : "isPlayerSleeping", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isPlayerSleeping",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsPlayerSleeping", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bm" : "isPlayerSleeping",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsPlayerSleeping", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bm" : "isPlayerSleeping",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsPlayerSleeping) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsPlayerSleeping", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bm" : "isPlayerSleeping",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "an" : "isSneaking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isSneaking",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsSneaking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "an" : "isSneaking",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsSneaking", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "an" : "isSneaking",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsSneaking) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsSneaking", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "an" : "isSneaking",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "ao" : "isSprinting", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "isSprinting",
                "(Lapi/player/client/IClientPlayerAPI;)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realIsSprinting", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ao" : "isSprinting",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superIsSprinting", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "ao" : "isSprinting",
                "()Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalIsSprinting) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localIsSprinting", "()Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "ao" : "isSprinting",
                    "()Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "bj" : "jump", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "jump",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realJump", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bj" : "jump",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superJump", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bj" : "jump",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalJump) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localJump", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bj" : "jump",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "knockBack",
                "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "knockBack",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lsa;FDD" : "Lnet/minecraft/entity/Entity;FDD") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realKnockBack",
                "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "knockBack",
                "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superKnockBack",
                "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "knockBack",
                "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalKnockBack) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localKnockBack",
                    "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 2);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "knockBack",
                    "" + (this.isObfuscated ? "(Lsa;FDD)V" : "(Lnet/minecraft/entity/Entity;FDD)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "d" : "moveEntity", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "moveEntity",
                "(Lapi/player/client/IClientPlayerAPI;DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realMoveEntity", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "d" : "moveEntity",
                "(DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superMoveEntity", "(DDD)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "d" : "moveEntity",
                "(DDD)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalMoveEntity) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveEntity", "(DDD)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "d" : "moveEntity",
                    "(DDD)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "e" : "moveEntityWithHeading", "(FF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "moveEntityWithHeading",
                "(Lapi/player/client/IClientPlayerAPI;FF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realMoveEntityWithHeading", "(FF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "e" : "moveEntityWithHeading",
                "(FF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superMoveEntityWithHeading", "(FF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "e" : "moveEntityWithHeading",
                "(FF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalMoveEntityWithHeading) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveEntityWithHeading", "(FF)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 2);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "e" : "moveEntityWithHeading",
                    "(FF)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "a" : "moveFlying", "(FFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "moveFlying",
                "(Lapi/player/client/IClientPlayerAPI;FFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realMoveFlying", "(FFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "moveFlying",
                "(FFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superMoveFlying", "(FFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 2);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "moveFlying",
                "(FFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalMoveFlying) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localMoveFlying", "(FFF)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 2);
            mv.visitVarInsn(Opcodes.FLOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "moveFlying",
                    "(FFF)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "onDeath",
                "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "onDeath",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lro;" : "Lnet/minecraft/util/DamageSource;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realOnDeath",
                "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "onDeath",
                "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superOnDeath",
                "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "onDeath",
                "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalOnDeath) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localOnDeath",
                    "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "onDeath",
                    "" + (this.isObfuscated ? "(Lro;)V" : "(Lnet/minecraft/util/DamageSource;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "e" : "onLivingUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "onLivingUpdate",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realOnLivingUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "e" : "onLivingUpdate",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superOnLivingUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "e" : "onLivingUpdate",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalOnLivingUpdate) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnLivingUpdate", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "e" : "onLivingUpdate",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "onKillEntity",
                "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "onKillEntity",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lsv;" : "Lnet/minecraft/entity/EntityLivingBase;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realOnKillEntity",
                "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "onKillEntity",
                "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superOnKillEntity",
                "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "onKillEntity",
                "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalOnKillEntity) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localOnKillEntity",
                    "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "onKillEntity",
                    "" + (this.isObfuscated ? "(Lsv;)V" : "(Lnet/minecraft/entity/EntityLivingBase;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "onStruckByLightning",
                "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "onStruckByLightning",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Lxh;" : "Lnet/minecraft/entity/effect/EntityLightningBolt;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realOnStruckByLightning",
                "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "onStruckByLightning",
                "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superOnStruckByLightning",
                "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "onStruckByLightning",
                "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalOnStruckByLightning) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localOnStruckByLightning",
                    "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "onStruckByLightning",
                    "" + (this.isObfuscated ? "(Lxh;)V" : "(Lnet/minecraft/entity/effect/EntityLightningBolt;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "h" : "onUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "onUpdate",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realOnUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "h" : "onUpdate",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superOnUpdate", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "h" : "onUpdate",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalOnUpdate) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localOnUpdate", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "h" : "onUpdate",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "func_145780_a",
                "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "playStepSound",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "IIILaji;" : "IIILnet/minecraft/block/Block;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realPlayStepSound",
                "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "func_145780_a",
                "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superPlayStepSound",
                "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitVarInsn(Opcodes.ALOAD, 4);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "func_145780_a",
                "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalPlayStepSound) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localPlayStepSound",
                    "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ALOAD, 4);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "func_145780_a",
                    "" + (this.isObfuscated ? "(IIILaji;)V" : "(IIILnet/minecraft/block/Block;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "j" : "func_145771_j", "(DDD)Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "pushOutOfBlocks",
                "(Lapi/player/client/IClientPlayerAPI;DDD)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realPushOutOfBlocks", "(DDD)Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "j" : "func_145771_j",
                "(DDD)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superPushOutOfBlocks", "(DDD)Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "j" : "func_145771_j",
                "(DDD)Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalPushOutOfBlocks) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localPushOutOfBlocks", "(DDD)Z", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "j" : "func_145771_j",
                    "(DDD)Z");
            mv.visitInsn(Opcodes.IRETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "rayTrace",
                "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "rayTrace",
                "(Lapi/player/client/IClientPlayerAPI;DF)"
                        + (this.isObfuscated ? "Lazu;" : "Lnet/minecraft/util/MovingObjectPosition;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realRayTrace",
                "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "rayTrace",
                "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superRayTrace",
                "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.FLOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "rayTrace",
                "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalRayTrace) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localRayTrace",
                    "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.FLOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "rayTrace",
                    "" + (this.isObfuscated ? "(DF)Lazu;" : "(DF)Lnet/minecraft/util/MovingObjectPosition;") + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "readEntityFromNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "readEntityFromNBT",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Ldh;" : "Lnet/minecraft/nbt/NBTTagCompound;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realReadEntityFromNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "readEntityFromNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superReadEntityFromNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "readEntityFromNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalReadEntityFromNBT) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localReadEntityFromNBT",
                    "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "readEntityFromNBT",
                    "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "bH" : "respawnPlayer", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "respawnPlayer",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realRespawnPlayer", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bH" : "respawnPlayer",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superRespawnPlayer", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bH" : "respawnPlayer",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalRespawnPlayer) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localRespawnPlayer", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bH" : "respawnPlayer",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "B" : "setDead", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "setDead",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSetDead", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "B" : "setDead",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSetDead", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "B" : "setDead",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSetDead) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetDead", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "B" : "setDead",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "n" : "setPlayerSPHealth", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "setPlayerSPHealth",
                "(Lapi/player/client/IClientPlayerAPI;F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSetPlayerSPHealth", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "n" : "setPlayerSPHealth",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSetPlayerSPHealth", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "n" : "setPlayerSPHealth",
                "(F)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSetPlayerSPHealth) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetPlayerSPHealth", "(F)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.FLOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "n" : "setPlayerSPHealth",
                    "(F)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "a" : "setPositionAndRotation", "(DDDFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitVarInsn(Opcodes.FLOAD, 7);
        mv.visitVarInsn(Opcodes.FLOAD, 8);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "setPositionAndRotation",
                "(Lapi/player/client/IClientPlayerAPI;DDDFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSetPositionAndRotation", "(DDDFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitVarInsn(Opcodes.FLOAD, 7);
        mv.visitVarInsn(Opcodes.FLOAD, 8);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "setPositionAndRotation",
                "(DDDFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSetPositionAndRotation", "(DDDFF)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitVarInsn(Opcodes.DLOAD, 3);
        mv.visitVarInsn(Opcodes.DLOAD, 5);
        mv.visitVarInsn(Opcodes.FLOAD, 7);
        mv.visitVarInsn(Opcodes.FLOAD, 8);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "setPositionAndRotation",
                "(DDDFF)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSetPositionAndRotation) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetPositionAndRotation", "(DDDFF)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.DLOAD, 1);
            mv.visitVarInsn(Opcodes.DLOAD, 3);
            mv.visitVarInsn(Opcodes.DLOAD, 5);
            mv.visitVarInsn(Opcodes.FLOAD, 7);
            mv.visitVarInsn(Opcodes.FLOAD, 8);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "setPositionAndRotation",
                    "(DDDFF)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "b" : "setSneaking", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "setSneaking",
                "(Lapi/player/client/IClientPlayerAPI;Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSetSneaking", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "b" : "setSneaking",
                "(Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSetSneaking", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "b" : "setSneaking",
                "(Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSetSneaking) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetSneaking", "(Z)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "b" : "setSneaking",
                    "(Z)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "c" : "setSprinting", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "setSprinting",
                "(Lapi/player/client/IClientPlayerAPI;Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSetSprinting", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "c" : "setSprinting",
                "(Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSetSprinting", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "c" : "setSprinting",
                "(Z)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSetSprinting) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSetSprinting", "(Z)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "c" : "setSprinting",
                    "(Z)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "a" : "sleepInBedAt",
                "" + (this.isObfuscated ? "(III)Lza;" : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "sleepInBedAt",
                "(Lapi/player/client/IClientPlayerAPI;III)"
                        + (this.isObfuscated ? "Lza;" : "Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;") + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realSleepInBedAt",
                "" + (this.isObfuscated ? "(III)Lza;" : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "sleepInBedAt",
                "" + (this.isObfuscated ? "(III)Lza;" : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superSleepInBedAt",
                "" + (this.isObfuscated ? "(III)Lza;" : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                        + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "sleepInBedAt",
                "" + (this.isObfuscated ? "(III)Lza;" : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                        + "");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSleepInBedAt) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localSleepInBedAt",
                    ""
                            + (this.isObfuscated
                                    ? "(III)Lza;"
                                    : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                            + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "sleepInBedAt",
                    ""
                            + (this.isObfuscated
                                    ? "(III)Lza;"
                                    : "(III)Lnet/minecraft/entity/player/EntityPlayer$EnumStatus;")
                            + "");
            mv.visitInsn(Opcodes.ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "ba" : "swingItem", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "swingItem",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realSwingItem", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ba" : "swingItem",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superSwingItem", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "ba" : "swingItem",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalSwingItem) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localSwingItem", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "ba" : "swingItem",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC, this.isObfuscated ? "bq" : "updateEntityActionState", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "updateEntityActionState",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realUpdateEntityActionState", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bq" : "updateEntityActionState",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superUpdateEntityActionState", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "bq" : "updateEntityActionState",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalUpdateEntityActionState) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localUpdateEntityActionState", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "bq" : "updateEntityActionState",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "ab" : "updateRidden", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "updateRidden",
                "(Lapi/player/client/IClientPlayerAPI;)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realUpdateRidden", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ab" : "updateRidden",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superUpdateRidden", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "ab" : "updateRidden",
                "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalUpdateRidden) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localUpdateRidden", "()V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "ab" : "updateRidden",
                    "()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC, this.isObfuscated ? "a" : "wakeUpPlayer", "(ZZZ)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "wakeUpPlayer",
                "(Lapi/player/client/IClientPlayerAPI;ZZZ)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "realWakeUpPlayer", "(ZZZ)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "wakeUpPlayer",
                "(ZZZ)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "superWakeUpPlayer", "(ZZZ)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "a" : "wakeUpPlayer",
                "(ZZZ)V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalWakeUpPlayer) {
            mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "localWakeUpPlayer", "(ZZZ)V", null, null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "a" : "wakeUpPlayer",
                    "(ZZZ)V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC,
                this.isObfuscated ? "b" : "writeEntityToNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "writeEntityToNBT",
                "(Lapi/player/client/IClientPlayerAPI;"
                        + (this.isObfuscated ? "Ldh;" : "Lnet/minecraft/nbt/NBTTagCompound;") + ")V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "realWriteEntityToNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "b" : "writeEntityToNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "superWriteEntityToNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESPECIAL,
                this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                this.isObfuscated ? "b" : "writeEntityToNBT",
                "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        if (!this.hadLocalWriteEntityToNBT) {
            mv = this.cv.visitMethod(
                    Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                    "localWriteEntityToNBT",
                    "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "",
                    null,
                    null);
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(
                    Opcodes.INVOKESPECIAL,
                    this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer",
                    this.isObfuscated ? "b" : "writeEntityToNBT",
                    "" + (this.isObfuscated ? "(Ldh;)V" : "(Lnet/minecraft/nbt/NBTTagCompound;)V") + "");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getAddedToChunkField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ag" : "addedToChunk",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setAddedToChunkField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ag" : "addedToChunk",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getArrowHitTimerField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "av" : "arrowHitTimer",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setArrowHitTimerField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "av" : "arrowHitTimer",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getAttackTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aB" : "attackTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setAttackTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aB" : "attackTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getAttackedAtYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "az" : "attackedAtYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setAttackedAtYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "az" : "attackedAtYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getAttackingPlayerField",
                this.isObfuscated ? "()Lyz;" : "()Lnet/minecraft/entity/player/EntityPlayer;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aR" : "attackingPlayer",
                this.isObfuscated ? "Lyz;" : "Lnet/minecraft/entity/player/EntityPlayer;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setAttackingPlayerField",
                this.isObfuscated ? "(Lyz;)V" : "(Lnet/minecraft/entity/player/EntityPlayer;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aR" : "attackingPlayer",
                this.isObfuscated ? "Lyz;" : "Lnet/minecraft/entity/player/EntityPlayer;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getBoundingBoxField",
                this.isObfuscated ? "()Lazt;" : "()Lnet/minecraft/util/AxisAlignedBB;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "C" : "boundingBox",
                this.isObfuscated ? "Lazt;" : "Lnet/minecraft/util/AxisAlignedBB;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getCameraPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aJ" : "cameraPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setCameraPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aJ" : "cameraPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getCameraYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bs" : "cameraYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setCameraYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bs" : "cameraYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getCapabilitiesField",
                this.isObfuscated ? "()Lyw;" : "()Lnet/minecraft/entity/player/PlayerCapabilities;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bE" : "capabilities",
                this.isObfuscated ? "Lyw;" : "Lnet/minecraft/entity/player/PlayerCapabilities;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setCapabilitiesField",
                this.isObfuscated ? "(Lyw;)V" : "(Lnet/minecraft/entity/player/PlayerCapabilities;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bE" : "capabilities",
                this.isObfuscated ? "Lyw;" : "Lnet/minecraft/entity/player/PlayerCapabilities;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getChunkCoordXField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ah" : "chunkCoordX",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setChunkCoordXField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ah" : "chunkCoordX",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getChunkCoordYField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ai" : "chunkCoordY",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setChunkCoordYField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ai" : "chunkCoordY",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getChunkCoordZField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aj" : "chunkCoordZ",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setChunkCoordZField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aj" : "chunkCoordZ",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getDataWatcherField",
                this.isObfuscated ? "()Lte;" : "()Lnet/minecraft/entity/DataWatcher;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "af" : "dataWatcher",
                this.isObfuscated ? "Lte;" : "Lnet/minecraft/entity/DataWatcher;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setDataWatcherField",
                this.isObfuscated ? "(Lte;)V" : "(Lnet/minecraft/entity/DataWatcher;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "af" : "dataWatcher",
                this.isObfuscated ? "Lte;" : "Lnet/minecraft/entity/DataWatcher;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getDeadField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aT" : "dead",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setDeadField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aT" : "dead",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getDeathTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aA" : "deathTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setDeathTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aA" : "deathTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getDimensionField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ap" : "dimension",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setDimensionField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ap" : "dimension",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getDistanceWalkedModifiedField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "P" : "distanceWalkedModified",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setDistanceWalkedModifiedField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "P" : "distanceWalkedModified",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getDistanceWalkedOnStepModifiedField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Q" : "distanceWalkedOnStepModified",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setDistanceWalkedOnStepModifiedField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Q" : "distanceWalkedOnStepModified",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getEntityAgeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aU" : "entityAge",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setEntityAgeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aU" : "entityAge",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getEntityCollisionReductionField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Y" : "entityCollisionReduction",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setEntityCollisionReductionField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Y" : "entityCollisionReduction",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getEntityUniqueIDField", "()Ljava/util/UUID;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ar" : "entityUniqueID",
                "Ljava/util/UUID;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setEntityUniqueIDField", "(Ljava/util/UUID;)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ar" : "entityUniqueID",
                "Ljava/util/UUID;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getExperienceField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bH" : "experience",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setExperienceField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bH" : "experience",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getExperienceLevelField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bF" : "experienceLevel",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setExperienceLevelField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bF" : "experienceLevel",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getExperienceTotalField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bG" : "experienceTotal",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setExperienceTotalField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bG" : "experienceTotal",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getFallDistanceField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "R" : "fallDistance",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setFallDistanceField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "R" : "fallDistance",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_110154_aXField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aW" : "field_110154_aX",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_110154_aXField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aW" : "field_110154_aX",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70135_KField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "J" : "field_70135_K",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70135_KField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "J" : "field_70135_K",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70741_aBField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aZ" : "field_70741_aB",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70741_aBField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aZ" : "field_70741_aB",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70763_axField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aY" : "field_70763_ax",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70763_axField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aY" : "field_70763_ax",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70764_awField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aX" : "field_70764_aw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70764_awField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aX" : "field_70764_aw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70768_auField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aV" : "field_70768_au",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70768_auField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aV" : "field_70768_au",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70769_aoField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aK" : "field_70769_ao",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70769_aoField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aK" : "field_70769_ao",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_70770_apField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aL" : "field_70770_ap",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_70770_apField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aL" : "field_70770_ap",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71079_bUField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bC" : "field_71079_bU",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71079_bUField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bC" : "field_71079_bU",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71082_cxField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "cc" : "field_71082_cx",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71082_cxField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "cc" : "field_71082_cx",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71085_bRField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bz" : "field_71085_bR",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71085_bRField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bz" : "field_71085_bR",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71089_bVField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bD" : "field_71089_bV",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71089_bVField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bD" : "field_71089_bV",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71091_bMField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bu" : "field_71091_bM",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71091_bMField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bu" : "field_71091_bM",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71094_bPField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bx" : "field_71094_bP",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71094_bPField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bx" : "field_71094_bP",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71095_bQField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "by" : "field_71095_bQ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71095_bQField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "by" : "field_71095_bQ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71096_bNField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bv" : "field_71096_bN",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71096_bNField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bv" : "field_71096_bN",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getField_71097_bOField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bw" : "field_71097_bO",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setField_71097_bOField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bw" : "field_71097_bO",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getField_71160_ciField",
                this.isObfuscated ? "()Lqm;" : "()Lnet/minecraft/util/MouseFilter;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bT" : "field_71160_ci",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setField_71160_ciField",
                this.isObfuscated ? "(Lqm;)V" : "(Lnet/minecraft/util/MouseFilter;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bT" : "field_71160_ci",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getField_71161_cjField",
                this.isObfuscated ? "()Lqm;" : "()Lnet/minecraft/util/MouseFilter;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bU" : "field_71161_cj",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setField_71161_cjField",
                this.isObfuscated ? "(Lqm;)V" : "(Lnet/minecraft/util/MouseFilter;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bU" : "field_71161_cj",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getField_71162_chField",
                this.isObfuscated ? "()Lqm;" : "()Lnet/minecraft/util/MouseFilter;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bS" : "field_71162_ch",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setField_71162_chField",
                this.isObfuscated ? "(Lqm;)V" : "(Lnet/minecraft/util/MouseFilter;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bS" : "field_71162_ch",
                this.isObfuscated ? "Lqm;" : "Lnet/minecraft/util/MouseFilter;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getFireResistanceField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ab" : "fireResistance",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setFireResistanceField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ab" : "fireResistance",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getFishEntityField",
                this.isObfuscated ? "()Lxe;" : "()Lnet/minecraft/entity/projectile/EntityFishHook;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bK" : "fishEntity",
                this.isObfuscated ? "Lxe;" : "Lnet/minecraft/entity/projectile/EntityFishHook;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setFishEntityField",
                this.isObfuscated ? "(Lxe;)V" : "(Lnet/minecraft/entity/projectile/EntityFishHook;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bK" : "fishEntity",
                this.isObfuscated ? "Lxe;" : "Lnet/minecraft/entity/projectile/EntityFishHook;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getFlyToggleTimerField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bq" : "flyToggleTimer",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setFlyToggleTimerField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bq" : "flyToggleTimer",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getFoodStatsField",
                this.isObfuscated ? "()Lzr;" : "()Lnet/minecraft/util/FoodStats;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bp" : "foodStats",
                this.isObfuscated ? "Lzr;" : "Lnet/minecraft/util/FoodStats;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setFoodStatsField",
                this.isObfuscated ? "(Lzr;)V" : "(Lnet/minecraft/util/FoodStats;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bp" : "foodStats",
                this.isObfuscated ? "Lzr;" : "Lnet/minecraft/util/FoodStats;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getForceSpawnField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "n" : "forceSpawn",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setForceSpawnField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "n" : "forceSpawn",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getHeightField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "N" : "height",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setHeightField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "N" : "height",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getHorseJumpPowerField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bO" : "horseJumpPower",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setHorseJumpPowerField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bO" : "horseJumpPower",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getHorseJumpPowerCounterField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "horseJumpPowerCounter",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setHorseJumpPowerCounterField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "a" : "horseJumpPowerCounter",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getHurtResistantTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ad" : "hurtResistantTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setHurtResistantTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ad" : "hurtResistantTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getHurtTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ax" : "hurtTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setHurtTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ax" : "hurtTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIgnoreFrustumCheckField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ak" : "ignoreFrustumCheck",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIgnoreFrustumCheckField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ak" : "ignoreFrustumCheck",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getInPortalField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "an" : "inPortal",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setInPortalField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "an" : "inPortal",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getInWaterField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ac" : "inWater",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setInWaterField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ac" : "inWater",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getInventoryField",
                this.isObfuscated ? "()Lyx;" : "()Lnet/minecraft/entity/player/InventoryPlayer;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bm" : "inventory",
                this.isObfuscated ? "Lyx;" : "Lnet/minecraft/entity/player/InventoryPlayer;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setInventoryField",
                this.isObfuscated ? "(Lyx;)V" : "(Lnet/minecraft/entity/player/InventoryPlayer;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bm" : "inventory",
                this.isObfuscated ? "Lyx;" : "Lnet/minecraft/entity/player/InventoryPlayer;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getInventoryContainerField",
                this.isObfuscated ? "()Lzs;" : "()Lnet/minecraft/inventory/Container;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bn" : "inventoryContainer",
                this.isObfuscated ? "Lzs;" : "Lnet/minecraft/inventory/Container;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setInventoryContainerField",
                this.isObfuscated ? "(Lzs;)V" : "(Lnet/minecraft/inventory/Container;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bn" : "inventoryContainer",
                this.isObfuscated ? "Lzs;" : "Lnet/minecraft/inventory/Container;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsAirBorneField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "al" : "isAirBorne",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsAirBorneField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "al" : "isAirBorne",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsCollidedField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "G" : "isCollided",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsCollidedField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "G" : "isCollided",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsCollidedHorizontallyField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "E" : "isCollidedHorizontally",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsCollidedHorizontallyField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "E" : "isCollidedHorizontally",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsCollidedVerticallyField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "F" : "isCollidedVertically",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsCollidedVerticallyField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "F" : "isCollidedVertically",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsDeadField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "K" : "isDead",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsDeadField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "K" : "isDead",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsImmuneToFireField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ae" : "isImmuneToFire",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsImmuneToFireField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ae" : "isImmuneToFire",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsInWebField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "I" : "isInWeb",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsInWebField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "I" : "isInWeb",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsJumpingField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bc" : "isJumping",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsJumpingField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bc" : "isJumping",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getIsSwingInProgressField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "at" : "isSwingInProgress",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setIsSwingInProgressField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "at" : "isSwingInProgress",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getJumpMovementFactorField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aQ" : "jumpMovementFactor",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setJumpMovementFactorField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aQ" : "jumpMovementFactor",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLastDamageField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bb" : "lastDamage",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLastDamageField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bb" : "lastDamage",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLastTickPosXField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "S" : "lastTickPosX",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLastTickPosXField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "S" : "lastTickPosX",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLastTickPosYField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "T" : "lastTickPosY",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLastTickPosYField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "T" : "lastTickPosY",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLastTickPosZField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "U" : "lastTickPosZ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLastTickPosZField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "U" : "lastTickPosZ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLimbSwingField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aG" : "limbSwing",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLimbSwingField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aG" : "limbSwing",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getLimbSwingAmountField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aF" : "limbSwingAmount",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setLimbSwingAmountField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aF" : "limbSwingAmount",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMaxHurtResistantTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aH" : "maxHurtResistantTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMaxHurtResistantTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aH" : "maxHurtResistantTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMaxHurtTimeField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ay" : "maxHurtTime",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMaxHurtTimeField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ay" : "maxHurtTime",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getMcField",
                this.isObfuscated ? "()Lbao;" : "()Lnet/minecraft/client/Minecraft;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "d" : "mc",
                this.isObfuscated ? "Lbao;" : "Lnet/minecraft/client/Minecraft;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setMcField",
                this.isObfuscated ? "(Lbao;)V" : "(Lnet/minecraft/client/Minecraft;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "d" : "mc",
                this.isObfuscated ? "Lbao;" : "Lnet/minecraft/client/Minecraft;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMotionXField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "v" : "motionX",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMotionXField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "v" : "motionX",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMotionYField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "w" : "motionY",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMotionYField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "w" : "motionY",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMotionZField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "x" : "motionZ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMotionZField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "x" : "motionZ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMoveForwardField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "be" : "moveForward",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMoveForwardField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "be" : "moveForward",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getMoveStrafingField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bd" : "moveStrafing",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setMoveStrafingField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bd" : "moveStrafing",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getMovementInputField",
                this.isObfuscated ? "()Lbli;" : "()Lnet/minecraft/util/MovementInput;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "c" : "movementInput",
                this.isObfuscated ? "Lbli;" : "Lnet/minecraft/util/MovementInput;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setMovementInputField",
                this.isObfuscated ? "(Lbli;)V" : "(Lnet/minecraft/util/MovementInput;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "c" : "movementInput",
                this.isObfuscated ? "Lbli;" : "Lnet/minecraft/util/MovementInput;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getMyEntitySizeField",
                this.isObfuscated ? "()Lse;" : "()Lnet/minecraft/entity/Entity$EnumEntitySize;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "as" : "myEntitySize",
                this.isObfuscated ? "Lse;" : "Lnet/minecraft/entity/Entity$EnumEntitySize;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setMyEntitySizeField",
                this.isObfuscated ? "(Lse;)V" : "(Lnet/minecraft/entity/Entity$EnumEntitySize;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "as" : "myEntitySize",
                this.isObfuscated ? "Lse;" : "Lnet/minecraft/entity/Entity$EnumEntitySize;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewPosRotationIncrementsField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bg" : "newPosRotationIncrements",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewPosRotationIncrementsField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bg" : "newPosRotationIncrements",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewPosXField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bh" : "newPosX",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewPosXField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bh" : "newPosX",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewPosYField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bi" : "newPosY",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewPosYField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bi" : "newPosY",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewPosZField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bj" : "newPosZ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewPosZField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bj" : "newPosZ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewRotationPitchField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bl" : "newRotationPitch",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewRotationPitchField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bl" : "newRotationPitch",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNewRotationYawField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bk" : "newRotationYaw",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNewRotationYawField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bk" : "newRotationYaw",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getNoClipField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "X" : "noClip",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setNoClipField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "X" : "noClip",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getOnGroundField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "D" : "onGround",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setOnGroundField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "D" : "onGround",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getOpenContainerField",
                this.isObfuscated ? "()Lzs;" : "()Lnet/minecraft/inventory/Container;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bo" : "openContainer",
                this.isObfuscated ? "Lzs;" : "Lnet/minecraft/inventory/Container;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setOpenContainerField",
                this.isObfuscated ? "(Lzs;)V" : "(Lnet/minecraft/inventory/Container;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bo" : "openContainer",
                this.isObfuscated ? "Lzs;" : "Lnet/minecraft/inventory/Container;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getPlayerLocationField",
                this.isObfuscated ? "()Lr;" : "()Lnet/minecraft/util/ChunkCoordinates;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bB" : "playerLocation",
                this.isObfuscated ? "Lr;" : "Lnet/minecraft/util/ChunkCoordinates;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setPlayerLocationField",
                this.isObfuscated ? "(Lr;)V" : "(Lnet/minecraft/util/ChunkCoordinates;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bB" : "playerLocation",
                this.isObfuscated ? "Lr;" : "Lnet/minecraft/util/ChunkCoordinates;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPortalCounterField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ao" : "portalCounter",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPortalCounterField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ao" : "portalCounter",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPosXField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "s" : "posX",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPosXField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "s" : "posX",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPosYField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "t" : "posY",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPosYField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "t" : "posY",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPosZField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "u" : "posZ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPosZField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "u" : "posZ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevCameraPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aI" : "prevCameraPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevCameraPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aI" : "prevCameraPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevCameraYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "br" : "prevCameraYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevCameraYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "br" : "prevCameraYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevDistanceWalkedModifiedField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "O" : "prevDistanceWalkedModified",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevDistanceWalkedModifiedField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "O" : "prevDistanceWalkedModified",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevHealthField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aw" : "prevHealth",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevHealthField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aw" : "prevHealth",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevLimbSwingAmountField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aE" : "prevLimbSwingAmount",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevLimbSwingAmountField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aE" : "prevLimbSwingAmount",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevPosXField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "p" : "prevPosX",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevPosXField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "p" : "prevPosX",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevPosYField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "q" : "prevPosY",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevPosYField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "q" : "prevPosY",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevPosZField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "r" : "prevPosZ",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevPosZField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "r" : "prevPosZ",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRenderArmPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bL" : "prevRenderArmPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRenderArmPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bL" : "prevRenderArmPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRenderArmYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "i" : "prevRenderArmYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRenderArmYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "i" : "prevRenderArmYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRenderYawOffsetField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aN" : "prevRenderYawOffset",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRenderYawOffsetField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aN" : "prevRenderYawOffset",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRotationPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "B" : "prevRotationPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRotationPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "B" : "prevRotationPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRotationYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "A" : "prevRotationYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRotationYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "A" : "prevRotationYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevRotationYawHeadField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aP" : "prevRotationYawHead",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevRotationYawHeadField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aP" : "prevRotationYawHead",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevSwingProgressField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aC" : "prevSwingProgress",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevSwingProgressField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aC" : "prevSwingProgress",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPrevTimeInPortalField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bN" : "prevTimeInPortal",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPrevTimeInPortalField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bN" : "prevTimeInPortal",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getPreventEntitySpawningField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "k" : "preventEntitySpawning",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setPreventEntitySpawningField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "k" : "preventEntitySpawning",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRandField", "()Ljava/util/Random;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Z" : "rand",
                "Ljava/util/Random;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRandField", "(Ljava/util/Random;)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "Z" : "rand",
                "Ljava/util/Random;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRandomYawVelocityField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bf" : "randomYawVelocity",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRandomYawVelocityField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bf" : "randomYawVelocity",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRecentlyHitField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aS" : "recentlyHit",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRecentlyHitField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aS" : "recentlyHit",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRenderArmPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "h" : "renderArmPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRenderArmPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "h" : "renderArmPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRenderArmYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "g" : "renderArmYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRenderArmYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "g" : "renderArmYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRenderDistanceWeightField", "()D", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "j" : "renderDistanceWeight",
                "D");
        mv.visitInsn(Opcodes.DRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRenderDistanceWeightField", "(D)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.DLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "j" : "renderDistanceWeight",
                "D");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRenderYawOffsetField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aM" : "renderYawOffset",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRenderYawOffsetField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aM" : "renderYawOffset",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getRiddenByEntityField",
                this.isObfuscated ? "()Lsa;" : "()Lnet/minecraft/entity/Entity;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "l" : "riddenByEntity",
                this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setRiddenByEntityField",
                this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "l" : "riddenByEntity",
                this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getRidingEntityField",
                this.isObfuscated ? "()Lsa;" : "()Lnet/minecraft/entity/Entity;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "m" : "ridingEntity",
                this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setRidingEntityField",
                this.isObfuscated ? "(Lsa;)V" : "(Lnet/minecraft/entity/Entity;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "m" : "ridingEntity",
                this.isObfuscated ? "Lsa;" : "Lnet/minecraft/entity/Entity;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRotationPitchField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "z" : "rotationPitch",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRotationPitchField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "z" : "rotationPitch",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRotationYawField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "y" : "rotationYaw",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRotationYawField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "y" : "rotationYaw",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getRotationYawHeadField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aO" : "rotationYawHead",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setRotationYawHeadField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aO" : "rotationYawHead",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getScoreValueField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ba" : "scoreValue",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setScoreValueField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ba" : "scoreValue",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getServerPosXField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bZ" : "serverPosX",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setServerPosXField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bZ" : "serverPosX",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getServerPosYField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ca" : "serverPosY",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setServerPosYField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "ca" : "serverPosY",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getServerPosZField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "cb" : "serverPosZ",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setServerPosZField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "cb" : "serverPosZ",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSleepingField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bA" : "sleeping",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSleepingField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bA" : "sleeping",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSpeedInAirField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bJ" : "speedInAir",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSpeedInAirField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bJ" : "speedInAir",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSpeedOnGroundField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bI" : "speedOnGround",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSpeedOnGroundField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bI" : "speedOnGround",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSprintToggleTimerField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "e" : "sprintToggleTimer",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSprintToggleTimerField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "e" : "sprintToggleTimer",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSprintingTicksLeftField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "f" : "sprintingTicksLeft",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSprintingTicksLeftField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "f" : "sprintingTicksLeft",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getStepHeightField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "W" : "stepHeight",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setStepHeightField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "W" : "stepHeight",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSwingProgressField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aD" : "swingProgress",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSwingProgressField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aD" : "swingProgress",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getSwingProgressIntField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "au" : "swingProgressInt",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setSwingProgressIntField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "au" : "swingProgressInt",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getTeleportDirectionField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aq" : "teleportDirection",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setTeleportDirectionField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aq" : "teleportDirection",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getTicksExistedField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aa" : "ticksExisted",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setTicksExistedField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "aa" : "ticksExisted",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getTimeInPortalField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bM" : "timeInPortal",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setTimeInPortalField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bM" : "timeInPortal",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getTimeUntilPortalField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "am" : "timeUntilPortal",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setTimeUntilPortalField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "am" : "timeUntilPortal",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getVelocityChangedField", "()Z", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "H" : "velocityChanged",
                "Z");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setVelocityChangedField", "(Z)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "H" : "velocityChanged",
                "Z");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getWidthField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "M" : "width",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setWidthField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "M" : "width",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getWorldObjField",
                this.isObfuscated ? "()Lahb;" : "()Lnet/minecraft/world/World;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "o" : "worldObj",
                this.isObfuscated ? "Lahb;" : "Lnet/minecraft/world/World;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "setWorldObjField",
                this.isObfuscated ? "(Lahb;)V" : "(Lnet/minecraft/world/World;)V",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "o" : "worldObj",
                this.isObfuscated ? "Lahb;" : "Lnet/minecraft/world/World;");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getXpCooldownField", "()I", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bt" : "xpCooldown",
                "I");
        mv.visitInsn(Opcodes.IRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setXpCooldownField", "(I)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "bt" : "xpCooldown",
                "I");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getYOffsetField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "L" : "yOffset",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setYOffsetField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "L" : "yOffset",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getYSizeField", "()F", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "V" : "ySize",
                "F");
        mv.visitInsn(Opcodes.FRETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "setYSizeField", "(F)V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.FLOAD, 1);
        mv.visitFieldInsn(
                Opcodes.PUTFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                this.isObfuscated ? "V" : "ySize",
                "F");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getClientPlayerBase",
                "(Ljava/lang/String;)Lapi/player/client/ClientPlayerBase;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getClientPlayerBase",
                "(Lapi/player/client/IClientPlayerAPI;Ljava/lang/String;)Lapi/player/client/ClientPlayerBase;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL, "getClientPlayerBaseIds", "()Ljava/util/Set;", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "getClientPlayerBaseIds",
                "(Lapi/player/client/IClientPlayerAPI;)Ljava/util/Set;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "dynamic",
                "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitVarInsn(Opcodes.ALOAD, 2);
        mv.visitMethodInsn(
                Opcodes.INVOKESTATIC,
                "api/player/client/ClientPlayerAPI",
                "dynamic",
                "(Lapi/player/client/IClientPlayerAPI;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getClientPlayerAPI",
                "()Lapi/player/client/ClientPlayerAPI;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitFieldInsn(
                Opcodes.GETFIELD,
                this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP",
                "clientPlayerAPI",
                "Lapi/player/client/ClientPlayerAPI;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        mv = this.cv.visitMethod(
                Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL,
                "getEntityPlayerSP",
                this.isObfuscated ? "()Lblk;" : "()Lnet/minecraft/client/entity/EntityPlayerSP;",
                null,
                null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
        this.cv.visitField(
                Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                "clientPlayerAPI",
                "Lapi/player/client/ClientPlayerAPI;",
                null,
                null);
    }
}
