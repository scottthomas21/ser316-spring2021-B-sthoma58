<h2>Code Review Defect List </h2>

<details>
<summary> General Info </summary>
 
 
**Reviewer**: Scott Thomas

**GH Repo**: ser316-spring2021-B-sthoma58



</details>
 
 
 
 
 

|**ID #** |      **Location**               |        **Problem Description**                         |    **Problem**    |    **Problem (cont)**    |
|:-------:|:-------------------------------:|:------------------------------------------------------:|:-----------------:|:------------------------:|
|         |**File and Line Number**         |                                                        |   **Category**    |  **Severity**            |
|   1     | Mascotmon.java; 76              | The use of a switch statement is prohibited per CS.    |    CS; 3          |       LOW                |
|   2     | BattleScenario.java; 1          |BattleScenario.java lacks a file banner comment.        |    CG; 1          |       LOW                |
|   3     | BattleScenario.java; 135        |The implementation of calculateDamage() is incorrect.   |      FD, NA       |                          |
|   4     |       type.java; 1              | The class 'type.java' does not use "CamelCase".        |       CG; 4.b     |                          |
|   5     | Mascotmon.java; 3               |The public class Mascotmon and lacks its banner comment.|    CG; 2          |       LOW                |
|   6     | Environment.java; 45            |  The enum 'Weather' is not fully capitalized.          |      CG; 4.a      |       MJ                 |
|   7     |     type.java; 14               |   This complex if statement does not use explicit {}.  |     CG; 8.c       |          LOW             |












<details>
<summary> CATEGORY CHART </summary>
 
**Category**
|**Type** |      **Meaning**                 | **Additional Info**                       |
|:-------:|:--------------------------------:|:-----------------------------------------:|
|  CS     | Code Smell defect                |      NA                                   |
|  CG     | Violation of a coding guideline. |  Provide the guideline number             |
|  FD     | Functional defect                | Code will not produce the expected result |
|  MD     |  Miscellaneous defect            | For all other defects                     |

</details>
<details>
<summary> SEVERITY CHART </summary>
 
**Severity**
|**Type** |      **Meaning**       | **Additional Info**                       |
|:-------:|:----------------------:|:-----------------------------------------:|
|  BR     | Blocker                |      Must be fixed asap                   |
|  MJ     | Major                  |   Of high importance but not a Blocker    |
|  LOW    | Low                    |      NA                                   |
</details>

