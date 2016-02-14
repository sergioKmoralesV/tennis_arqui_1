
public class TennisGame2 implements TennisGame
{
	//TODO: Revisar los siguientes nombres de variables
    public int Player1point = 0;
    public int Player2point= 0;
    public String Player1result = "";
    public String Player2result = "";
    private String player1Name;
    private String player2Name;
    private String[] scoreEquivalency = {"Love","Fifteen","Thirty","Forty"};
    private String score = "";
    
    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void reviewForDeuce(){
    	if (Player1point==Player2point && Player1point>=3)
    		score = "Deuce";
    }
    
    public void reviewForWinner(){
        if (Player1point>=4 && Player2point>=0 && (Player1point-Player2point)>=2)
        {
            score = "Win for player1";
        }
        if (Player2point>=4 && Player1point>=0 && (Player2point-Player1point)>=2)
        {
            score = "Win for player2";
        }
    }
    
    public void reviewForAdvantageScore(){

        if (Player1point > Player2point && Player2point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (Player2point > Player1point && Player1point >= 3)
        {
            score = "Advantage player2";
        }
    }
    
    public void reviewForTie(){
    	if (Player1point == Player2point && Player1point < 4)
        {
            Player1result = scoreEquivalency[Player1point];
            Player2result = "All";
        }
    }
    
    public void getScoreAvoidingSpecialCases(){
    	if (Player1point!=Player2point && (Player1point < 4 && Player2point <4))
        {
                Player1result=scoreEquivalency[Player1point];
                Player2result=scoreEquivalency[Player2point];
        }
    }
    
    public void reviewScoreBoard(){
    	reviewForTie();
        getScoreAvoidingSpecialCases();
        score = Player1result + "-" + Player2result;
        reviewForDeuce();
        reviewForAdvantageScore();
        reviewForWinner();
    }
    public String getScore(){
        reviewScoreBoard();
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
        Player1point++;
    }
    
    public void P2Score(){
        Player2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}