class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Diccionario -> { key, value } -> { value, index }
        Map<Integer, Integer> map = new HashMap<>();

        // empiezo a recorrer el array
        for(int index = 0; index < nums.length; index++) {
            int value = nums[index];

            // diferencia = actual - target
            int diff = target - value; 

            // valido en mi diccionario si existe
            if (map.containsKey(diff)) {
                // regreso diferencia
                /**
                int[] result = new int[2];
                result[0] = map.get(diff);
                result[1] = index;

                return result;
                **/

                return new int[] { map.get(diff), index };
            }

            // agregarlo al diccionario
            map.put(value, index);

        }

        
        // Return default 
        return new int[] {};
        

        

    }
}