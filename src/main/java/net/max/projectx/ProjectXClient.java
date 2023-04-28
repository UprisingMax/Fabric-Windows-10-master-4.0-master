package net.max.projectx;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.max.projectx.block.ModBlocks;
import net.max.projectx.client.ThirstHudOverlay;
import net.max.projectx.event.KeyInputHandler;
import net.max.projectx.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;

public class ProjectXClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());
        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
    }
}
