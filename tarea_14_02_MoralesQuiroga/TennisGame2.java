
public class TennisGame2 implements TennisGame
{
	//TODO: Revisar los siguientes nombres de variables
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "All";
    public String P2res = "All";
    private String player1Name;
    private String player2Name;
    private String[] scoreEquivalency = {"Love","Fifteen","Thirty","Forty"};
    private String score = "";
    
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void reviewForDeuce(){
    	if (P1point==P2point && P1point>=3)
    		score = "Deuce";
    }
    
    public void reviewForWinner(){
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
    }
    
    public void reviewForAdvantageScore(){

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
    }
    
    public void reviewScoreBoard(){
    	if (P1point == P2point && P1point < 4)
        {
            P1res = scoreEquivalency[P1point];
        }
        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = scoreEquivalency[P1point];
            if (P1point==2)
                P1res = scoreEquivalency[P1point];
            if (P1point==3)
                P1res = scoreEquivalency[P1point];
            P2res = scoreEquivalency[P2point];
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = scoreEquivalency[P2point];
            if (P2point==2)
                P2res = scoreEquivalency[P2point];
            if (P2point==3)
                P2res = scoreEquivalency[P2point];
            P1res = scoreEquivalency[P1point];
        }
        
        if (P1point!=P2point && (P1point < 4 && P2point <4))
        {
                P1res=scoreEquivalency[P1point];
                P2res=scoreEquivalency[P2point];
        }
    }
    public String getScore(){
        reviewScoreBoard();
        score = P1res + "-" + P2res;
        reviewForDeuce();
        reviewForAdvantageScore();
        reviewForWinner();
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}