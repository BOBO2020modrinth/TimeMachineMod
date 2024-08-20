package net.bobo2020.timemachine.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RuneBlock extends Block {
    public RuneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        BlockPos spawnPos = new BlockPos(pPos.getX(), pPos.getY() + 1, pPos.getZ());
        if(pLevel instanceof ServerLevel) {
            if(pEntity instanceof Player) {
                if(!pEntity.isShiftKeyDown()) {
                    EntityType.PIG.spawn((ServerLevel) pLevel, spawnPos, MobSpawnType.MOB_SUMMONED);
                }
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
