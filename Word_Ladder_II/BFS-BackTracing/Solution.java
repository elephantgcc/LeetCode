import java.util.*;

public class Solution {

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start.equals(end)) {
			return result;
		}

		HashMap<String, HashSet<String>> prevMap = new HashMap<String, HashSet<String>>();
		HashSet<String> removeBuffer = new HashSet<String>();
		ArrayDeque<String> q = new ArrayDeque<String>();
		q.add(start);
		dict.remove(start);
		dict.add(end);
		int levelCount = 1;
		boolean reached = false;

		while (levelCount > 0) {
			while (levelCount > 0) {
				String currWord = q.poll();
				char[] array = currWord.toCharArray();
				for (int i = 0; i < array.length; ++i) {
					for (char c = 'a'; c <= 'z'; ++c) {
						if (array[i] == c) {
							continue;
						}
						char temp = array[i];
						array[i] = c;
						String candWord = new String(array);
						if (dict.contains(candWord)) {
							if (candWord.equals(end)) {
								reached = true;
							}
							if (!q.contains(candWord)) {
								q.add(candWord);
							}
							removeBuffer.add(candWord);
							if (!prevMap.containsKey(candWord)) {
								HashSet<String> prevWords = new HashSet<String>();
								prevWords.add(currWord);
								prevMap.put(candWord, prevWords);
							} else {
								prevMap.get(candWord).add(currWord);
							}
						}
						array[i] = temp;
					}
				}// end for change and try
				--levelCount;
			}// this level is done

			if (reached) {
				return buildPaths(prevMap, end); // build final results
			}
			levelCount = q.size();
			dict.removeAll(removeBuffer);
			removeBuffer.clear();
		}
		return new ArrayList<ArrayList<String>>();
    }

	private ArrayList<ArrayList<String>> buildPaths(HashMap<String, HashSet<String>> prevMap, String end) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (!prevMap.containsKey(end)) {
			ArrayList<String> cell = new ArrayList<String>();
			cell.add(end);
			result.add(cell);
			return result;
		} else {
			HashSet<String> prevWords = prevMap.get(end);
			for (String prevWord : prevWords) {
				ArrayList<ArrayList<String>> prevResult = buildPaths(prevMap, prevWord);
				for (ArrayList<String> path : prevResult) {
					path.add(end);
					result.add(path);
				}
			}
		}
		return result;
	}
    
	public static void main(String args[]) {

		String start = "cet";
		String end = "ism";
		String[] dictArray = new String[] {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};

//		String start = "hit";
//		String end = "cog";
//		String [] dictArray = new String[] {"hot","dot","dog","lot","log"};

//		String start = "red";
//		String end = "tax";
//		String [] dictArray = new String[] {"ted","tex","red","tax","tad","den","rex","pee"};
		HashSet<String> dict = new HashSet<String>();
		for (String s: dictArray) {
			dict.add(s);
		}
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().findLadders(start, end, dict));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
