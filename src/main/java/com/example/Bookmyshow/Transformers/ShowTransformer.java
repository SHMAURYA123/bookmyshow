package com.example.Bookmyshow.Transformers;

import com.example.Bookmyshow.Entity.Show;
import com.example.Bookmyshow.RequestDTO.AddShowRequest;

public class ShowTransformer {

    public static Show convertAddShowRequestToShow(AddShowRequest addShowRequest){
        Show show= Show.builder().showDate(addShowRequest.getShowDate()).showTime(addShowRequest.getShowTime()).build();
        return show;
    }
}
