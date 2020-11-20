package miook.zust.kbmsystem.service;

import miook.zust.kbmsystem.dto.UserDto;
import miook.zust.kbmsystem.entity.Tuser;
import org.apache.tomcat.util.buf.UDecoder;

public interface UserServiceI {
    UserDto getUser(String loginName, String password);
    boolean login(UserDto dto);
    UserDto addUser(UserDto userDto);
}
