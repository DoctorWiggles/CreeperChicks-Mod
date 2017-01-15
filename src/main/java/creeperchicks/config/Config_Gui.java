package creeperchicks.config;



import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import creeperchicks.Main;

public class Config_Gui extends GuiConfig {

	
		public Config_Gui(GuiScreen parent) {
			super(parent, getConfigElements(), Main.MODID, false, false,
					TextFormatting.GREEN +""+ TextFormatting.ITALIC +Main.MODNAME+ " Configuration");
		}

		/** Compiles a list of config elements */
		private static List<IConfigElement> getConfigElements() {
			List<IConfigElement> list = new ArrayList<IConfigElement>();

			//Add categories to config GUI
			list.add(categoryElement(Config.Settings,"General Settings","General Settings"));
			
			return list;
		}
	 


	/** Creates a button linking to another screen where all options of the category are available */
	private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
		return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
				new ConfigElement(Config.config.getCategory(category)).getChildElements());
	}
}