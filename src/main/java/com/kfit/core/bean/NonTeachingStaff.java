package com.kfit.core.bean;

/**
 * Created by davi on 2017/6/15.
 */

import javax.persistence.Entity;

@Entity
public class NonTeachingStaff extends Staff
{

    private String areaexpertise;

    public NonTeachingStaff( int sid, String sname,
                             String areaexpertise )
    {
        super( sid, sname );
        this.areaexpertise = areaexpertise;
    }

    public NonTeachingStaff( )
    {
        super( );
    }

    public String getAreaexpertise( )
    {
        return areaexpertise;
    }

    public void setAreaexpertise( String areaexpertise )
    {
        this.areaexpertise = areaexpertise;
    }
}