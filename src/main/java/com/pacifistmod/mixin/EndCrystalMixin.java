package com.pacifistmod.mixin;

import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(EndCrystal.class)
public abstract class EndCrystalMixin {

    @ModifyArg(
        method = "hurtServer",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;explode(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/level/ExplosionDamageCalculator;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"
        ),
        index = 8
    )
    private Level.ExplosionInteraction modifyExplosionInteraction(Level.ExplosionInteraction original) {
        return Level.ExplosionInteraction.NONE;
    }
}
