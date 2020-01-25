package lesson7;

class Graph{
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Queue queue;


    public Graph(){
        stack = new Stack(MAX_VERTS);
        queue = new Queue();
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }

        }
    }

    public Graph(int vertex){
        stack = new Stack(vertex);
        queue = new Queue();
        vertexList = new Vertex[vertex];
        adjMat = new int[vertex][vertex];
        size = vertex;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                adjMat[i][j] = 0;
            }
            vertexList[i] = new Vertex(i);
        }
    }

    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }

        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1){
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }



    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println("Vertex "+vertexList[vertex].label);
    }

    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0); // Вставка в конец очереди
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true; // Пометка
                displayVertex(v2); // Вывод
                queue.insert(v2);
            }
        }
        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
    }

    public void bfsSearch(int aim){

        int[] parent = new int[vertexList.length];
        int distance=0;

        vertexList[0].wasVisited = true;
        queue.insert(0); // Вставка в конец очереди
        int v2=-1;
        parent[0]=-1;
        while(!queue.isEmpty()&&v2!=aim){
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true; // Пометка
                queue.insert(v2);
                //фиксируем кто родитель
                parent[v2]=v1;
            }
        }
        System.out.println("Кратчайший путь из 0 в "+aim+":");
        displayVertex(0);
        distance=recPath(aim, parent);
        displayVertex(aim);
        System.out.println("distance="+distance);


        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
    }
//рекурсивный метод вычисления кратчайшего пути
    public int recPath(int aim, int[]parent){
        int dist=1;
        if (parent[aim]!=0){
            dist=recPath(parent[aim], parent)+1;
            displayVertex(parent[aim]);
        }
        return dist;
    }



}
