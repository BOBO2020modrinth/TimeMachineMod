package net.bobo2020.timemachine.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class ComplexHammerItem extends DiggerItem {
    public ComplexHammerItem(Tier tier, Properties properties) {
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
                if(pTraceResult.getDirection() == Direction.NORTH) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            for(int z = 0; z <= 2 * pRange; z++) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.SOUTH) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            for(int z = 0; z >= -2 * pRange; z--) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.WEST) {
                    for(int x = 0; x <= 2 * pRange; x++) {
                        for(int y = -pRange; y <= pRange; y++) {
                            for(int z = -pRange; z <= pRange; z++) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.EAST) {
                    for(int x = 0; x >= -2 * pRange; x--) {
                        for(int y = -pRange; y <= pRange; y++) {
                            for(int z = -pRange; z <= pRange; z++) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.DOWN) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = 0; y <= 2 * pRange; y++) {
                            for(int z = -pRange; z <= pRange; z++) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }

                if(pTraceResult.getDirection() == Direction.UP) {
                    for(int x = -pRange; x <= pRange; x++) {
                        for(int y = 0; y >= -2 * pRange; y--) {
                            for(int z = -pRange; z <= pRange; z++) {
                                pPositions.add(new BlockPos(pPos.getX() + x, pPos.getY() + y, pPos.getZ() + z));
                            }
                        }
                    }
                }
            }

            return pPositions;
        }
}
