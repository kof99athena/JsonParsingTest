package com.athena.jsonparsingtest.data

import com.google.gson.annotations.SerializedName



data class Item(
    @SerializedName("movieNm")
    val movieNm : String
)

//겉을 감싸는 dailyBoxOfficeList는 필요없다.
//이해해야함!!!!!!
//JSON 데이터의 dailyBoxOfficeList 배열에 해당하는 부분

//Item class는 우리가 가져와야할 부분을 체크하면 된다.
//Item 클래스는 dailyBoxOfficeList 배열의 각 항목에 대응하고있다.


