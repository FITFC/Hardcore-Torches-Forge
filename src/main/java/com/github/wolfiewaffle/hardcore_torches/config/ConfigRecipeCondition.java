/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.github.wolfiewaffle.hardcore_torches.config;

import com.google.common.base.Supplier;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ConfigRecipeCondition implements ICondition
{
    private static final ResourceLocation NAME = new ResourceLocation("hardcore_torches", "config");
    private final Supplier<Boolean> bool;

    // Supplier is a functional interface that returns a boolean
    public ConfigRecipeCondition(Supplier<Boolean> bool) {
        this.bool = bool;
    }

    @Override
    public ResourceLocation getID()
    {
        return NAME;
    }

    @Override
    public boolean test()
    {
        return bool.get();
    }

    @Override
    public String toString()
    {
        return "hardcore_torches:config";
    }

    public static class Serializer implements IConditionSerializer<ConfigRecipeCondition>
    {
        Supplier<Boolean> bool;
        ResourceLocation id;

        public Serializer(Supplier<Boolean> bool, ResourceLocation id) {
            this.bool = bool;
            this.id = id;
        }

        @Override
        public void write(JsonObject json, ConfigRecipeCondition value)
        {

        }

        @Override
        public ConfigRecipeCondition read(JsonObject json)
        {
            return new ConfigRecipeCondition(bool);
        }

        @Override
        public ResourceLocation getID()
        {
            return id;
        }
    }
}