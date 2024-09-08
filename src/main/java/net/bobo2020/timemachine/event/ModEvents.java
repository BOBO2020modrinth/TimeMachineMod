package net.bobo2020.timemachine.event;

import net.bobo2020.timemachine.TimeMachine;
import net.bobo2020.timemachine.item.ModItems;
import net.bobo2020.timemachine.item.custom.ComplexHammerItem;
import net.bobo2020.timemachine.item.custom.SwitchableHammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = TimeMachine.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent pEvent) {
        Player pPlayer = pEvent.getPlayer();
        ItemStack mainHandItem = pPlayer.getMainHandItem();

        if(mainHandItem.getItem() instanceof SwitchableHammerItem hammer && pPlayer instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = pEvent.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : SwitchableHammerItem.getBlocksToBeDestroyed(1, 1,
                    initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, pEvent.getLevel().getBlockState(pos))) {
                    continue;
                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

        if(mainHandItem.getItem() instanceof ComplexHammerItem hammer && pPlayer instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = pEvent.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : ComplexHammerItem.getBlocksToBeDestroyed(1, 1,
                    initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, pEvent.getLevel().getBlockState(pos))) {
                    continue;
                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
}
