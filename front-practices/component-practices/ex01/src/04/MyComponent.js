import React from 'react';
import {PropTypes} from 'prop-types';

function MyComponent({props01, props02, props03, props04, props05, props06, props07, props08, props09}) {

    return (
        <div>
            <h2>Property Validation</h2>
            {/* <h3>props01 : {typeof(props01) === 'undefined' ? 'not set' : props1}</h3> */}
            <h3>{props01}</h3>
            <h3>props02 : {props02}</h3>
            <h3>props03 : {props03}</h3>
            <h3>props04 : {props04.no} {props04.name}</h3>
    
        </div>
    );
}

MyComponent.propTypes = {
    // JS dataType
    props01: PropTypes.string,
    props02: PropTypes.number,
    props03: PropTypes.bool,
    props04: PropTypes.object,
    props05: PropTypes.array,
    props06: PropTypes.func,
    props07: PropTypes.oneOfType([PropTypes.number]),
    props08: PropTypes.instanceOf(Array),
    props09: PropTypes.shape({no:PropTypes.number})
}
MyComponent.defaultProps ={
    props01: "안녕하세요 반갑습니다"
}

export default MyComponent;