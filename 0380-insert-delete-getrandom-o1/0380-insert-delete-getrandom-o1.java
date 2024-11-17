class RandomizedSet {
		
		HashMap<Integer, Integer> k2i = new HashMap<>();
		HashMap<Integer, Integer> i2k = new HashMap<>();
		
		public RandomizedSet() {
	        
	    }

		public boolean insert(int val) {
	        if(k2i.containsKey(val)) return false;
	        int s = k2i.size();
	        k2i.put(val, s);
	        i2k.put(s, val);
	        return true;
	    }
	    
	    public boolean remove(int val) {
	    	if(!k2i.containsKey(val)) return false;
	    	int ti = k2i.remove(val);
	    	i2k.remove(ti);
	    	if(ti < i2k.size()) {
	    		int lastIndex = i2k.size();
	    		int tv = i2k.remove(lastIndex);
	    		i2k.put(ti, tv);
	    		k2i.put(tv, ti);
	    	}
	    	return true;
	    }
	    
	    public int getRandom() {
	        int d = (int)(Math.random() * i2k.size());
	        return i2k.get(d);
	    }
}