// 스타일 파싱 함수 정의
function parseStyles(strings, ...values) {

    const arr = strings[0].split('\n');
    
    const filteredStyles = arr
        .filter(line => line.trim() !== '')
        .map(line => line.trim());
    
    const parsedStyles = filteredStyles.map(styleString => {
        const [property, value] = styleString.split(':');
        return { property: property.trim(), value: value.trim() };
    });

    return parsedStyles;
}

// 변수 선언
const textColor = 'blue';
const fontSize = '16px';

// 스타일 파싱 함수 호출 및 템플릿 리터럴 사용
const Styles = parseStyles`
    color: ${textColor};
    font-size: ${fontSize};
`;

console.log(Styles);
// 출력: [{ property: 'color', value: 'blue' }, { property: 'font-size', value: '16px' }]
