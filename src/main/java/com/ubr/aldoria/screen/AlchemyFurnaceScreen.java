package com.ubr.aldoria.screen;

import com.ubr.aldoria.container.AlchemyFurnaceContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AlchemyFurnaceScreen extends AbstractContainerScreen<AlchemyFurnaceContainer> {

    private static final ResourceLocation TEXTURE = ResourceLocation.tryParse( "textures/gui/alchemy_furnace.png");

    public AlchemyFurnaceScreen(AlchemyFurnaceContainer container, Inventory inv, Component title) {
        super(container, inv, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
        int x = this.leftPos;
        int y = this.topPos;

        // Render the background texture of the GUI
        guiGraphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        // Render progress bar
        if (this.menu.isCrafting()) {
            int progress = this.menu.getBurnProgress(); // Gets the burn progress from the container
            guiGraphics.blit(TEXTURE, x + 79, y + 34, 176, 14, progress + 1, 16);
        }

        // Render fuel bar (Essence Extractor fuel level)
        if (this.menu.isBurning()) {
            int fuel = this.menu.getFuelProgress(); // Gets the remaining fuel level
            guiGraphics.blit(TEXTURE, x + 56, y + 36 + 12 - fuel, 176, 12 - fuel, 14, fuel + 1);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private void renderBackground(GuiGraphics guiGraphics) {
    }
}
