package com.alex.vkdemo.model;

import java.util.List;

/**
 * Created by marat on 01.03.15.
 */
public class Item
{
    public String type ;
    public int source_id ;
    public int date ;
    public int post_id ;
    public String post_type ;
    public String text ;
    public List<Attachment> attachments ;
    public PostSource post_source ;
    public Comments comments ;
    public Likes likes ;
    public Reposts reposts ;
    public int signer_id ;
    public List<CopyHistory> copy_history ;
}
