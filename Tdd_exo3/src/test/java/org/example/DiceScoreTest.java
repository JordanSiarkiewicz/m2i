package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

public class DiceScoreTest {
    private DiceScore diceScore = Mockito.mock(DiceScore.class);
    private Ide de = Mockito.mock(Ide.class);

    @Test
    public void testDiceScoreWhenGetScore_BothDicesIdenticalAndNotEqual_6_ThenResult_DiceResultMultiplyBy_2_Plus_10(){
        diceScore = new DiceScore(de);
        int x = 1;
        Mockito.when(de.getRoll()).thenReturn(x);
        int resultAwait = (x*2)+10;
        int result = 0;

        for(x=1; x<=5; x++){
            result = diceScore.getScore();
//            Assertions.assertEquals(resultAwait,result);
        }

        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void testDiceScoreWhenGetScore_BothDicesIdenticalAndEqual_6_ThenResult_DiceResult_30(){
        diceScore = new DiceScore(de);
        Mockito.when(de.getRoll()).thenReturn(6);
        int resultAwait = 30;

        int result = diceScore.getScore();

        Assertions.assertEquals(resultAwait,result);
    }
}
