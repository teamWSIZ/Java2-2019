package wsi.tasks;

public class Parenthesis {

  //założenie: s zawiera tylko '(' albo ')'
  public boolean checkParenthesis(String s) {
    int cnt = 0;
    for(char c : s.toCharArray()) {
      if (c=='(') cnt++;
      else cnt--;
      if (cnt<0) return false;
    }
    return cnt==0;
  }
}
