package kirby.testmod.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AxeExtendedItem extends AxeItem {

    public AxeExtendedItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
