class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
		new_id = new_id.replaceAll("[^a-z0-9\\-\\_\\.]","");
        new_id = new_id.replaceAll("\\.+",".");
        new_id = new_id.replaceAll("^\\.|\\.$","");
        
        if(new_id.length()==0){
            new_id="a";
        }
        
        if(new_id.length()>15){
            new_id = new_id.substring(0,15);
        }
        new_id = new_id.replaceAll("\\.$","");
        if(new_id.length()==1){
            new_id = new_id+new_id+new_id;
        }else if(new_id.length()==2){
            new_id = new_id+new_id.charAt(1);
        }
        return new_id;
    }
}
