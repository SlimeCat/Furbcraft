package com.slimecat23.furbcraft.entity;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.slimecat23.furbcraft.entity.render.RenderFurby;
import com.slimecat23.furbcraft.init.ItemInit;
import com.slimecat23.furbcraft.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;


public class EntityFurby extends EntityTameable
	{//VARIABLES
	public int happiness;
	public int hunger;
	public int weight;
	public int item_timer;
	public int happy_timer;
	public int weight_timer;
	public int hunger_timer;
	public Biome spawn_biome;
	public ResourceLocation skin;
	public ModelBase model;
	private static final DataParameter<Float> DATA_HEALTH_ID= EntityDataManager.<Float>createKey(EntityFurby.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> EYE_COLOR= EntityDataManager.<Integer>createKey(EntityFurby.class, DataSerializers.VARINT);
	
	
	//CONSTRUTOR
	public EntityFurby(World _world) 
		{super(_world);
		this.setSize(0.4F, 0.4F);
		happiness= 50;
		hunger= 50;
		weight= 50;
		happy_timer= 1000;
		hunger_timer= 1000;
		weight_timer= 100;
		item_timer= this.rand.nextInt(6000) + 6000;
		spawn_biome= _world.getBiome(getPosition());
		skin= null;
		model= RenderFurby.SKIN;
		}
	
	
	//METHODS
		//overrides
	@Override
	protected void initEntityAI()
    	{//AI stuff
		EntityAISit sit= new EntityAISit(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, sit);
        this.aiSit= sit;
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
    	}
	
	@Override
	protected void updateAITasks()
	    {//Health update
		this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	    }
	
	@Override
	protected void applyEntityAttributes()
		{//Attributes (such as speed or max health)
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
		if (this.isTamed())
	        {this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
	        }
        else
	        {this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
	        }
		}
	
	@Override
	protected void entityInit()
	    {//Initialisation
	    super.entityInit();
	    this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
	    this.dataManager.register(EYE_COLOR, Integer.valueOf(EnumDyeColor.YELLOW.getDyeDamage()));
	    }
	
	@Override
	public void writeEntityToNBT(NBTTagCompound _compound)
	    {//Save NBT
	    super.writeEntityToNBT(_compound);
	    _compound.setByte("EyeColor", (byte)this.getEyeColor().getDyeDamage());
	    _compound.setString("Skin", this.skin.getResourcePath());
	    }

	@Override
	public void readEntityFromNBT(NBTTagCompound _compound)
	    {//Load NBT
	    super.readEntityFromNBT(_compound);
	    if (_compound.hasKey("EyeColor", 99))
	        {this.setEyeColor(EnumDyeColor.byDyeDamage(_compound.getByte("CollarColor")));
	        }
	    if (_compound.hasKey("Skin"))
	        {this.skin= new ResourceLocation(_compound.getString("Skin"));
	        }
	    }
	
	@Override
	public void setTamed(boolean _tamed)
    	{//Taming
        super.setTamed(_tamed);
        if (_tamed)
        	{this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        	}
        else
        	{this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        	}
    	}

	@Override
    public boolean processInteract(EntityPlayer _player, EnumHand _hand)
    	{//Player interaction
        ItemStack itemstack= _player.getHeldItem(_hand);
        if (this.isTamed())
        	{if (!itemstack.isEmpty())
        		{if (Arrays.asList(Reference.PLANTS).contains(itemstack.getItem()))
                	{//Feed to heal
        			if (((Float) this.dataManager.get(DATA_HEALTH_ID)).floatValue()< 15.0F)
                    	{if (!_player.capabilities.isCreativeMode)
                        	{itemstack.shrink(1);
                        	}
                        this.heal(5.0f);
                        hunger+= 20;
                        if (hunger> 100)
                        	{hunger= 100;
                        	weight+= 5;
                        	if (weight> 100)
	                        	{weight= 100;
	                            }
                        	}
                        return true;
                    	}
                	}
                else if (Arrays.asList(Reference.SWEETS).contains(itemstack.getItem()))
                	{//Feed to gain happiness
        			if (!_player.capabilities.isCreativeMode)
                        {itemstack.shrink(1);
                        }
        			happiness+= 10;
                    if (happiness> 100)
                    	{happiness= 100;
                        }
                    hunger+= 30;
                    if (hunger> 100)
                    	{hunger= 100;
                    	weight+= 5;
                        }
                    weight+= 5;
                    if (weight> 100)
                        {weight= 100;
                        }
                    return true;
                	}
                else if (itemstack.getItem()== Items.DYE)
                	{//Change eye colour
                	EnumDyeColor enumdyecolor= EnumDyeColor.byDyeDamage(itemstack.getMetadata());
                	if (enumdyecolor!= this.getEyeColor())
                    	{this.setEyeColor(enumdyecolor);
                        if (!_player.capabilities.isCreativeMode)
                        	{itemstack.shrink(1);
                        	}
                        return true;
                    	}
                	}
        		}
            if (this.isOwner(_player) && !this.world.isRemote && !this.isBreedingItem(itemstack))
            	{//Sit Command
            	this.aiSit.setSitting(!this.isSitting());
                this.isJumping= false;
                this.navigator.clearPath();
            	}
        	}
        else if (itemstack.getItem()== Items.COOKIE)
        	{//Taming
        	if (!_player.capabilities.isCreativeMode)
            	{itemstack.shrink(1);
            	}
            if (!this.world.isRemote)
            	{if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, _player))
                	{this.setTamedBy(_player);
                    this.navigator.clearPath();
                    this.aiSit.setSitting(true);
                    this.setHealth(15.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                	}
                else
                	{this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                	}
            	}
            return true;
        	}
        return super.processInteract(_player, _hand);
    	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack)
	    {//Breeding item
	    return stack.getItem()== Item.getItemFromBlock(Blocks.WOOL);
	    }
	
	@Override
	public int getMaxSpawnedInChunk()
		{//Max per chunk
        return 8;
		}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) 
		{//Children
		return new EntityFurby(world);
		}
	
	@Override
	public void onLivingUpdate()
    	{//Update
        super.onLivingUpdate();
        if (this.isTamed())
	        {if (!this.world.isRemote && !this.isChild() && --this.item_timer<= 0)
	        	{if (happiness>= 80)
	        		{this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	        		this.dropItem(ItemInit.FURBY_LOVE, 1);
	        		}
	        	else if (happiness< 20)
	        		{this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
	        		this.dropItem(ItemInit.FURBY_TEAR, 1);
	        		}
	            this.item_timer= this.rand.nextInt(6000) + 6000;
	        	}
	        if (!this.world.isRemote && !this.isChild() && --this.weight_timer<= 0 && weight> 80)
	        	{this.damageEntity(DamageSource.GENERIC, 1);
	        	weight_timer= 10;
	        	}
	        if (!this.world.isRemote && !this.isChild() && --this.hunger_timer<= 0)
		    	{hunger--;
		    	if (hunger< 0)
		    		{hunger= 0;
		    		}
		    	hunger_timer= 36;
		    	}
	        if (!this.world.isRemote && !this.isChild() && --this.happy_timer<= 0)
		    	{happiness--;
		    	if (hunger< 20)
		    		{happiness-= 4;
		    		weight-= 5;
		    		}
		    	if (happiness< 0)
		    		{happiness= 0;
		    		}
		    	happy_timer= 72;
		    	}
	        }
    	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
    	{//when attacked
        if (this.isEntityInvulnerable(source))
        	{return false;
        	}
        else
	        {Entity entity= source.getTrueSource();
	        if (this.aiSit != null)
	            {this.aiSit.setSitting(false);
	            }
	        if (Reference.random.nextInt(100)< 25)
	        	{this.dropItem(ItemInit.FURBY_TEAR, 1);
	        	}
	        return super.attackEntityFrom(source, amount);
	        }
    	}
	
	@Override
	protected SoundEvent getAmbientSound() 
		{return super.getAmbientSound();
		}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) 
		{// TODO Auto-generated method stub
		return super.getHurtSound(damageSourceIn);
		}
	
	@Override
	protected SoundEvent getDeathSound() 
		{// TODO Auto-generated method stub
		return super.getDeathSound();
		}
	
		//colours
	public EnumDyeColor getEyeColor()
    	{//Get eye colour
        return EnumDyeColor.byDyeDamage(((Integer)this.dataManager.get(EYE_COLOR)).intValue() & 15);
    	}

    public void setEyeColor(EnumDyeColor _color)
    	{//Set eye colour
        this.dataManager.set(EYE_COLOR, Integer.valueOf(_color.getDyeDamage()));
    	}
	}