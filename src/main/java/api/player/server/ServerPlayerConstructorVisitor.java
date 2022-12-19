package api.player.server;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public final class ServerPlayerConstructorVisitor extends MethodVisitor {
    private final boolean isObfuscated;

    public ServerPlayerConstructorVisitor(MethodVisitor mv, boolean isObfuscated) {
        super(262144, mv);
        this.isObfuscated = isObfuscated;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        super.visitMethodInsn(opcode, owner, name, desc);
        if (name.equals("<init>")
                && owner.equals(this.isObfuscated ? "yz" : "net/minecraft/entity/player/EntityPlayer")) {
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "api/player/server/ServerPlayerAPI",
                    "create",
                    "(Lapi/player/server/IServerPlayerAPI;)Lapi/player/server/ServerPlayerAPI;");
            this.mv.visitFieldInsn(
                    Opcodes.PUTFIELD,
                    this.isObfuscated ? "mw" : "net/minecraft/entity/player/EntityPlayerMP",
                    "serverPlayerAPI",
                    "Lapi/player/server/ServerPlayerAPI;");
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitIntInsn(Opcodes.ALOAD, 1);
            this.mv.visitIntInsn(Opcodes.ALOAD, 2);
            this.mv.visitIntInsn(Opcodes.ALOAD, 3);
            this.mv.visitIntInsn(Opcodes.ALOAD, 4);
            this.mv.visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "api/player/server/ServerPlayerAPI",
                    "beforeLocalConstructing",
                    "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/WorldServer;Lcom/mojang/authlib/GameProfile;Lnet/minecraft/server/management/ItemInWorldManager;)V");
        }
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitIntInsn(Opcodes.ALOAD, 1);
            this.mv.visitIntInsn(Opcodes.ALOAD, 2);
            this.mv.visitIntInsn(Opcodes.ALOAD, 3);
            this.mv.visitIntInsn(Opcodes.ALOAD, 4);
            this.mv.visitMethodInsn(
                    Opcodes.INVOKESTATIC,
                    "api/player/server/ServerPlayerAPI",
                    "afterLocalConstructing",
                    "(Lapi/player/server/IServerPlayerAPI;Lnet/minecraft/server/MinecraftServer;Lnet/minecraft/world/WorldServer;Lcom/mojang/authlib/GameProfile;Lnet/minecraft/server/management/ItemInWorldManager;)V");
        }

        super.visitInsn(opcode);
    }
}
