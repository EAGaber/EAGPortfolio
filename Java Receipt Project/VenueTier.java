/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;
// VenueTier.java
// Abdul - MIS 3370


// base class for the three venue tiers
// community, professional, and grand all extend this
public class VenueTier
{
    // protected so the subclasses can access these directly
    protected String tierName;
    protected double multiplier;


    // constructor takes the name and multiplier
    // the subclasses pass these up using super()
    public VenueTier(String tierName, double multiplier)
    {
        this.tierName = tierName;
        this.multiplier = multiplier;
    }


    // returns the multiplier, gets overridden in each subclass
    public double getMultiplier()
    {
        return multiplier;
    }


    // returns the tier name
    public String getTierName()
    {
        return tierName;
    }
}


// CommunityTier.java
// Abdul - MIS 3370


// this extends VenueTier so it inherits everything from that class
class CommunityTier extends VenueTier
{
    // community is the basic tier so the multiplier is just 1.0
    // meaning the price doesnt change
    public CommunityTier()
    {
        // passing the name and multiplier up to the parent class
        super("Community", 1.0);
    }


    // overriding getMultiplier from VenueTier
    // returns 1.0 so the total cost stays the same for this tier
    @Override
    public double getMultiplier()
    {
        return 1.0;
    }
}


// GrandTier.java
// Abdul - MIS 3370


// grand is the most expensive tier, extends VenueTier just like the others
class GrandTier extends VenueTier
{
    // no parameters needed since grand is always 2.1x
    public GrandTier()
    {
        // send the name and multiplier to the parent constructor
        super("Grand", 2.1);
    }


    // overriding the parent getMultiplier method
    // grand tier basically doubles the price which makes sense for a fancy venue
    @Override
    public double getMultiplier()
    {
        return 2.1;
    }
}





// ProfessionalTier.java
// Abdul - MIS 3370


// middle tier between community and grand
class ProfessionalTier extends VenueTier
{
    public ProfessionalTier()
    {
        // 1.55 multiplier so price goes up by 55 percent
        super("Professional", 1.55);
    }


    // overriding getMultiplier so each tier returns its own rate
    @Override
    public double getMultiplier()
    {
        return 1.55;
    }
}










