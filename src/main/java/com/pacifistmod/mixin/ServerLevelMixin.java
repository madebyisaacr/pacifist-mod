package com.pacifistmod.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

    @ModifyVariable(
        method = "explode(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/level/ExplosionDamageCalculator;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;Lnet/minecraft/core/particles/ParticleOptions;Lnet/minecraft/core/particles/ParticleOptions;Lnet/minecraft/util/random/WeightedList;Lnet/minecraft/core/Holder;)V",
        at = @At("HEAD"),
        argsOnly = true,
        ordinal = 0
    )
    private Level.ExplosionInteraction pacifistMod$forceNoBlockDamage(Level.ExplosionInteraction explosionInteraction) {
        return Level.ExplosionInteraction.NONE;
    }
}
