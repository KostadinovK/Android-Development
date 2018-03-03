package com.example.kostadin.tengag;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

public class AppDatabase {
    public static List<BaseModel> database;

    public static List<BaseModel> getData(){
        if(database == null)database = setDatabase();
        return database;
    }

    public static List<BaseModel> setDatabase(){
        return Arrays.asList(
                new Meme("Programming > Love","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28468019_1623436011038604_9170976619360836672_n.jpg?oh=02f20af2b50fa8701196546293214707&oe=5B00C835","23","33"),
                new Meme("CSS <3","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28467818_1623442567704615_682531752435887979_n.jpg?oh=198197f0cca56f75619cd48f74bf57e4&oe=5B435773","123","0"),
                new Meme("Programmer Reality ","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28378337_1623441544371384_7545324169326391764_n.jpg?oh=00dfa83b63d5aa6b9f48e8c6312104ad&oe=5B128B2A","233","22"),
                new Add("https://pbs.twimg.com/media/DSvK2TaVoAAAuCK.jpg"),
                new Meme("PHP pain","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28471581_1623437537705118_7303319741441136319_n.jpg?oh=9e06a8a6f9561694370a9698022981c3&oe=5B04E548","123","34"),
                new Meme("Should Basic be on top?","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28575939_1623437194371819_6108214272719198995_n.jpg?oh=2152e6c0ef30909f6a0e17e44f2d5d28&oe=5B4CD84A","113","331"),
                new Meme("FoodStrap!","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28377813_1623434434372095_7761516046250866933_n.jpg?oh=07cd100aff741b41975c14709b0e8183&oe=5B4E1680","100","12"),
                new Meme("Good kiss","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28279341_1623433041038901_6281440669593647640_n.jpg?oh=13285771cf7064639427c845c1fe2385&oe=5B0CB4D5","897","211"),
                new Meme("Priorities","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28276561_1623432531038952_626197238802945538_n.jpg?oh=96988b1baab3dedc7151c74065fea37d&oe=5B109F44","899","89"),
                new Add("http://www.phaidon.com/resource/ttennis.jpg"),
                new Meme("Never forget it!","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28378947_1623432071038998_7972518225969138025_n.jpg?oh=1da05bd6a969205d44ae6f39e018c830&oe=5B07EE68","23","33"),
                new Meme("Visual Studio debugger xD","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28378823_1623430407705831_6207030535779742612_n.jpg?oh=0f753da4e41927daf6dba4184dd0e574&oe=5B45F479","12","4"),
                new Meme("","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28468046_1623429181039287_6089280169395403107_n.jpg?oh=7d43c6d6135a1cfbbebaac50f522a8d6&oe=5B0244FE","21","12"),
                new Meme("Notepad++ army","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28377884_1623403697708502_7034255838919759523_n.jpg?oh=ec3cf33573eef2ef4779470dc2d38527&oe=5B4B8D51","398","111"),
                new Meme("USB protection","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28377641_1623199734395565_6838005331466521132_n.jpg?oh=8e86cb67fd23f52bcb627ef988186929&oe=5B4587D4","988","500"),
                new Meme("Expert","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28468063_1623160387732833_1657225588104094632_n.jpg?oh=4f3c2ad5555324358e0479ff17fb8df3&oe=5B142AB1","120","788"),
                new Meme("Never sleep","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28379589_1622764601105745_6304650811690146240_n.jpg?oh=7ff6a6355aede0bec9f65d5ce6ddde2b&oe=5B4B8EC3","899","211"),
                new Add("https://s-media-cache-ak0.pinimg.com/originals/08/b5/90/08b5909ff7efac41ca475a52a1e9e673.jpg"),
                new Meme("That happenes so many times xD","https://scontent.fsof3-1.fna.fbcdn.net/v/t1.0-9/28468235_1622591897789682_7163503549033510333_n.png?oh=29ff7e85ab43e9493d4a93b5a7adfc0a&oe=5B1586E2","199","23")




        );

    }
}
