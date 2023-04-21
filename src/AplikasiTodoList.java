public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    public static void main(String[] args) {
        viewShowTodoList();
    }


    /**
     * Bisnis Logic
     */
    public static void showTodoList(){
        System.out.println("\nTODOLIST");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + "." + todo);
            }
        }
    }

    public static void testShowTodoList(){
        model[0] = "Upgrade Monitor";
        model[1] = "Upgrade RAM";
        showTodoList();
    }

    public static void addTodoList(String todo){
        // cek apakah model penuh
        var isFull = true;
        for (var i = 0; i < model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }

        // jika penuh, resize ukuran model 2x lipat
        if (isFull){
            var temp = model;
            model = new String[model.length * 2];

            for (var i = 0; i < temp.length; i++){
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi data array yang NULL
        for (var i = 0; i < model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for(var i = 1; i <= 25; i++){
            addTodoList("Contoh todo ke." + i);
        }
        showTodoList();

    }

    public static boolean removeTodoList(Integer number){
        if((number - 1) >= model.length){
            return false;
        }else if(model[number-1] == null){
            return false;
        }else{
            for(int i = (number - 1); i < model.length; i++){
                if(i == (model.length) - 1){
                    model[i] = null;
                }else{
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }


    public static String inputData(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInputData(){
        var name = inputData("Nama");
        System.out.println("Hai " + name);
    }


    /**
     * View
     */
    public static void viewShowTodoList(){

        while (true){
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var inputData = inputData("Pilih");

            if(inputData.equals("1")){
                viewAddTodoList();
            }else if(inputData.equals("2")){
                viewRemoveTodoList();
            }else if (inputData.equals("3")){
                break;
            }else{
                System.out.println("Pilihan yang anda masukan salah");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = inputData("Todo (x jika batal)");

        if(todo.equals("x")){
        }else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        viewAddTodoList();
        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = inputData("Nomor todolist yang dihapus (x jika batal)");

        if(number.equals("x")){

        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus Todolist : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){

        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();

    }


}
