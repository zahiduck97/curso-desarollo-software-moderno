class Solution {
    public boolean isValid(String s) {
        // creamos el diccionario con los parentesis - { key: value }
        Map<Character, Character> pairs =
                /**
                new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        **/
        
            Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
            );
            
            /** 
            Map.ofEntries(
                Map.entry(')', '('),
                Map.entry(']', '['),
                Map.entry('}', '{'),
            )
            **/


          //  Stack || Queu = LIFO
          Deque<Character> stack = new ArrayDeque<>();

        // recorrer string s
        for(char c : s.toCharArray()) {
            // Si parentesis abre
            if(!pairs.containsKey(c)) {
                stack.push(c);
            } else {
                // si parentesis cierra
                // Para cada letra validar que sea correcto
                if(stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    // si no false
                    return false;
                }
                
            }
        }

        // si todo ok regresamos true
        return stack.isEmpty();

        
    }
}