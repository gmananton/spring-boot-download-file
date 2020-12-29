package com.gman.index;

import com.gman.domain.BlogPost;
import com.gman.domain.SearchableItem;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Anton Mikhaylov on 23.12.2020.
 */
@Component
public class IndexInitializer {

    @PostConstruct
    public void init() {

        SearchableItem post1 =
                BlogPost.builder()
                        .title("Дуров монетизирует Telegram")
                        .body("С 2021 года мессенджер Telegram начнет монетизироваться, сообщил его основатель Павел Дуров. Но для обычных пользователей он останется бесплатным")
                        .tag("it")
                        .tag("finance")
                        .build();

        SearchableItem post2 =
                BlogPost.builder()
                        .title("Обновленный Skoda Kodiaq засняли на видео")
                        .body("Рестайлинговый кроссовер Skoda Kodiaq изменится внешне и получит гибридную силовую установку с возможностью подзарядки от бытовой сети")
                        .tag("auto")
                        .build();


        SearchableItem post3 =
                BlogPost.builder()
                        .title("Мосбиржа допустила начало торгов европейскими акциями в 2021 году")
                        .body("В 2021 году на Мосбирже появятся более 200 новых иностранных акций. В этом году их число достигло 55")
                        .tag("finance")
                        .tag("investment")
                        .build();

        SearchableItem post4 =
                BlogPost.builder()
                        .title("США ввели санкции против отряда «Альфа» белорусского КГБ и минского ОМОНа")
                        .body("Минфин США ввел санкции против замминистра внутренних дел Белоруссии Геннадия Казакевича, отряда «Альфа» белорусского КГБ, ГУВД Минского горисполкома, минского ОМОНа и белорусского ЦИКа. Решение опубликовано на сайте ведомства")
                        .tag("politics")
                        .build();


        SearchableItem post5 =
                BlogPost.builder()
                        .title("Пермским медикам хотят удвоить выплаты за работу с Covid в праздники")
                        .body("В ходе заседания президент России Владимир Путин одобрил предложение партии «Единая Россия» поддержать медиков, которые будут работать в «красных зонах» в период новогодних каникул")
                        .tag("health")
                        .tag("covid")
                        .tag("коронавирус")
                        .tag("politics")
                        .build();


    }
}
