package api.player.client;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public final class ClientPlayerConstructorVisitor extends MethodVisitor {
    private final boolean isObfuscated;

    public ClientPlayerConstructorVisitor(MethodVisitor paramMethodVisitor, boolean isObfuscated) {
        super(262144, paramMethodVisitor);
        this.isObfuscated = isObfuscated;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        super.visitMethodInsn(opcode, owner, name, desc);
        if (name.equals("<init>") && owner.equals(this.isObfuscated ? "blg" : "net/minecraft/client/entity/AbstractClientPlayer")) {
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, "api/player/client/ClientPlayerAPI", "create", "(Lapi/player/client/IClientPlayerAPI;)Lapi/player/client/ClientPlayerAPI;");
            this.mv.visitFieldInsn(Opcodes.PUTFIELD, this.isObfuscated ? "blk" : "net/minecraft/client/entity/EntityPlayerSP", "clientPlayerAPI", "Lapi/player/client/ClientPlayerAPI;");
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitIntInsn(Opcodes.ALOAD, 1);
            this.mv.visitIntInsn(Opcodes.ALOAD, 2);
            this.mv.visitIntInsn(Opcodes.ALOAD, 3);
            this.mv.visitIntInsn(Opcodes.ILOAD, 4);
            this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, "api/player/client/ClientPlayerAPI", "beforeLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
        }

    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            this.mv.visitVarInsn(Opcodes.ALOAD, 0);
            this.mv.visitIntInsn(Opcodes.ALOAD, 1);
            this.mv.visitIntInsn(Opcodes.ALOAD, 2);
            this.mv.visitIntInsn(Opcodes.ALOAD, 3);
            this.mv.visitIntInsn(Opcodes.ILOAD, 4);
            this.mv.visitMethodInsn(Opcodes.INVOKESTATIC, "api/player/client/ClientPlayerAPI", "afterLocalConstructing", "(Lapi/player/client/IClientPlayerAPI;Lnet/minecraft/client/Minecraft;Lnet/minecraft/world/World;Lnet/minecraft/util/Session;I)V");
        }

        super.visitInsn(opcode);
    }
}
