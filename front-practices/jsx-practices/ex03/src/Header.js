import React from 'react';

function Header({name='seokwoo'}) {
    return (
        <div>
            {name}님 안녕하세요
        </div>
    );
}

export default Header;