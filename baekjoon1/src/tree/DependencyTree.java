package tree;

import java.util.HashMap;
import java.util.LinkedList;

class Project{
    private String name;
    //먼저 처리돼야 할 프로젝트의 리스트를 저장할 변수 선언
    private LinkedList<Project> dependencies;
    //순서를 정할 때 결과에 담았는지 알려주는 플래그
    private boolean marked;

    public Project(String name) {
        this.name = name;
        this.marked = false;
        this.dependencies = new LinkedList<>();
    }
    //의존관계를 추가해주는 함수
    public void addDependency(Project project){
        if(!dependencies.contains(project)){
            dependencies.add(project);
        }
    }

    public String getName() {
        return name;
    }

    public LinkedList<Project> getDependencies() {
        return dependencies;
    }

    public boolean getMarked() {
        return marked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDependencies(LinkedList<Project> dependencies) {
        this.dependencies = dependencies;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
//프로젝트 관리하는 클래스
class ProjectManager{
    private HashMap<String, Project> projects;

    public ProjectManager(String[] names, String[][] dependencies) {
        buildProjects(names);
        addDependencies(dependencies);
    }
    public void buildProjects(String[] names) {
        projects = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            projects.put(names[i], new Project(names[i]));
        }
    }

    public void addDependencies(String[][] dependencies) {
        for(String[] dependency : dependencies){
            Project before = findProject(dependency[0]);
            Project after = findProject(dependency[1]);
            //먼저 처리해야 하는 노드를 나중에 처리하는 노드의 디펜던시로 추가
            after.addDependency(before);
        }
    }
    private int index;
    //의존성에 입각한 프로젝트의 순서 정하기
    public Project[] buildOrder(){
        initMarkingFlags();
        //결과값을 저장할 배열 준비
        Project[] ordered = new Project[this.projects.size()];
        index = 0;
        //프로젝트 하나씩 돌면서 재귀함수 호출
        for(Project project : this.projects.values()){
            buildOrder(project, ordered);
        }
        //결과값 저장된 배열 반환
        return ordered;
    }
    public void buildOrder(Project project, Project[] ordered){
        //호출을 받으면 먼저 처리되야 하는 플젝 있는지 확인하고
        //있으면 for문 돌면서 함수 호출
        if(!project.getDependencies().isEmpty()){
            for(Project p : project.getDependencies()){
                buildOrder(p, ordered);
            }
        }
        //모든 의존하는 프로젝트가 처리되면 결과 배열 방에 추가되었는지 확인하고
        //아직 처리가 안 된 프로젝트면
        if(project.getMarked() == false){
            //마킹 플래그를 true로 바꾸고
            project.setMarked(true);
            //결과값을 배열방에 추가
            ordered[index] = project;
            //다음 배열방에 담도록 index값 +1
            index++;
        }
    }
    //순서를 정하기 전에 mark 플래그를 false로 세팅해 주는 함수
    private void initMarkingFlags(){
        for(Project project : this.projects.values()){
            project.setMarked(false);
        }
    }
    //이름으로 프로젝트 노드를 찾는 함수
    public Project findProject(String name){
        return projects.get(name);
        //HashMap을 이용했으므로 검색시 0의 시간이 걸림
    }
}

public class DependencyTree {
    public static void main(String[] args) {
        String[] projects = {"a", "b","c","d","e","f","g"};
        String[][] dependencies = {{"f","a"}, {"f","b"}, {"f","c"}, {"b","a"},
                {"c","a"}, {"a","e"}, {"b","e"}, {"d","g"}};
        ProjectManager pm = new ProjectManager(projects, dependencies);
        Project[] ps = pm.buildOrder();
        for(Project p : ps){
            if(p != null){
                System.out.print(p.getName() + " ");
            }
        }

    }
}
//그래프에 명시한 관계에 입각해 노드를 순서대로 조회
//회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은
//특정 프로젝트가 완료 되어야만 진행할 수 있는 프로젝트가 있다.
//프로젝트의 목록과 각 프로젝트 간 의존여부를 넘겨주면 의존도에 입각한
//프로젝트의 진행 순서를 반환하는 함수 구현
//노드와 노드의 관계를 명시 -> Graph 사용
//그래프를 자료구조에 담는 방법 (Matrix / *LinkedList)
//LinkedList는 Matrix 보다 공간효율이 좋음