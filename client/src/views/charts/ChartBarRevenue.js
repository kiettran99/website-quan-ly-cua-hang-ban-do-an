import React, { useState, useEffect } from 'react'
import PropTypes from 'prop-types'
import { getColor } from '@coreui/utils'
import { CChart } from '@coreui/react-chartjs'
import useGetOrders from './hooks/useGetOrders';
import { getLabelByTypeDate, exportDataOrdersByTypeDate } from '../../utils/charBarUtils';

const ChartBarRevenue = (props) => {
    const { typeDate, ...attributes } = props;

    const orders = useGetOrders();

    useEffect(() => {
        setData(exportDataOrdersByTypeDate(orders, typeDate));
    }, [typeDate, orders]);

    
    const [data, setData] = useState([]);

    const bar = {
        labels: getLabelByTypeDate(typeDate),
        datasets: [
            {
                label: 'Số lượng đơn đặt hàng',
                backgroundColor: 'rgba(255,99,132,0.2)',
                borderColor: 'rgba(255,99,132,1)',
                borderWidth: 1,
                hoverBackgroundColor: 'rgba(255,99,132,0.4)',
                hoverBorderColor: 'rgba(255,99,132,1)',
                data,
            },
        ],
    };

    const options = {
        // tooltips: {
        //   enabled: false,
        //   custom: customTooltips
        // },
        maintainAspectRatio: false
    }

    return (
        <div className="chart-wrapper">
            <CChart type="bar"
                {...attributes}
                labels={bar.labels}
                datasets={bar.datasets} options={options} />
        </div>
    );
};

export default ChartBarRevenue;