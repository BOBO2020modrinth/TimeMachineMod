package net.bobo2020.timemachine.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class SwitchableHammerItem extends DiggerItem {

    public SwitchableHammerItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int pMode, int pRange, BlockPos pPos,
                                                        ServerPlayer pPlayer) {
        List<BlockPos> pPositions = new ArrayList<>();

        BlockHitResult pTraceResult = pPlayer.level().clip(new ClipContext(pPlayer.getEyePosition(1f),
                (pPlayer.getEyePosition(1f).add(pPlayer.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, pPlayer));
        if(pTraceResult.getType() == HitResult.Type.MISS) {
            return pPositions;
        }

        if(pMode == 1) {
                if(pTraceResult.getDirection() == Direction.DOWN || pTraceResult.getDirection() == Direction.UP) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY(), pPos.getZ() + y));
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.NORTH || pTraceResult.getDirection() == Direction.SOUTH) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ()));
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.EAST || pTraceResult.getDirection() == Direction.WEST) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            pPositions.add(new BlockPos(pPos.getX(), pPos.getY() + y, pPos.getZ() + x));
                        }
                    }
                }
            }

            if(pMode == 2) {
                if(pTraceResult.getDirection() == Direction.DOWN || pTraceResult.getDirection() == Direction.UP) {
                    for(int x = -pRange; x <= pRange; x++) {
                        pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY(), pPos.getZ()));
                    }
                    for(int y = -pRange; y <= pRange; y++) {
                        pPositions.add(new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + y));
                    }
                }

                if(pTraceResult.getDirection() == Direction.NORTH || pTraceResult.getDirection() == Direction.SOUTH) {
                    for(int x = -pRange; x <= pRange; x++) {
                        pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY(), pPos.getZ()));
                    }
                    for(int y = -pRange; y <= pRange; y++) {
                        pPositions.add(new BlockPos(pPos.getX(), pPos.getY() + y, pPos.getZ()));
                    }
                }

                if(pTraceResult.getDirection() == Direction.EAST || pTraceResult.getDirection() == Direction.WEST) {
                    for(int x = -pRange; x <= pRange; x++) {
                        pPositions.add(new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + x));
                    }
                    for(int y = -pRange; y <= pRange; y++) {
                        pPositions.add(new BlockPos(pPos.getX(), pPos.getY() + y, pPos.getZ()));
                    }
                }
            }

        return pPositions;
    }
}
