package com.slimecat23.furbcraft.block;

import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockBuddy extends BlockBase
	{//VARIABLES
	public static final AxisAlignedBB BUDDY_AABB= new AxisAlignedBB(0.3125, 0, 0.3126, 0.6875, 0.375, 0.6875);
	public static final PropertyDirection FACING= PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	
	public BlockBuddy(String _name) 
		{super(_name, Material.CLOTH, Reference.FURBCRAFT);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		}
	
	
	//METHODS
	@Override
	public boolean isOpaqueCube(IBlockState state)
    	{//not opaque
        return false;
    	}
	
	@Override
	public boolean isFullCube(IBlockState state)
    	{//not opaque
        return false;
    	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
		{return BUDDY_AABB;
		}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    	{return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.isSideSolid(pos.down(), EnumFacing.UP);
    	}

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    	{return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    	}

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    	{return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    	}

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    	{return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    	}

    @Override
    public IBlockState getStateFromMeta(int meta)
    	{return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    	}

    @Override
    public int getMetaFromState(IBlockState state)
    	{return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    	}

    @Override
    protected BlockStateContainer createBlockState()
    	{return new BlockStateContainer(this, new IProperty[] {FACING});
    	}
	}
