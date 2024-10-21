package com.ubr.aldoria.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.ChatFormatting;

import java.util.function.Supplier;

public class CustomTextComponent {
    private final MutableComponent component;

    public CustomTextComponent(String text) {
        this.component = Component.literal(text);
    }

    // Add formatting methods
    public CustomTextComponent setBold(boolean bold) {
        this.component.setStyle(this.component.getStyle().withBold(bold));
        return this;
    }

    public CustomTextComponent setColor(ChatFormatting color) {
        this.component.setStyle(this.component.getStyle().withColor(color));
        return this;
    }

    // Method to append text
    public CustomTextComponent append(String text) {
        this.component.append(Component.literal(text));
        return this;
    }

    // Add methods to customize the component, such as formatting

    public Supplier<Component> build() {
        // Return a Supplier that supplies the component
        return () -> component;
}
}
