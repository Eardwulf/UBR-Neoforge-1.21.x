package com.ubr.aldoria.machines;

import com.ubr.aldoria.AldoriaCM;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.CraftingMenu;
import com.mojang.blaze3d.systems.RenderSystem;

public class ApothecaryTableScreen extends AbstractContainerScreen<ApothecaryTableContainer> {

    private static final ResourceLocation TEXTURE = ResourceLocation.tryParse("aldoria:textures/gui/apothecary_table.png");

    public ApothecaryTableScreen(ApothecaryTableContainer container, Inventory inv, Component title) {
        super(container, inv, title);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTicks, int mouseX, int mouseY) {
        // Calculate the position to center the texture
        int startX = (this.width - this.imageWidth) / 2;
        int startY = (this.height - this.imageHeight) / 2;

        // Render the background texture
        graphics.blit(TEXTURE, startX, startY, 0, 0, this.imageWidth, this.imageHeight);
    }
}
