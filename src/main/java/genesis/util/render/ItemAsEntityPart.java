package genesis.util.render;

import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.*;

public class ItemAsEntityPart extends CustomEntityPart
{
	private ItemStack itemStack;
	private ItemStack itemStackDef;
	
	public ItemAsEntityPart(ModelBase model)
	{
		super(model);
		
		offsetX += 0.5F;
		offsetZ += 0.5F;
		setDefaultState();
	}
	
	@Override
	public ItemAsEntityPart setDefaultState()
	{
		super.setDefaultState();

		itemStackDef = itemStack;
		
		return this;
	}
	
	@Override
	public void resetState()
	{
		super.resetState();
		
		itemStack = itemStackDef;
	}
	
	public void setStack(ItemStack stack)
	{
		itemStack = stack;
	}
	
	@Override
	public void doRender(float pxSize)
	{
		if (itemStack != null)
		{
			float scale = pxSize * 16;
			GlStateManager.scale(scale, scale, scale);
			RenderHelper.enableStandardItemLighting();
			Minecraft.getMinecraft().getRenderItem().renderItem(itemStack, TransformType.FIXED);
		}
	}
}
