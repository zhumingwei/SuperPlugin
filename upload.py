
import subprocess

subprocess.call(["rm","-rf",".repo"])

#注释代码

def getzhushi(str):
    return f"//{str}"

def jiezhushi(str):
    if str.startswith('//'):
        return str[2:]
    else:
        return str

def smartAdd(str):
    if f"//smart replace" in str and not str.startswith('//'):
        return getzhushi(str)
    else:
        return str

def smartRemove(str):
    if f"//smart replace" in str and str.startswith('//'):
        return jiezhushi(str)
    else:
        return str;

def smartAddFile(filename):
    with open(filename,'r') as f:
        content = f.readlines()

    content = [smartAdd(x) for x in content]

    with open(filename,'w') as f:
        f.writelines(content)

def smartRemoveFile(filename):
    with open(filename,'r') as f:
        content = f.readlines()

    content = [smartRemove(x) for x in content]

    with open(filename,'w') as f:
        f.writelines(content)
    

smartAddFile("build.gradle")
smartAddFile("app/build.gradle")

print('start uploadArchives')
subprocess.call(['./gradlew', 'uploadArchives'])

smartRemoveFile("build.gradle")
smartRemoveFile("app/build.gradle")

print('start clean')
subprocess.call(['./gradlew', 'clean'])

print("end")