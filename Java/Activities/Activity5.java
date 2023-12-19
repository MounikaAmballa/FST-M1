package activities;

public  class Activity5 {
    public static void main(String[] args) {

        String title="Core Java concepts";
        MyBook newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("Title of the Book is:"+newNovel.getTitle());
    }

}
